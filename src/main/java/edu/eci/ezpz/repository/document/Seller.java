package edu.eci.ezpz.repository.document;


import edu.eci.ezpz.controller.seller.SellerDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document
public class Seller {

    @Id
    private String email;

    @Indexed( unique = true )
    private String name;

    @Indexed( unique = true )
    private String username;

    private String linkPage;

    private String password;

    private ArrayList<Product> product;

    private List<RoleEnum> roles;

    public Seller(String email, String name, String username, String password, String linkPage) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.linkPage = linkPage;
        roles = new ArrayList<>(Collections.singleton(RoleEnum.SELLER));
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLinkPage() {
        return linkPage;
    }

    public void setLinkPage(String linkPage) {
        this.linkPage = linkPage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }

    public List<RoleEnum> getRoles() {return roles;}

    public void update(SellerDto dto, ArrayList<Product> products) {
        this.name = dto.getName();
        this.linkPage = dto.getLinkPage();
        this.email = dto.getEmail();
        this.username = dto.getUsername();
        this.product = products;
    }

}
