package edu.eci.ezpz.repository.document;
import edu.eci.ezpz.controller.administrator.AdministratorDto;
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
    private String username;

    private MemberShip memberShip;

    private String password;

    public Administrator(String email, String name, String username, String password, MemberShip memberShip) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.memberShip = memberShip;
        this.password = BCrypt.hashpw( password, BCrypt.gensalt() );
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

    public void setPassword(String password) {
        this.password = password;
    }
}