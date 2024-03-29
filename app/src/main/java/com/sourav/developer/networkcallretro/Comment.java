package com.sourav.developer.networkcallretro;

import com.google.gson.annotations.SerializedName;

public class Comment {

    private int postId;
    private int id;
    private  String name;
    private String email;
    @SerializedName("body")
    private String text;

    public String getPostId() {
        return String.valueOf(postId);
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }
}
