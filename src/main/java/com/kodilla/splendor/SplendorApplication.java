package com.kodilla.splendor;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class SplendorApplication extends Application {

    private Image imageback = new Image("nathan-anderson-505933-unsplash.jpg");


    private FlowPane jewels = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane aristocrats = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane player1Jewels = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane player2Jewels = new FlowPane(Orientation.HORIZONTAL);


    private HBox cards3 = new HBox();
    private HBox cards2 = new HBox();
    private HBox cards1 = new HBox();
    private HBox player1Aristocrats = new HBox();
    private HBox player2Aristocrats = new HBox();

    private Text player1Name = new Text();
    private Text player2Name = new Text();
    private Text player1Points = new Text();
    private Text player2Points = new Text();

    public static void main(String[] args) {
        launch(args);
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
        grid.setHgap(5.5);
        grid.setVgap(15);
        grid.setBackground(background);


        jewels.setAlignment(Pos.BOTTOM_CENTER);
        aristocrats.setAlignment(Pos.TOP_CENTER);
        player1Jewels.setAlignment(Pos.BOTTOM_CENTER);
        player2Jewels.setAlignment(Pos.BOTTOM_CENTER);
        player1Aristocrats.setAlignment(Pos.TOP_LEFT);
        player2Aristocrats.setAlignment(Pos.TOP_RIGHT);

        grid.add(aristocrats, 2, 0, 1, 1);
        grid.add(cards1, 2, 1, 1, 1);
        grid.add(cards2, 2, 2, 1, 1);
        grid.add(cards3, 2, 3, 1, 1);
        grid.add(jewels, 2, 4, 1, 1);
        grid.add(player1Name, 0, 0, 1, 1);
        grid.add(player2Name, 3, 0, 1, 1);
        grid.add(player1Points, 1, 0, 1, 1);
        grid.add(player2Points, 4, 0, 1, 1);
        grid.add(player1Jewels, 0, 4, 2, 1);
        grid.add(player2Jewels, 3, 4, 2, 1);
        grid.add(player1Aristocrats, 0, 1, 2, 1);
        grid.add(player2Aristocrats, 3, 1, 2, 1);



        Aristocrats aristocrat = new Aristocrats();

        Button aristocrat1 = new Button("", aristocrat.getAnna());
        Button aristocrat2 = new Button("", aristocrat.getHenry());
        Button aristocrat3 = new Button("", aristocrat.getCharles());
        aristocrats.getChildren().addAll(aristocrat1, aristocrat2, aristocrat3);

        player1Aristocrats.getChildren().addAll(aristocrat.anna, aristocrat.catherine, aristocrat.niccolo);
        player2Aristocrats.getChildren().addAll(aristocrat.isabella, aristocrat.francis, aristocrat.mary);

        Jewel jewel = new Jewel();

        Button buttonDiamond = new Button("", jewel.getDiamond());
        Button buttonOnyx = new Button("", jewel.getOnyx());
        Button buttonSaphire = new Button("", jewel.getSapphire());
        Button buttonRuby = new Button("", jewel.getRuby());
        Button buttonEmerald = new Button("", jewel.getEmerald());
        Button buttonGold = new Button("", jewel.getGold());

        jewels.getChildren().addAll(buttonDiamond, buttonOnyx, buttonSaphire, buttonRuby, buttonEmerald, buttonGold);
        player1Jewels.getChildren().addAll(jewel.sapphire, jewel.diamond, jewel.gold, jewel.onyx);
        player2Jewels.getChildren().addAll(jewel.ruby, jewel.emerald);


        Cards3Level card3Level = new Cards3Level();

        Button blue3White3Green3Black5 = new Button("", card3Level.getBlue3White3Green3Black5());
        Button blue4White6Blue3Black3 = new Button("", card3Level.getBlue4White6Blue3Black3());
        Button blue4White7 = new Button("", card3Level.getBlue4White7());
        Button blue5Blue3White = new Button("", card3Level.getBlue5Blue3White());
        cards3.getChildren().addAll(blue3White3Green3Black5, blue4White6Blue3Black3, blue4White7, blue5Blue3White);


        Cards2Level card2Level = new Cards2Level();

        Button blue3White3Green3Black52 = new Button("", card2Level.getBlue3White3Green3Black5());
        Button blue4White6Blue3Black32 = new Button("", card2Level.getBlue4White6Blue3Black3());
        Button blue4White72 = new Button("", card2Level.getBlue4White7());
        Button blue5Blue3White2 = new Button("", card2Level.getBlue5Blue3White());
        cards2.getChildren().addAll(blue3White3Green3Black52, blue4White6Blue3Black32, blue4White72, blue5Blue3White2);

        Cards1Level card1Level = new Cards1Level();

        Button blue3White3Green3Black51 = new Button("", card1Level.getBlue3White3Green3Black5());
        Button blue4White6Blue3Black31 = new Button("", card1Level.getBlue4White6Blue3Black3());
        Button blue4White71 = new Button("", card1Level.getBlue4White7());
        Button blue5Blue3White1 = new Button("", card1Level.getBlue5Blue3White());
        cards1.getChildren().addAll(blue3White3Green3Black51, blue4White6Blue3Black31, blue4White71, blue5Blue3White1);

        player1Name.setText("Irek");
        player1Name.setTextAlignment(TextAlignment.LEFT);
        player1Name.setStyle("-fx-fill: #d19935; -fx-font: normal bold 50px 'serif' ");
        player2Name.setText("Madzia");
        player2Name.setStyle("-fx-fill: #d19935; -fx-font: normal bold 50px 'serif' ");
        player2Name.setTextAlignment(TextAlignment.RIGHT);
        player1Points.setText("12");
        player1Points.setStyle("-fx-fill: #d19935; -fx-font: normal bold 60px 'serif' ");
        player1Points.setTextAlignment(TextAlignment.LEFT);
        player2Points.setText("10");
        player2Points.setStyle("-fx-fill: #d19935; -fx-font: normal bold 60px 'serif' ");
        player2Points.setTextAlignment(TextAlignment.RIGHT);

        Scene scene = new Scene(grid, 1200, 600, Color.BLUEVIOLET);

        primaryStage.setTitle("Splendor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

