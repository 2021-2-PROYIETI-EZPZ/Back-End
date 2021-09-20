package edu.eci.ezpz.repository.document;


import edu.eci.ezpz.controller.seller.SellerDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Document
public class Seller {

    @Id
    private String email;

    @Indexed( unique = true )
    private String name;

    @Indexed( unique = true )
    private String username;

    private String linkPage;

    private MemberShip memberShip;

    private String password;

    public Seller(String email, String name, String username, String password, String linkPage, MemberShip memberShip) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.linkPage = linkPage;
        this.memberShip = memberShip;
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

    public MemberShip getMemberShip() {
        return memberShip;
    }

    public void setMemberShip(MemberShip memberShip) {
        this.memberShip = memberShip;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void update(SellerDto dto) {
        this.name = dto.getName();
        this.linkPage = dto.getLinkPage();
        this.email = dto.getEmail();
        this.username = dto.getUsername();
    }
}
