package com.microsystem.UserService.Controllers;

import java.nio.CharBuffer;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;

import com.microsystem.UserService.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController()
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

    @PostMapping(value = "login")
    public String login(User userCredentials) {
        User user = userController.getUserByUsername(userCredentials.getUsername());
        if (passwordEncoder.matches(CharBuffer.wrap(userCredentials.getPassword()), user.getPassword())) {
             return createToken(user);
         }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("validateToken")
    public String validateToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        User user = userController.getUserByUsername(username);
        return createToken(user);
    }

    private String createToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());

        Date now = Date.from(Instant.now());
        Date validity = new Date(now.getTime() + 3600000); // 1 hour

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
