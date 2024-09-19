package org.globallogic.constant;

public class Constant {

    // Validations Errors
    public static final String USER_DOES_NOT_EXIST_EXCEPTION_MESSAGE = "User doesn't exist.";
    public static final String USERS_DOES_EXIST_EXCEPTION_MESSAGE = "This email are using.";
    public static final String EMAIL_FORMAT_ERROR_MESSAGE = "Enter a valid email address.Example : email@email.com";
    public static final String CREDENTIALS_FORMAT_ERROR_MESSAGE =
            "Invalid Format Password.The pattern to create the password most be first one capital letter, then lower case letters, and last two numbers from zero to nine. Example 'Password22'.";

    // Null Field Error
    public static final String EMAIL_NULL_ERROR_MESSAGE = "email cannot be null.";
    public static final String TOKEN_NULL_ERROR_MESSAGE = "token cannot be null.";
    public static final String CREDENTIALS_NULL_ERROR_MESSAGE = "password cannot be null.";
    public static final String NUMBER_NULL_ERROR_MESSAGE = "number cannot be null.";
    public static final String CITYWIDE_NULL_ERROR_MESSAGE = "city_code cannot be null.";
    public static final String COUNTRYSIDE_NULL_ERROR_MESSAGE = "country_code cannot be null.";

    // Empty Field Error
    public static final String EMAIL_EMPTY_ERROR_MESSAGE = "email is required.";
    public static final String TOKEN_EMPTY_ERROR_MESSAGE = "token is required.";
    public static final String CREDENTIALS_EMPTY_ERROR_MESSAGE = "password is required.";
    public static final String NUMBER_EMPTY_ERROR_MESSAGE = "number is required.";
    public static final String CITYWIDE_EMPTY_ERROR_MESSAGE = "city_code is required.";
    public static final String COUNTRYSIDE_EMPTY_ERROR_MESSAGE = "country_code is required.";

    // Patterns
    public static final String PATTERN_CREDENTIALS = "^([A-Z]{1})([a-z].*)([0-9]{2})";


}
