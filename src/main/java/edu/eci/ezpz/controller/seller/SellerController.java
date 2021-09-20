package edu.eci.ezpz.controller.seller;

import edu.eci.ezpz.repository.document.Seller;
import edu.eci.ezpz.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/v1/seller" )
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public Seller createSeller(@RequestBody SellerDto dto){
        return sellerService.createSeller( dto );
    }

    

}
