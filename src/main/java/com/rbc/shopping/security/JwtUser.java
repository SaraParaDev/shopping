package com.rbc.shopping.security;

import lombok.Data;

/**
 * Dto class for JWT token generation.
 *
 * @author SARA
 */
@Data
public class JwtUser {

    /**
     * Long representing User Id.
     */
    private Long userId;

    /**
     * String representing password.
     */
    private String password;
}
