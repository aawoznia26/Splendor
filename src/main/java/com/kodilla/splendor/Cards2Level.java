package com.kodilla.splendor;

import javafx.scene.image.ImageView;

import java.util.Map;


public final class Cards2Level {

    private Map<Colors, Integer> cost;
    private Colors color;
    private ImageView view;
    private int value;

    public Cards2Level(Map<Colors, Integer> cost, Colors color, ImageView view, int value) {
        this.cost = cost;
        this.color = color;
        this.view = view;
        this.value = value;
    }

    public Cards2Level() {
    }

    public Map<Colors, Integer> getCost() {
        return cost;
    }

    public Colors getColor() {
        return color;
    }

    public ImageView getView() {
        return view;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Cards2Level{" +
                "cost=" + cost +
                ", color=" + color +
                ", view=" + view +
                ", value=" + value +
                '}';
    }
}
