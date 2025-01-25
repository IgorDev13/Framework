package com.descomplica.Frameblog.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.descomplica.Frameblog.models.User;
import com.descomplica.Frameblog.repositories.UserRepository;
import com.descomplica.Frameblog.request.AuthRequest;
import com.descomplica.Frameblog.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AuthenticationServiceimpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
            return userRepository.findByUsername(login);
    }

    @Override
    public String getToken(AuthRequest auth){
        User user = userRepository.findByUsername(auth.getUsername());
        return generateToken(user);
    }
    

    private String generateToken(User user) {
    
        
        try{
            Algorithm algorithm = Algorithm.HMAC256("my-secret");


            return JWT.create()
                    .withIssuer("FrameBlog")
                    .withSubject(user.getUsername())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Fail to generate token" +exception.getMessage());
        }

    }
    private Instant getExpirationDate(){
        return LocalDateTime.now()
                .plusHours(8)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
