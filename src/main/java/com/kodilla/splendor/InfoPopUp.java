package com.kodilla.splendor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InfoPopUp {

    public void display(String title, String message){

        final Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(300);


        Label infoLabel = new Label(message);
        infoLabel.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
        infoLabel.setTextFill(Color.valueOf("#D4AF37"));

        VBox infoVbox = new VBox(10);
        infoVbox.setStyle("-fx-background-color : black;");
        infoVbox.setAlignment(Pos.CENTER);
        infoVbox.setPadding(new Insets(10, 50, 10, 50));
        infoVbox.getChildren().add(infoLabel);

        Scene infoScene = new Scene(infoVbox);
        window.setScene(infoScene);
        window.showAndWait();

    }


}
