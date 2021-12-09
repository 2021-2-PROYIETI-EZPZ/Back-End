package edu.eci.ezpz.service;
import edu.eci.ezpz.controller.administrator.AdministratorDto;
import edu.eci.ezpz.exception.AdministratorNotFoundException;
import edu.eci.ezpz.repository.document.Administrator;
public interface AdministratorService {
    public Administrator findByEmail(String email) throws AdministratorNotFoundException;
    Administrator createAdministrator(AdministratorDto dto);
    Administrator updateAdministrator(AdministratorDto dto, String email);
    public boolean compareCredential(String dtoPassword, String adminPassword);
}