package edu.eci.ezpz.controller.seller;

import edu.eci.ezpz.controller.client.CurrentMemberShip;
import edu.eci.ezpz.repository.document.Product;
import edu.eci.ezpz.repository.document.Seller;

public class SellerDto {

    private String email;
    private String name;
    private String username;
    private String password;
    private String linkPage;
    private String fileHash;
    private String nameFile;

    public SellerDto() {}

    public SellerDto(String email, String name, String username, String password, String linkPage, String fileHash, String fileName) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
        this.linkPage = linkPage;
        this.fileHash = fileHash;
        this.nameFile = nameFile;
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

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
}
