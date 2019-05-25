package com.kodilla.splendor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private String name;
    private int result;

    private HashMap<Colors, Integer> cardCounter = new HashMap<>();
    private HashMap<Colors, Integer> jewelCounter = new HashMap<>();

    private List<Aristocrats> aristocrats = new ArrayList<>();

    public Player(String name, int result) {
        this.name = name;
        this.result = result;

        cardCounter.put(Colors.BLACK, 5);
        cardCounter.put(Colors.BLUE, 4);
        cardCounter.put(Colors.RED, 6);
        cardCounter.put(Colors.WHITE, 6);
        cardCounter.put(Colors.GREEN, 4);

        jewelCounter.put(Colors.BLACK, 8);
        jewelCounter.put(Colors.BLUE, 10);
        jewelCounter.put(Colors.RED, 17);
        jewelCounter.put(Colors.WHITE, 7);
        jewelCounter.put(Colors.GREEN, 8);



    }

    public String getName() {
        return name;
    }

    public int getResult() {
        return result;
    }

    public HashMap<Colors, Integer> getCardCounter() {
        return cardCounter;
    }

    public List<Aristocrats> getAristocrats() {
        return aristocrats;
    }

    public HashMap<Colors, Integer> getJewelCounter() {
        return jewelCounter;
    }

    public void setResult(int result) {
        this.result = result;
    }

}
