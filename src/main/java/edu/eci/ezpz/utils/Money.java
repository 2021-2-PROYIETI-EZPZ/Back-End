package edu.eci.ezpz.utils;

import java.math.BigDecimal;

public class Money {

    private SymbolEnum symbol;
    private BigDecimal amount;

    public Money() {    }

    public Money(SymbolEnum symbol, BigDecimal amount) {
        this.symbol = symbol;
        this.amount = amount;
    }

    public SymbolEnum getSymbol() {
        return symbol;
    }

    public void setSymbol(SymbolEnum symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String showValue(){
        return this.symbol+" "+this.amount.toString();
    }
}
