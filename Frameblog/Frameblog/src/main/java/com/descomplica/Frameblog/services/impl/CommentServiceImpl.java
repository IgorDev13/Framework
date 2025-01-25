package com.descomplica.Frameblog.services.impl;

import com.descomplica.Frameblog.models.Comment;
import com.descomplica.Frameblog.services.CommentService;
import com.descomplica.Frameblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private UserService userService;

    @Override
    public Comment send(Comment comment){
        comment.setUser(userService.get(comment.getUser().getUserId()));

        return comment;
    }
}
