package com.example.friendsr;
import java.io.Serializable;

public class Friend implements Serializable{
    private String name, bio;
    private int drawableId;
    private float rating;

    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public float getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
