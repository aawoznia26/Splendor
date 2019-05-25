package com.kodilla.splendor;

import javafx.scene.image.Image;


public final class Jewel {

    Image diamond = new Image("file:src/main/resources/stones/diamond.png");
    Image sapphire = new Image("file:src/main/resources/stones/sapphire.png");
    Image onyx = new Image("file:src/main/resources/stones/onyx.png");
    Image emerald = new Image("file:src/main/resources/stones/emerald.png");
    Image ruby = new Image("file:src/main/resources/stones/ruby.png");


    private int diamondCounter = 4;
    private int sapphireCounter = 4;
    private int onyxCounter = 4;
    private int emeraldCounter = 4;
    private int rubyCounter = 4;

    public int getDiamondCounter() {
        return diamondCounter;
    }

    public int getSapphireCounter() {
        return sapphireCounter;
    }

    public int getOnyxCounter() {
        return onyxCounter;
    }

    public int getEmeraldCounter() {
        return emeraldCounter;
    }

    public int getRubyCounter() {
        return rubyCounter;
    }



    public Image getDiamond() {
        return diamond;
    }

    public Image getSapphire() {
        return sapphire;
    }

    public Image getOnyx() {
        return onyx;
    }

    public Image getEmerald() {
        return emerald;
    }

    public Image getRuby() {
        return ruby;
    }



    public void takeDiamond(Player player) {
        if (diamondCounter > 0) {
            diamondCounter = diamondCounter - 1;
            int playerDiamondCounter = player.getJewelCounter().get(Colors.WHITE);
            player.getJewelCounter().replace(Colors.WHITE, playerDiamondCounter + 1);
        } else {
            System.out.println("There is no diamonds to take");
        }

    }


    public void takeSapphire(Player player) {
        if (sapphireCounter > 0) {
            sapphireCounter = sapphireCounter - 1;
            int playerSapphireCounter = player.getJewelCounter().get(Colors.BLUE);
            player.getJewelCounter().replace(Colors.BLUE, playerSapphireCounter + 1);
        } else {
            System.out.println("There is no sapphire to take");
        }
    }

    public void takeOnyx(Player player) {
        if (onyxCounter > 0) {
            onyxCounter = onyxCounter - 1;
            int playerOnyxCounter = player.getJewelCounter().get(Colors.BLACK);
            player.getJewelCounter().replace(Colors.BLACK, playerOnyxCounter + 1);
        } else {
            System.out.println("There is no onyx to take");
        }

    }

    public void takeEmerald(Player player) {
        if (emeraldCounter > 0) {
            emeraldCounter = emeraldCounter - 1;
            int playerEmeraldCounter = player.getJewelCounter().get(Colors.GREEN);
            player.getJewelCounter().replace(Colors.GREEN, playerEmeraldCounter + 1);
        } else {
            System.out.println("There is no emerald to take");
        }

    }

    public void takeRuby(Player player) {
        if (rubyCounter > 0) {
            rubyCounter = rubyCounter - 1;
            int playerRubyCounter = player.getJewelCounter().get(Colors.RED);
            player.getJewelCounter().replace(Colors.RED, playerRubyCounter + 1);
        } else {
            System.out.println("There is no rubys to take");
        }

    }



}
