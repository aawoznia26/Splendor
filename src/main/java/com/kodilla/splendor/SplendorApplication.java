package com.kodilla.splendor;


import com.kodilla.splendor.Repository.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;


public class SplendorApplication extends Application {

    private Image imageback = new Image("1985-52-15143-pdp.jpg");

    //Players
    private PlayerCreator playerCreator = new PlayerCreator();
    private List<Player> players = new ArrayList<>();
    private Player player;
    private Player player1;
    private Player player2;
    private Player player1Saved;
    private Player player2Saved;

    private HBox player1NameAndPointsHB = new HBox();
    private HBox player2NameAndPointsHB = new HBox();

    //Move
    private int diamondTaken = 0;
    private int sapphireTaken = 0;
    private int onyxTaken = 0;
    private int emeraldTaken = 0;
    private int rubyTaken = 0;
    private int cardTaken = 0;
    private int aristocratsTaken = 0;

    private Button player1CommitButton = new Button();
    private Button player2CommitButton = new Button();
    private HBox player1CommitHB = new HBox();
    private HBox player2CommitHB = new HBox();

    //Jewel
    private JewelRepository jewelRepository = new JewelRepository();
    private JewelRepository savedJewelRepository;

    private HBox jewels = new HBox();
    private HBox player1Jewels = new HBox();
    private HBox player2Jewels = new HBox();

    //Aristocrats
    private AristocratsRepository aristocratsRepository = new AristocratsRepository();
    private AristocratsRepository savedAristocratsRepository;
    private HBox aristocrats = new HBox();
    private HBox player1Aristocrats = new HBox();
    private HBox player2Aristocrats = new HBox();
    private HBox player1JewelsTextHB = new HBox();
    private HBox player2JewelsTextHB = new HBox();

    private Aristocrats aristocrat1 = new Aristocrats();
    private Aristocrats aristocrat2 = new Aristocrats();
    private Aristocrats aristocrat3 = new Aristocrats();

    private Button aristocrat1Button = new Button();
    private Button aristocrat2Button = new Button();
    private Button aristocrat3Button = new Button();

    //Cards
    private Cards1LevelRepository cards1LevelRepository = new Cards1LevelRepository();
    private Cards2LevelRepository cards2LevelRepository = new Cards2LevelRepository();
    private Cards3LevelRepository cards3LevelRepository = new Cards3LevelRepository();

    private Cards1LevelRepository savedCards1LevelRepository;
    private Cards2LevelRepository savedCards2LevelRepository;
    private Cards3LevelRepository savedCards3LevelRepository;

    private HBox cards1 = new HBox();
    private HBox cards2 = new HBox();
    private HBox cards3 = new HBox();
    private HBox player1JewelsCards = new HBox();
    private HBox player2JewelsCards = new HBox();
    private HBox player1CardsTextHB = new HBox();
    private HBox player2CardsTextHB = new HBox();

    private Cards1Level cards1Level1 = new Cards1Level();
    private Cards1Level cards1Level2 = new Cards1Level();
    private Cards1Level cards1Level3 = new Cards1Level();
    private Cards1Level cards1Level4 = new Cards1Level();

    private Cards2Level cards2Level1 = new Cards2Level();
    private Cards2Level cards2Level2 = new Cards2Level();
    private Cards2Level cards2Level3 = new Cards2Level();
    private Cards2Level cards2Level4 = new Cards2Level();

    private Cards3Level cards3Level1 = new Cards3Level();
    private Cards3Level cards3Level2 = new Cards3Level();
    private Cards3Level cards3Level3 = new Cards3Level();
    private Cards3Level cards3Level4 = new Cards3Level();

    private Button card1Level1Button = new Button();
    private Button card1Level2Button = new Button();
    private Button card1Level3Button = new Button();
    private Button card1Level4Button = new Button();

    private Button card2Level1Button = new Button();
    private Button card2Level2Button = new Button();
    private Button card2Level3Button = new Button();
    private Button card2Level4Button = new Button();

    private Button card3Level1Button = new Button();
    private Button card3Level2Button = new Button();
    private Button card3Level3Button = new Button();
    private Button card3Level4Button = new Button();


    //Rest
    DropShadow shadow = new DropShadow();
    InfoPopUp infoPopUp = new InfoPopUp();


