package com.descomplica.Frameblog.services;

import com.descomplica.Frameblog.models.Comment;

import java.util.List;

public interface CommentService {
    Comment save(Comment comment);

    List<Comment> getAll();

    Comment get(long id);

    Comment update(long id, Comment comment);

    void delete(long id);
}
