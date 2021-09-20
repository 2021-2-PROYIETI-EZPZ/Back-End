package edu.eci.ezpz.repository.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Document
public class Administrator {

    @Id
    private String email;

    @Indexed( unique = true )
    private String name;

    @Indexed( unique = true )
    private String phoneNumber;

    @Indexed( unique = true )
    private String username;

    private String password;

    public Administrator() { }

    public Administrator(String email, String name, String phoneNumber, String username, String password) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = BCrypt.hashpw( password, BCrypt.gensalt() );
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}