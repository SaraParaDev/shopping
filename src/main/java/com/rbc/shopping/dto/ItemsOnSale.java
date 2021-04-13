package com.rbc.shopping.dto;

import lombok.Data;

import java.util.LinkedList;
import java.util.Set;

/**
 * Class for holding Recommendations list for my orders, wish and Hot deals.
 *
 * @author SARA
 */
@Data
public final class ItemsOnSale {

    /**
     * List of recommended items from My Orders List.
     */
    private LinkedList<RecommendedItems> myOrdersList;

    /**
     * List of recommended items from wish list.
     */
    private LinkedList<RecommendedItems> wishList;

    /**
     * List of recommended items from Hot deals list.
     */
    private LinkedList<RecommendedItems> hotDealsList;
}
