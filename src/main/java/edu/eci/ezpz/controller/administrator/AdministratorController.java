package edu.eci.ezpz.controller.administrator;
import edu.eci.ezpz.repository.document.Administrator;
import edu.eci.ezpz.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping( "/v1/admin" )
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping
    public Administrator createAdministrator(@RequestBody AdministratorDto dto){
        System.out.println("AdministratorController");
        System.out.println(dto.getEmail());
        System.out.println(dto.getPassword());
        return administratorService.createAdministrator(dto);
    }

    @PutMapping("/{email}")
    public Administrator updateAdministrator(@RequestBody AdministratorDto dto, @PathVariable String email){
        return administratorService.updateAdministrator(dto, email);
    }
}