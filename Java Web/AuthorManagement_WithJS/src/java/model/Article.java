/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Jessie
 */
public class Article {
    private int id;
    private String title;
    private Date publishedDate;
    private ArrayList<Author> author;

    public Article() {
    }

    public Article(int id, String title, Date publishedDate, ArrayList<Author> author) {
        this.id = id;
        this.title = title;
        this.publishedDate = publishedDate;
        this.author = author;
    }

    public Article(int id, String title, Date publishedDate) {
        this.id = id;
        this.title = title;
        this.publishedDate = publishedDate;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public ArrayList<Author> getAuthor() {
        return author;
    }

    public void setAuthor(ArrayList<Author> author) {
        this.author = author;
    }
    
    
}
