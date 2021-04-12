package com.rbc.shopping.controller;

import com.rbc.shopping.dto.ItemsOnSale;
import com.rbc.shopping.dto.Recommendations;
import com.rbc.shopping.dto.UserDetails;
import com.rbc.shopping.entity.Users;
import com.rbc.shopping.exception.UserNotFoundException;
import com.rbc.shopping.repository.UserRepository;
import com.rbc.shopping.security.JWTTokenHandlerImpl;
import com.rbc.shopping.security.JwtUser;
import com.rbc.shopping.service.IItemRecommendationService;
import com.rbc.shopping.util.AppConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Implementation class for the Item Controller.
 *
 * @author SARA
 */
@RequestMapping("/api/shopping")
@RestController
@Api(value = "Items On Sales Services")
public final class ItemRecommendationControllerImpl implements IItemRecommendationController {

    /**
     * Object representing ItemRecommendationService.
     */
    @Autowired
    private IItemRecommendationService itemRecommendationService;

    /**
     * Object representing UserRepository.
     */
    @Autowired
    private UserRepository userRepository;

    @Override
    @CrossOrigin( origins ="http://localhost:8085")
    public ResponseEntity<Object> health() {
        return new ResponseEntity<>("Application is up and running!", HttpStatus.OK);
    }

    @Override
    public String generateToken(@ApiParam(value = "The User Details") @NotNull(message = "User Details are required") @RequestBody UserDetails userDetails) {
        final JWTTokenHandlerImpl jwtTokenGenerator = new JWTTokenHandlerImpl();

        final JwtUser jwtUserJSON = new JwtUser();

        jwtUserJSON.setUserId(userDetails.getUserId());
        jwtUserJSON.setPassword(userDetails.getPassword());

        return jwtTokenGenerator.generate(jwtUserJSON);
    }

    @Override
    public ResponseEntity<Recommendations> findOrdersByUserId(HttpServletRequest request, @ApiParam(value = "The User Id") @NotNull(message = "User Id is required.") @PathVariable("userId") final Long userId) {

        // Perform Authorization
        final String authHeader = request.getHeader(AppConstants.AUTHORIZATION_HEADER);
        // Validate User. Throws Forbidden exception if invalid.
        itemRecommendationService.validateUser(authHeader, userId);

        final Optional<Users> userData = userRepository.findById(userId);

        if (userData.isPresent()) {
            final ItemsOnSale itemsOnSale = itemRecommendationService.getRecommendedItems(userId);
            final Recommendations recommendations = new Recommendations();
            recommendations.setItemsOnSale(itemsOnSale);
            recommendations.setMyOrderSuggestions(itemsOnSale.getMyOrdersList().size());
            recommendations.setWishSuggestions(itemsOnSale.getWishList().size());
            recommendations.setHotDealsSuggestions(itemsOnSale.getHotDealsList().size());
            return new ResponseEntity<>(recommendations, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }
}
