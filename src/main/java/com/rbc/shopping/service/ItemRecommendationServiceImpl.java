package com.rbc.shopping.service;

import com.rbc.shopping.dto.ItemsOnSale;
import com.rbc.shopping.dto.RecommendedItems;
import com.rbc.shopping.entity.Orders;
import com.rbc.shopping.entity.Wish;
import com.rbc.shopping.exception.ForbiddenException;
import com.rbc.shopping.repository.ItemRepository;
import com.rbc.shopping.repository.OrderRepository;
import com.rbc.shopping.repository.WishRepository;
import com.rbc.shopping.security.JWTTokenHandlerImpl;
import com.rbc.shopping.security.JwtUser;
import com.rbc.shopping.util.AppConstants;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementation class for Item Recommendation Service and its business logic.
 *
 * @author SARA
 */
@Service
@Data
public final class ItemRecommendationServiceImpl implements IItemRecommendationService {

    /**
     * Object representing OrderRepository;
     */
    @Autowired
    private OrderRepository orderRepository;

    /**
     * Object representing ItemRepository.
     */
    @Autowired
    private ItemRepository itemRepository;

    /**
     * Object representing WishRepository.
     */
    @Autowired
    private WishRepository wishRepository;

    @Override
    public ItemsOnSale getRecommendedItems(final long userId) {

        final ItemsOnSale itemsOnSale = new ItemsOnSale();

        //Highest rated category by user (My Orders)
        final Set<RecommendedItems> myOrdersRecommendationList = new HashSet<>();
        final List<Orders> myOrdersList = orderRepository.findOrdersByUserId(userId);

        getRecommendedList(myOrdersRecommendationList, myOrdersList, AppConstants.MY_ORDERS_COMMENT);

        itemsOnSale.setMyOrdersList(myOrdersRecommendationList);

        // Suggestions based on Wish List
        final Set<RecommendedItems> wishItemsList = new HashSet<>();
        final Set<Wish> wishList = wishRepository.findWishByUserId(userId);

        wishList.forEach(wish -> {
            itemRepository.findItemsByCategoryId(wish.getItem().getItemCategory().getId()).forEach(item -> {

                final RecommendedItems recommendedItem = new RecommendedItems();
                recommendedItem.setItemId(item.getId());
                recommendedItem.setItemDescription(item.getDescription());
                recommendedItem.setPrice(AppConstants.CURRENCY + item.getPrice().toString());
                recommendedItem.setComments(AppConstants.MY_WISH_COMMENT);
                recommendedItem.setCategory(item.getItemCategory().getDescription());

                wishItemsList.add(recommendedItem);


            });
        });

        itemsOnSale.setWishList(wishItemsList);

        //Hot Deals based on highest rated categories
        final Set<RecommendedItems> hotDealsList = new HashSet<>();
        final List<Orders> allOrdersList = orderRepository.findOrdersByOtherUsers(userId);

        getRecommendedList(hotDealsList, allOrdersList, AppConstants.HOT_DEALS_COMMENT);

        itemsOnSale.setHotDealsList(hotDealsList);

        return itemsOnSale;

    }

    @Override
    public void validateUser(final String authHeader, final long userId) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ForbiddenException();
        }

        final String authToken = authHeader.substring(7);

        if (!isValidUser(authToken, userId)) {
            throw new ForbiddenException();
        }
    }

    /**
     * Validates token from Authorization Header.
     *
     * @param token String representing bearer token from authorization
     * @return true if valid user else false.
     */
    private boolean isValidUser(final String token, final long userId) {

        boolean isValid = false;

        if (token != null && !token.isEmpty()) {
            final JWTTokenHandlerImpl jwtTokenGenerator = new JWTTokenHandlerImpl();

            final JwtUser jwtUser = jwtTokenGenerator.validate(token);

            // Check valid jwt token and if the token belongs to the user id passed in the url.
            isValid = (jwtUser != null && (jwtUser.getUserId().compareTo(userId) == 0));
        }

        return isValid;
    }


    /**
     * Generates Recommended list based on Orders list and its categories.
     *
     * @param recommendedItemsList Set of recommended items.
     * @param ordersList           List of Order List.
     * @param commentCategory      String for comment category.
     */
    private void getRecommendedList(Set<RecommendedItems> recommendedItemsList, List<Orders> ordersList, final String commentCategory) {

        // Group Orders by rating
        final Map<Long, List<Orders>> groupOrdersByUserRating =
                ordersList.stream().collect(Collectors.groupingBy(Orders::getUser_rating));

        // Map to hold Category Id and Highest Rating
        final Map<Long, Long> finalMap = new HashMap<>();

        //Iterate and Get Highest Rating for the category
        groupOrdersByUserRating.forEach((rating, v) -> v.forEach(obj -> {

                    /*
                     * Compare rating to existing category rating. If it is higher, map the same to the category
                     */
                    if (finalMap.get(obj.getItem().getItemCategory().getId()) == null) {
                        finalMap.put(obj.getItem().getItemCategory().getId(), rating);
                    } else if (rating.compareTo(finalMap.get(obj.getItem().getItemCategory().getId())) >= 0) {
                        finalMap.put(obj.getItem().getItemCategory().getId(), rating);
                    }
                }
        ));

        //Get items from highest rated categories in the order
        finalMap.forEach((itemCategoryId, rating) -> itemRepository.findItemsByCategoryId(itemCategoryId).forEach(item -> {

            final RecommendedItems recommendedItem = new RecommendedItems();
            recommendedItem.setItemId(item.getId());
            recommendedItem.setItemDescription(item.getDescription());
            recommendedItem.setPrice(AppConstants.CURRENCY + item.getPrice().toString());
            recommendedItem.setComments(commentCategory + rating);
            recommendedItem.setCategory(item.getItemCategory().getDescription());

            recommendedItemsList.add(recommendedItem);

        }));

    }
}

