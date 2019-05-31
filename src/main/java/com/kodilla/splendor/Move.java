package com.kodilla.splendor;

public class Move {

    private Player player;

    private int diamondTaken;
    private int sapphireTaken;
    private int onyxTaken;
    private int emeraldTaken;
    private int rubyTaken;

    private int cardTaken;
    private int aristocratsTaken;

    private InfoPopUp infoPopUp = new InfoPopUp();

    public Move(Player player, int diamondTaken, int sapphireTaken, int onyxTaken, int emeraldTaken, int rubyTaken, int cardTaken, int aristocratsTaken) {
        this.player = player;
        this.diamondTaken = diamondTaken;
        this.sapphireTaken = sapphireTaken;
        this.onyxTaken = onyxTaken;
        this.emeraldTaken = emeraldTaken;
        this.rubyTaken = rubyTaken;
        this.cardTaken = cardTaken;
        this.aristocratsTaken = aristocratsTaken;
    }

    public boolean commitMove() {
        boolean ifCommited = true;

        if (cardTaken > 1 || aristocratsTaken > 1) {
            infoPopUp.display("ALERT", "You can take only one card and one aristocrat within move. Try again.");
            ifCommited = false;
        } else if (cardTaken == 1 && (diamondTaken + sapphireTaken + onyxTaken + emeraldTaken + rubyTaken) > 0) {
            infoPopUp.display("ALERT", "You can either take card or jewels within move. Try again.");
            ifCommited = false;
        } else if ((diamondTaken + sapphireTaken + onyxTaken + emeraldTaken + rubyTaken) > 3) {
            infoPopUp.display("ALERT", "You can either take 2 jewel of the same kind or 3 jewel from different kinds within move. Try again.");
            ifCommited = false;
        } else if (((diamondTaken + sapphireTaken + onyxTaken + emeraldTaken + rubyTaken) == 3) && (diamondTaken >=2 || sapphireTaken >=2 || onyxTaken >=2 || emeraldTaken >=2 || rubyTaken >=2)) {
            infoPopUp.display("ALERT", "You can either take 2 jewel of the same kind or 3 jewel from different kinds within move. Try again.");
            ifCommited = false;
        } else if (((diamondTaken + sapphireTaken + onyxTaken + emeraldTaken + rubyTaken) >= 0) && ((diamondTaken + sapphireTaken + onyxTaken + emeraldTaken + rubyTaken) <= 2)
                && (diamondTaken <=2 || sapphireTaken <=2 || onyxTaken <=2 || emeraldTaken <=2 || rubyTaken <=2) && (aristocratsTaken + cardTaken) < 0){
            infoPopUp.display("ALERT", "You can either take 2 jewel of the same kind or 3 jewel from different kinds within move. Take more.");
            ifCommited = false;
        } else {
            ifCommited = true;
        }
        return ifCommited;
    }


}
