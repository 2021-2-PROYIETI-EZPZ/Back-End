package edu.eci.ezpz.controller.administrator;
import edu.eci.ezpz.repository.document.Administrator;
import edu.eci.ezpz.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping( "/v1/administrator" )
public class AdministratorController {

    @Autowired
    private AdministratorService service;

    @PostMapping
    public Administrator createAdministrator(@RequestBody AdministratorDto dto){
        return service.createAdministrator( dto );
    }

    @DeleteMapping("/{email}")
    public boolean deleteAdministrator( @PathVariable String email ){
        return service.deleteAdministrator( email );
    }
}