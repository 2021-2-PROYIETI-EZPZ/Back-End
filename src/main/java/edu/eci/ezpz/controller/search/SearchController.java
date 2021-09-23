package edu.eci.ezpz.controller.search;

import edu.eci.ezpz.controller.client.ClientDto;
import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.repository.document.Search;
import edu.eci.ezpz.service.ClientService;
import edu.eci.ezpz.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( "/v1/search" )
public class SearchController {
    @Autowired
    private SearchService service;

    @PostMapping
    public boolean createClient(@RequestBody SearchDto dto){
        return service.saveHistory( dto );
    }
    @GetMapping("/{emailuser}")
    public ArrayList<String> getHistoryByUser(@PathVariable String emailuser)
    {
        return service.getHistoryByUser(emailuser);
    }
}

