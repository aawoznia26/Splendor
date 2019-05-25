package com.kodilla.splendor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplendorRunner {

    List<Player> players = new ArrayList<>();


    public static final Scanner scanner = new Scanner(System.in);

    public List<Player> createPlayers() {

        System.out.println("Enter Player 1 name");

        String player1Name = scanner.next();

        System.out.println("Enter Player 2 name");

        String player2Name = scanner.next();

        Player player1 = new Player(player1Name, 0);
        Player player2 = new Player(player2Name, 0);
        players.add(player1);
        players.add(player2);

        return players;

    }

    public void move(Player player){
        int diamondTaken = 0;
        int sapphireTaken = 0;
        int onyxTaken = 0;
        int emeraldTaken = 0;
        int rubyTaken = 0;

        int cardTaken = 0;
        int aristocratsTaken = 0;

        Move move = new Move( player, diamondTaken, sapphireTaken, onyxTaken, emeraldTaken, rubyTaken, cardTaken, aristocratsTaken);

    }



}
