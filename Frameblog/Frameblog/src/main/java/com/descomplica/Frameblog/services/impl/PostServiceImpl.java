package com.descomplica.Frameblog.services.impl;

import com.descomplica.Frameblog.models.Post;
import com.descomplica.Frameblog.repositories.PostRepository;
import com.descomplica.Frameblog.repositories.TagRepository;
import com.descomplica.Frameblog.services.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {

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

    @Override
    public Post get(final long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Post not Found")
        );
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post update(final long id,final Post post) {
        Post postUpdate = postRepository.findById(id).orElse(null);
        if(Objects.nonNull(postUpdate)){
            postUpdate.setPostId(post.getPostId());
            postUpdate.setDate(post.getDate());
            postUpdate.setContent(post.getContent());
            postUpdate.setTitle(post.getTitle());
            postUpdate.setUserId(post.getUserId());
            return postRepository.save(postUpdate);
        }
        return null;
    }

    @Override
    public void delete(final long id) {
        postRepository.deleteById(id);
    }
}
