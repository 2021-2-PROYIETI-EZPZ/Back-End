package edu.eci.ezpz.repository.document;



public class MemberShip {

    private boolean active;
    private String name;
    private String codeMembership;
    private String description;

    public String getCodeMembership() {
        return codeMembership;
    }

    public void setCodeMembership(String codeMembership) {
        this.codeMembership = codeMembership;
    }

    public MemberShip() {  }

    public MemberShip(boolean active, String name,String codeMembership, String description) {
        this.active = active;
        this.name = name;
        this.codeMembership=codeMembership;
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
