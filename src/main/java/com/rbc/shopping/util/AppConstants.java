package com.rbc.shopping.util;

/**
 * Constants for Shopping Application.
 *
 * @author SARA
 */
public class AppConstants {

    // Swagger Constants
    public static final String BASE_PACKAGE = "com.rbc.shopping";
    public static final String PATH_REGEX = "/api.*";
    public static final String DOC_TITLE = "RBC Shopping Application";
    public static final String DOC_TITLE_DESC = "API documentation for RBC Shopping Application";
    public static final String DOC_VERSION = "1.0";
    public static final String DOC_TERMS_OF_SERVICE = "Terms of Service";
    public static final String DOC_CONTACT_NAME = "mailtonishasara@gmail.com";
    public static final String DOC_LICENSE_URL = "#";

    public static final String EMPTY_STRING ="";

    public static final String CURRENCY = "$";
    public static final String HOT_DEALS_COMMENT = "Suggested based on highest rated categories among customers: ";
    public static final String MY_ORDERS_COMMENT = "Suggested based on your highest rating for this category: ";
    public static final String MY_WISH_COMMENT = "Suggested based on categories you wish";

    // JWT Constants
    public static final String SECRET_KEY = "rbcshopping";
    public static final String USER_ID = "userId";
    public static final String PASSWORD = "password";

    // Error Constants
    public static final String USER_NOT_FOUND = "User not found";
    public static final String UNAUTHORIZED = "Unauthorized access";
    public static final String APP_ERROR = "Application error occurred, please retry later.";

    public static final String AUTHORIZATION_HEADER = "Authorization";

    public static final String SCHEDULER_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

}
