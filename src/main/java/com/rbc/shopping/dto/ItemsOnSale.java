package com.rbc.shopping.dto;

import lombok.Data;

import java.util.Set;

/**
 * Class for holding Recommendations list for my orders, wish and Hot deals.
 *
 * @author SARA
 */
@Data
public final class ItemsOnSale {

    /**
     * Set of recommended items from My Orders List.
     */
    private Set<RecommendedItems> myOrdersList;

    /**
     * Set of recommended items from wish list.
     */
    private Set<RecommendedItems> wishList;

    /**
     * Set of recommended items from Hot deals list.
     */
    private Set<RecommendedItems> hotDealsList;
}
