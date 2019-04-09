package com.sayed.apiblog.model;

import java.io.Serializable;

public class Post implements Serializable {
    private String id;
    private String title;
    private String body;
    private String image;

    public Post(String id, String title, String body,String image) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
