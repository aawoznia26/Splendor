package com.kodilla.splendor;

import com.kodilla.splendor.Repository.*;
import com.kodilla.splendor.Services.AristocratsService;
import com.kodilla.splendor.Services.CardsService;
import com.kodilla.splendor.Services.JewelService;
import com.kodilla.splendor.Services.PlayerService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SplendorApplication extends Application {

    private Image imageback = new Image("1985-52-15143-pdp.jpg");

    //Players
    private PlayerService playerService = new PlayerService();
    private Player player = playerService.getPlayingPlayer();

    private HBox player1NameAndPointsHB = playerService.getPlayer1NameAndPointsHB();
    private HBox player2NameAndPointsHB = playerService.getPlayer2NameAndPointsHB();

    //Move
    private HBox player1CommitHB = new HBox();
    private HBox player2CommitHB = new HBox();
    private Button player1CommitButton = new Button();
    private Button player2CommitButton = new Button();

    //Jewel
    private JewelRepository jewelRepository = new JewelRepository();
    private JewelService jewelService = new JewelService(jewelRepository, playerService, player);

    private HBox jewels = jewelService.getJewels();
    private HBox player1Jewels = jewelService.getPlayer1Jewels();
    private HBox player2Jewels = jewelService.getPlayer2Jewels();
    private HBox player1JewelsTextHB = jewelService.getPlayer1JewelsTextHB();
    private HBox player2JewelsTextHB = jewelService.getPlayer2JewelsTextHB();

    //Aristocrats
    private AristocratsRepository aristocratsRepository = new AristocratsRepository();
    private AristocratsService aristocratsService = new AristocratsService(aristocratsRepository, playerService, player);
    private HBox aristocrats = aristocratsService.getAristocrats();
    private HBox player1Aristocrats = aristocratsService.getPlayer1Aristocrats();
    private HBox player2Aristocrats = aristocratsService.getPlayer2Aristocrats();

    //Cards
    private Cards1LevelRepository cards1LevelRepository = new Cards1LevelRepository();
    private Cards2LevelRepository cards2LevelRepository = new Cards2LevelRepository();
    private Cards3LevelRepository cards3LevelRepository = new Cards3LevelRepository();

    private CardsService cardsService = new CardsService(cards1LevelRepository, cards2LevelRepository,
            cards3LevelRepository, playerService, jewelRepository, player, jewelService);

    private HBox cards1 = cardsService.getCards1();
    private HBox cards2 = cardsService.getCards2();
    private HBox cards3 = cardsService.getCards3();
    private HBox player1Cards = cardsService.getPlayer1Cards();
    private HBox player2Cards = cardsService.getPlayer2Cards();
    private HBox player1CardsTextHB = cardsService.getPlayer1CardsTextHB();
    private HBox player2CardsTextHB = cardsService.getPlayer2CardsTextHB();

    //the Rest
    private GridPane grid = new GridPane();
    private GridPane player1CardsGridPane = new GridPane();
    private GridPane player2CardsGridPane = new GridPane();
    private DropShadow shadow = new DropShadow();
    private InfoPopUp infoPopUp = new InfoPopUp();
    private GridPane gridPane1 = new GridPane();
    private GridPane gridPane2 = new GridPane();
    private GridPane gridPane3 = new GridPane();


    public boolean finishGame() {
        Player player1 = playerService.getPlayers().get(0);
        Player player2 = playerService.getPlayers().get(1);
        if ((player1.getResult() >= 15 || player2.getResult() >= 15) && (player1.getMovesCounter() == player2.getMovesCounter())) {
            Player winner = null;
            if(player1.getResult() == player2.getResult()){
                int player1CardNumber = player1.getCardCounter().entrySet().stream()
                        .map(c -> c.getValue())
                        .mapToInt(Integer::intValue)
                        .sum();
                int player2CardNumber = player2.getCardCounter().entrySet().stream()
                        .map(c -> c.getValue())
                        .mapToInt(Integer::intValue)
                        .sum();
                if(player1CardNumber > player2CardNumber) {
                    winner = player1;
                } else {
                    winner = player2;
                }
            } else if(player2.getResult() > player1.getResult()) {
                winner = player2;
            } else {
                winner = player1;
            }
            infoPopUp.display("INFO", "Game finished. The winner is " + winner.getName());
            return true;
        }
        return false;
    }

    public boolean commitMove() {
        boolean ifCommited = false;
        Move move = new Move(player);
        if (move.commitMove()) {
            player.setMovesCounter(player.getMovesCounter() + 1);
            player = playerService.switchPlayer(player);
            ifCommited = true;

            jewelService.loadJewels(player);

            aristocrats.getChildren().clear();
            aristocratsService.loadAristocrats(player);
            aristocrats = aristocratsService.getAristocrats();
            player1Aristocrats = aristocratsService.getPlayer1Aristocrats();
            player2Aristocrats = aristocratsService.getPlayer2Aristocrats();

            cards1.getChildren().clear();
            cards2.getChildren().clear();
            cards3.getChildren().clear();
            cardsService.loadCards(player);
            cards1 = cardsService.getCards1();
            cards2 = cardsService.getCards2();
            cards3 = cardsService.getCards3();

            player1NameAndPointsHB = playerService.getPlayer1NameAndPointsHB();
            player2NameAndPointsHB = playerService.getPlayer2NameAndPointsHB();

        }
        return ifCommited;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        playerService.createPlayers();
        player = playerService.getPlayingPlayer();

        //Background
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        //GridPanesAdding
        grid.add(gridPane1, 0, 0, 1, 1);
        grid.add(gridPane2, 1, 0, 1, 1);
        grid.add(gridPane3, 2, 0, 1, 1);

        gridPane1.add(player1NameAndPointsHB, 0, 0, 1, 1);
        gridPane1.add(player1Jewels, 0, 6, 1, 1);
        gridPane1.add(player1Aristocrats, 0, 1, 1, 1);
        gridPane1.add(player1CardsGridPane, 0, 3, 1, 1);
        gridPane1.add(player1Cards, 0, 4, 1, 1);
        gridPane1.add(player1CardsTextHB, 0, 2, 1, 1);
        gridPane1.add(player1JewelsTextHB, 0, 5, 1, 1);
        gridPane1.add(player1CommitHB, 0, 7, 1, 1);
        gridPane1.setEffect(shadow);

        gridPane2.add(aristocrats, 0, 0, 1, 1);
        gridPane2.add(cards1, 0, 3, 1, 1);
        gridPane2.add(cards2, 0, 2, 1, 1);
        gridPane2.add(cards3, 0, 1, 1, 1);
        gridPane2.add(jewels, 0, 4, 1, 1);

        gridPane3.add(player2NameAndPointsHB, 0, 0, 1, 1);
        gridPane3.add(player2Jewels, 0, 6, 1, 1);
        gridPane3.add(player2Aristocrats, 0, 1, 1, 1);
        gridPane3.add(player2CardsGridPane, 0, 3, 1, 1);
        gridPane3.add(player2Cards, 0, 4, 1, 1);
        gridPane3.add(player2CardsTextHB, 0, 2, 1, 1);
        gridPane3.add(player2JewelsTextHB, 0, 5, 1, 1);
        gridPane3.add(player2CommitHB, 0, 7, 1, 1);

        //GridPanesSettings
        grid.setBackground(background);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(8, 12, 8, 12));
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setBackground(background);
        gridPane1.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10; -fx-border-color: #D4AF37; -fx-border-radius: 10;");
        gridPane3.setStyle("-fx-background-color: rgba(139, 0, 0, 0.5); -fx-background-radius: 10;");

        //Move
        player1CommitHB.setAlignment(Pos.BOTTOM_RIGHT);
        player1CommitHB.setPrefHeight(150);
        player1CommitHB.setPadding(new Insets(30, 30, 30, 30));
        player2CommitHB.setAlignment(Pos.BOTTOM_RIGHT);
        player2CommitHB.setPrefHeight(150);
        player2CommitHB.setPadding(new Insets(30, 30, 30, 30));
        final String COMMIT_BUTTON_STYLE = "-fx-background-color: black; -fx-text-fill: #D4AF37;-fx-font-size: 20";

        //Cards
        player1CardsGridPane.setAlignment(Pos.CENTER);
        player2CardsGridPane.setAlignment(Pos.CENTER);

        //Scene
        Scene scene = new Scene(grid, 1200, 600, Color.BLUEVIOLET);

        primaryStage.setTitle("Splendor");
        primaryStage.setScene(scene);
        primaryStage.show();

        //MoveCommitButtons
        player1CommitButton.setStyle(COMMIT_BUTTON_STYLE);
        player1CommitButton.setOnMouseEntered(e -> player1CommitButton.setEffect(shadow));
        player1CommitButton.setOnMouseExited(e -> player1CommitButton.setEffect(null));
        player1CommitButton.setText("Commit move");
        player1CommitButton.setOnAction((e) -> {
            if(commitMove()){
                gridPane1.setEffect(null);
                gridPane1.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10;");
                gridPane3.setEffect(shadow);
                gridPane3.setStyle("-fx-background-color: rgba(139, 0, 0, 0.5); -fx-background-radius: 10; -fx-border-color: #D4AF37; -fx-border-radius: 10;");
            };
            if(finishGame()){
                primaryStage.close();
            };
        });

        player2CommitButton.setStyle(COMMIT_BUTTON_STYLE);
        player2CommitButton.setOnMouseEntered(e -> player2CommitButton.setEffect(shadow));
        player2CommitButton.setOnMouseExited(e -> player2CommitButton.setEffect(null));
        player2CommitButton.setText("Commit move");
        player2CommitButton.setOnAction((e) -> {
            if(commitMove()){
                gridPane3.setEffect(null);
                gridPane3.setStyle("-fx-background-color: rgba(139, 0, 0, 0.5); -fx-background-radius: 10;");
                gridPane1.setEffect(shadow);
                gridPane1.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10; -fx-border-color: #D4AF37; -fx-border-radius: 10;");
            } ;
            if(finishGame()){
                primaryStage.close();
            };
        });

        player1CommitHB.getChildren().add(player1CommitButton);
        player2CommitHB.getChildren().add(player2CommitButton);

        aristocratsService.initialAristocratsLoad(player);
        jewelService.loadJewels(player);
        cardsService.initialCardsLoad(player);
        jewelService.loadPlayersJewelCounters();
        playerService.loadPlayersAtributes();

    }

    public static void main(String[] args) {

        launch(args);

    }
}