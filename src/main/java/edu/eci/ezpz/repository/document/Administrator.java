package edu.eci.ezpz.repository.document;
import edu.eci.ezpz.controller.administrator.AdministratorDto;
import edu.eci.ezpz.repository.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document
public class Administrator implements User {

    @Id
    private String email;

    @Indexed( unique = true )
    private String name;

    @Indexed( unique = true )
    private String username;

    private MemberShip memberShip;

    private String password;
    private String password2;
    private List<RoleEnum> roles;

    public Administrator(String email, String name, String username, String password, MemberShip memberShip) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.memberShip = memberShip;
        this.password = BCrypt.hashpw( password, BCrypt.gensalt() );
        this.password2 = password;
        roles = new ArrayList<>(Collections.singleton(RoleEnum.ADMIN));
    }

    public void update(AdministratorDto dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.username = dto.getUsername();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MemberShip getMemberShip() {
        return memberShip;
    }

    public void setMemberShip(MemberShip memberShip) {
        this.memberShip = memberShip;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public List<RoleEnum> getRoles() {return roles;}
}