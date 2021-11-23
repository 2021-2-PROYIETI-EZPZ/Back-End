package edu.eci.ezpz.service;

import edu.eci.ezpz.controller.client.ClientDto;
import edu.eci.ezpz.exception.ClientNotFoundException;
import edu.eci.ezpz.repository.document.Client;

import java.util.List;

public interface ClientService {
    public Client findByEmail(String email) throws ClientNotFoundException;
    public Client createClient(ClientDto dto);
    public boolean deleteClient( String email );
    public boolean updateClient(ClientDto dto, String email);
    public boolean compareCredential(String dtoPassword, String adminPassword);
    List<Client> all();
}
