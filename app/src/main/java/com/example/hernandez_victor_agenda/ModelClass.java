package com.example.hernandez_victor_agenda;

public class ModelClass {
    private int imageIcon;
    String title;
    String body;

    public ModelClass(int imageIcon, String title, String body) {
        this.imageIcon = imageIcon;
        this.title = title;
        this.body = body;
    }

    public int getImageIcon() {
        return imageIcon;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
