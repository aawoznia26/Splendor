package com.kodilla.splendor.Repository;

import com.kodilla.splendor.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;
import java.util.stream.Collectors;

public class Cards2LevelRepository implements CardsRepository{
    
    private List<Cards2Level> cardsList = new ArrayList<>();
    private List<Cards2Level> fourCards = new ArrayList<>();
    private Random random = new Random();

    ImageView _1black_3w_2b_2g = new ImageView(
            new Image("file:src/main/resources/cards/level2/1black_3w_2b_2g.png",
                    120,240, true, true));
    ImageView _1black_3w_3g_2bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/1black_3w_3g_2bc.png",
                    120,240, true, true));
    ImageView _1blue_2b_2g_3r = new ImageView(
            new Image("file:src/main/resources/cards/level2/1blue_2b_2g_3r.png",
                    120,240, true, true));
    ImageView _1blue__2b_3g_3bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/1blue__2b_3g_3bc.png",
                    120,240, true, true));
    ImageView _1green_2w_3b_2bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/1green_2w_3b_2bc.png",
                    120,240, true, true));
    ImageView _1green_3w_2g_3r = new ImageView(
            new Image("file:src/main/resources/cards/level2/1green_3w_2g_3r.png",
                    120,240, true, true));
    ImageView _1red_2w_2r_3bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/1red_2w_2r_3bc.png",
                    120,240, true, true));
    ImageView _1red_3b_2r_3bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/1red_3b_2r_3bc.png",
                    120,240, true, true));
    ImageView _1white_2w_3b_3r = new ImageView(
            new Image("file:src/main/resources/cards/level2/1white_2w_3b_3r.png",
                    120,240, true, true));
    ImageView _1white_3g_2r_2bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/1white_3g_2r_2bc.png",
                    120,240, true, true));
    ImageView _2black_1b_4g_2r = new ImageView(
            new Image("file:src/main/resources/cards/level2/2black_1b_4g_2r.png",
                    120,240, true, true));
    ImageView _2black_5g_3r = new ImageView(
            new Image("file:src/main/resources/cards/level2/2black_5g_3r.png",
                    120,240, true, true));
    ImageView _2black_5w = new ImageView(
            new Image("file:src/main/resources/cards/level2/2black_5w.png",
                    120,240, true, true));
    ImageView _2blue__2w_1r_4bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/2blue__2w_1r_4bc.png",
                    120,240, true, true));
    ImageView _2blue__5b = new ImageView(
            new Image("file:src/main/resources/cards/level2/2blue__5b.png",
                    120,240, true, true));
    ImageView _2blue__5w_3b = new ImageView(
            new Image("file:src/main/resources/cards/level2/2blue__5w_3b.png",
                    120,240, true, true));
    ImageView _2green_4w_2b_1bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/2green_4w_2b_1bc.png",
                    120,240, true, true));
    ImageView _2green_5b_3g = new ImageView(
            new Image("file:src/main/resources/cards/level2/2green_5b_3g.png",
                    120,240, true, true));
    ImageView _2green_5g = new ImageView(
            new Image("file:src/main/resources/cards/level2/2green_5g.png",
                    120,240, true, true));
    ImageView _2red_1w_4b_2g = new ImageView(
            new Image("file:src/main/resources/cards/level2/2red_1w_4b_2g.png",
                    120,240, true, true));
    ImageView _2red_3w_5bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/2red_3w_5bc.png",
                    120,240, true, true));
    ImageView _2red_5bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/2red_5bc.png",
                    120,240, true, true));
    ImageView _2white_1g_4r_2bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/2white_1g_4r_2bc.png",
                    120,240, true, true));
    ImageView _2white_5r = new ImageView(
            new Image("file:src/main/resources/cards/level2/2white_5r.png",
                    120,240, true, true));
    ImageView _2white_5r_3bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/2white_5r_3bc.png",
                    120,240, true, true));


    ImageView _3black_6bc = new ImageView(
            new Image("file:src/main/resources/cards/level2/3black_6bc.png",
                    120,240, true, true));
    ImageView _3blue__6b = new ImageView(
            new Image("file:src/main/resources/cards/level2/3blue__6b.png",
                    120,240, true, true));
    ImageView _3green_6g = new ImageView(
            new Image("file:src/main/resources/cards/level2/3green_6g.png",
                    120,240, true, true));
    ImageView _3red_6r = new ImageView(
            new Image("file:src/main/resources/cards/level2/3red_6r.png",
                    120,240, true, true));
    ImageView _3white_6w = new ImageView(
            new Image("file:src/main/resources/cards/level2/3white_6w.png",
                    120,240, true, true));



    private Map<Colors, Integer> _1black_3w_2b_2gCost = new HashMap<>();
    private Map<Colors, Integer> _1black_3w_3g_2bcCost = new HashMap<>();
    private Map<Colors, Integer> _1blue_2b_2g_3rCost = new HashMap<>();
    private Map<Colors, Integer> _1blue__2b_3g_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _1green_2w_3b_2bcCost = new HashMap<>();
    private Map<Colors, Integer> _1green_3w_2g_3rCost = new HashMap<>();
    private Map<Colors, Integer> _1red_2w_2r_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _1red_3b_2r_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _1white_2w_3b_3rCost = new HashMap<>();
    private Map<Colors, Integer> _1white_3g_2r_2bcCost = new HashMap<>();
    private Map<Colors, Integer> _2black_1b_4g_2rCost = new HashMap<>();
    private Map<Colors, Integer> _2black_5g_3rCost = new HashMap<>();
    private Map<Colors, Integer> _2black_5wCost = new HashMap<>();
    private Map<Colors, Integer> _2blue__2w_1r_4bcCost = new HashMap<>();
    private Map<Colors, Integer> _2blue__5bCost = new HashMap<>();
    private Map<Colors, Integer> _2blue__5w_3bCost = new HashMap<>();
    private Map<Colors, Integer> _2green_4w_2b_1bcCost = new HashMap<>();
    private Map<Colors, Integer> _2green_5b_3gCost = new HashMap<>();
    private Map<Colors, Integer> _2green_5gCost = new HashMap<>();
    private Map<Colors, Integer> _2red_1w_4b_2gCost = new HashMap<>();
    private Map<Colors, Integer> _2red_3w_5bcCost = new HashMap<>();
    private Map<Colors, Integer> _2red_5bcCost = new HashMap<>();
    private Map<Colors, Integer> _2white_1g_4r_2bcCost = new HashMap<>();
    private Map<Colors, Integer> _2white_5rCost = new HashMap<>();
    private Map<Colors, Integer> _2white_5r_3bcCost = new HashMap<>();

    private Map<Colors, Integer> _3black_6bcCost = new HashMap<>();
    private Map<Colors, Integer> _3blue__6bCost = new HashMap<>();
    private Map<Colors, Integer> _3green_6gCost = new HashMap<>();
    private Map<Colors, Integer> _3red_6rCost = new HashMap<>();
    private Map<Colors, Integer> _3white_6wCost = new HashMap<>();


    private Cards2Level _1black_3w_2b_2gCard = new Cards2Level(_1black_3w_2b_2gCost, Colors.BLACK, _1black_3w_2b_2g, 1 );
    private Cards2Level _1black_3w_3g_2bcCard = new Cards2Level(_1black_3w_3g_2bcCost, Colors.BLACK, _1black_3w_3g_2bc, 1 );
    private Cards2Level _1blue_2b_2g_3rCard = new Cards2Level(_1blue_2b_2g_3rCost, Colors.BLUE, _1blue_2b_2g_3r, 1 );
    private Cards2Level _1blue__2b_3g_3bcCard = new Cards2Level(_1blue__2b_3g_3bcCost, Colors.BLUE, _1blue__2b_3g_3bc, 1 );
    private Cards2Level _1green_2w_3b_2bcCard = new Cards2Level(_1green_2w_3b_2bcCost, Colors.GREEN, _1green_2w_3b_2bc, 1 );
    private Cards2Level _1green_3w_2g_3rCard = new Cards2Level(_1green_3w_2g_3rCost, Colors.GREEN, _1green_3w_2g_3r, 1 );
    private Cards2Level _1red_2w_2r_3bcCard = new Cards2Level(_1red_2w_2r_3bcCost, Colors.RED, _1red_2w_2r_3bc, 1 );
    private Cards2Level _1red_3b_2r_3bcCard = new Cards2Level(_1red_3b_2r_3bcCost, Colors.RED, _1red_3b_2r_3bc, 1 );
    private Cards2Level _1white_2w_3b_3rCard = new Cards2Level(_1white_2w_3b_3rCost, Colors.WHITE, _1white_2w_3b_3r, 1 );
    private Cards2Level _1white_3g_2r_2bcCard = new Cards2Level(_1white_3g_2r_2bcCost, Colors.WHITE, _1white_3g_2r_2bc, 1 );
    private Cards2Level _2black_1b_4g_2rCard = new Cards2Level(_2black_1b_4g_2rCost, Colors.BLACK, _2black_1b_4g_2r, 2 );
    private Cards2Level _2black_5g_3rCard = new Cards2Level(_2black_5g_3rCost, Colors.BLACK, _2black_5g_3r, 2 );
    private Cards2Level _2black_5wCard = new Cards2Level(_2black_5wCost, Colors.BLACK, _2black_5w, 2 );
    private Cards2Level _2blue__2w_1r_4bcCard = new Cards2Level(_2blue__2w_1r_4bcCost, Colors.BLUE, _2blue__2w_1r_4bc, 2 );
    private Cards2Level _2blue__5bCard = new Cards2Level(_2blue__5bCost, Colors.BLUE, _2blue__5b, 2 );
    private Cards2Level _2blue__5w_3bCard = new Cards2Level(_2blue__5w_3bCost, Colors.BLUE, _2blue__5w_3b, 2 );
    private Cards2Level _2green_4w_2b_1bcCard = new Cards2Level(_2green_4w_2b_1bcCost, Colors.GREEN, _2green_4w_2b_1bc, 2 );
    private Cards2Level _2green_5b_3gCard = new Cards2Level(_2green_5b_3gCost, Colors.GREEN, _2green_5b_3g, 2 );
    private Cards2Level _2green_5gCard = new Cards2Level(_2green_5gCost, Colors.GREEN, _2green_5g, 2 );
    private Cards2Level _2red_1w_4b_2gCard = new Cards2Level(_2red_1w_4b_2gCost, Colors.RED, _2red_1w_4b_2g, 2 );
    private Cards2Level _2red_3w_5bcCard = new Cards2Level(_2red_3w_5bcCost, Colors.RED, _2red_3w_5bc, 2 );
    private Cards2Level _2red_5bcCard = new Cards2Level(_2red_5bcCost, Colors.RED, _2red_5bc, 2 );
    private Cards2Level _2white_1g_4r_2bcCard = new Cards2Level(_2white_1g_4r_2bcCost, Colors.WHITE, _2white_1g_4r_2bc, 2 );
    private Cards2Level _2white_5rCard = new Cards2Level(_2white_5rCost, Colors.WHITE, _2white_5r, 2 );
    private Cards2Level _2white_5r_3bcCard = new Cards2Level(_2white_5r_3bcCost, Colors.WHITE, _2white_5r_3bc, 2 );


    private Cards2Level _3black_6bcCard = new Cards2Level(_3black_6bcCost, Colors.BLACK, _3black_6bc, 3 );
    private Cards2Level _3blue__6bCard = new Cards2Level(_3blue__6bCost, Colors.BLUE, _3blue__6b, 3 );
    private Cards2Level _3green_6gCard = new Cards2Level(_3green_6gCost, Colors.GREEN, _3green_6g, 3 );
    private Cards2Level _3red_6Crard = new Cards2Level(_3red_6rCost, Colors.RED, _3red_6r, 3 );
    private Cards2Level _3white_6wCard = new Cards2Level(_3white_6wCost, Colors.WHITE, _3white_6w, 3 );

    public Cards2LevelRepository() {
        _1black_3w_2b_2gCost.put(Colors.BLUE, 2);
        _1black_3w_2b_2gCost.put(Colors.BLACK, 0);
        _1black_3w_2b_2gCost.put(Colors.RED, 0);
        _1black_3w_2b_2gCost.put(Colors.GREEN, 2);
        _1black_3w_2b_2gCost.put(Colors.WHITE, 3);

        _1black_3w_3g_2bcCost.put(Colors.BLUE, 0);
        _1black_3w_3g_2bcCost.put(Colors.BLACK, 2);
        _1black_3w_3g_2bcCost.put(Colors.RED, 0);
        _1black_3w_3g_2bcCost.put(Colors.GREEN, 3);
        _1black_3w_3g_2bcCost.put(Colors.WHITE, 3);

        _1blue_2b_2g_3rCost.put(Colors.BLUE, 2);
        _1blue_2b_2g_3rCost.put(Colors.BLACK, 3);
        _1blue_2b_2g_3rCost.put(Colors.RED, 0);
        _1blue_2b_2g_3rCost.put(Colors.GREEN, 3);
        _1blue_2b_2g_3rCost.put(Colors.WHITE, 0);

        _1blue__2b_3g_3bcCost.put(Colors.BLUE, 2);
        _1blue__2b_3g_3bcCost.put(Colors.BLACK, 0);
        _1blue__2b_3g_3bcCost.put(Colors.RED, 3);
        _1blue__2b_3g_3bcCost.put(Colors.GREEN, 2);
        _1blue__2b_3g_3bcCost.put(Colors.WHITE, 0);

        _1green_2w_3b_2bcCost.put(Colors.BLUE, 3);
        _1green_2w_3b_2bcCost.put(Colors.BLACK, 2);
        _1green_2w_3b_2bcCost.put(Colors.RED, 0);
        _1green_2w_3b_2bcCost.put(Colors.GREEN, 0);
        _1green_2w_3b_2bcCost.put(Colors.WHITE, 2);

        _1green_3w_2g_3rCost.put(Colors.BLUE, 0);
        _1green_3w_2g_3rCost.put(Colors.BLACK, 0);
        _1green_3w_2g_3rCost.put(Colors.RED, 3);
        _1green_3w_2g_3rCost.put(Colors.GREEN, 2);
        _1green_3w_2g_3rCost.put(Colors.WHITE, 3);

        _1red_2w_2r_3bcCost.put(Colors.BLUE, 0);
        _1red_2w_2r_3bcCost.put(Colors.BLACK, 3);
        _1red_2w_2r_3bcCost.put(Colors.RED, 2);
        _1red_2w_2r_3bcCost.put(Colors.GREEN, 0);
        _1red_2w_2r_3bcCost.put(Colors.WHITE, 2);

        _1red_3b_2r_3bcCost.put(Colors.BLUE, 3);
        _1red_3b_2r_3bcCost.put(Colors.BLACK, 3);
        _1red_3b_2r_3bcCost.put(Colors.RED, 2);
        _1red_3b_2r_3bcCost.put(Colors.GREEN, 0);
        _1red_3b_2r_3bcCost.put(Colors.WHITE, 0);

        _1white_2w_3b_3rCost.put(Colors.BLUE, 3);
        _1white_2w_3b_3rCost.put(Colors.BLACK, 0);
        _1white_2w_3b_3rCost.put(Colors.RED, 3);
        _1white_2w_3b_3rCost.put(Colors.GREEN, 0);
        _1white_2w_3b_3rCost.put(Colors.WHITE, 2);

        _1white_3g_2r_2bcCost.put(Colors.BLUE, 0);
        _1white_3g_2r_2bcCost.put(Colors.BLACK, 2);
        _1white_3g_2r_2bcCost.put(Colors.RED, 2);
        _1white_3g_2r_2bcCost.put(Colors.GREEN, 3);
        _1white_3g_2r_2bcCost.put(Colors.WHITE, 0);

        _2black_1b_4g_2rCost.put(Colors.BLUE, 1);
        _2black_1b_4g_2rCost.put(Colors.BLACK, 0);
        _2black_1b_4g_2rCost.put(Colors.RED, 2);
        _2black_1b_4g_2rCost.put(Colors.GREEN, 4);
        _2black_1b_4g_2rCost.put(Colors.WHITE, 0);

        _2black_5g_3rCost.put(Colors.BLUE, 0);
        _2black_5g_3rCost.put(Colors.BLACK, 0);
        _2black_5g_3rCost.put(Colors.RED, 3);
        _2black_5g_3rCost.put(Colors.GREEN, 5);
        _2black_5g_3rCost.put(Colors.WHITE, 0);

        _2black_5wCost.put(Colors.BLUE, 0);
        _2black_5wCost.put(Colors.BLACK, 5);
        _2black_5wCost.put(Colors.RED, 0);
        _2black_5wCost.put(Colors.GREEN, 0);
        _2black_5wCost.put(Colors.WHITE, 0);

        _2blue__2w_1r_4bcCost.put(Colors.BLUE, 0);
        _2blue__2w_1r_4bcCost.put(Colors.BLACK, 4);
        _2blue__2w_1r_4bcCost.put(Colors.RED, 1);
        _2blue__2w_1r_4bcCost.put(Colors.GREEN, 0);
        _2blue__2w_1r_4bcCost.put(Colors.WHITE, 2);

        _2blue__5bCost.put(Colors.BLUE, 5);
        _2blue__5bCost.put(Colors.BLACK, 5);
        _2blue__5bCost.put(Colors.RED, 0);
        _2blue__5bCost.put(Colors.GREEN, 0);
        _2blue__5bCost.put(Colors.WHITE, 5);

        _2blue__5w_3bCost.put(Colors.BLUE, 3);
        _2blue__5w_3bCost.put(Colors.BLACK, 0);
        _2blue__5w_3bCost.put(Colors.RED, 0);
        _2blue__5w_3bCost.put(Colors.GREEN, 0);
        _2blue__5w_3bCost.put(Colors.WHITE, 5);

        _2green_4w_2b_1bcCost.put(Colors.BLUE, 2);
        _2green_4w_2b_1bcCost.put(Colors.BLACK, 1);
        _2green_4w_2b_1bcCost.put(Colors.RED, 0);
        _2green_4w_2b_1bcCost.put(Colors.GREEN, 0);
        _2green_4w_2b_1bcCost.put(Colors.WHITE, 4);

        _2green_5b_3gCost.put(Colors.BLUE, 5);
        _2green_5b_3gCost.put(Colors.BLACK, 0);
        _2green_5b_3gCost.put(Colors.RED, 0);
        _2green_5b_3gCost.put(Colors.GREEN, 3);
        _2green_5b_3gCost.put(Colors.WHITE, 0);

        _2green_5gCost.put(Colors.BLUE, 0);
        _2green_5gCost.put(Colors.BLACK, 0);
        _2green_5gCost.put(Colors.RED, 0);
        _2green_5gCost.put(Colors.GREEN, 5);
        _2green_5gCost.put(Colors.WHITE, 0);

        _2red_1w_4b_2gCost.put(Colors.BLUE, 4);
        _2red_1w_4b_2gCost.put(Colors.BLACK, 0);
        _2red_1w_4b_2gCost.put(Colors.RED, 0);
        _2red_1w_4b_2gCost.put(Colors.GREEN, 2);
        _2red_1w_4b_2gCost.put(Colors.WHITE, 1);

        _2red_3w_5bcCost.put(Colors.BLUE, 0);
        _2red_3w_5bcCost.put(Colors.BLACK, 5);
        _2red_3w_5bcCost.put(Colors.RED, 0);
        _2red_3w_5bcCost.put(Colors.GREEN, 0);
        _2red_3w_5bcCost.put(Colors.WHITE, 3);

        _2red_5bcCost.put(Colors.BLUE, 0);
        _2red_5bcCost.put(Colors.BLACK, 5);
        _2red_5bcCost.put(Colors.RED, 0);
        _2red_5bcCost.put(Colors.GREEN, 0);
        _2red_5bcCost.put(Colors.WHITE, 0);

        _2white_1g_4r_2bcCost.put(Colors.BLUE, 0);
        _2white_1g_4r_2bcCost.put(Colors.BLACK, 2);
        _2white_1g_4r_2bcCost.put(Colors.RED, 4);
        _2white_1g_4r_2bcCost.put(Colors.GREEN, 1);
        _2white_1g_4r_2bcCost.put(Colors.WHITE, 0);

        _2white_5rCost.put(Colors.BLUE, 0);
        _2white_5rCost.put(Colors.BLACK, 0);
        _2white_5rCost.put(Colors.RED, 5);
        _2white_5rCost.put(Colors.GREEN, 0);
        _2white_5rCost.put(Colors.WHITE, 0);

        _2white_5r_3bcCost.put(Colors.BLUE, 0);
        _2white_5r_3bcCost.put(Colors.BLACK, 3);
        _2white_5r_3bcCost.put(Colors.RED, 5);
        _2white_5r_3bcCost.put(Colors.GREEN, 0);
        _2white_5r_3bcCost.put(Colors.WHITE, 0);

        _3black_6bcCost.put(Colors.BLUE, 0);
        _3black_6bcCost.put(Colors.BLACK, 6);
        _3black_6bcCost.put(Colors.RED, 0);
        _3black_6bcCost.put(Colors.GREEN, 0);
        _3black_6bcCost.put(Colors.WHITE, 0);

        _3blue__6bCost.put(Colors.BLUE, 6);
        _3blue__6bCost.put(Colors.BLACK, 0);
        _3blue__6bCost.put(Colors.RED, 0);
        _3blue__6bCost.put(Colors.GREEN, 0);
        _3blue__6bCost.put(Colors.WHITE, 0);

        _3green_6gCost.put(Colors.BLUE, 0);
        _3green_6gCost.put(Colors.BLACK, 0);
        _3green_6gCost.put(Colors.RED, 0);
        _3green_6gCost.put(Colors.GREEN, 6);
        _3green_6gCost.put(Colors.WHITE, 0);

        _3red_6rCost.put(Colors.BLUE, 0);
        _3red_6rCost.put(Colors.BLACK, 0);
        _3red_6rCost.put(Colors.RED, 6);
        _3red_6rCost.put(Colors.GREEN, 0);
        _3red_6rCost.put(Colors.WHITE, 0);

        _3white_6wCost.put(Colors.BLUE, 0);
        _3white_6wCost.put(Colors.BLACK, 0);
        _3white_6wCost.put(Colors.RED, 0);
        _3white_6wCost.put(Colors.GREEN, 0);
        _3white_6wCost.put(Colors.WHITE, 6);



        cardsList.add(_1black_3w_2b_2gCard);
        cardsList.add(_1black_3w_3g_2bcCard);
        cardsList.add(_1blue_2b_2g_3rCard);
        cardsList.add(_1blue__2b_3g_3bcCard);
        cardsList.add(_1green_2w_3b_2bcCard);
        cardsList.add(_1green_3w_2g_3rCard);
        cardsList.add(_1red_2w_2r_3bcCard);
        cardsList.add(_1red_3b_2r_3bcCard);
        cardsList.add(_1white_2w_3b_3rCard);
        cardsList.add(_1white_3g_2r_2bcCard);
        cardsList.add(_2black_1b_4g_2rCard);
        cardsList.add(_2black_5g_3rCard);
        cardsList.add(_2black_5wCard);
        cardsList.add(_2blue__2w_1r_4bcCard);
        cardsList.add(_2blue__5bCard);
        cardsList.add(_2blue__5w_3bCard);
        cardsList.add(_2green_4w_2b_1bcCard);
        cardsList.add(_2green_5b_3gCard);
        cardsList.add(_2green_5gCard);
        cardsList.add(_2red_1w_4b_2gCard);
        cardsList.add(_2red_3w_5bcCard);
        cardsList.add(_2red_5bcCard);
        cardsList.add(_2white_1g_4r_2bcCard);
        cardsList.add(_2white_5rCard);
        cardsList.add(_2white_5r_3bcCard);
        cardsList.add(_3black_6bcCard);
        cardsList.add(_3blue__6bCard);
        cardsList.add(_3green_6gCard);
        cardsList.add(_3red_6Crard);
        cardsList.add(_3white_6wCard);

    }


    public List<Cards2Level> getFourCards() {
        return fourCards;
    }

    public void drawFourCards() {
        Cards2Level card1 = drawCard();
        Cards2Level card2 = drawCard();
        Cards2Level card3 = drawCard();
        Cards2Level card4 = drawCard();

        fourCards.add(card1);
        fourCards.add(card2);
        fourCards.add(card3);
        fourCards.add(card4);
    }


    public Cards2Level drawCard() {
        Cards2Level randomCard = new Cards2Level();
        if (cardsList.size() > 0) {
            randomCard = cardsList.get(random.nextInt(cardsList.size()));
            cardsList.remove(randomCard);
        }
        return randomCard;
    }


    public boolean takeCard(Player player, Cards2Level card) {

        boolean ifCardTaken = false;
        int cardPosition = fourCards.indexOf(card);

        Map<Colors, Integer> costAfterCards = card.getCost().entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue() - player.getCardCounter().get(e.getKey())))
                .entrySet().stream()
                .filter(c -> c.getValue() > 0)
                .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));

        long costCheckCounter = costAfterCards.entrySet().stream()
                .filter(e -> player.getJewelCounter().get(e.getKey()) >= e.getValue())
                .count();
        long costAfterCardsSize = costAfterCards.size();

        if (costCheckCounter == costAfterCardsSize && Move.validateMove("card")) {
            player.setResult(player.getResult() + card.getValue());
            int cardNumber = player.getCardCounter().get(card.getColor());
            player.getCardCounter().replace(card.getColor(), cardNumber +1 );
            costAfterCards.entrySet().stream()
                    .forEach(e -> player.getJewelCounter().replace(e.getKey(), player.getJewelCounter().get(e.getKey())-e.getValue()));
            fourCards.set(cardPosition, drawCard());
            ifCardTaken = true;
            Move.setCardTaken(Move.getCardTaken() + 1);
        }

        return ifCardTaken;
    }
}
