package edu.eci.ezpz.utils;

public class Constants {

    public static String COOKIE_NAME = "ezpz-JWT";
    public static String CLAIMS_ROLES_KEY = "ezpz_roles";
    public static int TOKEN_DURATION_MINUTES = 1440;
    public static String ADMIN_ROLE = "ADMIN";
    public static String USER_ROLE = "USER";

    public static String[][] memberships = {
            { "MEM_01", "Notificaciones de vendedor", "El sistema notifica al usuario sobre las nuevas actualizaciones de sus vendedores favoritos" },
            {"MEM_02", "Notificaciones de cliente", "El sistema notificara cuando un usuario realice busquedas en su pagina"}
    };
}
