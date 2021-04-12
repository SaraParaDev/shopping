package com.rbc.shopping.dto;

import lombok.Data;

/**
 * Dto class for holding recommended item details.
 *
 * @author SARA
 */
@Data
public final class RecommendedItems {

    /**
     * Long representing item id.
     */
    private long itemId;

    /**
     * String representing Item Description.
     */
    private String itemDescription;

    /**
     * String representing Item price.
     */
    private String price;

    /**
     * String representing item Category.
     */
    private String category;

    /**
     * String representing comments for the User.
     */
    private String comments;
}
