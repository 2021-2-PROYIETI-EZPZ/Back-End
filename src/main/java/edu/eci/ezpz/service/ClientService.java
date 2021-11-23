package edu.eci.ezpz.service;

import edu.eci.ezpz.controller.client.ClientDto;
import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.repository.document.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ClientService {

    public Client createClient(ClientDto dto);
    public boolean deleteClient( String email );
    public boolean updateClient(ClientDto dto, String email);
    public boolean getClientByEmail(String email,String password) throws IOException;

    List<Client> all();
}
