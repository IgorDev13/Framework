package com.descomplica.Frameblog.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "Tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tagId;

    @NonNull //@Column(nullable = false)
    private String name;

    public Tag() {
    }

    public Tag(long tagId, @NonNull String name) {
        this.tagId = tagId;
        this.name = name;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
