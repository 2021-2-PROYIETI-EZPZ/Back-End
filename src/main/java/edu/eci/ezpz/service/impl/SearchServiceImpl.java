package edu.eci.ezpz.service.impl;

import edu.eci.ezpz.controller.search.SearchDto;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.repository.document.Search;
import edu.eci.ezpz.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    private final HashMap<String, List<String>> hashSearchUser = new HashMap();
    @Override
    public boolean saveHistory(SearchDto searchDto) {
        if (hashSearchUser.containsKey(searchDto.getIdclient())==false)
        {
            List<String> arrayList=new ArrayList<>();
            arrayList.add(searchDto.getProductname());
            hashSearchUser.put(searchDto.getIdclient(),arrayList);
            return true;
        }
        else
        {
            List<String> arrayList=hashSearchUser.get(searchDto.getIdclient());
            arrayList.add(searchDto.getProductname());
            hashSearchUser.replace(searchDto.getIdclient(), arrayList);
            return true;
        }

    }

    @Override
    public ArrayList<String> getHistoryByUser(String emailuser) {
        return (ArrayList<String>) hashSearchUser.get(emailuser);
    }
}
