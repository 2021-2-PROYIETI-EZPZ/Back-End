package edu.eci.ezpz.service.impl;

import edu.eci.ezpz.controller.client.ClientDto;
import edu.eci.ezpz.exception.ClientNotFoundException;
import edu.eci.ezpz.exception.EmptyMembershipField;
import edu.eci.ezpz.repository.ClientRepository;
import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.repository.document.Product;
import edu.eci.ezpz.repository.document.Seller;
import edu.eci.ezpz.service.ClientService;
import edu.eci.ezpz.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository repository;


    @Override
    public Client findByEmail(String email) throws ClientNotFoundException
    {
        Client client = null;
        Optional<Client> optionalClient = repository.findByEmail(email);
        if(optionalClient.isPresent()) client = optionalClient.get();
        else throw new ClientNotFoundException();
        return client;
    }

    @Override
    public Client createClient(ClientDto dto) {
        checkMembership(dto.getCurrentMemberShip());
        return repository.save( new Client(dto.getEmail(), dto.getName(), dto.getPhoneNumber(), dto.getUsername(), dto.getPassword(), dto.getSearchRecord(), dto.getCurrentMemberShip()) );
    }

    @Override
    public boolean deleteClient(String email) {
        boolean deleted = repository.existsById( email );
        if( deleted ){ repository.deleteById( email ); }else{throw new ClientNotFoundException();}
        return deleted;
    }

    @Override
    public boolean updateClient(ClientDto dto, String email) {
        Optional<Client> op = repository.findById(email);
        if ( op.isPresent() )
        {
            Client client = op.get();
            client.update( dto );
            repository.save( client );
            return true;
        }
        else{
            throw new ClientNotFoundException();
        }

    }
    @Override
    public boolean getClientByEmail(String email, String password) throws IOException {
        boolean resbool=false;
        Client cliente= repository.findById(email).get();
        if(repository.findById(email).isPresent()){
            boolean checkpass=BCrypt.checkpw(password,cliente.getPassword());
            if(checkpass==true)
            {
                resbool=true;
            }
            else
            {
                resbool=false;
            }
        }
        return resbool;
    }
    @Override
    public List<Client> all() {
        return repository.findAll();
    }

    @Override
    public Client getClient(String email) {
        Optional<Client> op = repository.findById(email);
        if(op.isPresent()){
            return op.get();
        }
        else{
            throw new ClientNotFoundException();
        }

    }


    private boolean checkMembership(MemberShip ms){
        boolean response = false;
        if( ms == null ){ return true; }
        else{
            for (Field f : ms.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                try {
                    if (f.get(ms) == null  ) { throw new EmptyMembershipField();  }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

    @Override
    public boolean compareCredential(String dtoPassword, String adminPassword) {
        boolean check = false;
        if(dtoPassword.equals(adminPassword))
        {
            check = true;
        }
        else {
            check = false;
        }

        return check;
    }
}
