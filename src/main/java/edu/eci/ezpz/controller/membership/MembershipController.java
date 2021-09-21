package edu.eci.ezpz.controller.membership;

import edu.eci.ezpz.controller.client.ClientDto;
import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.service.ClientService;
import edu.eci.ezpz.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/v1/membership" )
public class MembershipController {
    @Autowired
    private MembershipService service;
    @PostMapping
    public MemberShip createMemberShip(@RequestBody MemberShip dto){
        return service.createMembership( dto );
    }
    @GetMapping("/{id}")
    public MemberShip findByIdMembership(@PathVariable String id)
    {
        return service.findById(id);
    }


}
