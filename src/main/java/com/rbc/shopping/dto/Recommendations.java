package com.rbc.shopping.dto;

import lombok.Data;

/**
 * Response class for Recommendations.
 *
 * @author SARA
 */
@Data
public final class Recommendations {

    /**
     * Object representing ItemsOnSale.
     */
    private ItemsOnSale itemsOnSale;

    /**
     * Holds recommendations Count based on My Order.
     */
    private int myOrderSuggestions;

    /**
     * Holds recommendations Count based on Wish.
     */
    private int wishSuggestions;

    /**
     * Holds recommendations Count based on Hot Deals.
     */
    private int hotDealsSuggestions;
}
