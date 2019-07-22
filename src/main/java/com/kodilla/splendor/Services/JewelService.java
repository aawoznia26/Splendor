package com.kodilla.splendor.Services;

import com.kodilla.splendor.Player;
import com.kodilla.splendor.Repository.JewelRepository;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JewelService {

    private JewelRepository jewelRepository;
    private PlayerService playerService;
    private Player player;

    private HBox jewels = new HBox();
    private HBox player1Jewels = new HBox();
    private HBox player2Jewels = new HBox();

    private HBox player1JewelsTextHB = new HBox();
    private HBox player2JewelsTextHB = new HBox();
    private List<HBox> playersJewelTextHBList = new ArrayList<>(Arrays.asList(player1JewelsTextHB, player2JewelsTextHB));

    public JewelService(JewelRepository jewelRepository, PlayerService playerService, Player player) {
        this.jewelRepository = jewelRepository;
        this.playerService = playerService;
        this.player = player;
    }

    final String JEWEL_BUTTON_STYLE = "-fx-background-color: transparent; -fx-text-fill: #D4AF37;";
    final String HOVERED_BUTTON_STYLE = "-fx-background-color: rgba(212,175,55,0.5);";

    public HBox getJewels() {
        return jewels;
    }

    public HBox getPlayer1Jewels() {
        return player1Jewels;
    }

    public HBox getPlayer2Jewels() {
        return player2Jewels;
    }

    public HBox getPlayer1JewelsTextHB() {
        return player1JewelsTextHB;
    }

    public HBox getPlayer2JewelsTextHB() {
        return player2JewelsTextHB;
    }


    public void loadJewels(Player player) {
        jewels.getChildren().clear();
        jewelRepository.getJewelList().stream()
                .forEach(a -> {
                    Button jewelButton = new Button(String.valueOf(a.getNumber()), new ImageView(a.getView().getImage()));
                    jewelButton.setStyle(JEWEL_BUTTON_STYLE);
                    jewelButton.setOnMouseEntered(e -> jewelButton.setStyle(HOVERED_BUTTON_STYLE));
                    jewelButton.setOnMouseExited(e -> jewelButton.setStyle(JEWEL_BUTTON_STYLE));
                    jewelButton.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
                    jewelButton.setOnAction((e) ->
                    {
                        jewelRepository.takeJewel(player, a.getColor());
                        loadPlayersJewelCounters();
                        jewelButton.setText(String.valueOf(a.getNumber()));
                    });
                    jewels.getChildren().add(jewelButton);
                });
        jewels.setAlignment(Pos.BOTTOM_CENTER);
        jewels.setPrefWidth(500);
    }


    public void loadPlayersJewelCounters() {

        player1Jewels.getChildren().clear();
        player2Jewels.getChildren().clear();

        for (int i = 0; i < playersJewelTextHBList.size(); i++) {
            playersJewelTextHBList.get(i).getChildren().clear();
            Text playerJewelsText = new Text("Jewels");
            playersJewelTextHBList.get(i).getChildren().add(playerJewelsText);
            playerJewelsText.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
            playerJewelsText.setFill(Color.valueOf("#D4AF37"));
            playersJewelTextHBList.get(i).setAlignment(Pos.CENTER);
        }
        player1Jewels.setAlignment(Pos.BOTTOM_CENTER);
        player2Jewels.setAlignment(Pos.BOTTOM_CENTER);

        jewelRepository.getJewelList().stream()
                .forEach(a -> {
                    ImageView player1JewelView = new ImageView();
                    player1JewelView.setImage(a.getView().getImage());
                    Label player1JewelCounter = new Label(String.valueOf(playerService.getPlayers().get(0)
                            .getJewelCounter().get(a.getColor())), player1JewelView);
                    player1JewelCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
                    player1JewelCounter.setTextFill(Color.web("#D4AF37"));
                    player1Jewels.getChildren().add(player1JewelCounter);

                    ImageView player2JewelView = new ImageView();
                    player2JewelView.setImage(a.getView().getImage());
                    Label player2JewelCounter = new Label(String.valueOf(playerService.getPlayers().get(1)
                            .getJewelCounter().get(a.getColor())), player2JewelView);
                    player2JewelCounter.setFont(Font.loadFont("file:src/main/resources/AurelisADFNo2Std-Italic_1.ttf", 30));
                    player2JewelCounter.setTextFill(Color.web("#D4AF37"));
                    player2Jewels.getChildren().add(player2JewelCounter);
                });
    }
}
