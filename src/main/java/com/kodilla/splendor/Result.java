package com.kodilla.splendor;

public class Result {

    private boolean result;
    private Player winner;

    public Result(boolean result, Player winner) {
        this.result = result;
        this.winner = winner;
    }

    public Result(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public Player getWinner() {
        return winner;
    }
}
