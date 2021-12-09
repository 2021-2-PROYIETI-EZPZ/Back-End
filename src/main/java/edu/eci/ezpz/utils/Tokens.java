package edu.eci.ezpz.utils;

public interface Tokens {
    String COOKIE_NAME = "ezpz-JWT";
    String CLAIMS_ROLES_KEY = "ezpz_roles";
    int TOKEN_DURATION_MINUTES = 1440;
    String ADMIN_ROLE = "ADMIN";
    String USER_ROLE = "USER";
}
