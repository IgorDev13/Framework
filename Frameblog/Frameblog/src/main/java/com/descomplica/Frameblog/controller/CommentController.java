package com.descomplica.Frameblog.controller;


import com.descomplica.Frameblog.models.Comment;
import com.descomplica.Frameblog.models.User;
import com.descomplica.Frameblog.services.CommentService;
import com.descomplica.Frameblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    private @ResponseBody Comment save(@RequestBody Comment comment){
        return commentService.save(comment);
    }


}
