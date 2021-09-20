package edu.eci.ezpz.service;

import edu.eci.ezpz.controller.client.ClientDto;
import edu.eci.ezpz.repository.document.Client;

public interface ClientService {

    public Client createClient(ClientDto dto);
    public boolean deleteClient( String email );
}
