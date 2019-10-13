package com.kodilla.splendor.Services;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InstructionsService {

    public void displayInstructions() {

        final Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Instructions");
        window.setMaxWidth(900);

        Label infoLabel = new Label("Splendor\n" +
                "\n" +
                "Use your wealth to purchase developments and attract nobles to gain prestige and influence as a wealthy Renaissance merchant. \n"+
                "\n" +
                "Each player may perform only one of three actions per turn. The three possible actions:\n" +
                " -Take 3 gem tokens of different colors.\n" +
                " -Take 2 gem tokens of the same color, but there must be at least 4 of the same color token for a player to perform this action on that chosen color.\n" +
                " -Pay the purchase price of 1 development card from the face-up cards or from a reserved card in your hand.\n" +
                "\n" +
                "A player may never have more than 10 tokens at the end of their turn; if they do have more than 10 tokens then they must return any number of tokens until their pile is reduced back down to 10 tokens. " +
                "A player may return any number of the tokens that they have just drawn.\n" +
                "Development and noble cards are worth prestige points, of which you need fifteen prestige points to win.\n"+
                "\n" +
                "Development cards have a cost (bottom left) which must be played before a player may ‘own’ the card and receive its resource bonus (top right) and prestige value (top left). Resource bonuses listed on development cards are used to reduce the purchase cost of future development cards and to attract nobles to your business.\n" +
                "Development cards have a “difficulty” level represented by the 1, 2, or 3 circles along their bottom. This difficulty represents the cost to build these developments, as well as their potential value when purchased.\n" +
                "\n" +
                "Noble tiles have a “value” that must be achieved before they are “attracted” to your business. The first player, by the end of their turn, with the correct resource bonuses (from their developments) wins the noble. " +
                "Each noble is worth 3 prestige points, and only one noble may be won per turn; if a player might have won more than one in a single turn, then they may choose the noble they wish and may still win the other noble if it is not taken by the next turn.\n" +
                "\n" +
                "Winning the Game\n" +
                "Play continues until a player reaches 15 points. The remaining players may then finish out their final turns and the player with the most points at the end of the final round wins the game.");
        infoLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        infoLabel.setWrapText(true);
        infoLabel.setMaxWidth(800);
        infoLabel.setTextFill(Color.valueOf("#D4AF37"));

        VBox infoVbox = new VBox(10);
        infoVbox.setStyle("-fx-background-color : black;");
        infoVbox.setAlignment(Pos.CENTER);
        infoVbox.setPadding(new Insets(10, 50, 50, 50));
        infoVbox.getChildren().addAll(infoLabel);

        ScrollPane scrollPane = new ScrollPane(infoVbox);
        scrollPane.setContent(infoVbox);
        scrollPane.setPannable(true);

        Scene infoScene = new Scene(scrollPane);
        window.setScene(infoScene);
        window.showAndWait();

    }
}
