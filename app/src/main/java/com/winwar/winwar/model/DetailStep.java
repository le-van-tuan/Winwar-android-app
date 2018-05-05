package com.winwar.winwar.model;

import java.io.Serializable;

public class DetailStep implements Serializable {

    private int step;

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
