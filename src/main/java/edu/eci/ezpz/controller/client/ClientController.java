package edu.eci.ezpz.controller.client;


import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/v1/client" )
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public Client createClient(@RequestBody ClientDto dto){
        return service.createClient( dto );
    }







}
