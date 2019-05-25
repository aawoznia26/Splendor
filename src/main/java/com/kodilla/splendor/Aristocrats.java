package com.kodilla.splendor;

import javafx.scene.image.ImageView;

import java.util.Map;


public final class Aristocrats {

    private Map<Colors, Integer> cost;
    private ImageView view;
    private int value;

    public Aristocrats(Map<Colors, Integer> cost, ImageView view, int value) {
        this.cost = cost;
        this.view = view;
        this.value = value;
    }

    public Aristocrats() {
    }

    public Map<Colors, Integer> getCost() {
        return cost;
    }

    public ImageView getView() {
        return view;
    }

    public int getValue() {
        return value;
    }

}