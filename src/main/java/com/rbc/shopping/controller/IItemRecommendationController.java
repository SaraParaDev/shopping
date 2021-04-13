package com.rbc.shopping.controller;

import com.rbc.shopping.dto.ItemsOnSale;
import com.rbc.shopping.dto.Recommendations;
import com.rbc.shopping.dto.UserDetails;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 * Resource interface for Item Recommendations and jwt token generator.
 *
 * @author SARA
 */
public interface IItemRecommendationController {

    /**
     * Returns 200 status if the application is up and running.
     */
    @ApiOperation(value = "Application Health status",
            notes = "Returns 200 status if the application is up and running.")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success"),
                    @ApiResponse(code = 500, message = "Server error. For more details check the logs.")
            }
    )
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    ResponseEntity<Object>  health();

    /**
     * Generates Json Web Token based on the User Credentials.
     *
     * @param userDetails Request object for which jwt to be generated.
     * @return Returns String representing jwt token.
     */
    @ApiOperation(value = "Generate Token",
            notes = "Generates JSON web token for the supplied User Id and Password.")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success"),
                    @ApiResponse(code = 400, message = "Bad Request"),
                    @ApiResponse(code = 403, message = "Forbidden. Please check your credentials"),
                    @ApiResponse(code = 404, message = "Unauthorized"),
                    @ApiResponse(code = 415, message = "Unsupported media type"),
                    @ApiResponse(code = 500, message = "Server error. For more details check the logs.")
            }
    )
    @PostMapping(value = "/auth/generate-token", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    ResponseEntity<String>  generateToken(@ApiParam(value = "The User Details") @NotNull(message = "User Details are required") @RequestBody UserDetails userDetails);


    /**
     * Recommends Items based on user order history, wish list and hot deals.
     *
     * @param request The HttpServletRequest.
     * @param userId  Long representing User Id.
     * @return Returns ItemsOnSale object based on the order history, wish list and hot deals.
     */
    @ApiOperation(value = "Recommended Items",
            notes = "Recommends Items based on user order history, wish list and hot deals.")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success"),
                    @ApiResponse(code = 400, message = "Bad Request"),
                    @ApiResponse(code = 403, message = "Forbidden. Please check your credentials"),
                    @ApiResponse(code = 404, message = "Not Found"),
                    @ApiResponse(code = 415, message = "Unsupported media type"),
                    @ApiResponse(code = 500, message = "Server error. For more details check the logs.")
            }
    )
    @GetMapping(value = "/recommendations/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Recommendations> getRecommendedItems(HttpServletRequest request, @ApiParam(value = "The User Id") @NotNull(message = "User Id is required.") @PathVariable("userId") final Long userId);
}
