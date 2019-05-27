package com.kodilla.splendor;

import javafx.scene.image.ImageView;


public final class Jewel {


    private Colors color;
    private ImageView view;
    private int number;

    public Jewel(Colors color, ImageView view, int number) {
        this.color = color;
        this.view = view;
        this.number = number;
    }


    public Colors getColor() {
        return color;
    }

    public ImageView getView() {
        return view;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
