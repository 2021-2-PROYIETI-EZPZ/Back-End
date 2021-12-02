package edu.eci.ezpz.controller.membership;

import java.util.Date;

public class IncomeResponse {

    private Date start;
    private Date end;
    private String income;

    public IncomeResponse() {  }

    public IncomeResponse(Date start, Date end, String income) {
        this.start = start;
        this.end = end;
        this.income = income;
    }


    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
