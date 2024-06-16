package com.csgp.cardatabase.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.csgp.cardatabase.domain.AccountCredentials;
import com.csgp.cardatabase.service.JwtService;

@RestController
public class LoginController {
    
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // inyecto el JwtService y AuhtenticationManager
    public LoginController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {

        // obtengo las credenciales del parámetro credentials 
        UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.username(),
        credentials.password());
    
        // autentico con las credenciales obtenidas
        Authentication auth = authenticationManager.authenticate(creds);

        // Genero el token
        String jwts = jwtService.getToken(auth.getName());

        // construyo una respuesta con el token generado 
        ResponseEntity<?> result = ResponseEntity.ok().header(
                HttpHeaders.AUTHORIZATION, "Bearer " + jwts).header(HttpHeaders.
                ACCESS_CONTROL_EXPOSE_HEADERS,
"Authorization").build();

        return result;
    }
    
}
