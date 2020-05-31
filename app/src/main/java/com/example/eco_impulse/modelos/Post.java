package com.example.eco_impulse.modelos;

import java.util.Map;

public class Post {

    private String tittle;
    private String imageUrl;
    private String postId;
    private String description;
    private String date;
    private String category;
    private String authorId;
    //Atributo para pruebas offLine
    public int imageId=0;

    public Post(String tittle, String imageUrl, String postId, String description, String date, String category, String authorId) {
        this.tittle = tittle;
        this.imageUrl = imageUrl;
        this.postId = postId;
        this.description = description;
        this.date = date;
        this.category = category;
        this.authorId = authorId;
    }

    //Constructor de prueba para versión offLine
    public Post(String tittle, int imageId){
        this.tittle = tittle;
        this.imageId = imageId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
