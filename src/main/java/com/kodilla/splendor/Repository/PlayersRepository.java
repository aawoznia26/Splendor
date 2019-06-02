package com.kodilla.splendor.Repository;

import com.kodilla.splendor.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayersRepository {

    private List<Player> playersList = new ArrayList<>();

    public List<Player> getPlayers() {
        return playersList;
    }

    public void setPlayers(List<Player> playersList) {
        this.playersList = playersList;
    }
}
