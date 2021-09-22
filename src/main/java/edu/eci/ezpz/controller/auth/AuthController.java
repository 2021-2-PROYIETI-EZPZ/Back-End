package edu.eci.ezpz.controller.auth;


import edu.eci.ezpz.exception.InvalidCredentialsException;
import edu.eci.ezpz.repository.document.Administrator;
import edu.eci.ezpz.repository.document.Client;
import edu.eci.ezpz.repository.document.Seller;
import edu.eci.ezpz.service.AdministratorService;
import edu.eci.ezpz.service.ClientService;
import edu.eci.ezpz.service.SellerService;
import static edu.eci.ezpz.utils.Tokens.CLAIMS_ROLES_KEY;
import static edu.eci.ezpz.utils.Tokens.TOKEN_DURATION_MINUTES;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping( "v1/auth" )
public class AuthController
{
    @Value( "${app.secret}" )
    String secret;

    private final SellerService sellerService;
    private final ClientService clientService;
    private final AdministratorService administratorService;

    public AuthController(@Autowired SellerService sellerService,@Autowired ClientService clientService,@Autowired AdministratorService administratorService)
    {
        this.sellerService = sellerService;
        this.clientService = clientService;
        this.administratorService = administratorService;
    }

    @PostMapping("/loginSeller")
    public TokenDto loginSeller(@RequestBody LoginDto loginDto)
    {
        Seller seller = sellerService.findByEmail(loginDto.email);

        if (BCrypt.checkpw(loginDto.password, seller.getPassword()))
        {
            return generateTokenDto(seller);
        }
        else
        {
            throw new InvalidCredentialsException();
        }

    }

    @PostMapping("/loginClient")
    public TokenDto loginClient(@RequestBody LoginDto loginDto)
    {
        Client client = clientService.findByEmail(loginDto.email);
        if (BCrypt.checkpw(loginDto.password, client.getPassword()))
        {
            return generateTokenDto(client);
        }
        else
        {
            throw new InvalidCredentialsException();
        }

    }

    @PostMapping("/loginAdministrator")
    public TokenDto loginAdministrator(@RequestBody LoginDto loginDto)
    {
        Administrator administrator = administratorService.findByEmail(loginDto.email);
        if (BCrypt.checkpw(loginDto.password, administrator.getPassword()))
        {
            return generateTokenDto(administrator);
        }
        else
        {
            throw new InvalidCredentialsException();
        }

    }

    private String generateToken(Seller seller, Date expirationDate)
    {
        return Jwts.builder()
                .setSubject(seller.getEmail())
                .claim(CLAIMS_ROLES_KEY, seller)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private TokenDto generateTokenDto(Seller seller)
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, TOKEN_DURATION_MINUTES);
        String token = generateToken(seller, expirationDate.getTime());
        return new TokenDto(token, expirationDate.getTime());
    }

    private String generateToken(Client client, Date expirationDate)
    {
        return Jwts.builder()
                .setSubject(client.getEmail())
                .claim(CLAIMS_ROLES_KEY, client)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private TokenDto generateTokenDto(Client client)
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, TOKEN_DURATION_MINUTES);
        String token = generateToken(client, expirationDate.getTime());
        return new TokenDto(token, expirationDate.getTime());
    }

    private String generateToken(Administrator administrator, Date expirationDate)
    {
        return Jwts.builder()
                .setSubject(administrator.getEmail())
                .claim(CLAIMS_ROLES_KEY, administrator)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private TokenDto generateTokenDto(Administrator administrator)
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, TOKEN_DURATION_MINUTES);
        String token = generateToken(administrator, expirationDate.getTime());
        return new TokenDto(token, expirationDate.getTime());
    }
}
