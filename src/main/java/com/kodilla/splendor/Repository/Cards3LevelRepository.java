package com.kodilla.splendor.Repository;

import com.kodilla.splendor.Aristocrats;
import com.kodilla.splendor.Cards3Level;
import com.kodilla.splendor.Colors;
import com.kodilla.splendor.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;

public class Cards3LevelRepository {

    private List<Cards3Level> cardsList = new ArrayList<>();
    private List<Cards3Level> fourCards = new ArrayList<>();
    private Random random = new Random();

    ImageView _3black_3w_3b_5g_3r = new ImageView(
            new Image("file:src/main/resources/cards/level3/3black_3w_3b_5g_3r.png",
                    120,240, true, true));
    ImageView _3blue__3w_3g_3r_5bc = new ImageView(
            new Image("file:src/main/resources/cards/level3/3blue__3w_3g_3r_5bc.png",
                    120,240, true, true));
    ImageView _3green_5w_3b_3r_3bc = new ImageView(
            new Image("file:src/main/resources/cards/level3/3green_5w_3b_3r_3bc.png",
                    120,240, true, true));
    ImageView _3red_3w_5b_3g_3bc = new ImageView(
            new Image("file:src/main/resources/cards/level3/3red_3w_5b_3g_3bc.png",
                    120,240, true, true));
    ImageView _3white_3b_3g_5r_3bc = new ImageView(
            new Image("file:src/main/resources/cards/level3/3white_3b_3g_5r_3bc.png",
                    120,240, true, true));
    ImageView _4black_3g_6r_3bc = new ImageView(
            new Image("file:src/main/resources/cards/level3/4black_3g_6r_3bc.png",
                    120,240, true, true));
    ImageView _4black_7r = new ImageView(
            new Image("file:src/main/resources/cards/level3/4black_7r.png",
                    120,240, true, true));

    private Map<Colors, Integer> _3black_3w_3b_5g_3rCost = new HashMap<>();
    private Map<Colors, Integer> _3blue__3w_3g_3r_5bcCost = new HashMap<>();
    private Map<Colors, Integer> _3green_5w_3b_3r_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _3red_3w_5b_3g_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _3white_3b_3g_5r_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _4black_3g_6r_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _4black_7rCost = new HashMap<>();

    private Cards3Level _3black_3w_3b_5g_3rCard = new Cards3Level(_3black_3w_3b_5g_3rCost, Colors.BLACK, _3black_3w_3b_5g_3r, 3 );
    private Cards3Level _3blue__3w_3g_3r_5bcCard = new Cards3Level(_3blue__3w_3g_3r_5bcCost, Colors.BLUE, _3blue__3w_3g_3r_5bc, 3 );
    private Cards3Level _3green_5w_3b_3r_3bcCard = new Cards3Level(_3green_5w_3b_3r_3bcCost, Colors.GREEN, _3green_5w_3b_3r_3bc, 3 );
    private Cards3Level _3red_3w_5b_3g_3bcCard = new Cards3Level(_3red_3w_5b_3g_3bcCost, Colors.RED, _3red_3w_5b_3g_3bc, 3 );
    private Cards3Level _3white_3b_3g_5r_3bcCard = new Cards3Level(_3white_3b_3g_5r_3bcCost, Colors.WHITE, _3white_3b_3g_5r_3bc, 3 );
    private Cards3Level _4black_3g_6r_3bcCard = new Cards3Level(_4black_3g_6r_3bcCost, Colors.BLACK, _4black_3g_6r_3bc, 4 );
    private Cards3Level _4black_7rCard = new Cards3Level(_4black_7rCost, Colors.BLACK, _4black_7r, 4 );

