package com.descomplica.Frameblog.services.impl;

import com.descomplica.Frameblog.models.User;
import com.descomplica.Frameblog.repositories.UserRepository;
import com.descomplica.Frameblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save (final User user){

        User existingUSer = userRepository.findByUsername(user.getName());

        if(Objects.nonNull(existingUSer)){
            throw new RuntimeException("Existing USer");
        }

        User entity = new User(user.getUserId(), user.getName(), user.getEmail(), user.getPassword(), user.getRole());
        User newUser = userRepository.save(entity);
        return new User(newUser.getUserId(), newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getRole());
    }

}
