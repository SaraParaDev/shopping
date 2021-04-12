package com.rbc.shopping.service;

import com.rbc.shopping.dto.ItemsOnSale;
import com.rbc.shopping.exception.ForbiddenException;

/**
 * Interface for Item Recommendation Service and it is business logic.
 *
 * @author SARA
 */
public interface IItemRecommendationService {

    /**
     * Gets and returns recommended items for the userId.
     *
     * @param userId long representing userId.
     * @return returns ItemsOnSale with recommendations.
     */
    ItemsOnSale getRecommendedItems(long userId);


    /**
     * Validates the Bearer token passed in the Authorization header.
     *
     * @param authHeader String representing the bearer token from the authorization header.
     * @throws ForbiddenException if user credential is invalid.
     */
    void validateUser(String authHeader, long userId);
}
