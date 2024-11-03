package com.descomplica.Frameblog.services;

import com.descomplica.Frameblog.models.User;

import java.util.List;

public interface UserService {

    User    save(User user);
    List<User> getAll();
    User get(long id);
    User update(long id, User user);
    void delete(long id);
}
