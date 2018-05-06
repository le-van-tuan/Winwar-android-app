package com.winwar.winwar.model;

import java.io.Serializable;

public class DetailStep implements Serializable {

    private int step;

    private String content;

    private int image;

    public DetailStep() {
    }

    public DetailStep(int step, String content, int image) {
        this.step = step;
        this.content = content;
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public DetailStep(int step) {
        this.step = step;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
