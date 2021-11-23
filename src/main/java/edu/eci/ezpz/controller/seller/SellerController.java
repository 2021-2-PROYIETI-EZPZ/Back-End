package edu.eci.ezpz.controller.seller;

import edu.eci.ezpz.controller.auth.LoginDto;
import edu.eci.ezpz.controller.auth.TokenDto;
import edu.eci.ezpz.exception.InvalidCredentialsException;
import edu.eci.ezpz.repository.document.Product;
import edu.eci.ezpz.repository.document.Seller;
import edu.eci.ezpz.service.SellerService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static edu.eci.ezpz.utils.Constants.CLAIMS_ROLES_KEY;
import static edu.eci.ezpz.utils.Constants.TOKEN_DURATION_MINUTES;

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
    public Seller updateSeller(@RequestBody SellerDto dto, @PathVariable String email) throws IOException {
        return sellerService.updateSeller(dto, email);
    }

}
