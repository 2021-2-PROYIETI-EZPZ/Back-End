package edu.eci.ezpz.service;
import edu.eci.ezpz.controller.administrator.AdministratorDto;
import edu.eci.ezpz.exception.AdministratorNotFoundException;
import edu.eci.ezpz.repository.document.Administrator;
public interface AdministratorService {
    Administrator createAdministrator(AdministratorDto dto);
    Administrator updateAdministrator(AdministratorDto dto, String email);
    Administrator findByEmail( String email ) throws AdministratorNotFoundException;
}