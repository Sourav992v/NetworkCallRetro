package com.sourav.developer.networkcallretro;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int userId;
    private Integer id;
    private String title;

    @SerializedName("body")
    private String text;

    public Post(int userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    public String getUserId() {
        return String.valueOf(userId);
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getId() {
        return String.valueOf(id);
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
