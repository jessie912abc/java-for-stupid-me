/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jessie
 */
public class Status {
    private int id;
    private String content;
    private Date publishDate;
    private User owner;
    private ArrayList<User> like;
    private ArrayList<Comment> comment;

    public Status() {
    }

    public Status(int id, String content, Date publishDate, User owner) {
        this.id = id;
        this.content = content;
        this.publishDate = publishDate;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<User> getLike() {
        return like;
    }

    public void setLike(ArrayList<User> like) {
        this.like = like;
    }

    public ArrayList<Comment> getComment() {
        return comment;
    }

    public void setComment(ArrayList<Comment> comment) {
        this.comment = comment;
    }

    
}
