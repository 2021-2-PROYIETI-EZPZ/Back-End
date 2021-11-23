package edu.eci.ezpz.controller.client;


import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.repository.document.Product;
import edu.eci.ezpz.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping( "/v1/client" )
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public Client createClient(@RequestBody ClientDto dto){
        return service.createClient( dto );
    }


    @DeleteMapping("/{email}")
    public boolean deleteClient( @PathVariable String email ){
        return service.deleteClient( email );
    }

    @PutMapping("/{email}")
    public boolean updateClient( @RequestBody ClientDto dto, @PathVariable String email){
        return service.updateClient( dto,email );
    }
    @GetMapping("/login")
    public boolean getClientByEmail (@RequestParam("email") String email,@RequestParam("password") String password) throws IOException {
        return service.getClientByEmail(email,password);
    }
    @GetMapping
    public List<Client> all()
    {
        return service.all();
    }






}
