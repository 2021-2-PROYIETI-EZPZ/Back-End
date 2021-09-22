package edu.eci.ezpz.controller.seller;

import edu.eci.ezpz.repository.document.Seller;
import edu.eci.ezpz.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping( "/v1/seller" )
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public Seller createSeller(@RequestBody SellerDto dto) throws IOException {
        return sellerService.createSeller( dto );
    }

    @PutMapping("/{email}")
    public Seller updateSeller(@RequestBody SellerDto dto, @PathVariable String email){
        return sellerService.updateSeller(dto, email);
    }

    @DeleteMapping("/{email}")
    public boolean deleteSeller(@PathVariable String email){
        return sellerService.deleteSeller(email);
    }
}
