package com.kodilla.splendor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private String name;
    private int result;
    private int movesCounter = 0;

    private HashMap<Colors, Integer> cardCounter = new HashMap<>();
    private HashMap<Colors, Integer> jewelCounter = new HashMap<>();

    private List<Aristocrats> aristocrats = new ArrayList<>();

    public Player(String name, int result) {
        this.name = name;
        this.result = result;

        cardCounter.put(Colors.BLACK, 0);
        cardCounter.put(Colors.BLUE, 0);
        cardCounter.put(Colors.RED, 0);
        cardCounter.put(Colors.WHITE, 0);
        cardCounter.put(Colors.GREEN, 0);

        jewelCounter.put(Colors.BLACK, 0);
        jewelCounter.put(Colors.BLUE, 0);
        jewelCounter.put(Colors.RED, 0);
        jewelCounter.put(Colors.WHITE, 0);
        jewelCounter.put(Colors.GREEN, 0);

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

    public int getMovesCounter() {
        return movesCounter;
    }

    public void setMovesCounter(int movesCounter) {
        this.movesCounter = movesCounter;
    }

    public void setResult(int result) {
        this.result = result;
    }

}
