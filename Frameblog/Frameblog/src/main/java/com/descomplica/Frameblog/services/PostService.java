package com.descomplica.Frameblog.services;

import com.descomplica.Frameblog.models.Post;

import java.util.List;

public interface PostService {
    void delete(long id);

    Post update(long id, Post post);

    Post get(long id);

    List<Post> getAll();

    Post save(Post post);
}
