package com.kodilla.splendor;

import javafx.scene.image.ImageView;


public final class Jewel {

    private Colors color;
    private ImageView view;
    private int number;
    private String name;

    public Jewel(Colors color, ImageView view, int number, String name) {
        this.color = color;
        this.view = view;
        this.number = number;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
