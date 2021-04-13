package com.rbc.shopping.security;

import com.rbc.shopping.util.AppConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Implementation class for JWT token generation and validating.
 *
 * @author SARA
 */
public class JWTTokenHandlerImpl implements IJWTTokenHandler {

    @Override
    public String generate(JwtUser user) {

        //Set Expiration if required
        final Claims claims = Jwts.claims().setSubject(user.getUserId().toString());

        claims.put(AppConstants.USER_ID, String.valueOf(user.getUserId()));
        claims.put(AppConstants.PASSWORD, user.getPassword());

        return Jwts.builder().setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, AppConstants.SECRET_KEY).compact();
    }

    @Override
    public JwtUser validate(final String token) {
        JwtUser jwtUser = null;
        try {
            // Parse the token
            final Claims requestBody = Jwts.parser().setSigningKey(AppConstants.SECRET_KEY).parseClaimsJws(token).getBody();

            jwtUser = new JwtUser();
            jwtUser.setUserId(Long.parseLong((String) requestBody.get(AppConstants.USER_ID)));
            jwtUser.setPassword((String) requestBody.get(AppConstants.PASSWORD));

        } catch (final Exception e) {
			/*
			Throw error in case of malformed jwt token or invalid token
			 */
            return jwtUser;
        }

        return jwtUser;
    }

}
