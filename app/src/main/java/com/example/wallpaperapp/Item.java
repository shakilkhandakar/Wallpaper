package com.example.wallpaperapp;

public class Item {
    private int id;
    private String originalUrl,mediumUrl;

    public Item() {
    }

    public Item(int id, String originalUrl, String mediumUrl) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.mediumUrl = mediumUrl;
    }

    public int getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }
}
