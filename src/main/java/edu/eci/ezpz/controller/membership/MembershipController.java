package edu.eci.ezpz.controller.membership;

import edu.eci.ezpz.controller.client.ClientDto;
import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.repository.document.MemberShip;
import edu.eci.ezpz.service.ClientService;
import edu.eci.ezpz.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping( "/v1/membership" )
public class MembershipController {
    @Autowired
    private MembershipService service;

    @PostMapping
    public MemberShip createMemberShip(@RequestBody MemberShip dto){
        return service.createMembership( dto );
    }

    @GetMapping
    public List<MemberShip> findAllMemberShips(){ return service.findAllMemberShips(); }

    @GetMapping("/purchasedMemberships")
    public List<MemberShip> findAllPurchasedMembership(){ return service.findAllPurchasedMembership(); }

    @PostMapping("/filterAllMemberships")
    public List<MemberShip> filterAllMemberships(@RequestBody DateRange dateRange){ return service.filterAllMemberships( dateRange.getStart(), dateRange.getEnd() ); }

    @GetMapping("/{id}")
    public MemberShip findByIdMembership(@PathVariable String id)
    {
        return service.findById(id);
    }

    @PutMapping( "/{id}" )
    public MemberShip updateMemberShip( @PathVariable String id, @RequestBody MemberShip ms ){ return service.updateMemberShip( ms, id ); }

    @DeleteMapping("/{id}")
    public boolean deleteMemberShipById( @PathVariable String id ){ return service.deleteById( id ); }

}
