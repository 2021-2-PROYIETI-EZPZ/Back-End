package edu.eci.ezpz.controller.auth;

public class LoginDto
{
    public String email;
    public String password;

    public LoginDto(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }
}
