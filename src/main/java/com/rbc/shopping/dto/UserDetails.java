package com.rbc.shopping.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Class for holding User credentials for token generation.
 *
 * @author SARA
 */
@Data
public final class UserDetails implements Serializable {

    /**
     * Long representing User Id.
     */
    private long userId;

    /**
     * String representing the password.
     */
    private String password;
}
