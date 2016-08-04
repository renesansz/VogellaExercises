package com.example.renesansz.activitysqllite.models;

public class Comment {

    private long id;
    private String comment;

    public long getId() {
        return this.id;
    }

    public void setId(long newId) {
        this.id = newId;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String newComment) {
        this.comment = newComment;
    }

    @Override
    public String toString() {
        return comment;
    }
}
