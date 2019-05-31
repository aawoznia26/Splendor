package com.kodilla.splendor.Repository;

import com.kodilla.splendor.Cards3Level;
import com.kodilla.splendor.Colors;
import com.kodilla.splendor.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;
import java.util.stream.Collectors;

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
    ImageView _4blue_6w_3b_3bc = new ImageView(
            new Image("file:src/main/resources/cards/level3/4blue_6w_3b_3bc.png",
                    120,240, true, true));
    ImageView _4blue_7w = new ImageView(
            new Image("file:src/main/resources/cards/level3/4blue_7w.png",
                    120,240, true, true));
    ImageView _4green_3w_6b_3g = new ImageView(
            new Image("file:src/main/resources/cards/level3/4green_3w_6b_3g.png",
                    120,240, true, true));
    ImageView _4green_7b = new ImageView(
            new Image("file:src/main/resources/cards/level3/4green_7b.png",
                    120,240, true, true));
    ImageView _4white_3w_3r_6bc = new ImageView(
            new Image("file:src/main/resources/cards/level3/4white_3w_3r_6bc.png",
                    120,240, true, true));
    ImageView _4white_7bc = new ImageView(
            new Image("file:src/main/resources/cards/level3/4white_7bc.png",
                    120,240, true, true));
    ImageView _5black_7r_3bc = new ImageView(
            new Image("file:src/main/resources/cards/level3/5black_7r_3bc.png",
                    120,240, true, true));
    ImageView _5blue_7w_3b = new ImageView(
            new Image("file:src/main/resources/cards/level3/5blue_7w_3b.png",
                    120,240, true, true));
    ImageView _4red_3b_6g_3r = new ImageView(
            new Image("file:src/main/resources/cards/level3/4red_3b_6g_3r.png",
                    120,240, true, true));
    ImageView _4red_7g = new ImageView(
            new Image("file:src/main/resources/cards/level3/4red_7g.png",
                    120,240, true, true));
    ImageView _5green_7b_3g = new ImageView(
            new Image("file:src/main/resources/cards/level3/5green_7b_3g.png",
                    120,240, true, true));
    ImageView _5red_7g_3r = new ImageView(
            new Image("file:src/main/resources/cards/level3/5red_7g_3r.png",
                    120,240, true, true));
    ImageView _5white_3w_7bc = new ImageView(
            new Image("file:src/main/resources/cards/level3/5white_3w_7bc.png",
                    120,240, true, true));

    private Map<Colors, Integer> _3black_3w_3b_5g_3rCost = new HashMap<>();
    private Map<Colors, Integer> _3blue__3w_3g_3r_5bcCost = new HashMap<>();
    private Map<Colors, Integer> _3green_5w_3b_3r_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _3red_3w_5b_3g_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _3white_3b_3g_5r_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _4black_3g_6r_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _4black_7rCost = new HashMap<>();
    private Map<Colors, Integer> _4blue__6w_3b_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _4blue_7wCost = new HashMap<>();
    private Map<Colors, Integer> _4green_3w_6b_3gCost = new HashMap<>();
    private Map<Colors, Integer> _4green_7bCost = new HashMap<>();
    private Map<Colors, Integer> _4white_3w_3r_6bcCost = new HashMap<>();
    private Map<Colors, Integer> _4white_7bcCost = new HashMap<>();
    private Map<Colors, Integer> _5black_7r_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _5blue_7w_3bCost = new HashMap<>();
    private Map<Colors, Integer> _4red_3b_6g_3rCost = new HashMap<>();
    private Map<Colors, Integer> _4red_7gCost = new HashMap<>();
    private Map<Colors, Integer> _5green_7b_3gCost = new HashMap<>();
    private Map<Colors, Integer> _5red_7g_3rCost = new HashMap<>();
    private Map<Colors, Integer> _5white_3w_7bcCost = new HashMap<>();

    private Cards3Level _3black_3w_3b_5g_3rCard = new Cards3Level(_3black_3w_3b_5g_3rCost, Colors.BLACK, _3black_3w_3b_5g_3r, 3 );
    private Cards3Level _3blue__3w_3g_3r_5bcCard = new Cards3Level(_3blue__3w_3g_3r_5bcCost, Colors.BLUE, _3blue__3w_3g_3r_5bc, 3 );
    private Cards3Level _3green_5w_3b_3r_3bcCard = new Cards3Level(_3green_5w_3b_3r_3bcCost, Colors.GREEN, _3green_5w_3b_3r_3bc, 3 );
    private Cards3Level _3red_3w_5b_3g_3bcCard = new Cards3Level(_3red_3w_5b_3g_3bcCost, Colors.RED, _3red_3w_5b_3g_3bc, 3 );
    private Cards3Level _3white_3b_3g_5r_3bcCard = new Cards3Level(_3white_3b_3g_5r_3bcCost, Colors.WHITE, _3white_3b_3g_5r_3bc, 3 );
    private Cards3Level _4black_3g_6r_3bcCard = new Cards3Level(_4black_3g_6r_3bcCost, Colors.BLACK, _4black_3g_6r_3bc, 4 );
    private Cards3Level _4black_7rCard = new Cards3Level(_4black_7rCost, Colors.BLACK, _4black_7r, 4 );
    private Cards3Level _4blue__6w_3b_3bcCard = new Cards3Level(_4blue__6w_3b_3bcCost, Colors.BLUE, _4blue_6w_3b_3bc, 4 );
    private Cards3Level _4blue_7wCard = new Cards3Level(_4blue_7wCost, Colors.BLUE, _4blue_7w, 4 );
    private Cards3Level _4green_3w_6b_3gCard = new Cards3Level(_4green_3w_6b_3gCost, Colors.GREEN, _4green_3w_6b_3g, 4 );
    private Cards3Level _4green_7bCard = new Cards3Level(_4green_7bCost, Colors.GREEN, _4green_7b, 4 );
    private Cards3Level _4white_3w_3r_6bcCard = new Cards3Level(_4white_3w_3r_6bcCost, Colors.WHITE, _4white_3w_3r_6bc, 4 );
    private Cards3Level _4white_7bcCard = new Cards3Level(_4white_7bcCost, Colors.WHITE, _4white_7bc, 4 );
    private Cards3Level _5black_7r_3bcCard = new Cards3Level(_5black_7r_3bcCost, Colors.BLACK, _5black_7r_3bc, 5 );
    private Cards3Level _5blue_7w_3bCard = new Cards3Level(_5blue_7w_3bCost, Colors.BLUE, _5blue_7w_3b, 5 );
    private Cards3Level _4red_3b_6g_3rCard = new Cards3Level(_4red_3b_6g_3rCost, Colors.RED, _4red_3b_6g_3r, 4 );
    private Cards3Level _4red_7gCard = new Cards3Level(_4red_7gCost, Colors.RED, _4red_7g, 4 );
    private Cards3Level _5green_7b_3gCard = new Cards3Level(_5green_7b_3gCost, Colors.GREEN, _5green_7b_3g, 5 );
    private Cards3Level _5red_7g_3rCard = new Cards3Level(_5red_7g_3rCost, Colors.RED, _5red_7g_3r, 5 );
    private Cards3Level _5white_3w_7bcCard = new Cards3Level(_5white_3w_7bcCost, Colors.WHITE, _5white_3w_7bc, 5 );

    public Cards3LevelRepository() {
        _3black_3w_3b_5g_3rCost.put(Colors.BLUE, 3);
        _3black_3w_3b_5g_3rCost.put(Colors.BLACK, 0);
        _3black_3w_3b_5g_3rCost.put(Colors.RED, 3);
        _3black_3w_3b_5g_3rCost.put(Colors.GREEN, 5);
        _3black_3w_3b_5g_3rCost.put(Colors.WHITE, 3);

        _3blue__3w_3g_3r_5bcCost.put(Colors.BLUE, 0);
        _3blue__3w_3g_3r_5bcCost.put(Colors.BLACK, 5);
        _3blue__3w_3g_3r_5bcCost.put(Colors.RED, 3);
        _3blue__3w_3g_3r_5bcCost.put(Colors.GREEN, 3);
        _3blue__3w_3g_3r_5bcCost.put(Colors.WHITE, 3);

        _3green_5w_3b_3r_3bcCost.put(Colors.BLUE, 3);
        _3green_5w_3b_3r_3bcCost.put(Colors.BLACK, 3);
        _3green_5w_3b_3r_3bcCost.put(Colors.RED, 3);
        _3green_5w_3b_3r_3bcCost.put(Colors.GREEN, 0);
        _3green_5w_3b_3r_3bcCost.put(Colors.WHITE, 5);

        _3red_3w_5b_3g_3bcCost.put(Colors.BLUE, 5);
        _3red_3w_5b_3g_3bcCost.put(Colors.BLACK, 3);
        _3red_3w_5b_3g_3bcCost.put(Colors.RED, 0);
        _3red_3w_5b_3g_3bcCost.put(Colors.GREEN, 3);
        _3red_3w_5b_3g_3bcCost.put(Colors.WHITE, 3);

        _3white_3b_3g_5r_3bcCost.put(Colors.BLUE, 3);
        _3white_3b_3g_5r_3bcCost.put(Colors.BLACK, 3);
        _3white_3b_3g_5r_3bcCost.put(Colors.RED, 5);
        _3white_3b_3g_5r_3bcCost.put(Colors.GREEN, 3);
        _3white_3b_3g_5r_3bcCost.put(Colors.WHITE, 0);

        _4black_3g_6r_3bcCost.put(Colors.BLUE, 3);
        _4black_3g_6r_3bcCost.put(Colors.BLACK, 3);
        _4black_3g_6r_3bcCost.put(Colors.RED, 6);
        _4black_3g_6r_3bcCost.put(Colors.GREEN, 0);
        _4black_3g_6r_3bcCost.put(Colors.WHITE, 0);

        _4black_7rCost.put(Colors.BLUE, 0);
        _4black_7rCost.put(Colors.BLACK, 0);
        _4black_7rCost.put(Colors.RED, 7);
        _4black_7rCost.put(Colors.GREEN, 0);
        _4black_7rCost.put(Colors.WHITE, 0);

        _4blue__6w_3b_3bcCost.put(Colors.BLUE, 3);
        _4blue__6w_3b_3bcCost.put(Colors.BLACK, 3);
        _4blue__6w_3b_3bcCost.put(Colors.RED, 0);
        _4blue__6w_3b_3bcCost.put(Colors.GREEN, 0);
        _4blue__6w_3b_3bcCost.put(Colors.WHITE, 6);

        _4blue_7wCost.put(Colors.BLUE, 0);
        _4blue_7wCost.put(Colors.BLACK, 0);
        _4blue_7wCost.put(Colors.RED, 0);
        _4blue_7wCost.put(Colors.GREEN, 0);
        _4blue_7wCost.put(Colors.WHITE, 7);

        _4green_3w_6b_3gCost.put(Colors.BLUE, 6);
        _4green_3w_6b_3gCost.put(Colors.BLACK, 0);
        _4green_3w_6b_3gCost.put(Colors.RED, 0);
        _4green_3w_6b_3gCost.put(Colors.GREEN, 3);
        _4green_3w_6b_3gCost.put(Colors.WHITE, 3);

        _4green_7bCost.put(Colors.BLUE, 7);
        _4green_7bCost.put(Colors.BLACK, 0);
        _4green_7bCost.put(Colors.RED, 0);
        _4green_7bCost.put(Colors.GREEN, 0);
        _4green_7bCost.put(Colors.WHITE, 0);

        _4white_3w_3r_6bcCost.put(Colors.BLUE, 0);
        _4white_3w_3r_6bcCost.put(Colors.BLACK, 6);
        _4white_3w_3r_6bcCost.put(Colors.RED, 3);
        _4white_3w_3r_6bcCost.put(Colors.GREEN, 0);
        _4white_3w_3r_6bcCost.put(Colors.WHITE, 3);

        _4white_7bcCost.put(Colors.BLUE, 0);
        _4white_7bcCost.put(Colors.BLACK, 7);
        _4white_7bcCost.put(Colors.RED, 0);
        _4white_7bcCost.put(Colors.GREEN, 0);
        _4white_7bcCost.put(Colors.WHITE, 0);

        _5black_7r_3bcCost.put(Colors.BLUE, 0);
        _5black_7r_3bcCost.put(Colors.BLACK, 3);
        _5black_7r_3bcCost.put(Colors.RED, 7);
        _5black_7r_3bcCost.put(Colors.GREEN, 0);
        _5black_7r_3bcCost.put(Colors.WHITE, 0);

        _4red_3b_6g_3rCost.put(Colors.BLUE, 3);
        _4red_3b_6g_3rCost.put(Colors.BLACK, 0);
        _4red_3b_6g_3rCost.put(Colors.RED, 3);
        _4red_3b_6g_3rCost.put(Colors.GREEN, 6);
        _4red_3b_6g_3rCost.put(Colors.WHITE, 0);


        _4red_7gCost.put(Colors.BLUE, 0);
        _4red_7gCost.put(Colors.BLACK, 0);
        _4red_7gCost.put(Colors.RED, 0);
        _4red_7gCost.put(Colors.GREEN, 7);
        _4red_7gCost.put(Colors.WHITE, 0);

        _5blue_7w_3bCost.put(Colors.BLUE, 3);
        _5blue_7w_3bCost.put(Colors.BLACK, 0);
        _5blue_7w_3bCost.put(Colors.RED, 0);
        _5blue_7w_3bCost.put(Colors.GREEN, 0);
        _5blue_7w_3bCost.put(Colors.WHITE, 7);

        _5green_7b_3gCost.put(Colors.BLUE, 7);
        _5green_7b_3gCost.put(Colors.BLACK, 0);
        _5green_7b_3gCost.put(Colors.RED, 0);
        _5green_7b_3gCost.put(Colors.GREEN, 3);
        _5green_7b_3gCost.put(Colors.WHITE, 0);

        _5red_7g_3rCost.put(Colors.BLUE, 0);
        _5red_7g_3rCost.put(Colors.BLACK, 0);
        _5red_7g_3rCost.put(Colors.RED, 3);
        _5red_7g_3rCost.put(Colors.GREEN, 7);
        _5red_7g_3rCost.put(Colors.WHITE, 0);

        _5white_3w_7bcCost.put(Colors.BLUE, 0);
        _5white_3w_7bcCost.put(Colors.BLACK, 7);
        _5white_3w_7bcCost.put(Colors.RED, 0);
        _5white_3w_7bcCost.put(Colors.GREEN, 0);
        _5white_3w_7bcCost.put(Colors.WHITE, 3);

        cardsList.add(_3black_3w_3b_5g_3rCard);
        cardsList.add(_3blue__3w_3g_3r_5bcCard);
        cardsList.add(_3green_5w_3b_3r_3bcCard);
        cardsList.add(_3red_3w_5b_3g_3bcCard);
        cardsList.add(_3white_3b_3g_5r_3bcCard);
        cardsList.add(_4black_3g_6r_3bcCard);
        cardsList.add(_4black_7rCard);
        cardsList.add(_4blue__6w_3b_3bcCard);
        cardsList.add(_4blue_7wCard);
        cardsList.add(_4green_3w_6b_3gCard);
        cardsList.add(_4green_7bCard);
        cardsList.add(_4white_3w_3r_6bcCard);
        cardsList.add(_4white_7bcCard);
        cardsList.add(_5black_7r_3bcCard);
        cardsList.add(_5blue_7w_3bCard);
        cardsList.add(_4red_3b_6g_3rCard);
        cardsList.add(_4red_7gCard);
        cardsList.add(_5green_7b_3gCard);
        cardsList.add(_5red_7g_3rCard);
        cardsList.add(_5white_3w_7bcCard);

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

        Map<Colors, Integer> costAfterCards = card.getCost().entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue() - player.getCardCounter().get(e.getKey())))
                .entrySet().stream()
                .filter(c -> c.getValue() > 0)
                .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));

        long costCheckCounter = costAfterCards.entrySet().stream()
                .filter(e -> player.getJewelCounter().get(e.getKey()) >= e.getValue())
                .count();
        long costAfterCardsSize = costAfterCards.size();

        if (costCheckCounter == costAfterCardsSize) {
            player.setResult(player.getResult() + card.getValue());
            int cardNumber = player.getCardCounter().get(card.getColor());
            player.getCardCounter().replace(card.getColor(), cardNumber +1 );
            costAfterCards.entrySet().stream()
                    .forEach(e -> player.getJewelCounter().replace(e.getKey(), player.getJewelCounter().get(e.getKey())-e.getValue()));
            ifCardTaken = true;
            fourCards.set(position, drawCard());
        }

        return ifCardTaken;
    }
}
