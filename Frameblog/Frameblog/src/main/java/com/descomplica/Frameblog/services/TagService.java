package com.descomplica.Frameblog.services;

import com.descomplica.Frameblog.models.Tag;

import java.util.List;

public interface TagService {
    Tag save(Tag tag);

    List<Tag> getAll();

    void delete(long id);

    Tag get(long id);

    Tag update(long id, Tag tag);
}
