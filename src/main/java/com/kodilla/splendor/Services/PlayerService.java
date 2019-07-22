package com.kodilla.splendor.Services;

import com.kodilla.splendor.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerService {

    private List<Player> players = new ArrayList<>();
    private Player player1;
    private Player player2;
    private Player playingPlayer;
    private HBox player1NameAndPointsHB = new HBox();
    private HBox player2NameAndPointsHB = new HBox();
    private List<HBox> nameAndPointsHBList = new ArrayList<>(Arrays.asList(player1NameAndPointsHB, player2NameAndPointsHB));

    public PlayerService() {
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayingPlayer() {
        return playingPlayer;
    }

    public HBox getPlayer1NameAndPointsHB() {
        return player1NameAndPointsHB;
    }

    public HBox getPlayer2NameAndPointsHB() {
        return player2NameAndPointsHB;
    }

    public void create(String player1Name, String player2Name) {

        player1 = new Player(player1Name, 0);
        player2 = new Player(player2Name, 0);
        players.add(0, player1);
        players.add(1, player2);
        playingPlayer = player1;
    }

    public void createPlayers() {

        final Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Players");
        window.setMinWidth(250);
        window.setMinHeight(300);

        Label infoLabel = new Label("Please enter players names");
        infoLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        infoLabel.setTextFill(Color.valueOf("#D4AF37"));

        TextField player1Name = new TextField("Player 1");
        TextField player2Name = new TextField("Player 2");

        Button confirm = new Button();
        confirm.setText("OK");
        confirm.setMinSize(50, 20);
        confirm.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 15));
        confirm.setTextFill(Color.valueOf("#D4AF37"));
        confirm.setStyle("-fx-background-color : rgba(139, 0, 0, 1);");
        confirm.setOnAction(e -> {
                    create(player1Name.getText(), player2Name.getText());
                    window.close();
                }
        );

        VBox infoVbox = new VBox(10);
        infoVbox.setStyle("-fx-background-color : black;");
        infoVbox.setAlignment(Pos.CENTER);
        infoVbox.setPadding(new Insets(10, 50, 10, 50));
        infoVbox.getChildren().addAll(infoLabel, player1Name, player2Name, confirm);

        Scene infoScene = new Scene(infoVbox);
        window.setScene(infoScene);
        window.showAndWait();

    }

    public Player switchPlayer(Player playingPlayer) {

        if (playingPlayer == player1) {
            playingPlayer = player2;
        } else {
            playingPlayer = player1;
        }

        return playingPlayer;
    }

    public void loadPlayersAtributes() {

        player1NameAndPointsHB.getChildren().clear();
        player2NameAndPointsHB.getChildren().clear();

        for (int i = 0; i < nameAndPointsHBList.size(); i++) {
            Text playerNameAndPoints = new Text();
            playerNameAndPoints.setText(players.get(i).getName() + ": " + players.get(i).getResult());
            playerNameAndPoints.setTextAlignment(TextAlignment.CENTER);
            playerNameAndPoints.setWrappingWidth(300);
            playerNameAndPoints.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 50));
            playerNameAndPoints.setFill(Color.valueOf("#D4AF37"));
            nameAndPointsHBList.get(i).setAlignment(Pos.TOP_CENTER);
            nameAndPointsHBList.get(i).getChildren().add(playerNameAndPoints);
        }
    }
}
