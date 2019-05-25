package com.kodilla.splendor;


import com.kodilla.splendor.Repository.AristocratsRepository;
import com.kodilla.splendor.Repository.Cards1LevelRepository;
import com.kodilla.splendor.Repository.Cards2LevelRepository;
import com.kodilla.splendor.Repository.Cards3LevelRepository;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.List;


public class SplendorApplication extends Application {

    private Image imageback = new Image("1985-52-15143-pdp.jpg");

    private SplendorRunner splendorRunner = new SplendorRunner();
    private List<Player> players = splendorRunner.createPlayers();

    private final Player player1 = players.get(0);
    private final Player player2 = players.get(1);
    private Player player = player2;



    private HBox jewels = new HBox();
    private HBox aristocrats = new HBox();
    private HBox player1Jewels = new HBox();
    private HBox player2Jewels = new HBox();
    private HBox cards3 = new HBox();
    private HBox cards2 = new HBox();
    private HBox cards1 = new HBox();
    private HBox player1Aristocrats = new HBox();
    private HBox player2Aristocrats = new HBox();
    private HBox player1JewelsCards = new HBox();
    private HBox player2JewelsCards = new HBox();

    private HBox player1NameAndPointsHB = new HBox();
    private HBox player2NameAndPointsHB = new HBox();

    private FlowPane player1CardsDiamond = new FlowPane();
    private FlowPane player1CardsSapphire = new FlowPane();
    private FlowPane player1CardsOnyx = new FlowPane();
    private FlowPane player1CardsEmerald = new FlowPane();
    private FlowPane player1CardsRuby = new FlowPane();

    private HBox player1CardsTextHB = new HBox();
    private HBox player1JewelsTextHB = new HBox();


    private FlowPane player2CardsDiamond = new FlowPane();
    private FlowPane player2CardsSapphire = new FlowPane();
    private FlowPane player2CardsOnyx = new FlowPane();
    private FlowPane player2CardsEmerald = new FlowPane();
    private FlowPane player2CardsRuby = new FlowPane();

    private HBox player2CardsTextHB = new HBox();
    private HBox player2JewelsTextHB = new HBox();

    private AristocratsRepository aristocratsRepository = new AristocratsRepository();
    private Aristocrats aristocrat1 = new Aristocrats();
    private Aristocrats aristocrat2 = new Aristocrats();
    private Aristocrats aristocrat3 = new Aristocrats();

    private Button aristocrat1Button = new Button();
    private Button aristocrat2Button = new Button();
    private Button aristocrat3Button = new Button();

    private Cards1LevelRepository cards1LevelRepository = new Cards1LevelRepository();
    private Cards2LevelRepository cards2LevelRepository = new Cards2LevelRepository();
    private Cards3LevelRepository cards3LevelRepository = new Cards3LevelRepository();

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

    Button card1Level1Button = new Button();
    Button card1Level2Button = new Button();
    Button card1Level3Button = new Button();
    Button card1Level4Button = new Button();

    Button card2Level1Button = new Button();
    Button card2Level2Button = new Button();
    Button card2Level3Button = new Button();
    Button card2Level4Button = new Button();

    Button card3Level1Button = new Button();
    Button card3Level2Button = new Button();
    Button card3Level3Button = new Button();
    Button card3Level4Button = new Button();


    public void draw1LevelCards(){
        cards1LevelRepository.drawFourCards();
    }

    public void draw2LevelCards(){
        cards2LevelRepository.drawFourCards();
    }

    public void draw3LevelCards(){
        cards3LevelRepository.drawFourCards();
    }

    private Jewel jewel = new Jewel();


