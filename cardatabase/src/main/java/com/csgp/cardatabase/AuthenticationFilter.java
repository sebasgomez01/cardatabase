package com.csgp.cardatabase;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.csgp.cardatabase.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    public AuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
    FilterChain filterChain) throws ServletException, java.io.IOException {

        // obtengo el token del header AUTHORIZATION
        String jws = request.getHeader(HttpHeaders.AUTHORIZATION);

        // si el token no es nulo
        if (jws != null) {

            // Verifico que el token sea válido y obtengo el usuario 
            String user = jwtService.getAuthUser(request);
            // Realizo la autenticación 
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null,
            java.util.Collections.emptyList());
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

       
}
