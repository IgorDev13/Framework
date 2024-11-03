package com.descomplica.Frameblog.services.impl;

import com.descomplica.Frameblog.models.Tag;
import com.descomplica.Frameblog.repositories.TagRepository;
import com.descomplica.Frameblog.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TagServiceIMPL implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag save(final Tag tag){
        Tag existingTag = tagRepository.findById(tag.getTagId()).orElse(null);

        if(Objects.nonNull(existingTag)){
            throw new RuntimeException("Existing Tag");
        }

        Tag entity = new Tag(tag.getTagId(), tag.getName());
        return tagRepository.save(entity);
    }

}
