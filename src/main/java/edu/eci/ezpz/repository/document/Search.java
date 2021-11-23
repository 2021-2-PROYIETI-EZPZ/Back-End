package edu.eci.ezpz.repository.document;

import java.util.ArrayList;
import java.util.Date;

public class Search {
    //private Date datesearch;
    private String productname;

    ArrayList<String> arrayListSearch=new ArrayList<>();

    public Search( String productname) {

        this.productname = productname;
    }

    public void setArrayListSearch(String productname) {
        this.arrayListSearch.add(productname);
    }
    public ArrayList<String> getArrayListSearch(String productname) {
        return arrayListSearch;
    }
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
}