    public boolean finishGame() {
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



    public void saveCurrentStatus() {

        player1Saved = players.get(0);
        player2Saved = players.get(1);
        savedAristocratsRepository = aristocratsRepository;
        savedCards1LevelRepository = cards1LevelRepository;
        savedCards2LevelRepository = cards2LevelRepository;
        savedCards3LevelRepository = cards3LevelRepository;
        savedJewelRepository = jewelRepository;

    }

    public void rollBackMove() {
        players.clear();
        players.add(0, player1Saved);
        players.add(1, player2Saved);
        player1 = players.get(0);
        player2 = players.get(0);

        aristocratsRepository = savedAristocratsRepository;
        cards1LevelRepository = savedCards1LevelRepository;
        cards2LevelRepository = savedCards2LevelRepository;
        cards3LevelRepository = savedCards3LevelRepository;
        jewelRepository = savedJewelRepository;
        loadPlayersCardsCounters();
        loadPlayersAristocrats();
        loadPlayersJewelCounters();
    }


    public boolean commitMove() {
        boolean ifCommited = false;
        Move move = new Move(player, diamondTaken, sapphireTaken, onyxTaken, emeraldTaken, rubyTaken, cardTaken, aristocratsTaken);
        if (move.commitMove()) {
            player.setMovesCounter(player.getMovesCounter() + 1);
            if (player == player1) {
                player = player2;
            } else {
                player = player1;
            }
            saveCurrentStatus();
            ifCommited = true;

        } else {
            rollBackMove();
            player1 = playerCreator.getPlayers().get(0);
            player2 = playerCreator.getPlayers().get(1);
        }
        diamondTaken = 0;
        sapphireTaken = 0;
        onyxTaken = 0;
        emeraldTaken = 0;
        rubyTaken = 0;
        cardTaken = 0;
        aristocratsTaken = 0;
        return ifCommited;
    }


    public void draw1LevelCards() {
        cards1LevelRepository.drawFourCards();
    }

    public void draw2LevelCards() {
        cards2LevelRepository.drawFourCards();
    }

    public void draw3LevelCards() {
        cards3LevelRepository.drawFourCards();
    }


    public void loadPlayersCardsCounters() {
        player1JewelsCards.getChildren().clear();
        player2JewelsCards.getChildren().clear();

        jewelRepository.getJewelList().stream()
                .forEach(a -> {
                    ImageView player1CardView = new ImageView();
                    player1CardView.setImage(a.getView().getImage());
                    Text player1CardCounter = new Text();
                    player1CardCounter.setText(String.valueOf(player1.getCardCounter().get(a.getColor())));
                    player1CardCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
                    player1CardCounter.setFill(Color.web("#D4AF37"));
                    FlowPane playe1CardFP = new FlowPane();
                    playe1CardFP.setMaxSize(30, 10);
                    playe1CardFP.getChildren().addAll(player1CardView, player1CardCounter);
                    player1JewelsCards.getChildren().add(playe1CardFP);

                    ImageView player2CardView = new ImageView();
                    player2CardView.setImage(a.getView().getImage());
                    Text player2CardCounter = new Text();
                    player2CardCounter.setText(String.valueOf(player2.getCardCounter().get(a.getColor())));
                    player2CardCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
                    player2CardCounter.setFill(Color.web("#D4AF37"));
                    FlowPane playe2CardFP = new FlowPane();
                    playe2CardFP.setMaxSize(30, 10);
                    playe2CardFP.getChildren().addAll(player2CardView, player2CardCounter);
                    player2JewelsCards.getChildren().add(playe2CardFP);
                });

    }

    public void loadPlayersJewelCounters() {
        player1Jewels.getChildren().clear();
        player2Jewels.getChildren().clear();

        jewelRepository.getJewelList().stream()
                .forEach(a -> {
                    ImageView player1JewelView = new ImageView();
                    player1JewelView.setImage(a.getView().getImage());
                    Label player1JewelCounter = new Label(String.valueOf(player1.getJewelCounter().get(a.getColor())), player1JewelView);
                    player1JewelCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
                    player1JewelCounter.setTextFill(Color.web("#D4AF37"));
                    player1Jewels.getChildren().add(player1JewelCounter);

                    ImageView player2JewelView = new ImageView();
                    player2JewelView.setImage(a.getView().getImage());
                    Label player2JewelCounter = new Label(String.valueOf(player2.getJewelCounter().get(a.getColor())), player2JewelView);
                    player2JewelCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
                    player2JewelCounter.setTextFill(Color.web("#D4AF37"));
                    player2Jewels.getChildren().add(player2JewelCounter);
                });
    }


    public void load1LevelCards() {

        try {
            cards1Level1 = cards1LevelRepository.getFourCards().get(0);
            cards1Level2 = cards1LevelRepository.getFourCards().get(1);
            cards1Level3 = cards1LevelRepository.getFourCards().get(2);
            cards1Level4 = cards1LevelRepository.getFourCards().get(3);

            ImageView card1Level1ImgView = cards1Level1.getView();
            ImageView card1Level2ImgView = cards1Level2.getView();
            ImageView card1Level3ImgView = cards1Level3.getView();
            ImageView card1Level4ImgView = cards1Level4.getView();

            card1Level1Button.setGraphic(card1Level1ImgView);
            card1Level2Button.setGraphic(card1Level2ImgView);
            card1Level3Button.setGraphic(card1Level3ImgView);
            card1Level4Button.setGraphic(card1Level4ImgView);

            card1Level1ImgView.setFitHeight(200);
            card1Level1ImgView.setPreserveRatio(true);

            card1Level2ImgView.setFitHeight(200);
            card1Level2ImgView.setPreserveRatio(true);

            card1Level3ImgView.setFitHeight(200);
            card1Level3ImgView.setPreserveRatio(true);

            card1Level4ImgView.setFitHeight(200);
            card1Level4ImgView.setPreserveRatio(true);


        } catch (NullPointerException e) {
            System.out.println("No more cards to take");
        }

    }

    public void load2LevelCards() {

        try {
            cards2Level1 = cards2LevelRepository.getFourCards().get(0);
            cards2Level2 = cards2LevelRepository.getFourCards().get(1);
            cards2Level3 = cards2LevelRepository.getFourCards().get(2);
            cards2Level4 = cards2LevelRepository.getFourCards().get(3);

            ImageView card2Level1ImgView = cards2Level1.getView();
            ImageView card2Level2ImgView = cards2Level2.getView();
            ImageView card2Level3ImgView = cards2Level3.getView();
            ImageView card2Level4ImgView = cards2Level4.getView();

            card2Level1Button.setGraphic(card2Level1ImgView);
            card2Level2Button.setGraphic(card2Level2ImgView);
            card2Level3Button.setGraphic(card2Level3ImgView);
            card2Level4Button.setGraphic(card2Level4ImgView);

            card2Level1ImgView.setFitHeight(200);
            card2Level1ImgView.setPreserveRatio(true);

            card2Level2ImgView.setFitHeight(200);
            card2Level2ImgView.setPreserveRatio(true);

            card2Level3ImgView.setFitHeight(200);
            card2Level3ImgView.setPreserveRatio(true);

            card2Level4ImgView.setFitHeight(200);
            card2Level4ImgView.setPreserveRatio(true);


        } catch (NullPointerException e) {
            System.out.println("No more cards to take");
        }

    }

    public void load3LevelCards() {

        try {
            cards3Level1 = cards3LevelRepository.getFourCards().get(0);
            cards3Level2 = cards3LevelRepository.getFourCards().get(1);
            cards3Level3 = cards3LevelRepository.getFourCards().get(2);
            cards3Level4 = cards3LevelRepository.getFourCards().get(3);

            ImageView card3Level1ImgView = cards3Level1.getView();
            ImageView card3Level2ImgView = cards3Level2.getView();
            ImageView card3Level3ImgView = cards3Level3.getView();
            ImageView card3Level4ImgView = cards3Level4.getView();

            card3Level1Button.setGraphic(card3Level1ImgView);
            card3Level2Button.setGraphic(card3Level2ImgView);
            card3Level3Button.setGraphic(card3Level3ImgView);
            card3Level4Button.setGraphic(card3Level4ImgView);

            card3Level1ImgView.setFitHeight(200);
            card3Level1ImgView.setPreserveRatio(true);

            card3Level2ImgView.setFitHeight(200);
            card3Level2ImgView.setPreserveRatio(true);

            card3Level3ImgView.setFitHeight(200);
            card3Level3ImgView.setPreserveRatio(true);

            card3Level4ImgView.setFitHeight(200);
            card3Level4ImgView.setPreserveRatio(true);


        } catch (NullPointerException e) {
            System.out.println("No more cards to take");
        }

    }


    public void drawAristocrates() {
        aristocratsRepository.drawThreeAristocrats();
    }


    public void loadAristocrats() {

        try {
            aristocrat1 = aristocratsRepository.getThreeAristocratsList().get(0);
            aristocrat2 = aristocratsRepository.getThreeAristocratsList().get(1);
            aristocrat3 = aristocratsRepository.getThreeAristocratsList().get(2);

            ImageView aristocrat1ImgView = aristocrat1.getView();
            ImageView aristocrat2ImgView = aristocrat2.getView();
            ImageView aristocrat3ImgView = aristocrat3.getView();

            aristocrat1Button.setGraphic(aristocrat1ImgView);
            aristocrat2Button.setGraphic(aristocrat2ImgView);
            aristocrat3Button.setGraphic(aristocrat3ImgView);

            aristocrat1ImgView.setFitWidth(150);
            aristocrat1ImgView.setFitHeight(150);

            aristocrat2ImgView.setFitWidth(150);
            aristocrat2ImgView.setFitHeight(150);

            aristocrat3ImgView.setFitWidth(150);
            aristocrat3ImgView.setFitHeight(150);

        } catch (NullPointerException e) {
            System.out.println("No more aristocrats to take");
        }

    }


    public void loadPlayersAristocrats() {
        player1Aristocrats.getChildren().clear();
        player2Aristocrats.getChildren().clear();
        player1.getAristocrats().stream()
                .forEach(a -> {
                    ImageView player1Aristocrat = new ImageView();
                    player1Aristocrat.setImage(a.getView().getImage());
                    player1Aristocrat.setFitWidth(150);
                    player1Aristocrat.setFitHeight(150);
                    player1Aristocrats.getChildren().add(player1Aristocrat);
                });
        player2.getAristocrats().stream()
                .forEach(a -> {
                    ImageView player2Aristocrat = new ImageView();
                    player2Aristocrat.setImage(a.getView().getImage());
                    player2Aristocrat.setImage(a.getView().getImage());
                    player2Aristocrat.setFitWidth(150);
                    player2Aristocrat.setFitHeight(150);
                    player2Aristocrats.getChildren().add(player2Aristocrat);
                });
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        PlayerCreator playerCreator = new PlayerCreator();
        playerCreator.createPlayers();
        player1 = playerCreator.getPlayers().get(0);
        player2 = playerCreator.getPlayers().get(1);
        players.add(player1);
        players.add(player2);
        saveCurrentStatus();
        loadPlayersJewelCounters();
        player = player1;

        //Background
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        //GridPanesAdding
        GridPane grid = new GridPane();
        GridPane gridPane1 = new GridPane();
        GridPane gridPane2 = new GridPane();
        GridPane gridPane3 = new GridPane();
        GridPane player1CardsGridPane = new GridPane();
        GridPane player2CardsGridPane = new GridPane();

        grid.add(gridPane1, 0, 0, 1, 1);
        grid.add(gridPane2, 1, 0, 1, 1);
        grid.add(gridPane3, 2, 0, 1, 1);

        gridPane1.add(player1NameAndPointsHB, 0, 0, 1, 1);
        gridPane1.add(player1Jewels, 0, 6, 1, 1);
        gridPane1.add(player1Aristocrats, 0, 1, 1, 1);
        gridPane1.add(player1CardsGridPane, 0, 3, 1, 1);
        gridPane1.add(player1JewelsCards, 0, 4, 1, 1);
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
        gridPane3.add(player2JewelsCards, 0, 4, 1, 1);
        gridPane3.add(player2CardsTextHB, 0, 2, 1, 1);
        gridPane3.add(player2JewelsTextHB, 0, 5, 1, 1);
        gridPane3.add(player2CommitHB, 0, 7, 1, 1);

        //GridPanesSettingUp
        grid.setBackground(background);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(8, 12, 8, 12));
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setBackground(background);

        gridPane1.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10;");
        gridPane3.setStyle("-fx-background-color: rgba(139, 0, 0, 0.5); -fx-background-radius: 10;");

        //Move
        player1CommitHB.setAlignment(Pos.BOTTOM_RIGHT);
        player1CommitHB.setPrefHeight(150);
        player1CommitHB.setPadding(new Insets(30, 30, 30, 30));
        player2CommitHB.setAlignment(Pos.BOTTOM_RIGHT);
        player2CommitHB.setPrefHeight(150);
        player2CommitHB.setPadding(new Insets(30, 30, 30, 30));

        //Jewel
        player1JewelsTextHB.setAlignment(Pos.CENTER);
        player2JewelsTextHB.setAlignment(Pos.CENTER);
        jewels.setAlignment(Pos.BOTTOM_CENTER);
        jewels.setPrefWidth(500);
        player1Jewels.setAlignment(Pos.BOTTOM_CENTER);
        player1JewelsCards.setAlignment(Pos.TOP_CENTER);
        player1JewelsCards.setPrefHeight(150);
        player2Jewels.setAlignment(Pos.BOTTOM_CENTER);
        player2JewelsCards.setAlignment(Pos.TOP_CENTER);
        player2JewelsCards.setPrefHeight(150);

        //Aristocrats
        aristocrats.setAlignment(Pos.TOP_CENTER);
        aristocrats.setPrefWidth(500);
        player1Aristocrats.setAlignment(Pos.CENTER);
        player1Aristocrats.setPrefWidth(400);
        player1Aristocrats.setPrefHeight(250);
        player2Aristocrats.setAlignment(Pos.CENTER);
        player2Aristocrats.setPrefWidth(400);
        player2Aristocrats.setPrefHeight(250);

        //Cards
        player1CardsGridPane.setAlignment(Pos.CENTER);
        player2CardsGridPane.setAlignment(Pos.CENTER);
        player1CardsTextHB.setAlignment(Pos.CENTER);
        player2CardsTextHB.setAlignment(Pos.CENTER);
        cards1.setAlignment(Pos.TOP_CENTER);
        cards2.setAlignment(Pos.TOP_CENTER);
        cards3.setAlignment(Pos.TOP_CENTER);


        final String BUTTON_STYLE = "-fx-background-color: transparent;";
        final String JEWEL_BUTTON_STYLE = "-fx-background-color: transparent; -fx-text-fill: #D4AF37;";
        final String COMMIT_BUTTON_STYLE = "-fx-background-color: black; -fx-text-fill: #D4AF37;-fx-font-size: 20";
        final String HOVERED_BUTTON_STYLE = "-fx-background-color: rgba(212,175,55,0.5);";

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
                gridPane3.setEffect(shadow);
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
                gridPane1.setEffect(shadow);
            } ;
            if(finishGame()){
                primaryStage.close();
            };
        });

        player1CommitHB.getChildren().add(player1CommitButton);
        player2CommitHB.getChildren().add(player2CommitButton);


        //Players
        Text player1NameAndPoints = new Text();
        player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
        player1NameAndPoints.setTextAlignment(TextAlignment.CENTER);
        player1NameAndPoints.setWrappingWidth(300);
        player1NameAndPoints.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 50));
        player1NameAndPoints.setFill(Color.valueOf("#D4AF37"));

        player1NameAndPointsHB.setAlignment(Pos.TOP_CENTER);
        player1NameAndPointsHB.getChildren().add(player1NameAndPoints);

        Text player2NameAndPoints = new Text();
        player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
        player2NameAndPoints.setTextAlignment(TextAlignment.CENTER);
        player2NameAndPoints.setWrappingWidth(300);
        player2NameAndPoints.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 50));
        player2NameAndPoints.setFill(Color.valueOf("#D4AF37"));

        player2NameAndPointsHB.setAlignment(Pos.TOP_CENTER);
        player2NameAndPointsHB.getChildren().add(player2NameAndPoints);

        //Jewels_Buttons
        String diamondCounter = String.valueOf(jewelRepository.getDiamond().getNumber());
        String onyxCounter = String.valueOf(jewelRepository.getOnyx().getNumber());
        String saphireCounter = String.valueOf(jewelRepository.getSapphire().getNumber());
        String rubyCounter = String.valueOf(jewelRepository.getRuby().getNumber());
        String emeraldCounter = String.valueOf(jewelRepository.getEmerald().getNumber());

        Button buttonDiamond = new Button(diamondCounter, new ImageView(jewelRepository.getDiamondImage()));
        buttonDiamond.setStyle(JEWEL_BUTTON_STYLE);
        buttonDiamond.setOnMouseEntered(e -> buttonDiamond.setStyle(HOVERED_BUTTON_STYLE));
        buttonDiamond.setOnMouseExited(e -> buttonDiamond.setStyle(JEWEL_BUTTON_STYLE));
        buttonDiamond.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        buttonDiamond.setOnAction((e) -> {
            jewelRepository.takeJewel(player, Colors.WHITE);
            loadPlayersJewelCounters();
            buttonDiamond.setText(String.valueOf(jewelRepository.getDiamond().getNumber()));
            diamondTaken += 1;

        });

        Button buttonSapphire = new Button(saphireCounter, new ImageView(jewelRepository.getSapphireImage()));
        buttonSapphire.setStyle(JEWEL_BUTTON_STYLE);
        buttonSapphire.setOnMouseEntered(e -> buttonSapphire.setStyle(HOVERED_BUTTON_STYLE));
        buttonSapphire.setOnMouseExited(e -> buttonSapphire.setStyle(JEWEL_BUTTON_STYLE));
        buttonSapphire.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        buttonSapphire.setOnAction((e) -> {
            jewelRepository.takeJewel(player, Colors.BLUE);
            loadPlayersJewelCounters();
            buttonSapphire.setText(String.valueOf(jewelRepository.getSapphire().getNumber()));
            sapphireTaken += 1;
        });

        Button buttonOnyx = new Button(onyxCounter, new ImageView(jewelRepository.getOnyxImage()));
        buttonOnyx.setStyle(JEWEL_BUTTON_STYLE);
        buttonOnyx.setOnMouseEntered(e -> buttonOnyx.setStyle(HOVERED_BUTTON_STYLE));
        buttonOnyx.setOnMouseExited(e -> buttonOnyx.setStyle(JEWEL_BUTTON_STYLE));
        buttonOnyx.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        buttonOnyx.setOnAction((e) -> {
            jewelRepository.takeJewel(player, Colors.BLACK);
            loadPlayersJewelCounters();
            buttonOnyx.setText(String.valueOf(jewelRepository.getOnyx().getNumber()));
            onyxTaken += 1;
        });


        Button buttonEmerald = new Button(emeraldCounter, new ImageView(jewelRepository.getEmeraldImage()));
        buttonEmerald.setStyle(JEWEL_BUTTON_STYLE);
        buttonEmerald.setOnMouseEntered(e -> buttonEmerald.setStyle(HOVERED_BUTTON_STYLE));
        buttonEmerald.setOnMouseExited(e -> buttonEmerald.setStyle(JEWEL_BUTTON_STYLE));
        buttonEmerald.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        buttonEmerald.setOnAction((e) -> {
            jewelRepository.takeJewel(player, Colors.GREEN);
            loadPlayersJewelCounters();
            buttonEmerald.setText(String.valueOf(jewelRepository.getEmerald().getNumber()));
            emeraldTaken += 1;
        });

        Button buttonRuby = new Button(rubyCounter, new ImageView(jewelRepository.getRubyImage()));
        buttonRuby.setStyle(JEWEL_BUTTON_STYLE);
        buttonRuby.setOnMouseEntered(e -> buttonRuby.setStyle(HOVERED_BUTTON_STYLE));
        buttonRuby.setOnMouseExited(e -> buttonRuby.setStyle(JEWEL_BUTTON_STYLE));
        buttonRuby.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        buttonRuby.setOnAction((e) -> {
            jewelRepository.takeJewel(player, Colors.RED);
            loadPlayersJewelCounters();
            buttonRuby.setText(String.valueOf(jewelRepository.getRuby().getNumber()));
            rubyTaken += 1;
        });

        jewels.getChildren().addAll(buttonDiamond, buttonOnyx, buttonSapphire, buttonRuby, buttonEmerald);

        //Player1JewelsText
        Text player1JevelsText = new Text("Jewels");
        player1JewelsTextHB.getChildren().add(player1JevelsText);
        player1JevelsText.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1JevelsText.setFill(Color.valueOf("#D4AF37"));


        //Player2JewelsText
        Text player2JewelsText = new Text("Jewels");
        player2JewelsTextHB.getChildren().add(player2JewelsText);
        player2JewelsText.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2JewelsText.setFill(Color.valueOf("#D4AF37"));


        //Aristocrats
        drawAristocrates();
        loadAristocrats();

        aristocrat1Button.setStyle(BUTTON_STYLE);
        aristocrat1Button.setOnMouseEntered(e -> aristocrat1Button.setStyle(HOVERED_BUTTON_STYLE));
        aristocrat1Button.setOnMouseExited(e -> aristocrat1Button.setStyle(BUTTON_STYLE));
        aristocrat1Button.setOnAction((e) -> {
            if (aristocratsRepository.takeAristocrat(player, aristocrat1, 0)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                loadPlayersAristocrats();
                loadAristocrats();
                aristocratsTaken += 1;
            }
        });

        aristocrat2Button.setStyle(BUTTON_STYLE);
        aristocrat2Button.setOnMouseEntered(e -> aristocrat2Button.setStyle(HOVERED_BUTTON_STYLE));
        aristocrat2Button.setOnMouseExited(e -> aristocrat2Button.setStyle(BUTTON_STYLE));
        aristocrat2Button.setOnAction((e) -> {
            if (aristocratsRepository.takeAristocrat(player, aristocrat2, 1)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                loadPlayersAristocrats();
                loadAristocrats();
                aristocratsTaken += 1;
            }
        });


        aristocrat3Button.setStyle(BUTTON_STYLE);
        aristocrat3Button.setOnMouseEntered(e -> aristocrat3Button.setStyle(HOVERED_BUTTON_STYLE));
        aristocrat3Button.setOnMouseExited(e -> aristocrat3Button.setStyle(BUTTON_STYLE));
        aristocrat3Button.setOnAction((e) -> {
            if (aristocratsRepository.takeAristocrat(player, aristocrat3, 2)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                loadPlayersAristocrats();
                loadAristocrats();
                aristocratsTaken += 1;
            }
        });

        aristocrats.getChildren().addAll(aristocrat1Button, aristocrat2Button, aristocrat3Button);

        //1LevelCards
        draw1LevelCards();
        load1LevelCards();

        card1Level1Button.setStyle(BUTTON_STYLE);
        card1Level1Button.setOnMouseEntered(e -> card1Level1Button.setStyle(HOVERED_BUTTON_STYLE));
        card1Level1Button.setOnMouseExited(e -> card1Level1Button.setStyle(BUTTON_STYLE));
        card1Level1Button.setOnAction((e) -> {
            if (cards1LevelRepository.takeCard(player, cards1Level1, 0)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load1LevelCards();
                loadPlayersCardsCounters();
                loadPlayersJewelCounters();
                cardTaken += 1;
            }
        });

        card1Level2Button.setStyle(BUTTON_STYLE);
        card1Level2Button.setOnMouseEntered(e -> card1Level2Button.setStyle(HOVERED_BUTTON_STYLE));
        card1Level2Button.setOnMouseExited(e -> card1Level2Button.setStyle(BUTTON_STYLE));
        card1Level2Button.setOnAction((e) -> {
            if (cards1LevelRepository.takeCard(player, cards1Level2, 1)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load1LevelCards();
                loadPlayersCardsCounters();
                loadPlayersJewelCounters();
                cardTaken += 1;
            }
        });

        card1Level3Button.setStyle(BUTTON_STYLE);
        card1Level3Button.setOnMouseEntered(e -> card1Level3Button.setStyle(HOVERED_BUTTON_STYLE));
        card1Level3Button.setOnMouseExited(e -> card1Level3Button.setStyle(BUTTON_STYLE));
        card1Level3Button.setOnAction((e) -> {
            if (cards1LevelRepository.takeCard(player, cards1Level3, 2)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load1LevelCards();
                loadPlayersCardsCounters();
                loadPlayersJewelCounters();
                cardTaken += 1;
            }
        });

        card1Level4Button.setStyle(BUTTON_STYLE);
        card1Level4Button.setOnMouseEntered(e -> card1Level4Button.setStyle(HOVERED_BUTTON_STYLE));
        card1Level4Button.setOnMouseExited(e -> card1Level4Button.setStyle(BUTTON_STYLE));
        card1Level4Button.setOnAction((e) -> {
            if (cards1LevelRepository.takeCard(player, cards1Level4, 3)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load1LevelCards();
                loadPlayersCardsCounters();
                loadPlayersJewelCounters();
                cardTaken += 1;
            }
        });

        cards1.getChildren().addAll(card1Level1Button, card1Level2Button, card1Level3Button, card1Level4Button);


        //2LevelCards
        draw2LevelCards();
        load2LevelCards();

        card2Level1Button.setStyle(BUTTON_STYLE);
        card2Level1Button.setOnMouseEntered(e -> card2Level1Button.setStyle(HOVERED_BUTTON_STYLE));
        card2Level1Button.setOnMouseExited(e -> card2Level1Button.setStyle(BUTTON_STYLE));
        card2Level1Button.setOnAction((e) -> {
            if (cards2LevelRepository.takeCard(player, cards2Level1, 0)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load2LevelCards();
                loadPlayersCardsCounters();
                loadPlayersJewelCounters();
                cardTaken += 1;
            }
        });


        card2Level2Button.setStyle(BUTTON_STYLE);
        card2Level2Button.setOnMouseEntered(e -> card2Level2Button.setStyle(HOVERED_BUTTON_STYLE));
        card2Level2Button.setOnMouseExited(e -> card2Level2Button.setStyle(BUTTON_STYLE));
        card2Level2Button.setOnAction((e) -> {
            if (cards2LevelRepository.takeCard(player, cards2Level2, 1)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load2LevelCards();
                loadPlayersCardsCounters();
                loadPlayersJewelCounters();
                cardTaken += 1;
            }
        });


        card2Level3Button.setStyle(BUTTON_STYLE);
        card2Level3Button.setOnMouseEntered(e -> card2Level3Button.setStyle(HOVERED_BUTTON_STYLE));
        card2Level3Button.setOnMouseExited(e -> card2Level3Button.setStyle(BUTTON_STYLE));
        card2Level3Button.setOnAction((e) -> {
            if (cards2LevelRepository.takeCard(player, cards2Level3, 2)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load2LevelCards();
                loadPlayersCardsCounters();
                loadPlayersJewelCounters();
                cardTaken += 1;
            }
        });


        card2Level4Button.setStyle(BUTTON_STYLE);
        card2Level4Button.setOnMouseEntered(e -> card2Level4Button.setStyle(HOVERED_BUTTON_STYLE));
        card2Level4Button.setOnMouseExited(e -> card2Level4Button.setStyle(BUTTON_STYLE));
        card2Level4Button.setOnAction((e) -> {
            if (cards2LevelRepository.takeCard(player, cards2Level4, 3)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load2LevelCards();
                loadPlayersCardsCounters();
                loadPlayersJewelCounters();
                cardTaken += 1;

            }
        });


        cards2.getChildren().addAll(card2Level1Button, card2Level2Button, card2Level3Button, card2Level4Button);


        //3LevelCards
        draw3LevelCards();
        load3LevelCards();

        card3Level1Button.setStyle(BUTTON_STYLE);
        card3Level1Button.setOnMouseEntered(e -> card3Level1Button.setStyle(HOVERED_BUTTON_STYLE));
        card3Level1Button.setOnMouseExited(e -> card3Level1Button.setStyle(BUTTON_STYLE));
        card3Level1Button.setOnAction((e) -> {
            if (cards3LevelRepository.takeCard(player, cards3Level1, 0)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load3LevelCards();
                loadPlayersCardsCounters();
                loadPlayersJewelCounters();
                cardTaken += 1;
            }
        });

        card3Level2Button.setStyle(BUTTON_STYLE);
        card3Level2Button.setOnMouseEntered(e -> card3Level2Button.setStyle(HOVERED_BUTTON_STYLE));
        card3Level2Button.setOnMouseExited(e -> card3Level2Button.setStyle(BUTTON_STYLE));
        card3Level2Button.setOnAction((e) -> {
            if (cards3LevelRepository.takeCard(player, cards3Level2, 1)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load3LevelCards();
                loadPlayersCardsCounters();
                loadPlayersJewelCounters();
                cardTaken += 1;
            }
        });


        card3Level3Button.setStyle(BUTTON_STYLE);
        card3Level3Button.setOnMouseEntered(e -> card3Level3Button.setStyle(HOVERED_BUTTON_STYLE));
        card3Level3Button.setOnMouseExited(e -> card3Level3Button.setStyle(BUTTON_STYLE));
        card3Level3Button.setOnAction((e) -> {
            if (cards3LevelRepository.takeCard(player, cards3Level3, 2)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load3LevelCards();
                loadPlayersCardsCounters();
                loadPlayersJewelCounters();
                cardTaken += 1;
            }
        });

        card3Level4Button.setStyle(BUTTON_STYLE);
        card3Level4Button.setOnMouseEntered(e -> card3Level4Button.setStyle(HOVERED_BUTTON_STYLE));
        card3Level4Button.setOnMouseExited(e -> card3Level4Button.setStyle(BUTTON_STYLE));
        card3Level4Button.setOnAction((e) -> {
            if (cards3LevelRepository.takeCard(player, cards3Level4, 3)) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load3LevelCards();
                loadPlayersCardsCounters();
                loadPlayersJewelCounters();
                cardTaken += 1;
            }
        });


        cards3.getChildren().addAll(card3Level1Button, card3Level2Button, card3Level3Button, card3Level4Button);


        //Player1CardsText&Counters
        loadPlayersCardsCounters();

        Text player1CardsText = new Text("Cards with jewel");
        player1CardsTextHB.getChildren().add(player1CardsText);
        player1CardsText.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1CardsText.setFill(Color.valueOf("#D4AF37"));


        Text player2CardsText = new Text("Cards with jewel");
        player2CardsTextHB.getChildren().add(player2CardsText);
        player2CardsText.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2CardsText.setFill(Color.valueOf("#D4AF37"));






    }

    public static void main(String[] args) {

        launch(args);


    }


}

