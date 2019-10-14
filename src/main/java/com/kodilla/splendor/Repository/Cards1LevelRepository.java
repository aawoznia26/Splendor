package com.kodilla.splendor.Repository;

import com.kodilla.splendor.Cards1Level;
import com.kodilla.splendor.Colors;
import com.kodilla.splendor.Move;
import com.kodilla.splendor.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;
import java.util.stream.Collectors;

public class Cards1LevelRepository implements CardsRepository{

    private List<Cards1Level> cardsList = new ArrayList<>();
    private List<Cards1Level> fourCards = new ArrayList<>();
    private Random random = new Random();

    ImageView _1black_4b = new ImageView(
            new Image("file:src/main/resources/cards/level1/1black_4b.png",
                    120,240, true, true));
    ImageView _1blue__2r = new ImageView(
            new Image("file:src/main/resources/cards/level1/1blue__2r.png",
                    120,240, true, true));
    ImageView _1green_4bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/1green_4bc.png",
                    120,240, true, true));
    ImageView _1red_4w = new ImageView(
            new Image("file:src/main/resources/cards/level1/1red_4w.png",
                    120,240, true, true));
    ImageView _1white_4g = new ImageView(
            new Image("file:src/main/resources/cards/level1/1white_4g.png",
                    120,240, true, true));
    ImageView _black_1g_3r_1bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/black_1g_3r_1bc.png",
                    120,240, true, true));
    ImageView _black_1w_1b_1g_1r = new ImageView(
            new Image("file:src/main/resources/cards/level1/black_1w_1b_1g_1r.png",
                    120,240, true, true));
    ImageView _black_1w_2b_1g_1r = new ImageView(
            new Image("file:src/main/resources/cards/level1/black_1w_2b_1g_1r.png",
                    120,240, true, true));
    ImageView _black_2g_1r = new ImageView(
            new Image("file:src/main/resources/cards/level1/black_2g_1r.png",
                    120,240, true, true));
    ImageView _black_2w_2b_1r = new ImageView(
            new Image("file:src/main/resources/cards/level1/black_2w_2b_1r.png",
                    120,240, true, true));
    ImageView _black_2w_2g = new ImageView(
            new Image("file:src/main/resources/cards/level1/black_2w_2g.png",
                    120,240, true, true));
    ImageView _black_3g = new ImageView(
            new Image("file:src/main/resources/cards/level1/black_3g.png",
                    120,240, true, true));
    ImageView _blue__1b_3g_1r = new ImageView(
            new Image("file:src/main/resources/cards/level1/blue__1b_3g_1r.png",
                    120,240, true, true));
    ImageView _blue_1w_1g_1r_1bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/blue_1w_1g_1r_1bc.png",
                    120,240, true, true));
    ImageView _blue_1w_1g_2r_1bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/blue_1w_1g_2r_1bc.png",
                    120,240, true, true));
    ImageView _blue_1w_2bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/blue_1w_2bc.png",
                    120,240, true, true));
    ImageView _blue_1w_2g_2r = new ImageView(
            new Image("file:src/main/resources/cards/level1/blue_1w_2g_2r.png",
                    120,240, true, true));
    ImageView _blue_2g_2bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/blue_2g_2bc.png",
                    120,240, true, true));
    ImageView _blue_3bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/blue_3bc.png",
                    120,240, true, true));
    ImageView _green_1b_2r_2bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/green_1b_2r_2bc.png",
                    120,240, true, true));
    ImageView _green_1w_1b_1r_1bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/green_1w_1b_1r_1bc.png",
                    120,240, true, true));
    ImageView _green_1w_1b_1r_2bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/green_1w_1b_1r_2bc.png",
                    120,240, true, true));
    ImageView _green_1w_3b_1g = new ImageView(
            new Image("file:src/main/resources/cards/level1/green_1w_3b_1g.png",
                    120,240, true, true));
    ImageView _green_2b_2r = new ImageView(
            new Image("file:src/main/resources/cards/level1/green_2b_2r.png",
                    120,240, true, true));
    ImageView _green_2w_1b = new ImageView(
            new Image("file:src/main/resources/cards/level1/green_2w_1b.png",
                    120,240, true, true));
    ImageView _green_3r = new ImageView(
            new Image("file:src/main/resources/cards/level1/green_3r.png",
                    120,240, true, true));
    ImageView _red_1w_1b_1g_1bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/red_1w_1b_1g_1bc.png",
                    120,240, true, true));
    ImageView _red_1w_1r_3bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/red_1w_1r_3bc.png",
                    120,240, true, true));
    ImageView _red_2b_1g = new ImageView(
            new Image("file:src/main/resources/cards/level1/red_2b_1g.png",
                    120,240, true, true));
    ImageView _red_2w_1b_1g_1bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/red_2w_1b_1g_1bc.png",
                    120,240, true, true));
    ImageView _red_2w_1g_2bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/red_2w_1g_2bc.png",
                    120,240, true, true));
    ImageView _red_2w_2r = new ImageView(
            new Image("file:src/main/resources/cards/level1/red_2w_2r.png",
                    120,240, true, true));
    ImageView _red_3w = new ImageView(
            new Image("file:src/main/resources/cards/level1/red_3w.png",
                    120,240, true, true));
    ImageView _white_1b_1g_1r_1bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/white_1b_1g_1r_1bc.png",
                    120,240, true, true));
    ImageView _white_1b_2g_1r_1bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/white_1b_2g_1r_1bc.png",
                    120,240, true, true));
    ImageView _white_1r_1bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/white_1r_1bc.png",
                    120,240, true, true));
    ImageView _white_2b_2bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/white_2b_2bc.png",
                    120,240, true, true));
    ImageView _white_2b_2g_1w = new ImageView(
            new Image("file:src/main/resources/cards/level1/white_2b_2g_1w.png",
                    120,240, true, true));
    ImageView _white_3b = new ImageView(
            new Image("file:src/main/resources/cards/level1/white_3b.png",
                    120,240, true, true));
    ImageView _white_3w_1b_1bc = new ImageView(
            new Image("file:src/main/resources/cards/level1/white_3w_1b_1bc.png",
                    120,240, true, true));


    private Map<Colors, Integer> _1black_4bCost = new HashMap<>();
    private Map<Colors, Integer> _1blue__2rCost = new HashMap<>();
    private Map<Colors, Integer> _1green_4bcCost = new HashMap<>();
    private Map<Colors, Integer> _1red_4wCost = new HashMap<>();
    private Map<Colors, Integer> _1white_4gCost = new HashMap<>();
    private Map<Colors, Integer> _black_1g_3r_1bcCost = new HashMap<>();
    private Map<Colors, Integer> _black_1w_1b_1g_1rCost = new HashMap<>();
    private Map<Colors, Integer> _black_1w_2b_1g_1rCost = new HashMap<>();
    private Map<Colors, Integer> _black_2g_1rCost = new HashMap<>();
    private Map<Colors, Integer> _black_2w_2b_1rCost = new HashMap<>();
    private Map<Colors, Integer> _black_2w_2gCost = new HashMap<>();
    private Map<Colors, Integer> _black_3gCost = new HashMap<>();
    private Map<Colors, Integer> _blue__1b_3g_1rCost = new HashMap<>();
    private Map<Colors, Integer> _blue_1w_1g_1r_1bcCost = new HashMap<>();
    private Map<Colors, Integer> _blue_1w_1g_2r_1bcCost = new HashMap<>();
    private Map<Colors, Integer> _blue_1w_2bcCost = new HashMap<>();
    private Map<Colors, Integer> _blue_1w_2g_2rCost = new HashMap<>();
    private Map<Colors, Integer> _blue_2g_2bcCost = new HashMap<>();
    private Map<Colors, Integer> _blue_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _green_1b_2r_2bcCost = new HashMap<>();
    private Map<Colors, Integer> _green_1w_1b_1r_1bcCost = new HashMap<>();
    private Map<Colors, Integer> _green_1w_1b_1r_2bcCost = new HashMap<>();
    private Map<Colors, Integer> _green_1w_3b_1gCost = new HashMap<>();
    private Map<Colors, Integer> _green_2b_2rCost = new HashMap<>();
    private Map<Colors, Integer> _green_2w_1bCost = new HashMap<>();
    private Map<Colors, Integer> _green_3rCost = new HashMap<>();
    private Map<Colors, Integer> _red_1w_1b_1g_1bcCost = new HashMap<>();
    private Map<Colors, Integer> _red_1w_1r_3bcCost = new HashMap<>();
    private Map<Colors, Integer> _red_2b_1gCost = new HashMap<>();
    private Map<Colors, Integer> _red_2w_1b_1g_1bcCost = new HashMap<>();
    private Map<Colors, Integer> _red_2w_1g_2bcCost = new HashMap<>();
    private Map<Colors, Integer> _red_2w_2rCost = new HashMap<>();
    private Map<Colors, Integer> _red_3wCost = new HashMap<>();


    private Map<Colors, Integer> _white_1b_1g_1r_1bcCost = new HashMap<>();
    private Map<Colors, Integer> _white_1b_2g_1r_1bcCost = new HashMap<>();
    private Map<Colors, Integer> _white_1r_1bcCost = new HashMap<>();
    private Map<Colors, Integer> _white_2b_2bcCost = new HashMap<>();
    private Map<Colors, Integer> _white_2b_2g_1wCost = new HashMap<>();
    private Map<Colors, Integer> _white_3bCost = new HashMap<>();
    private Map<Colors, Integer> _white_3w_1b_1bcCost = new HashMap<>();

    private Cards1Level _1black_4bCard = new Cards1Level(_1black_4bCost, Colors.BLACK, _1black_4b, 1 );
    private Cards1Level _1blue__2rCard = new Cards1Level(_1blue__2rCost, Colors.BLUE, _1blue__2r, 1 );
    private Cards1Level _1green_4bcCard = new Cards1Level(_1green_4bcCost, Colors.GREEN, _1green_4bc, 1 );
    private Cards1Level _1red_4wCard = new Cards1Level(_1red_4wCost, Colors.RED, _1red_4w, 1 );
    private Cards1Level _1white_4gCard = new Cards1Level(_1white_4gCost, Colors.WHITE, _1white_4g, 1 );
    private Cards1Level _black_1g_3r_1bcCard = new Cards1Level(_black_1g_3r_1bcCost, Colors.BLACK, _black_1g_3r_1bc, 0 );
    private Cards1Level _black_1w_1b_1g_1rCard = new Cards1Level(_black_1w_1b_1g_1rCost, Colors.BLACK, _black_1w_1b_1g_1r, 0 );
    private Cards1Level _black_1w_2b_1g_1rCard = new Cards1Level(_black_1w_2b_1g_1rCost, Colors.BLACK, _black_1w_2b_1g_1r, 0 );
    private Cards1Level _black_2g_1rCard = new Cards1Level(_black_2g_1rCost, Colors.BLACK, _black_2g_1r, 0 );
    private Cards1Level _black_2w_2b_1rCard = new Cards1Level(_black_2w_2b_1rCost, Colors.BLACK, _black_2w_2b_1r, 0 );
    private Cards1Level _black_2w_2gCard = new Cards1Level(_black_2w_2gCost, Colors.BLACK, _black_2w_2g, 0 );
    private Cards1Level _black_3gCard = new Cards1Level(_black_3gCost, Colors.BLACK, _black_3g, 0 );
    private Cards1Level _blue__1b_3g_1rCard = new Cards1Level(_blue__1b_3g_1rCost, Colors.BLUE, _blue__1b_3g_1r, 0 );
    private Cards1Level _blue_1w_1g_1r_1bcCard = new Cards1Level(_blue_1w_1g_1r_1bcCost, Colors.BLUE, _blue_1w_1g_1r_1bc, 0 );
    private Cards1Level _blue_1w_1g_2r_1bcCard = new Cards1Level(_blue_1w_1g_2r_1bcCost, Colors.BLUE, _blue_1w_1g_2r_1bc, 0 );
    private Cards1Level _blue_1w_2bcCard = new Cards1Level(_blue_1w_2bcCost, Colors.BLUE, _blue_1w_2bc, 0 );
    private Cards1Level _blue_1w_2g_2rCard = new Cards1Level(_blue_1w_2g_2rCost, Colors.BLUE, _blue_1w_2g_2r, 0 );
    private Cards1Level _blue_2g_2bcCard = new Cards1Level(_blue_2g_2bcCost, Colors.BLUE, _blue_2g_2bc, 0 );
    private Cards1Level _blue_3bcCard = new Cards1Level(_blue_3bcCost, Colors.BLUE, _blue_3bc, 0 );
    private Cards1Level _green_1b_2r_2bcCard = new Cards1Level(_green_1b_2r_2bcCost, Colors.GREEN, _green_1b_2r_2bc, 0 );
    private Cards1Level _green_1w_1b_1r_1bcCard = new Cards1Level(_green_1w_1b_1r_1bcCost, Colors.GREEN, _green_1w_1b_1r_1bc, 0 );
    private Cards1Level _green_1w_1b_1r_2bcCard = new Cards1Level(_green_1w_1b_1r_2bcCost, Colors.GREEN, _green_1w_1b_1r_2bc, 0 );
    private Cards1Level _green_1w_3b_1gCard = new Cards1Level(_green_1w_3b_1gCost, Colors.GREEN, _green_1w_3b_1g, 0 );
    private Cards1Level _green_2b_2rCard = new Cards1Level(_green_2b_2rCost, Colors.GREEN, _green_2b_2r, 0 );
    private Cards1Level _green_2w_1bCard = new Cards1Level(_green_2w_1bCost, Colors.GREEN, _green_2w_1b, 0 );
    private Cards1Level _green_3rCard = new Cards1Level(_green_3rCost, Colors.GREEN, _green_3r, 0 );
    private Cards1Level _red_1w_1b_1g_1bcCard = new Cards1Level(_red_1w_1b_1g_1bcCost, Colors.RED, _red_1w_1b_1g_1bc, 0 );
    private Cards1Level _red_1w_1r_3bcCard = new Cards1Level(_red_1w_1r_3bcCost, Colors.RED, _red_1w_1r_3bc, 0 );
    private Cards1Level _red_2b_1gCard = new Cards1Level(_red_2b_1gCost, Colors.RED, _red_2b_1g, 0 );
    private Cards1Level _red_2w_1b_1g_1bcCard = new Cards1Level(_red_2w_1b_1g_1bcCost, Colors.RED, _red_2w_1b_1g_1bc, 0 );
    private Cards1Level _red_2w_1g_2bcCard = new Cards1Level(_red_2w_1g_2bcCost, Colors.RED, _red_2w_1g_2bc, 0 );
    private Cards1Level _red_2w_2rCard = new Cards1Level(_red_2w_2rCost, Colors.RED, _red_2w_2r, 0 );
    private Cards1Level _red_3wCard = new Cards1Level(_red_3wCost, Colors.RED, _red_3w, 0 );
    private Cards1Level _white_1b_1g_1r_1bcCard = new Cards1Level(_white_1b_1g_1r_1bcCost, Colors.WHITE, _white_1b_1g_1r_1bc, 0 );
    private Cards1Level _white_1b_2g_1r_1bcCard = new Cards1Level(_white_1b_2g_1r_1bcCost, Colors.WHITE, _white_1b_2g_1r_1bc, 0 );
    private Cards1Level _white_1r_1bcCard = new Cards1Level(_white_1r_1bcCost, Colors.WHITE, _white_1r_1bc, 0 );
    private Cards1Level _white_2b_2bcCard = new Cards1Level(_white_2b_2bcCost, Colors.WHITE, _white_2b_2bc, 0 );
    private Cards1Level _white_2b_2g_1wCard = new Cards1Level(_white_2b_2g_1wCost, Colors.WHITE, _white_2b_2g_1w, 0 );
    private Cards1Level _white_3bCard = new Cards1Level(_white_3bCost, Colors.WHITE, _white_3b, 0 );
    private Cards1Level _white_3w_1b_1bcCard = new Cards1Level(_white_3w_1b_1bcCost, Colors.WHITE, _white_3w_1b_1bc, 0 );


    public Cards1LevelRepository() {
        _1black_4bCost.put(Colors.BLUE, 4);
        _1black_4bCost.put(Colors.BLACK, 0);
        _1black_4bCost.put(Colors.RED, 0);
        _1black_4bCost.put(Colors.GREEN, 0);
        _1black_4bCost.put(Colors.WHITE, 0);

        _1blue__2rCost.put(Colors.BLUE, 0);
        _1blue__2rCost.put(Colors.BLACK, 0);
        _1blue__2rCost.put(Colors.RED, 4);
        _1blue__2rCost.put(Colors.GREEN, 0);
        _1blue__2rCost.put(Colors.WHITE, 0);

        _1green_4bcCost.put(Colors.BLUE, 0);
        _1green_4bcCost.put(Colors.BLACK, 4);
        _1green_4bcCost.put(Colors.RED, 0);
        _1green_4bcCost.put(Colors.GREEN, 0);
        _1green_4bcCost.put(Colors.WHITE, 0);

        _1red_4wCost.put(Colors.BLUE, 0);
        _1red_4wCost.put(Colors.BLACK, 0);
        _1red_4wCost.put(Colors.RED, 0);
        _1red_4wCost.put(Colors.GREEN, 0);
        _1red_4wCost.put(Colors.WHITE, 4);

        _1white_4gCost.put(Colors.BLUE, 0);
        _1white_4gCost.put(Colors.BLACK, 0);
        _1white_4gCost.put(Colors.RED, 0);
        _1white_4gCost.put(Colors.GREEN, 4);
        _1white_4gCost.put(Colors.WHITE, 0);

        _black_1g_3r_1bcCost.put(Colors.BLUE, 0);
        _black_1g_3r_1bcCost.put(Colors.BLACK, 1);
        _black_1g_3r_1bcCost.put(Colors.RED, 3);
        _black_1g_3r_1bcCost.put(Colors.GREEN, 1);
        _black_1g_3r_1bcCost.put(Colors.WHITE, 0);

        _black_1w_1b_1g_1rCost.put(Colors.BLUE, 1);
        _black_1w_1b_1g_1rCost.put(Colors.BLACK, 0);
        _black_1w_1b_1g_1rCost.put(Colors.RED, 1);
        _black_1w_1b_1g_1rCost.put(Colors.GREEN, 1);
        _black_1w_1b_1g_1rCost.put(Colors.WHITE, 1);

        _black_1w_2b_1g_1rCost.put(Colors.BLUE, 2);
        _black_1w_2b_1g_1rCost.put(Colors.BLACK, 0);
        _black_1w_2b_1g_1rCost.put(Colors.RED, 1);
        _black_1w_2b_1g_1rCost.put(Colors.GREEN, 1);
        _black_1w_2b_1g_1rCost.put(Colors.WHITE, 1);

        _black_2g_1rCost.put(Colors.BLUE, 0);
        _black_2g_1rCost.put(Colors.BLACK, 0);
        _black_2g_1rCost.put(Colors.RED, 1);
        _black_2g_1rCost.put(Colors.GREEN, 2);
        _black_2g_1rCost.put(Colors.WHITE, 0);

        _black_2w_2b_1rCost.put(Colors.BLUE, 2);
        _black_2w_2b_1rCost.put(Colors.BLACK, 0);
        _black_2w_2b_1rCost.put(Colors.RED, 1);
        _black_2w_2b_1rCost.put(Colors.GREEN, 0);
        _black_2w_2b_1rCost.put(Colors.WHITE, 2);

        _black_2w_2gCost.put(Colors.BLUE, 0);
        _black_2w_2gCost.put(Colors.BLACK, 0);
        _black_2w_2gCost.put(Colors.RED, 0);
        _black_2w_2gCost.put(Colors.GREEN, 2);
        _black_2w_2gCost.put(Colors.WHITE, 2);

        _blue_3bcCost.put(Colors.BLUE, 0);
        _blue_3bcCost.put(Colors.BLACK, 3);
        _blue_3bcCost.put(Colors.RED, 0);
        _blue_3bcCost.put(Colors.GREEN, 0);
        _blue_3bcCost.put(Colors.WHITE, 0);

        _blue__1b_3g_1rCost.put(Colors.BLUE, 1);
        _blue__1b_3g_1rCost.put(Colors.BLACK, 0);
        _blue__1b_3g_1rCost.put(Colors.RED, 1);
        _blue__1b_3g_1rCost.put(Colors.GREEN, 3);
        _blue__1b_3g_1rCost.put(Colors.WHITE, 0);

        _blue_1w_1g_1r_1bcCost.put(Colors.BLUE, 0);
        _blue_1w_1g_1r_1bcCost.put(Colors.BLACK, 1);
        _blue_1w_1g_1r_1bcCost.put(Colors.RED, 1);
        _blue_1w_1g_1r_1bcCost.put(Colors.GREEN, 1);
        _blue_1w_1g_1r_1bcCost.put(Colors.WHITE, 1);

        _blue_1w_1g_2r_1bcCost.put(Colors.BLUE, 0);
        _blue_1w_1g_2r_1bcCost.put(Colors.BLACK, 1);
        _blue_1w_1g_2r_1bcCost.put(Colors.RED, 2);
        _blue_1w_1g_2r_1bcCost.put(Colors.GREEN, 1);
        _blue_1w_1g_2r_1bcCost.put(Colors.WHITE, 1);

        _blue_1w_2bcCost.put(Colors.BLUE, 0);
        _blue_1w_2bcCost.put(Colors.BLACK, 2);
        _blue_1w_2bcCost.put(Colors.RED, 0);
        _blue_1w_2bcCost.put(Colors.GREEN, 0);
        _blue_1w_2bcCost.put(Colors.WHITE, 1);

        _blue_1w_2g_2rCost.put(Colors.BLUE, 0);
        _blue_1w_2g_2rCost.put(Colors.BLACK, 0);
        _blue_1w_2g_2rCost.put(Colors.RED, 2);
        _blue_1w_2g_2rCost.put(Colors.GREEN, 2);
        _blue_1w_2g_2rCost.put(Colors.WHITE, 1);

        _blue_2g_2bcCost.put(Colors.BLUE, 0);
        _blue_2g_2bcCost.put(Colors.BLACK, 2);
        _blue_2g_2bcCost.put(Colors.RED, 0);
        _blue_2g_2bcCost.put(Colors.GREEN, 2);
        _blue_2g_2bcCost.put(Colors.WHITE, 0);

        _green_1b_2r_2bcCost.put(Colors.BLUE, 1);
        _green_1b_2r_2bcCost.put(Colors.BLACK, 2);
        _green_1b_2r_2bcCost.put(Colors.RED, 2);
        _green_1b_2r_2bcCost.put(Colors.GREEN, 0);
        _green_1b_2r_2bcCost.put(Colors.WHITE, 0);

        _green_1w_1b_1r_1bcCost.put(Colors.BLUE, 1);
        _green_1w_1b_1r_1bcCost.put(Colors.BLACK, 1);
        _green_1w_1b_1r_1bcCost.put(Colors.RED, 1);
        _green_1w_1b_1r_1bcCost.put(Colors.GREEN, 0);
        _green_1w_1b_1r_1bcCost.put(Colors.WHITE, 1);

        _green_1w_1b_1r_2bcCost.put(Colors.BLUE, 1);
        _green_1w_1b_1r_2bcCost.put(Colors.BLACK, 2);
        _green_1w_1b_1r_2bcCost.put(Colors.RED, 1);
        _green_1w_1b_1r_2bcCost.put(Colors.GREEN, 0);
        _green_1w_1b_1r_2bcCost.put(Colors.WHITE, 1);

        _green_1w_3b_1gCost.put(Colors.BLUE, 3);
        _green_1w_3b_1gCost.put(Colors.BLACK, 0);
        _green_1w_3b_1gCost.put(Colors.RED, 0);
        _green_1w_3b_1gCost.put(Colors.GREEN, 1);
        _green_1w_3b_1gCost.put(Colors.WHITE, 1);

        _green_2b_2rCost.put(Colors.BLUE, 2);
        _green_2b_2rCost.put(Colors.BLACK, 0);
        _green_2b_2rCost.put(Colors.RED, 2);
        _green_2b_2rCost.put(Colors.GREEN, 0);
        _green_2b_2rCost.put(Colors.WHITE, 0);

        _green_2w_1bCost.put(Colors.BLUE, 1);
        _green_2w_1bCost.put(Colors.BLACK, 0);
        _green_2w_1bCost.put(Colors.RED, 0);
        _green_2w_1bCost.put(Colors.GREEN, 0);
        _green_2w_1bCost.put(Colors.WHITE, 2);

        _green_3rCost.put(Colors.BLUE, 0);
        _green_3rCost.put(Colors.BLACK, 0);
        _green_3rCost.put(Colors.RED, 3);
        _green_3rCost.put(Colors.GREEN, 0);
        _green_3rCost.put(Colors.WHITE, 0);

        _red_1w_1b_1g_1bcCost.put(Colors.BLUE, 1);
        _red_1w_1b_1g_1bcCost.put(Colors.BLACK, 1);
        _red_1w_1b_1g_1bcCost.put(Colors.RED, 0);
        _red_1w_1b_1g_1bcCost.put(Colors.GREEN, 1);
        _red_1w_1b_1g_1bcCost.put(Colors.WHITE, 1);

        _red_1w_1r_3bcCost.put(Colors.BLUE, 0);
        _red_1w_1r_3bcCost.put(Colors.BLACK, 3);
        _red_1w_1r_3bcCost.put(Colors.RED, 1);
        _red_1w_1r_3bcCost.put(Colors.GREEN, 0);
        _red_1w_1r_3bcCost.put(Colors.WHITE, 1);

        _red_2b_1gCost.put(Colors.BLUE, 2);
        _red_2b_1gCost.put(Colors.BLACK, 0);
        _red_2b_1gCost.put(Colors.RED, 0);
        _red_2b_1gCost.put(Colors.GREEN, 1);
        _red_2b_1gCost.put(Colors.WHITE, 0);

        _red_2w_1b_1g_1bcCost.put(Colors.BLUE, 1);
        _red_2w_1b_1g_1bcCost.put(Colors.BLACK, 1);
        _red_2w_1b_1g_1bcCost.put(Colors.RED, 0);
        _red_2w_1b_1g_1bcCost.put(Colors.GREEN, 1);
        _red_2w_1b_1g_1bcCost.put(Colors.WHITE, 2);

        _red_2w_1g_2bcCost.put(Colors.BLUE, 0);
        _red_2w_1g_2bcCost.put(Colors.BLACK, 2);
        _red_2w_1g_2bcCost.put(Colors.RED, 0);
        _red_2w_1g_2bcCost.put(Colors.GREEN, 1);
        _red_2w_1g_2bcCost.put(Colors.WHITE, 2);

        _red_2w_2rCost.put(Colors.BLUE, 0);
        _red_2w_2rCost.put(Colors.BLACK, 0);
        _red_2w_2rCost.put(Colors.RED, 2);
        _red_2w_2rCost.put(Colors.GREEN, 0);
        _red_2w_2rCost.put(Colors.WHITE, 2);

        _red_3wCost.put(Colors.BLUE, 0);
        _red_3wCost.put(Colors.BLACK, 0);
        _red_3wCost.put(Colors.RED, 0);
        _red_3wCost.put(Colors.GREEN, 0);
        _red_3wCost.put(Colors.WHITE, 3);

        _white_1b_1g_1r_1bcCost.put(Colors.BLUE, 1);
        _white_1b_1g_1r_1bcCost.put(Colors.BLACK, 1);
        _white_1b_1g_1r_1bcCost.put(Colors.RED, 1);
        _white_1b_1g_1r_1bcCost.put(Colors.GREEN, 1);
        _white_1b_1g_1r_1bcCost.put(Colors.WHITE, 0);

        _white_1b_2g_1r_1bcCost.put(Colors.BLUE, 1);
        _white_1b_2g_1r_1bcCost.put(Colors.BLACK, 1);
        _white_1b_2g_1r_1bcCost.put(Colors.RED, 1);
        _white_1b_2g_1r_1bcCost.put(Colors.GREEN, 2);
        _white_1b_2g_1r_1bcCost.put(Colors.WHITE, 0);

        _white_1r_1bcCost.put(Colors.BLUE, 0);
        _white_1r_1bcCost.put(Colors.BLACK, 1);
        _white_1r_1bcCost.put(Colors.RED, 2);
        _white_1r_1bcCost.put(Colors.GREEN, 0);
        _white_1r_1bcCost.put(Colors.WHITE, 0);

        _white_2b_2bcCost.put(Colors.BLUE, 2);
        _white_2b_2bcCost.put(Colors.BLACK, 2);
        _white_2b_2bcCost.put(Colors.RED, 0);
        _white_2b_2bcCost.put(Colors.GREEN, 0);
        _white_2b_2bcCost.put(Colors.WHITE, 0);

        _white_2b_2g_1wCost.put(Colors.BLUE, 2);
        _white_2b_2g_1wCost.put(Colors.BLACK, 1);
        _white_2b_2g_1wCost.put(Colors.RED, 0);
        _white_2b_2g_1wCost.put(Colors.GREEN, 2);
        _white_2b_2g_1wCost.put(Colors.WHITE, 0);

        _white_3bCost.put(Colors.BLUE, 3);
        _white_3bCost.put(Colors.BLACK, 0);
        _white_3bCost.put(Colors.RED, 0);
        _white_3bCost.put(Colors.GREEN, 0);
        _white_3bCost.put(Colors.WHITE, 0);

        _white_3w_1b_1bcCost.put(Colors.BLUE, 1);
        _white_3w_1b_1bcCost.put(Colors.BLACK, 1);
        _white_3w_1b_1bcCost.put(Colors.RED, 0);
        _white_3w_1b_1bcCost.put(Colors.GREEN, 0);
        _white_3w_1b_1bcCost.put(Colors.WHITE, 3);


        cardsList.add(_1black_4bCard);
        cardsList.add(_1blue__2rCard);
        cardsList.add(_1green_4bcCard);
        cardsList.add(_1red_4wCard);
        cardsList.add(_1white_4gCard);
        cardsList.add(_black_1g_3r_1bcCard);
        cardsList.add(_black_1w_1b_1g_1rCard);
        cardsList.add(_black_1w_2b_1g_1rCard);
        cardsList.add(_black_2g_1rCard);
        cardsList.add(_black_2w_2b_1rCard);
        cardsList.add(_black_2w_2gCard);
        cardsList.add(_black_3gCard);
        cardsList.add(_blue__1b_3g_1rCard);
        cardsList.add(_blue_1w_1g_1r_1bcCard);
        cardsList.add(_blue_1w_1g_2r_1bcCard);
        cardsList.add(_blue_1w_2bcCard);
        cardsList.add(_blue_1w_2g_2rCard);
        cardsList.add(_blue_2g_2bcCard);
        cardsList.add(_blue_3bcCard);
        cardsList.add(_green_1b_2r_2bcCard);
        cardsList.add(_green_1w_1b_1r_1bcCard);
        cardsList.add(_green_1w_1b_1r_2bcCard);
        cardsList.add(_green_1w_3b_1gCard);
        cardsList.add(_green_2b_2rCard);
        cardsList.add(_green_2w_1bCard);
        cardsList.add(_green_3rCard);
        cardsList.add(_red_1w_1b_1g_1bcCard);
        cardsList.add(_red_1w_1r_3bcCard);
        cardsList.add(_red_2b_1gCard);
        cardsList.add(_red_2w_1b_1g_1bcCard);
        cardsList.add(_red_2w_1g_2bcCard);
        cardsList.add(_red_2w_2rCard);
        cardsList.add(_red_3wCard);
        cardsList.add(_white_1b_1g_1r_1bcCard);
        cardsList.add(_white_1b_2g_1r_1bcCard);
        cardsList.add(_white_1r_1bcCard);
        cardsList.add(_white_2b_2bcCard);
        cardsList.add(_white_2b_2g_1wCard);
        cardsList.add(_white_3bCard);
        cardsList.add(_white_3w_1b_1bcCard);

    }

    public List<Cards1Level> getFourCards() {
        return fourCards;
    }

    public void drawFourCards() {
        Cards1Level card1 = drawCard();
        Cards1Level card2 = drawCard();
        Cards1Level card3 = drawCard();
        Cards1Level card4 = drawCard();

        fourCards.add(card1);
        fourCards.add(card2);
        fourCards.add(card3);
        fourCards.add(card4);
    }


    public Cards1Level drawCard() {
        Cards1Level randomCard = new Cards1Level();
        if (cardsList.size() > 0) {
            randomCard = cardsList.get(random.nextInt(cardsList.size()));
            cardsList.remove(randomCard);
        }
        return randomCard;
    }


    public boolean takeCard(Player player, Cards1Level card) {

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