    public void loadPlayersCardsCounters(){
        player1CardsDiamond.getChildren().clear();
        player1CardsSapphire.getChildren().clear();
        player1CardsOnyx.getChildren().clear();
        player1CardsEmerald.getChildren().clear();
        player1CardsRuby.getChildren().clear();
        player1JewelsCards.getChildren().clear();

        player2CardsDiamond.getChildren().clear();
        player2CardsSapphire.getChildren().clear();
        player2CardsOnyx.getChildren().clear();
        player2CardsEmerald.getChildren().clear();
        player2CardsRuby.getChildren().clear();
        player2JewelsCards.getChildren().clear();

        ImageView player1WhiteCard = new ImageView(jewel.getDiamond());
        ImageView player1BlueCard = new ImageView(jewel.getSapphire());
        ImageView player1BlackCard = new ImageView(jewel.getOnyx());
        ImageView player1GreenCard = new ImageView(jewel.getEmerald());
        ImageView player1RedCard = new ImageView(jewel.getRuby());

        Text player1WhiteCounter = new Text(String.valueOf(player1.getCardCounter().get(Colors.WHITE)));
        Text player1BlueCounter = new Text(String.valueOf(player1.getCardCounter().get(Colors.BLUE)));
        Text player1BlackCounter = new Text(String.valueOf(player1.getCardCounter().get(Colors.BLACK)));
        Text player1GreenCounter = new Text(String.valueOf(player1.getCardCounter().get(Colors.GREEN)));
        Text player1RedCounter = new Text(String.valueOf(player1.getCardCounter().get(Colors.RED)));

        player1WhiteCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1WhiteCounter.setFill(Color.web("#D4AF37"));
        player1BlueCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1BlueCounter.setFill(Color.web("#D4AF37"));
        player1BlackCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1BlackCounter.setFill(Color.web("#D4AF37"));
        player1GreenCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1GreenCounter.setFill(Color.web("#D4AF37"));
        player1RedCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1RedCounter.setFill(Color.web("#D4AF37"));

        player1CardsDiamond.getChildren().addAll(player1WhiteCard, player1WhiteCounter);
        player1CardsSapphire.getChildren().addAll(player1BlueCard, player1BlueCounter);
        player1CardsOnyx.getChildren().addAll(player1BlackCard, player1BlackCounter);
        player1CardsEmerald.getChildren().addAll(player1GreenCard, player1GreenCounter);
        player1CardsRuby.getChildren().addAll(player1RedCard, player1RedCounter);

        player1JewelsCards.getChildren().addAll(player1CardsDiamond, player1CardsSapphire, player1CardsOnyx, player1CardsEmerald, player1CardsRuby);

        ImageView player2DiamondCard = new ImageView(jewel.getDiamond());
        ImageView player2SapphireCard = new ImageView(jewel.getSapphire());
        ImageView player2OnyxCard = new ImageView(jewel.getOnyx());
        ImageView player2EmeraldCard = new ImageView(jewel.getEmerald());
        ImageView player2RubyCard = new ImageView(jewel.getRuby());

        Text player2DiamondCounter = new Text(String.valueOf(player2.getCardCounter().get(Colors.WHITE)));
        Text player2SapphireCounter = new Text(String.valueOf(player2.getCardCounter().get(Colors.BLUE)));
        Text player2OnyxCounter = new Text(String.valueOf(player2.getCardCounter().get(Colors.BLACK)));
        Text player2EmeraldCounter = new Text(String.valueOf(player2.getCardCounter().get(Colors.GREEN)));
        Text player2RubyCounter = new Text(String.valueOf(player2.getCardCounter().get(Colors.RED)));

        player2DiamondCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2DiamondCounter.setFill(Color.web("#D4AF37"));
        player2SapphireCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2SapphireCounter.setFill(Color.web("#D4AF37"));
        player2OnyxCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2OnyxCounter.setFill(Color.web("#D4AF37"));
        player2EmeraldCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2EmeraldCounter.setFill(Color.web("#D4AF37"));
        player2RubyCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2RubyCounter.setFill(Color.web("#D4AF37"));

        player2CardsDiamond.getChildren().addAll(player2DiamondCard, player2DiamondCounter);
        player2CardsSapphire.getChildren().addAll(player2SapphireCard, player2SapphireCounter);
        player2CardsOnyx.getChildren().addAll(player2OnyxCard, player2OnyxCounter);
        player2CardsEmerald.getChildren().addAll(player2EmeraldCard, player2EmeraldCounter);
        player2CardsRuby.getChildren().addAll(player2RubyCard, player2RubyCounter);

        player2JewelsCards.getChildren().addAll(player2CardsDiamond, player2CardsSapphire, player2CardsOnyx, player2CardsEmerald, player2CardsRuby);

    }

