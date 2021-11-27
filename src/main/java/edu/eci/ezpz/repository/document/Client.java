package edu.eci.ezpz.repository.document;

import edu.eci.ezpz.controller.client.ClientDto;
import edu.eci.ezpz.utils.Constants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Document
public class Client {

    @Id
    private String email;

    @Indexed( unique = true )
    private String name;

    @Indexed( unique = true )
    private String phoneNumber;

    @Indexed( unique = true )
    private String username;

    private String password;

    private String[] searchRecord;

    private MemberShip memberShip;

    public Client() { }

    public Client(String email, String name, String phoneNumber, String username, String password, String[] searchRecord, MemberShip memberShip) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = BCrypt.hashpw( password, BCrypt.gensalt() );
        this.searchRecord = searchRecord;
        this.memberShip = memberShip;
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

    public String[] getSearchRecord() {
        return searchRecord;
    }

    public void setSearchRecord(String[] searchRecord) {
        this.searchRecord = searchRecord;
    }

    public MemberShip getMemberShip() {
        return memberShip;
    }

    public void setMemberShip(MemberShip memberShip) {
        this.memberShip = memberShip;
    }

    public void update(ClientDto dto) {
        this.email= ( this.email != dto.getEmail() && dto.getEmail() != null )? dto.getEmail() : this.email;
        this.name =  (this.name != dto.getName() && dto.getName() != null )? dto.getName() : this.name ;
        this.phoneNumber = (this.phoneNumber != dto.getPhoneNumber() && dto.getPhoneNumber() != null )? dto.getPhoneNumber() : this.phoneNumber;
        this.username = (this.username != dto.getUsername() && dto.getUsername() != null )? dto.getUsername() : this.username;
        //this.password = this.password !=  BCrypt.hashpw( dto.getPassword(), BCrypt.gensalt() ) ? BCrypt.hashpw( dto.getPassword(), BCrypt.gensalt() ) : this.password ;

        this.memberShip = this.memberShip != dto.getCurrentMemberShip() ? dto.getCurrentMemberShip() : this.memberShip;
    }
}
