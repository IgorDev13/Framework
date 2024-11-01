package com.descomplica.Frameblog.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name ="Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commentId;
    private String content;
    private Date date;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    public Comment() {
    }

    public Comment(final long commentId, final String content,
                   final Date date, final Post postId, final User userID) {
        this.commentId = commentId;
        this.content = content;
        this.date = date;
        this.post = post;
        this.user = user;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post postId) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
