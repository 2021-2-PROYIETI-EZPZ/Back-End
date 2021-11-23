package edu.eci.ezpz.controller.auth;


import edu.eci.ezpz.exception.InvalidCredentialsException;
import edu.eci.ezpz.repository.User;
import edu.eci.ezpz.repository.document.Administrator;
import edu.eci.ezpz.repository.document.Client;
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
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping( "v1/auth" )
public class AuthController
{
    @Value( "${app.secret}" )
    String secret;

    private final ClientService clientService;
    private final AdministratorService administratorService;

    public AuthController(@Autowired SellerService sellerService,@Autowired ClientService clientService,@Autowired AdministratorService administratorService)
    {
        this.clientService = clientService;
        this.administratorService = administratorService;
    }

    @PostMapping("/loginAdmin")
    public TokenDto loginAdministrator(@RequestBody LoginDto loginDto) {
        Administrator admin = administratorService.findByEmail(loginDto.email);
        if (administratorService.compareCredential(loginDto.password, admin.getPassword2()))
        {
            return generateTokenDtoClient(admin);
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
        if (clientService.compareCredential(loginDto.password, client.getPassword2()))
        {
            return generateTokenDtoClient(client);
        }
        else
        {
            throw new InvalidCredentialsException();
        }
    }

    private String generateTokenClient(User client, Date expirationDate)
    {
        return Jwts.builder()
                .setSubject(client.getEmail())
                .claim(CLAIMS_ROLES_KEY, client.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private TokenDto generateTokenDtoClient(User client)
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, TOKEN_DURATION_MINUTES);
        String token = generateTokenClient(client, expirationDate.getTime());
        return new TokenDto(token, expirationDate.getTime());
    }
}
