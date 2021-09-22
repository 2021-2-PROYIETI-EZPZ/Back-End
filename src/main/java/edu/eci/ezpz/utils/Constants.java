package edu.eci.ezpz.utils;

public class Constants {

    public String COOKIE_NAME = "ezpz-JWT";
    public String CLAIMS_ROLES_KEY = "ezpz_roles";
    public int TOKE_DURATION_MINUTES = 1440;
    public String ADMIN_ROLE = "ADMIN";
    public String USER_ROLE = "USER";

    public static String[][] memberships = {
            { "MEM_01", "Notificaciones de vendedor", "El sistema notifica al usuario sobre las nuevas actualizaciones de sus vendedores favoritos" },
            { "MEM_02", "Notificaciones de cliente", "El sistema notificara cuando un usuario realice busquedas en su pagina"},
            { "MEM_03", "Notificaciones de administrador", "El sistema notificara cuando el administrador realice cambios en cuanto a administracion de la pagina"}
    };


}
