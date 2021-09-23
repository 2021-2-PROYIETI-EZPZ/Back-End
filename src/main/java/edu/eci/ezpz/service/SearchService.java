package edu.eci.ezpz.service;

import edu.eci.ezpz.controller.search.SearchDto;
import edu.eci.ezpz.repository.document.Search;

import java.util.ArrayList;

public interface SearchService {
    public boolean saveHistory(SearchDto searchDto);
    public ArrayList<String> getHistoryByUser(String emailuser);

}
