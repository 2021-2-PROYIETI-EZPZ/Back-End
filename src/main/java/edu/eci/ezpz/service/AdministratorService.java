package edu.eci.ezpz.service;
import edu.eci.ezpz.controller.administrator.AdministratorDto;
import edu.eci.ezpz.repository.document.Administrator;
public interface AdministratorService {
    public Administrator createAdministrator(AdministratorDto dto);
    public boolean deleteAdministrator( String email );
}