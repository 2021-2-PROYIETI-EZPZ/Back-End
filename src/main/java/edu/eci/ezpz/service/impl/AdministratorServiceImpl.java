package edu.eci.ezpz.service.impl;
import edu.eci.ezpz.controller.administrator.AdministratorDto;
import edu.eci.ezpz.exception.AdministratorNotFoundException;
import edu.eci.ezpz.exception.SellerNotFoundException;
import edu.eci.ezpz.repository.AdministratorRepository;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.repository.document.Administrator;
import edu.eci.ezpz.service.AdministratorService;
import edu.eci.ezpz.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public Administrator findByEmail(String email) throws AdministratorNotFoundException
    {
        Administrator administrator = null;
        Optional<Administrator> optionalAdministrator = administratorRepository.findByEmail(email);
        if(optionalAdministrator.isPresent()) administrator = optionalAdministrator.get();
        else throw new SellerNotFoundException();
        return administrator;
    }

    @Override
    public Administrator createAdministrator(AdministratorDto dto) {
        MemberShip memberShip = new MemberShip();
        for(String[] member : Constants.memberships){
            if (member[0].equals(dto.getCurrentMemberShip().getCodeMembership())) {
                memberShip.setActive(dto.getCurrentMemberShip().isActive());
                memberShip.setName(member[1]);
                memberShip.setDescription(member[2]);
            }
        }
        return administratorRepository.save(new Administrator(dto.getEmail(), dto.getName(), dto.getUsername(), dto.getPassword(), memberShip));
    }

    @Override
    public Administrator updateAdministrator(AdministratorDto dto, String email) {
        if(administratorRepository.findById(email).isPresent()){
            Administrator administrator = administratorRepository.findById(email).get();
            administrator.update(dto);
            administratorRepository.save(administrator);
            return administrator;
        }
        return null;
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