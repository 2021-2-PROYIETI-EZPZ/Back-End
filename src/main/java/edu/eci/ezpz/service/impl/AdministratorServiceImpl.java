package edu.eci.ezpz.service.impl;
import edu.eci.ezpz.controller.administrator.AdministratorDto;
import edu.eci.ezpz.exception.AdministratorNotFoundException;
import edu.eci.ezpz.repository.AdministratorRepository;
import edu.eci.ezpz.repository.document.Administrator;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.service.AdministratorService;
import edu.eci.ezpz.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository repository;

    @Override
    public Administrator createAdministrator(AdministratorDto dto) {
        MemberShip ms =  new MemberShip();
        for( String[] m : Constants.memberships ){
            if( m[0].equals( dto.getCurrentMemberShip().getCodeMembership() ) ){
                ms.setActive( dto.getCurrentMemberShip().isActive() );
                ms.setName( m[1] );
                ms.setDescription( m[2] );
            }
        }
        return repository.save( new Administrator(dto.getEmail(), dto.getName(), dto.getPhoneNumber(), dto.getUsername(), dto.getPassword(), dto.getSearchRecord(), ms) );
    }

    @Override
    public boolean deleteAdministrator(String email) {
        boolean deleted = repository.existsById( email );
        if( deleted ){ repository.deleteById( email ); }else{throw new AdministratorNotFoundException();}
        return deleted;
    }
}