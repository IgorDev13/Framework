package com.descomplica.Frameblog.controller;

import com.descomplica.Frameblog.models.Post;
import com.descomplica.Frameblog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/save")
    private @ResponseBody Post post(@RequestBody Post post){
        return postService.save(post);
    }

    @GetMapping(path = "/getAll")
    private @ResponseBody List<Post> getAll(){
        return postService.getAll();
    }


    @GetMapping(path = "/get")
    private @ResponseBody Post post(@RequestParam final long id){
        return postService.get(id);
    }

    @PostMapping(path = "/update")
    private @ResponseBody Post update(@RequestParam final long id, @RequestBody Post post){
        return postService.update(id, post);
    }

    @GetMapping(path = "/delete")
    private ResponseEntity<?> delete(@RequestParam final long id){
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/")
    public @ResponseBody String authentication(){
        return "Hello World";

    }
}
