package edu.eci.ezpz.service.impl;
import edu.eci.ezpz.controller.administrator.AdministratorDto;
import edu.eci.ezpz.repository.AdministratorRepository;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.repository.document.Administrator;
import edu.eci.ezpz.service.AdministratorService;
import edu.eci.ezpz.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

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
}