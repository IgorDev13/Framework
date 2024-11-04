package com.descomplica.Frameblog.services.impl;

import com.descomplica.Frameblog.models.User;
import com.descomplica.Frameblog.repositories.UserRepository;
import com.descomplica.Frameblog.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save (final User user){

        User existingUSer = userRepository.findByUsername(user.getUsername());

        if(Objects.nonNull(existingUSer)){
            throw new RuntimeException("Existing USer");
        }

        User entity = new User(user.getUserId(), user.getName(), user.getEmail(), user.getUsername(), user.getPassword(), user.getRole());
        User newUser = userRepository.save(entity);
        return new User(newUser.getUserId(), newUser.getName(), newUser.getEmail(), newUser.getUsername(), newUser.getPassword(), newUser.getRole());
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User get(final long id){
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User not Found")
        );
    }

    @Override
    public User update(final long id, final User user){
        User userUpdate = userRepository.findById(id).orElse(null);
        if (Objects.nonNull(userUpdate)){
            userUpdate.setName(user.getName());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setPassword(user.getPassword());
            userUpdate.setRole(user.getRole());
            return userRepository.save(userUpdate);
        }
        return null;
    }

    @Override
    public void delete(final long id){
        userRepository.deleteById(id);
    }

}
