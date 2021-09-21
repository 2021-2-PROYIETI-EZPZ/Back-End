package edu.eci.ezpz.service.impl;

import edu.eci.ezpz.controller.client.ClientDto;
import edu.eci.ezpz.exception.ClientNotFoundException;
import edu.eci.ezpz.repository.ClientRepository;
import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.service.ClientService;
import edu.eci.ezpz.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository repository;


    @Override
    public Client createClient(ClientDto dto) {
        MemberShip ms =  new MemberShip();
        for( String[] m : Constants.memberships ){
            if( m[0].equals( dto.getCurrentMemberShip().getCodeMembership() ) ){
                ms.setActive( dto.getCurrentMemberShip().isActive() );
                ms.setName( m[1] );
                ms.setDescription( m[2] );
            }
        }
        return repository.save( new Client(dto.getEmail(), dto.getName(), dto.getPhoneNumber(), dto.getUsername(), dto.getPassword(), dto.getSearchRecord(), ms) );
    }

    @Override
    public boolean deleteClient(String email) {
        boolean deleted = repository.existsById( email );
        if( deleted ){ repository.deleteById( email ); }else{throw new ClientNotFoundException();}
        return deleted;
    }

    @Override
    public boolean updateClient(ClientDto dto, String email) {
        if ( repository.findById(email).isPresent() )
        {
            Client client = repository.findById( email ).get();
            client.update( dto );
            repository.save( client );
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public List<Client> all() {
        return repository.findAll();
    }


}
