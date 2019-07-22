package com.kodilla.splendor.Services;

import com.kodilla.splendor.Cards1Level;
import com.kodilla.splendor.Cards2Level;
import com.kodilla.splendor.Cards3Level;
import com.kodilla.splendor.Player;
import com.kodilla.splendor.Repository.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardsService {

    private Cards1LevelRepository cards1LevelRepository;
    private Cards2LevelRepository cards2LevelRepository;
    private Cards3LevelRepository cards3LevelRepository;
    private PlayerService playerService;
    private JewelRepository jewelRepository;
    private Player player;
    private JewelService jewelService;

    private HBox cards1 = new HBox();
    private HBox cards2 = new HBox();
    private HBox cards3 = new HBox();
    private HBox player1Cards = new HBox();
    private HBox player2Cards = new HBox();
    private HBox player1CardsTextHB = new HBox();
    private HBox player2CardsTextHB = new HBox();
    private List<HBox> playersCardsHBList = new ArrayList<>(Arrays.asList(player1CardsTextHB, player2CardsTextHB));

    public CardsService(Cards1LevelRepository cards1LevelRepository, Cards2LevelRepository cards2LevelRepository, Cards3LevelRepository cards3LevelRepository
            , PlayerService playerService, JewelRepository jewelRepository, Player player, JewelService jewelService) {
        this.cards1LevelRepository = cards1LevelRepository;
        this.cards2LevelRepository = cards2LevelRepository;
        this.cards3LevelRepository = cards3LevelRepository;
        this.cards3LevelRepository = cards3LevelRepository;
        this.playerService = playerService;
        this.jewelRepository = jewelRepository;
        this.player = player;
        this.jewelService = jewelService;
    }

    final String BUTTON_STYLE = "-fx-background-color: transparent;";
    final String HOVERED_BUTTON_STYLE = "-fx-background-color: rgba(212,175,55,0.5);";

    public Cards1LevelRepository getCards1LevelRepository() {
        return cards1LevelRepository;
    }

    public HBox getCards1() {
        return cards1;
    }

    public HBox getCards2() {
        return cards2;
    }

    public HBox getCards3() {
        return cards3;
    }

    public HBox getPlayer1Cards() {
        return player1Cards;
    }

    public HBox getPlayer2Cards() {
        return player2Cards;
    }

    public HBox getPlayer1CardsTextHB() {
        return player1CardsTextHB;
    }

    public HBox getPlayer2CardsTextHB() {
        return player2CardsTextHB;
    }

    public void initialCardsLoad(Player player) {
        cards1LevelRepository.drawFourCards();
        cards2LevelRepository.drawFourCards();
        cards3LevelRepository.drawFourCards();
        loadCards(player);
        loadPlayersCardsCounters();
        playersCardsHBList.stream()
                .forEach(h -> {
                    Text playerCardsText = new Text("Cards with jewel");
                    h.getChildren().add(playerCardsText);
                    playerCardsText.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
                    playerCardsText.setFill(Color.valueOf("#D4AF37"));
                    h.setAlignment(Pos.CENTER);
                });
    }

    public void loadCards(Player player) {

        for (int i = 0; i < cards1LevelRepository.getFourCards().size(); i++) {
            Cards1Level cards1Level = cards1LevelRepository.getFourCards().get(i);
            Button card1LevelButton = new Button();
            ImageView card1LevelImgView = cards1Level.getView();
            card1LevelButton.setGraphic(card1LevelImgView);

            try {
                card1LevelImgView.setFitHeight(200);
                card1LevelImgView.setPreserveRatio(true);

                card1LevelButton.setStyle(BUTTON_STYLE);
                card1LevelButton.setOnMouseEntered(e -> card1LevelButton.setStyle(HOVERED_BUTTON_STYLE));
                card1LevelButton.setOnMouseExited(e -> card1LevelButton.setStyle(BUTTON_STYLE));
                card1LevelButton.setOnAction((e) -> {
                    if (cards1LevelRepository.takeCard(player, cards1Level)) {
                        cards1.getChildren().clear();
                        cards2.getChildren().clear();
                        cards3.getChildren().clear();
                        playerService.loadPlayersAtributes();
                        loadCards(player);
                        loadPlayersCardsCounters();
                        jewelService.loadPlayersJewelCounters();
                    }
                });
                cards1.getChildren().add(card1LevelButton);

            } catch (NullPointerException e) {
                System.out.println("No more cards to take");
            }
        }

        for (int i = 0; i < cards2LevelRepository.getFourCards().size(); i++) {
            Cards2Level cards2Level = cards2LevelRepository.getFourCards().get(i);
            Button card2LevelButton = new Button();
            ImageView cardLeve2ImgView = cards2Level.getView();
            card2LevelButton.setGraphic(cardLeve2ImgView);

            try {
                cardLeve2ImgView.setFitHeight(200);
                cardLeve2ImgView.setPreserveRatio(true);

                card2LevelButton.setStyle(BUTTON_STYLE);
                card2LevelButton.setOnMouseEntered(e -> card2LevelButton.setStyle(HOVERED_BUTTON_STYLE));
                card2LevelButton.setOnMouseExited(e -> card2LevelButton.setStyle(BUTTON_STYLE));
                card2LevelButton.setOnAction((e) -> {
                    if (cards2LevelRepository.takeCard(player, cards2Level)) {
                        cards1.getChildren().clear();
                        cards2.getChildren().clear();
                        cards3.getChildren().clear();
                        playerService.loadPlayersAtributes();
                        loadCards(player);
                        loadPlayersCardsCounters();
                        jewelService.loadPlayersJewelCounters();
                    }
                });
                cards2.getChildren().add(card2LevelButton);

            } catch (NullPointerException e) {
                System.out.println("No more cards to take");
            }
        }

        for (int i = 0; i < cards3LevelRepository.getFourCards().size(); i++) {
            Cards3Level cards3Level = cards3LevelRepository.getFourCards().get(i);
            Button card3LevelButton = new Button();
            ImageView cardLeve3ImgView = cards3Level.getView();
            card3LevelButton.setGraphic(cardLeve3ImgView);

            try {
                cardLeve3ImgView.setFitHeight(200);
                cardLeve3ImgView.setPreserveRatio(true);

                card3LevelButton.setStyle(BUTTON_STYLE);
                card3LevelButton.setOnMouseEntered(e -> card3LevelButton.setStyle(HOVERED_BUTTON_STYLE));
                card3LevelButton.setOnMouseExited(e -> card3LevelButton.setStyle(BUTTON_STYLE));
                card3LevelButton.setOnAction((e) -> {
                    if (cards3LevelRepository.takeCard(player, cards3Level)) {
                        cards1.getChildren().clear();
                        cards2.getChildren().clear();
                        cards3.getChildren().clear();
                        playerService.loadPlayersAtributes();
                        loadCards(player);
                        loadPlayersCardsCounters();
                        jewelService.loadPlayersJewelCounters();
                    }
                });
                cards3.getChildren().add(card3LevelButton);

            } catch (NullPointerException e) {
                System.out.println("No more cards to take");
            }
        }

        cards1.setAlignment(Pos.TOP_CENTER);
        cards2.setAlignment(Pos.TOP_CENTER);
        cards3.setAlignment(Pos.TOP_CENTER);
    }

    public void loadPlayersCardsCounters() {

        player1Cards.getChildren().clear();
        player2Cards.getChildren().clear();

        jewelRepository.getJewelList().stream()
                .forEach(a -> {
                    ImageView player1CardView = new ImageView();
                    player1CardView.setImage(a.getView().getImage());
                    Text player1CardCounter = new Text();
                    player1CardCounter.setText(String.valueOf(playerService.getPlayers().get(0)
                            .getCardCounter().get(a.getColor())));
                    player1CardCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
                    player1CardCounter.setFill(Color.web("#D4AF37"));
                    FlowPane playe1CardFP = new FlowPane();
                    playe1CardFP.setMaxSize(30, 10);
                    playe1CardFP.getChildren().addAll(player1CardView, player1CardCounter);
                    player1Cards.getChildren().add(playe1CardFP);

                    ImageView player2CardView = new ImageView();
                    player2CardView.setImage(a.getView().getImage());
                    Text player2CardCounter = new Text();
                    player2CardCounter.setText(String.valueOf(playerService.getPlayers().get(1)
                            .getCardCounter().get(a.getColor())));
                    player2CardCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
                    player2CardCounter.setFill(Color.web("#D4AF37"));
                    FlowPane playe2CardFP = new FlowPane();
                    playe2CardFP.setMaxSize(30, 10);
                    playe2CardFP.getChildren().addAll(player2CardView, player2CardCounter);
                    player2Cards.getChildren().add(playe2CardFP);
                });

        player1Cards.setAlignment(Pos.TOP_CENTER);
        player1Cards.setPrefHeight(150);
        player2Cards.setAlignment(Pos.TOP_CENTER);
        player2Cards.setPrefHeight(150);
    }
}
