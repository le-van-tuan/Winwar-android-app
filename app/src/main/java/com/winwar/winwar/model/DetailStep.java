package com.winwar.winwar.model;

import java.io.Serializable;

public class DetailStep implements Serializable {

    private int step;

    private String content;

    public DetailStep() {
    }

    public DetailStep(int step, String content) {
        this.step = step;
        this.content = content;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
