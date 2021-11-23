package edu.eci.ezpz.repository;

import edu.eci.ezpz.repository.document.RoleEnum;

import java.util.List;

public interface User {

    public String getEmail();
    public void setEmail(String email);
    public String getName();
    public void setName(String name);
    public String getUsername();
    public void setUsername(String username);
    public String getPassword();
    public void setPassword(String password);
    public List<RoleEnum> getRoles();
}