    public Cards3LevelRepository() {
        _3black_3w_3b_5g_3rCost.put(Colors.BLUE, 3);
        _3black_3w_3b_5g_3rCost.put(Colors.BLACK, 0);
        _3black_3w_3b_5g_3rCost.put(Colors.RED, 3);
        _3black_3w_3b_5g_3rCost.put(Colors.GREEN, 5);
        _3black_3w_3b_5g_3rCost.put(Colors.WHITE, 3);

        _3blue__3w_3g_3r_5bcCost.put(Colors.BLUE, 3);
        _3blue__3w_3g_3r_5bcCost.put(Colors.BLACK, 0);
        _3blue__3w_3g_3r_5bcCost.put(Colors.RED, 3);
        _3blue__3w_3g_3r_5bcCost.put(Colors.GREEN, 5);
        _3blue__3w_3g_3r_5bcCost.put(Colors.WHITE, 3);

        _3green_5w_3b_3r_3bcCost.put(Colors.BLUE, 3);
        _3green_5w_3b_3r_3bcCost.put(Colors.BLACK, 3);
        _3green_5w_3b_3r_3bcCost.put(Colors.RED, 3);
        _3green_5w_3b_3r_3bcCost.put(Colors.GREEN, 0);
        _3green_5w_3b_3r_3bcCost.put(Colors.WHITE, 5);

        _3red_3w_5b_3g_3bcCost.put(Colors.BLUE, 3);
        _3red_3w_5b_3g_3bcCost.put(Colors.BLACK, 0);
        _3red_3w_5b_3g_3bcCost.put(Colors.RED, 3);
        _3red_3w_5b_3g_3bcCost.put(Colors.GREEN, 5);
        _3red_3w_5b_3g_3bcCost.put(Colors.WHITE, 3);

        _3white_3b_3g_5r_3bcCost.put(Colors.BLUE, 3);
        _3white_3b_3g_5r_3bcCost.put(Colors.BLACK, 0);
        _3white_3b_3g_5r_3bcCost.put(Colors.RED, 3);
        _3white_3b_3g_5r_3bcCost.put(Colors.GREEN, 5);
        _3white_3b_3g_5r_3bcCost.put(Colors.WHITE, 3);

        _4black_3g_6r_3bcCost.put(Colors.BLUE, 3);
        _4black_3g_6r_3bcCost.put(Colors.BLACK, 0);
        _4black_3g_6r_3bcCost.put(Colors.RED, 3);
        _4black_3g_6r_3bcCost.put(Colors.GREEN, 5);
        _4black_3g_6r_3bcCost.put(Colors.WHITE, 3);

        _4black_7rCost.put(Colors.BLUE, 3);
        _4black_7rCost.put(Colors.BLACK, 0);
        _4black_7rCost.put(Colors.RED, 3);
        _4black_7rCost.put(Colors.GREEN, 5);
        _4black_7rCost.put(Colors.WHITE, 3);

        cardsList.add(_3black_3w_3b_5g_3rCard);
        cardsList.add(_3blue__3w_3g_3r_5bcCard);
        cardsList.add(_3green_5w_3b_3r_3bcCard);
        cardsList.add(_3red_3w_5b_3g_3bcCard);
        cardsList.add(_3white_3b_3g_5r_3bcCard);
        cardsList.add(_4black_3g_6r_3bcCard);
        cardsList.add(_4black_7rCard);

    }

    public Cards3Level get_3black_3w_3b_5g_3rCard() {
        return _3black_3w_3b_5g_3rCard;
    }

    public Cards3Level get_3blue__3w_3g_3r_5bcCard() {
        return _3blue__3w_3g_3r_5bcCard;
    }

    public Cards3Level get_3green_5w_3b_3r_3bcCard() {
        return _3green_5w_3b_3r_3bcCard;
    }

    public Cards3Level get_3red_3w_5b_3g_3bcCard() {
        return _3red_3w_5b_3g_3bcCard;
    }

    public Cards3Level get_3white_3b_3g_5r_3bcCard() {
        return _3white_3b_3g_5r_3bcCard;
    }

    public Cards3Level get_4black_3g_6r_3bcCard() {
        return _4black_3g_6r_3bcCard;
    }

    public Cards3Level get_4black_7rCard() {
        return _4black_7rCard;
    }

    public List<Cards3Level> getFourCards() {
        return fourCards;
    }

    public void drawFourCards() {
        Cards3Level card1 = drawCard();
        Cards3Level card2 = drawCard();
        Cards3Level card3 = drawCard();
        Cards3Level card4 = drawCard();


        fourCards.add(card1);
        fourCards.add(card2);
        fourCards.add(card3);
        fourCards.add(card4);
    }


    public Cards3Level drawCard() {
        Cards3Level randomCard = new Cards3Level();
        if (cardsList.size() > 0) {
            randomCard = cardsList.get(random.nextInt(cardsList.size()));
            cardsList.remove(randomCard);
        }
        return randomCard;
    }


    public boolean takeCard(Player player, Cards3Level card, int position) {

        boolean ifCardTaken = false;

        long costCheckCounter = card.getCost().entrySet().stream()
                .filter(e -> player.getJewelCounter().get(e.getKey()) >= e.getValue())
                .count();

        if (costCheckCounter == 5L) {
            player.setResult(player.getResult() + card.getValue());
            int cardNumber = player.getCardCounter().get(card.getColor());
            player.getCardCounter().replace(card.getColor(), cardNumber +1 );
            ifCardTaken = true;
            fourCards.set(position, drawCard());
        }

        return ifCardTaken;
    }
}
