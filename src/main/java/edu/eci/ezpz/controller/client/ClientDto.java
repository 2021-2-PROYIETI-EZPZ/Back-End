package edu.eci.ezpz.controller.client;

import edu.eci.ezpz.repository.document.MemberShip;

public class ClientDto {

    private String email;
    private String name;
    private String phoneNumber;
    private String username;
    private String password;
    private String[] searchRecord;
    private MemberShip currentMemberShip;

    public ClientDto() { }

    public ClientDto(String email, String name, String phoneNumber, String username, String password, String[] searchRecord, MemberShip currentMemberShip) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.searchRecord = searchRecord;
        this.currentMemberShip = currentMemberShip;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSearchRecord(String[] searchRecord) {
        this.searchRecord = searchRecord;
    }

    public void setCurrentMemberShip(MemberShip currentMemberShip) {
        this.currentMemberShip = currentMemberShip;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String[] getSearchRecord() {
        return searchRecord;
    }

    public MemberShip getCurrentMemberShip() {
        return currentMemberShip;
    }
}
