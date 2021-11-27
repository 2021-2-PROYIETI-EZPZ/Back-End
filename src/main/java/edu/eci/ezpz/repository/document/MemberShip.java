package edu.eci.ezpz.repository.document;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class MemberShip {

    @Id
    private String codeMembership;
    private boolean active;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date startDate;
    private String description;

    public MemberShip() {  }

    public MemberShip(String codeMembership, boolean active, String name, Date startDate, String description) {
        this.codeMembership = codeMembership;
        this.active = active;
        this.name = name;
        this.startDate = startDate;
        this.description = description;
    }

    public String getCodeMembership() {
        return codeMembership;
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setCodeMembership(String codeMembership) {
        this.codeMembership = codeMembership;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
