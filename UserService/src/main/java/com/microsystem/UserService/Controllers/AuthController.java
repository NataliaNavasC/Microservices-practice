package com.microsystem.UserService.Controllers;

import java.nio.CharBuffer;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;

import com.microsystem.UserService.Response.TokenResponse;
import com.microsystem.UserService.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import Exceptions.InvalidFieldsException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthController {
    @Autowired
    private UserController userController;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @PostConstruct
    protected void init() {
         secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    @RequestMapping(
        value = "login",
        method = RequestMethod.POST,
        produces = {"application/json"}
    )
    public TokenResponse login(@RequestBody User userCredentials) {
        if( userCredentials.getUsername().equals("") && userCredentials.getPassword().equals("")){
            throw new InvalidFieldsException();
        }

        User user = userController.getUserByUsername(userCredentials.getUsername());
        
        if (passwordEncoder.matches(CharBuffer.wrap(userCredentials.getPassword()), user.getPassword())) {
             return createToken(user);
             
         }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping("validateToken")
    public TokenResponse validateToken(@RequestParam String token) {
        String username = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        User user = userController.getUserByUsername(username);
        return createToken(user);
    }

    private TokenResponse createToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());

        Date now = Date.from(Instant.now());
        Date validity = new Date(now.getTime() + 3600000 * 10); // 10 hours
        String token = Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(validity)
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
        return new TokenResponse(token);
    }

    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
