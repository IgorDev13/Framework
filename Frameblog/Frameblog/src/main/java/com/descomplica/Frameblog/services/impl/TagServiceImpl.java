package com.descomplica.Frameblog.services.impl;

import com.descomplica.Frameblog.models.Tag;
import com.descomplica.Frameblog.repositories.TagRepository;
import com.descomplica.Frameblog.services.TagService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TagServiceImpl implements TagService {

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


    @Override
    public List<Tag> getAll(){
        return tagRepository.findAll();
    }

    @Override
    public Tag get(final long id){
        return tagRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User not Found")
        );
    }


    public Tag update(final long id, final Tag tag){
        Tag tagUpdate = tagRepository.findById(id).orElse(null);

        if (Objects.nonNull(tagUpdate)){
            tagUpdate.setTagId(tag.getTagId());
            tagUpdate.setName(tag.getName());
            return tagRepository.save(tagUpdate);
        }
        return null;
    }

    @Override
    public void delete(final long id){
        tagRepository.deleteById(id);
    }

}
