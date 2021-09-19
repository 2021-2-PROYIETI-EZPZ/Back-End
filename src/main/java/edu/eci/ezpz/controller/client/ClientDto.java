package edu.eci.ezpz.controller.client;

public class ClientDto {

    private String email;
    private String name;
    private String phoneNumber;
    private String username;
    private String password;
    private String[] searchRecord;
    private CurrentMemberShip currentMemberShip;

    public ClientDto() {}

    public ClientDto(String email, String name, String phoneNumber, String username, String password, String[] searchRecord, CurrentMemberShip currentMemberShip) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.searchRecord = searchRecord;
        this.currentMemberShip = currentMemberShip;
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

    public CurrentMemberShip getCurrentMemberShip() {
        return currentMemberShip;
    }

    public void setCurrentMemberShip(CurrentMemberShip currentMemberShip) {
        this.currentMemberShip = currentMemberShip;
    }
}
