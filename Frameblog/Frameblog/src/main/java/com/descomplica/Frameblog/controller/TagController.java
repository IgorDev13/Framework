package com.descomplica.Frameblog.controller;

import com.descomplica.Frameblog.models.Tag;
import com.descomplica.Frameblog.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/save")
    private @ResponseBody Tag save(@RequestBody Tag tag){
        return tagService.save(tag);
    }

    @GetMapping(path = "/getAll")
    private @ResponseBody List<Tag> getAll(){
        return tagService.getAll();
    }

    @GetMapping(path = "/get")
    private @ResponseBody Tag get(@RequestParam final long id){
        return tagService.get(id);
    }

    @PostMapping(path = "/update")
    private @ResponseBody Tag update(@RequestParam final long id, @RequestBody Tag tag){
        return tagService.update(id, tag);
    }

    private ResponseEntity<?> delete(@RequestParam final long id){
        tagService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