    public void loadPlayersJewelsCounters(){

    }


    public void load1LevelCards(){

        try{
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

    public void load2LevelCards(){

        try{
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

    public void load3LevelCards(){

        try{
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


    public void drawAristocrates(){
        aristocratsRepository.drawThreeAristocrats();
    }


    public void loadAristocrats(){

        try{
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
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setBackground(background);

        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(8, 12, 8, 12));
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setBackground(background);

        GridPane gridPane1 = new GridPane();

        GridPane gridPane2 = new GridPane();
        GridPane gridPane3 = new GridPane();

        gridPane1.setStyle("-fx-background-color: rgba(0, 100, 100, 0.5); -fx-background-radius: 10;");
        gridPane3.setStyle("-fx-background-color: rgba(139, 0, 0, 0.5); -fx-background-radius: 10;");

        grid.add(gridPane1, 0, 0, 1, 1);
        grid.add(gridPane2, 1, 0, 1, 1);
        grid.add(gridPane3, 2, 0, 1, 1);

        GridPane player1CardsGridPane = new GridPane();
        GridPane player2CardsGridPane = new GridPane();

        gridPane1.add(player1NameAndPointsHB, 0, 0, 1, 1);
        gridPane1.add(player1Jewels, 0, 6, 1, 1);
        gridPane1.add(player1Aristocrats, 0, 1, 1, 1);
        gridPane1.add(player1CardsGridPane, 0, 3, 1, 1);
        gridPane1.add(player1JewelsCards, 0, 4, 1, 1);
        gridPane1.add(player1CardsTextHB, 0, 2,1,1);
        gridPane1.add(player1JewelsTextHB, 0, 5, 1, 1);

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
        gridPane3.add(player2CardsTextHB, 0, 2,1,1);
        gridPane3.add(player2JewelsTextHB, 0, 5, 1, 1);

        player1CardsGridPane.add(player1CardsDiamond, 0,0,1,1);
        player1CardsGridPane.add(player1CardsSapphire, 1,0,1,1);
        player1CardsGridPane.add(player1CardsOnyx, 2,0,1,1);
        player1CardsGridPane.add(player1CardsEmerald, 3,0,1,1);
        player1CardsGridPane.add(player1CardsRuby, 4,0,1,1);

        player2CardsGridPane.add(player2CardsDiamond, 0,0,1,1);
        player2CardsGridPane.add(player2CardsSapphire, 1,0,1,1);
        player2CardsGridPane.add(player2CardsOnyx, 2,0,1,1);
        player2CardsGridPane.add(player2CardsEmerald, 3,0,1,1);
        player2CardsGridPane.add(player2CardsRuby, 4,0,1,1);

        player1CardsGridPane.setAlignment(Pos.CENTER);
        player2CardsGridPane.setAlignment(Pos.CENTER);


        player1CardsTextHB.setAlignment(Pos.CENTER);
        player2CardsTextHB.setAlignment(Pos.CENTER);

        player1JewelsTextHB.setAlignment(Pos.CENTER);
        player2JewelsTextHB.setAlignment(Pos.CENTER);

        player1CardsDiamond.setMaxSize(30, 10);
        player1CardsSapphire.setMaxSize(30, 10);
        player1CardsOnyx.setMaxSize(30, 10);
        player1CardsEmerald.setMaxSize(30, 10);
        player1CardsRuby.setMaxSize(30, 10);

        player2CardsDiamond.setMaxSize(30, 10);
        player2CardsSapphire.setMaxSize(30, 10);
        player2CardsOnyx.setMaxSize(30, 10);
        player2CardsEmerald.setMaxSize(30, 10);
        player2CardsRuby.setMaxSize(30, 10);

        jewels.setAlignment(Pos.BOTTOM_CENTER);
        jewels.setPrefWidth(500);
        cards1.setAlignment(Pos.TOP_CENTER);
        cards2.setAlignment(Pos.TOP_CENTER);
        cards3.setAlignment(Pos.TOP_CENTER);
        aristocrats.setAlignment(Pos.TOP_CENTER);
        aristocrats.setPrefWidth(500);

        player1Jewels.setAlignment(Pos.BOTTOM_CENTER);
        player1JewelsCards.setAlignment(Pos.TOP_CENTER);
        player1JewelsCards.setPrefHeight(150);
        player1Aristocrats.setAlignment(Pos.CENTER);
        player1Aristocrats.setPrefWidth(400);
        player1Aristocrats.setPrefHeight(250);


        player2Jewels.setAlignment(Pos.BOTTOM_CENTER);
        player2JewelsCards.setAlignment(Pos.TOP_CENTER);
        player2JewelsCards.setPrefHeight(150);
        player2Aristocrats.setAlignment(Pos.CENTER);
        player2Aristocrats.setPrefWidth(400);
        player2Aristocrats.setPrefHeight(250);

        final String BUTTON_STYLE = "-fx-background-color: transparent;";
        final String JEWEL_BUTTON_STYLE = "-fx-background-color: transparent; -fx-text-fill: #D4AF37;";
        final String HOVERED_BUTTON_STYLE = "-fx-background-color: rgba(212,175,55,0.5);";


        //PlayersNames&Points


        Text player1NameAndPoints = new Text();
        player1NameAndPoints.setText( players.get(0).getName() + ": " + players.get(0).getResult());
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


        //Aristocrats
        drawAristocrates();
        loadAristocrats();

        aristocrat1Button.setOnAction((e) ->  {
            if (aristocratsRepository.takeAristocrat(player, aristocrat1, 0) == true){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                loadPlayersAristocrats();
                loadAristocrats();
            }
        });

        aristocrat1Button.setStyle(BUTTON_STYLE);
        aristocrat1Button.setOnMouseEntered(e -> aristocrat1Button.setStyle(HOVERED_BUTTON_STYLE));
        aristocrat1Button.setOnMouseExited(e -> aristocrat1Button.setStyle(BUTTON_STYLE));

        aristocrat2Button.setOnAction((e) ->  {
            if (aristocratsRepository.takeAristocrat(player, aristocrat2, 1) == true){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                loadPlayersAristocrats();
                loadAristocrats();
            }
        });

        aristocrat2Button.setStyle(BUTTON_STYLE);
        aristocrat2Button.setOnMouseEntered(e -> aristocrat2Button.setStyle(HOVERED_BUTTON_STYLE));
        aristocrat2Button.setOnMouseExited(e -> aristocrat2Button.setStyle(BUTTON_STYLE));


        aristocrat3Button.setOnAction((e) ->  {
            if (aristocratsRepository.takeAristocrat(player, aristocrat3, 2) == true) {
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                loadPlayersAristocrats();
                loadAristocrats();
            }
        });

        aristocrat3Button.setStyle(BUTTON_STYLE);
        aristocrat3Button.setOnMouseEntered(e -> aristocrat3Button.setStyle(HOVERED_BUTTON_STYLE));
        aristocrat3Button.setOnMouseExited(e -> aristocrat3Button.setStyle(BUTTON_STYLE));

        aristocrats.getChildren().addAll(aristocrat1Button, aristocrat2Button, aristocrat3Button);



        //JewelsImages
        Jewel jewel = new Jewel();

        ImageView diamond = new ImageView(jewel.getDiamond());
        ImageView sapphire = new ImageView(jewel.getSapphire());
        ImageView onyx = new ImageView(jewel.getOnyx());
        ImageView emerald = new ImageView(jewel.getEmerald());
        ImageView ruby = new ImageView(jewel.getRuby());


        //Player1Jewels
        ImageView player1Diamond = new ImageView(jewel.getDiamond());
        ImageView player1Sapphire = new ImageView(jewel.getSapphire());
        ImageView player1Onyx = new ImageView(jewel.getOnyx());
        ImageView player1Emerald = new ImageView(jewel.getEmerald());
        ImageView player1Ruby = new ImageView(jewel.getRuby());


        Label player1DiamondLabel = new Label(String.valueOf(player1.getJewelCounter().get(Colors.WHITE)), player1Diamond);
        player1DiamondLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1DiamondLabel.setTextFill(Color.web("#D4AF37"));

        Label player1SapphireLabel = new Label(String.valueOf(player1.getJewelCounter().get(Colors.BLUE)), player1Sapphire);
        player1SapphireLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1SapphireLabel.setTextFill(Color.web("#D4AF37"));

        Label player1OnyxLabel = new Label(String.valueOf(player1.getJewelCounter().get(Colors.BLACK)), player1Onyx);
        player1OnyxLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1OnyxLabel.setTextFill(Color.web("#D4AF37"));

        Label player1EmeraldLabel = new Label(String.valueOf(player1.getJewelCounter().get(Colors.GREEN)), player1Emerald);
        player1EmeraldLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1EmeraldLabel.setTextFill(Color.web("#D4AF37"));

        Label player1RubyLabel = new Label(String.valueOf(player1.getJewelCounter().get(Colors.RED)), player1Ruby);
        player1RubyLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1RubyLabel.setTextFill(Color.web("#D4AF37"));

        player1Jewels.getChildren().addAll(player1DiamondLabel, player1SapphireLabel, player1OnyxLabel, player1EmeraldLabel, player1RubyLabel);


        //Player2Jewels
        ImageView player2Diamond = new ImageView(jewel.getDiamond());
        ImageView player2Sapphire = new ImageView(jewel.getSapphire());
        ImageView player2Onyx = new ImageView(jewel.getOnyx());
        ImageView player2Emerald = new ImageView(jewel.getEmerald());
        ImageView player2Ruby = new ImageView(jewel.getRuby());


        Label player2DiamondLabel = new Label(String.valueOf(player2.getJewelCounter().get(Colors.WHITE)), player2Diamond);
        player2DiamondLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2DiamondLabel.setTextFill(Color.web("#D4AF37"));

        Label player2SapphireLabel = new Label(String.valueOf(player2.getJewelCounter().get(Colors.BLUE)), player2Sapphire);
        player2SapphireLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2SapphireLabel.setTextFill(Color.web("#D4AF37"));

        Label player2OnyxLabel = new Label(String.valueOf(player2.getJewelCounter().get(Colors.BLACK)), player2Onyx);
        player2OnyxLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2OnyxLabel.setTextFill(Color.web("#D4AF37"));

        Label player2EmeraldLabel = new Label(String.valueOf(player2.getJewelCounter().get(Colors.GREEN)), player2Emerald);
        player2EmeraldLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2EmeraldLabel.setTextFill(Color.web("#D4AF37"));

        Label player2RubyLabel = new Label(String.valueOf(player2.getJewelCounter().get(Colors.RED)), player2Ruby);
        player2RubyLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2RubyLabel.setTextFill(Color.web("#D4AF37"));

        player2Jewels.getChildren().addAll(player2DiamondLabel, player2SapphireLabel, player2OnyxLabel, player2EmeraldLabel, player2RubyLabel);


        //JewelsButtons

        String diamondCounter = String.valueOf(jewel.getDiamondCounter());
        String onyxCounter = String.valueOf(jewel.getOnyxCounter());
        String saphireCounter = String.valueOf(jewel.getSapphireCounter());
        String rubyCounter = String.valueOf(jewel.getRubyCounter());
        String emeraldCounter = String.valueOf(jewel.getEmeraldCounter());

        Button buttonDiamond = new Button(diamondCounter, diamond);
        buttonDiamond.setStyle(JEWEL_BUTTON_STYLE);
        buttonDiamond.setOnMouseEntered(e -> buttonDiamond.setStyle(HOVERED_BUTTON_STYLE));
        buttonDiamond.setOnMouseExited(e -> buttonDiamond.setStyle(JEWEL_BUTTON_STYLE));
        buttonDiamond.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        buttonDiamond.setOnAction((e) ->  {
            jewel.takeDiamond(player);
            player1DiamondLabel.setText(String.valueOf(player1.getJewelCounter().get(Colors.WHITE)));
            player2DiamondLabel.setText(String.valueOf(player2.getJewelCounter().get(Colors.WHITE)));
            buttonDiamond.setText(String.valueOf(jewel.getDiamondCounter()));

        });

        Button buttonSapphire = new Button(saphireCounter, sapphire);
        buttonSapphire.setStyle(JEWEL_BUTTON_STYLE);
        buttonSapphire.setOnMouseEntered(e -> buttonSapphire.setStyle(HOVERED_BUTTON_STYLE));
        buttonSapphire.setOnMouseExited(e -> buttonSapphire.setStyle(JEWEL_BUTTON_STYLE));
        buttonSapphire.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        buttonSapphire.setOnAction((e) ->  {
            jewel.takeSapphire(player);
            player1SapphireLabel.setText(String.valueOf(player1.getJewelCounter().get(Colors.BLUE)));
            player2SapphireLabel.setText(String.valueOf(player2.getJewelCounter().get(Colors.BLUE)));
            buttonSapphire.setText(String.valueOf(jewel.getSapphireCounter()));
        });

        Button buttonOnyx = new Button(onyxCounter, onyx);
        buttonOnyx.setStyle(JEWEL_BUTTON_STYLE);
        buttonOnyx.setOnMouseEntered(e -> buttonOnyx.setStyle(HOVERED_BUTTON_STYLE));
        buttonOnyx.setOnMouseExited(e -> buttonOnyx.setStyle(JEWEL_BUTTON_STYLE));
        buttonOnyx.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        buttonOnyx.setOnAction((e) ->  {
            jewel.takeOnyx(player);
            player1OnyxLabel.setText(String.valueOf(player1.getJewelCounter().get(Colors.BLACK)));
            player2OnyxLabel.setText(String.valueOf(player2.getJewelCounter().get(Colors.BLACK)));
            buttonOnyx.setText(String.valueOf(jewel.getOnyxCounter()));
        });



        Button buttonEmerald = new Button(emeraldCounter, emerald);
        buttonEmerald.setStyle(JEWEL_BUTTON_STYLE);
        buttonEmerald.setOnMouseEntered(e -> buttonEmerald.setStyle(HOVERED_BUTTON_STYLE));
        buttonEmerald.setOnMouseExited(e -> buttonEmerald.setStyle(JEWEL_BUTTON_STYLE));
        buttonEmerald.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        buttonEmerald.setOnAction((e) ->  {
            jewel.takeEmerald(player);
            player1EmeraldLabel.setText(String.valueOf(player1.getJewelCounter().get(Colors.GREEN)));
            player2EmeraldLabel.setText(String.valueOf(player2.getJewelCounter().get(Colors.GREEN)));
            buttonEmerald.setText(String.valueOf(jewel.getEmeraldCounter()));
        });

        Button buttonRuby = new Button(rubyCounter, ruby);
        buttonRuby.setStyle(JEWEL_BUTTON_STYLE);
        buttonRuby.setOnMouseEntered(e -> buttonRuby.setStyle(HOVERED_BUTTON_STYLE));
        buttonRuby.setOnMouseExited(e -> buttonRuby.setStyle(JEWEL_BUTTON_STYLE));
        buttonRuby.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        buttonRuby.setOnAction((e) ->  {
            jewel.takeRuby(player);
            player1RubyLabel.setText(String.valueOf(player1.getJewelCounter().get(Colors.RED)));
            player2RubyLabel.setText(String.valueOf(player2.getJewelCounter().get(Colors.RED)));
            buttonRuby.setText(String.valueOf(jewel.getRubyCounter()));
        });


        jewels.getChildren().addAll(buttonDiamond, buttonOnyx, buttonSapphire, buttonRuby, buttonEmerald);


        //3LevelCards
        draw3LevelCards();
        load3LevelCards();

        card3Level1Button.setOnAction((e) ->  {
            if (cards3LevelRepository.takeCard(player, cards3Level1, 0) == true){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load3LevelCards();
                loadPlayersCardsCounters();
            }
        });

        card3Level1Button.setStyle(BUTTON_STYLE);
        card3Level1Button.setOnMouseEntered(e -> card3Level1Button.setStyle(HOVERED_BUTTON_STYLE));
        card3Level1Button.setOnMouseExited(e -> card3Level1Button.setStyle(BUTTON_STYLE));

        card3Level2Button.setOnAction((e) ->  {
            if (cards3LevelRepository.takeCard(player, cards3Level2, 1) == true){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load3LevelCards();
                loadPlayersCardsCounters();
            }
        });

        card3Level2Button.setStyle(BUTTON_STYLE);
        card3Level2Button.setOnMouseEntered(e -> card3Level2Button.setStyle(HOVERED_BUTTON_STYLE));
        card3Level2Button.setOnMouseExited(e -> card3Level2Button.setStyle(BUTTON_STYLE));

        card3Level3Button.setOnAction((e) ->  {
            if (cards3LevelRepository.takeCard(player, cards3Level3, 2) == true){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load3LevelCards();
                loadPlayersCardsCounters();
            }
        });


        card3Level3Button.setStyle(BUTTON_STYLE);
        card3Level3Button.setOnMouseEntered(e -> card3Level3Button.setStyle(HOVERED_BUTTON_STYLE));
        card3Level3Button.setOnMouseExited(e -> card3Level3Button.setStyle(BUTTON_STYLE));

        card3Level4Button.setOnAction((e) ->  {
            if (cards3LevelRepository.takeCard(player, cards3Level4, 3) == true){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load3LevelCards();
                loadPlayersCardsCounters();
            }
        });

        card3Level4Button.setStyle(BUTTON_STYLE);
        card3Level4Button.setOnMouseEntered(e -> card3Level4Button.setStyle(HOVERED_BUTTON_STYLE));
        card3Level4Button.setOnMouseExited(e -> card3Level4Button.setStyle(BUTTON_STYLE));

        cards3.getChildren().addAll(card3Level1Button, card3Level2Button, card3Level3Button, card3Level4Button);



        //2LevelCards
        draw2LevelCards();
        load2LevelCards();

        card2Level1Button.setOnAction((e) ->  {
            if (cards2LevelRepository.takeCard(player, cards2Level1, 0)){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load2LevelCards();
                loadPlayersCardsCounters();
            }
        });
        card2Level1Button.setStyle(BUTTON_STYLE);
        card2Level1Button.setOnMouseEntered(e -> card2Level1Button.setStyle(HOVERED_BUTTON_STYLE));
        card2Level1Button.setOnMouseExited(e -> card2Level1Button.setStyle(BUTTON_STYLE));


        card2Level2Button.setOnAction((e) ->  {
            if (cards2LevelRepository.takeCard(player, cards2Level2, 1)){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load2LevelCards();
                loadPlayersCardsCounters();
            }
        });
        card2Level2Button.setStyle(BUTTON_STYLE);
        card2Level2Button.setOnMouseEntered(e -> card2Level2Button.setStyle(HOVERED_BUTTON_STYLE));
        card2Level2Button.setOnMouseExited(e -> card2Level2Button.setStyle(BUTTON_STYLE));


        card2Level3Button.setOnAction((e) ->  {
            if (cards2LevelRepository.takeCard(player, cards2Level3, 2)){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load2LevelCards();
                loadPlayersCardsCounters();
            }
        });
        card2Level3Button.setStyle(BUTTON_STYLE);
        card2Level3Button.setOnMouseEntered(e -> card2Level3Button.setStyle(HOVERED_BUTTON_STYLE));
        card2Level3Button.setOnMouseExited(e -> card2Level3Button.setStyle(BUTTON_STYLE));


        card2Level4Button.setOnAction((e) ->  {
            if (cards2LevelRepository.takeCard(player, cards2Level4, 3)){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load2LevelCards();
                loadPlayersCardsCounters();
            }
        });
        card2Level4Button.setStyle(BUTTON_STYLE);
        card2Level4Button.setOnMouseEntered(e -> card2Level4Button.setStyle(HOVERED_BUTTON_STYLE));
        card2Level4Button.setOnMouseExited(e -> card2Level4Button.setStyle(BUTTON_STYLE));

        cards2.getChildren().addAll(card2Level1Button, card2Level2Button, card2Level3Button, card2Level4Button);


        //1LevelCards
        draw1LevelCards();
        load1LevelCards();

        card1Level1Button.setOnAction((e) ->  {
            if (cards1LevelRepository.takeCard(player, cards1Level1, 0)){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load1LevelCards();
                loadPlayersCardsCounters();
            }
        });

        card1Level1Button.setStyle(BUTTON_STYLE);
        card1Level1Button.setOnMouseEntered(e -> card1Level1Button.setStyle(HOVERED_BUTTON_STYLE));
        card1Level1Button.setOnMouseExited(e -> card1Level1Button.setStyle(BUTTON_STYLE));

        card1Level2Button.setOnAction((e) ->  {
            if (cards1LevelRepository.takeCard(player, cards1Level2, 1)){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load1LevelCards();
                loadPlayersCardsCounters();
            }
        });
        card1Level2Button.setStyle(BUTTON_STYLE);
        card1Level2Button.setOnMouseEntered(e -> card1Level2Button.setStyle(HOVERED_BUTTON_STYLE));
        card1Level2Button.setOnMouseExited(e -> card1Level2Button.setStyle(BUTTON_STYLE));

        card1Level3Button.setOnAction((e) ->  {
            if (cards1LevelRepository.takeCard(player, cards1Level3, 2)){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load1LevelCards();
                loadPlayersCardsCounters();
            }
        });

        card1Level3Button.setStyle(BUTTON_STYLE);
        card1Level3Button.setOnMouseEntered(e -> card1Level3Button.setStyle(HOVERED_BUTTON_STYLE));
        card1Level3Button.setOnMouseExited(e -> card1Level3Button.setStyle(BUTTON_STYLE));

        card1Level4Button.setOnAction((e) ->  {
            if (cards1LevelRepository.takeCard(player, cards1Level4, 3)){
                player1NameAndPoints.setText(players.get(0).getName() + ": " + players.get(0).getResult());
                player2NameAndPoints.setText(players.get(1).getName() + ": " + players.get(1).getResult());
                load1LevelCards();
                loadPlayersCardsCounters();
            }
        });

        card1Level4Button.setStyle(BUTTON_STYLE);
        card1Level4Button.setOnMouseEntered(e -> card1Level4Button.setStyle(HOVERED_BUTTON_STYLE));
        card1Level4Button.setOnMouseExited(e -> card1Level4Button.setStyle(BUTTON_STYLE));

        cards1.getChildren().addAll(card1Level1Button, card1Level2Button, card1Level3Button, card1Level4Button);

        //Player1CardsText
        Text player1CardsText = new Text("Cards with jewel");
        player1CardsTextHB.getChildren().add(player1CardsText);
        player1CardsText.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player1CardsText.setFill(Color.valueOf("#D4AF37"));


        //Player2CardsText
        Text player2CardsText = new Text("Cards with jewel");
        player2CardsTextHB.getChildren().add(player2CardsText);
        player2CardsText.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        player2CardsText.setFill(Color.valueOf("#D4AF37"));


        //PlayerCardsCounters
        loadPlayersCardsCounters();

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



        Scene scene = new Scene(grid, 1200, 600, Color.BLUEVIOLET);

        primaryStage.setTitle("Splendor");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    public static void main(String[] args) {

        launch(args);


    }


}

