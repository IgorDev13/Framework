package com.descomplica.Frameblog.services.impl;

import com.descomplica.Frameblog.models.Post;
import com.descomplica.Frameblog.repositories.PostRepository;
import com.descomplica.Frameblog.repositories.TagRepository;
import com.descomplica.Frameblog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PostServiceIMPL implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Post save(final Post  post){
        Post existingPost = postRepository.findById(post.getPostId()).orElse(null);

        if(Objects.nonNull(existingPost)){
            throw new RuntimeException("Existing Post");
        }

        Post entity = new Post(post.getPostId(), post.getTitle(), post.getContent(), post.getDate(), post.getUserId(), post.getTagId());
        return postRepository.save(entity);
    }
}
