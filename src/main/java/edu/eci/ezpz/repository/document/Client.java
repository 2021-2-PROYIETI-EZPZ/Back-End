package edu.eci.ezpz.repository.document;

import edu.eci.ezpz.controller.client.ClientDto;
import edu.eci.ezpz.repository.User;
import edu.eci.ezpz.utils.Constants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document
public class Client implements User {

    @Id
    private String email;

    @Indexed( unique = true )
    private String name;

    @Indexed( unique = true )
    private String phoneNumber;

    @Indexed( unique = true )
    private String username;

    private String password;
    private String password2;
    private String[] searchRecord;

    private MemberShip memberShip;

    private List<RoleEnum> roles;

    public Client() { }

    public Client(String email, String name, String phoneNumber, String username, String password, String[] searchRecord, MemberShip memberShip) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = BCrypt.hashpw( password, BCrypt.gensalt() );
        this.password2 = password;
        roles = new ArrayList<>(Collections.singleton(RoleEnum.CLIENT));
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
    public String getPassword2() {
        return password2;
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

    public List<RoleEnum> getRoles() {return roles;}

    public void update(ClientDto dto) {
        //this.email= dto.getEmail();
        this.name = dto.getName();
        this.phoneNumber = dto.getPhoneNumber();
        this.username = dto.getUsername();
        this.password = BCrypt.hashpw( dto.getPassword(), BCrypt.gensalt() );

        this.searchRecord = dto.getSearchRecord();
        MemberShip ms1 =  new MemberShip();
        for( String[] m : Constants.memberships ){
            if( m[0].equals( dto.getCurrentMemberShip().getCodeMembership() ) ){
                ms1.setActive( dto.getCurrentMemberShip().isActive() );
                ms1.setName( m[1] );
                ms1.setDescription( m[2] );
            }
        }
        this.memberShip = ms1;
    }
}

