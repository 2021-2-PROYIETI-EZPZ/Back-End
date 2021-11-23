package edu.eci.ezpz.controller.administrator;
import edu.eci.ezpz.controller.client.CurrentMemberShip;
public class AdministratorDto {

    private String email;
    private String name;
    private String username;
    private String password;
    private String linkPage;
    private CurrentMemberShip currentMemberShip;

    public AdministratorDto() {}

    public AdministratorDto(String email, String name, String username, String password, CurrentMemberShip currentMemberShip) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.currentMemberShip = currentMemberShip;
        System.out.println("AdministratorDto");
        System.out.println(this.email);
        System.out.println(this.password);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLinkPage() {
        return linkPage;
    }

    public void setLinkPage(String linkPage) {
        this.linkPage = linkPage;
    }

    public CurrentMemberShip getCurrentMemberShip() {
        return currentMemberShip;
    }

    public void setCurrentMemberShip(CurrentMemberShip currentMemberShip) {
        this.currentMemberShip = currentMemberShip;
    }
}