package com.rbc.shopping.security;

/**
 * Handler interface for JWT token generation and validating.
 *
 * @author SARA
 */
public interface IJWTTokenHandler {

    /**
     * Generates JWT token for the supplied userId and password.
     *
     * @param user JwtUser object with userId and password.
     * @return Returns String containing JWT token.
     */
    String generate(JwtUser user);

    /**
     * Validates the JWT token string against secret key and users table.
     *
     * @param token String containing authorization token.
     * @return Returns    Object containing JWT User.
     */
    JwtUser validate(String token);
}
