package edu.eci.ezpz.controller.client;

public class CurrentMemberShip {

    private boolean active;
    private String codeMembership;

    public CurrentMemberShip() {
    }

    public CurrentMemberShip(boolean active, String codeMembership) {
        this.active = active;
        this.codeMembership = codeMembership;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCodeMembership() {
        return codeMembership;
    }

    public void setCodeMembership(String codeMembership) {
        this.codeMembership = codeMembership;
    }
}
