package com.kodilla.splendor;

public class Move {

    private Player player;

    private static int diamondTaken;
    private static int sapphireTaken;
    private static int onyxTaken;
    private static int emeraldTaken;
    private static int rubyTaken;

    private static int cardTaken;
    private static int aristocratsTaken;

    private static InfoPopUp infoPopUp = new InfoPopUp();

    public Move(Player player) {
        this.player = player;
    }

    public static boolean validateMove(String takenObject){
        boolean ifValid = true;
        if (cardTaken == 1 && aristocratsTaken == 1) {
            infoPopUp.display("ALERT", "You can take only one card and one aristocrat within move.");
            ifValid = false;
        } else if (aristocratsTaken == 1 && takenObject.equals("aristocrat")) {
            infoPopUp.display("ALERT", "You can take one aristocrat within move.");
            ifValid = false;
        } else if (cardTaken == 1 && takenObject.equals("card")) {
            infoPopUp.display("ALERT", "You can take one card within move.");
            ifValid = false;
        } else if ((diamondTaken + sapphireTaken + onyxTaken + emeraldTaken + rubyTaken) >= 1 && takenObject.equals("card")) {
            infoPopUp.display("ALERT", "You can take either one card or jewels within move.");
            ifValid = false;
        } else if (cardTaken == 1 && takenObject.equals("jewel")) {
                infoPopUp.display("ALERT", "You can either take card or jewels within move.");
                ifValid = false;
        } else if ((diamondTaken + sapphireTaken + onyxTaken + emeraldTaken + rubyTaken) >= 3) {
            infoPopUp.display("ALERT", "You can either take 2 jewel of the same kind or 3 jewel from different kinds within move.");
            ifValid = false;
        } else if (diamondTaken >= 2 || sapphireTaken >= 2 || onyxTaken >= 2 || emeraldTaken >= 2 || rubyTaken >= 2) {
            infoPopUp.display("ALERT", "You can either take 2 jewel of the same kind or 3 jewel from different kinds within move.");
            ifValid = false;
        }
        return ifValid;

    }

    public boolean commitMove() {
        diamondTaken = 0;
        sapphireTaken = 0;
        onyxTaken = 0;
        emeraldTaken = 0;
        rubyTaken = 0;
        cardTaken = 0;
        aristocratsTaken = 0;

        return true;
    }

    public static int getDiamondTaken() {
        return diamondTaken;
    }

    public static void setDiamondTaken(int diamondTakenNew) {
        diamondTaken = diamondTakenNew;
    }

    public static int getSapphireTaken() {
        return sapphireTaken;
    }

    public static void setSapphireTaken(int sapphireTakenNew) {
        sapphireTaken = sapphireTakenNew;
    }

    public static int getOnyxTaken() {
        return onyxTaken;
    }

    public static void setOnyxTaken(int onyxTakenNew) {
        onyxTaken = onyxTakenNew;
    }

    public static int getEmeraldTaken() {
        return emeraldTaken;
    }

    public static void setEmeraldTaken(int emeraldTakenNew) {
        emeraldTaken = emeraldTakenNew;
    }

    public static int getRubyTaken() {
        return rubyTaken;
    }

    public static void setRubyTaken(int rubyTakenNew) {
        rubyTaken = rubyTakenNew;
    }

    public static int getCardTaken() {
        return cardTaken;
    }

    public static void setCardTaken(int cardTakenNew) {
        cardTaken = cardTakenNew;
    }

    public static int getAristocratsTaken() {
        return aristocratsTaken;
    }

    public static void setAristocratsTaken(int aristocratsTakenNew) {
        aristocratsTaken = aristocratsTakenNew;
    }
}
