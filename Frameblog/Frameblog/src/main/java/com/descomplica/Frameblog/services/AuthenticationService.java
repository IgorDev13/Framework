package com.descomplica.Frameblog.services;

import com.descomplica.Frameblog.request.AuthRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthenticationService {
    UserDetails loadUserByUsername(String login) throws UsernameNotFoundException

    String getToken(AuthRequest auth);
}
