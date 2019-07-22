package com.kodilla.splendor.Services;

import com.kodilla.splendor.Aristocrats;
import com.kodilla.splendor.Player;
import com.kodilla.splendor.Repository.AristocratsRepository;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AristocratsService {

    private AristocratsRepository aristocratsRepository;
    private PlayerService playerService;
    private Player player;

    private int numberOfAristocrates = 3;

    private HBox aristocrats = new HBox();
    private HBox player1Aristocrats = new HBox();
    private HBox player2Aristocrats = new HBox();
    private List<HBox> playersAristocratesHBList = new ArrayList<>(Arrays.asList(player1Aristocrats, player2Aristocrats));
    private final String BUTTON_STYLE = "-fx-background-color: transparent;";
    private final String HOVERED_BUTTON_STYLE = "-fx-background-color: rgba(212,175,55,0.5);";

    public AristocratsService(AristocratsRepository aristocratsRepository, PlayerService playerService, Player player) {
        this.aristocratsRepository = aristocratsRepository;
        this.playerService = playerService;
        this.player = player;
    }

    public HBox getAristocrats() {
        return aristocrats;
    }

    public HBox getPlayer1Aristocrats() {
        return player1Aristocrats;
    }

    public HBox getPlayer2Aristocrats() {
        return player2Aristocrats;
    }

    public void initialAristocratsLoad(Player player) {
        aristocratsRepository.drawThreeAristocrats();
        loadAristocrats(player);
        loadPlayersAristocrats();

    }

    public void loadAristocrats(Player player) {
        for (int i = 0; i < numberOfAristocrates; i++) {
            Aristocrats aristocrat = aristocratsRepository.getThreeAristocratsList().get(i);
            ImageView aristocratImgView = aristocrat.getView();
            Button aristocratButton = new Button();
            aristocratButton.setGraphic(aristocratImgView);

            try {
                aristocratImgView.setFitWidth(150);
                aristocratImgView.setFitHeight(150);

                aristocratButton.setStyle(BUTTON_STYLE);
                aristocratButton.setOnMouseEntered(e -> aristocratButton.setStyle(HOVERED_BUTTON_STYLE));
                aristocratButton.setOnMouseExited(e -> aristocratButton.setStyle(BUTTON_STYLE));
                aristocratButton.setOnAction((e) -> {
                    if (aristocratsRepository.takeAristocrat(player, aristocrat)) {
                        aristocrats.getChildren().clear();
                        loadPlayersAristocrats();
                        playerService.loadPlayersAtributes();
                        loadAristocrats(player);
                    }
                });
                aristocrats.getChildren().add(aristocratButton);

            } catch (NullPointerException e) {
                System.out.println("No more Aristocrates to take");
            }

        }
        aristocrats.setAlignment(Pos.TOP_CENTER);
        aristocrats.setPrefWidth(500);
    }


    public void loadPlayersAristocrats() {
        player1Aristocrats.getChildren().clear();
        player2Aristocrats.getChildren().clear();

        for (int i = 0; i < playersAristocratesHBList.size(); i++) {
            HBox playersAristocratesHB = playersAristocratesHBList.get(i);
            playerService.getPlayers().get(i).getAristocrats().stream()
                    .forEach(a -> {
                        ImageView playerAristocrat = new ImageView();
                        playerAristocrat.setImage(a.getView().getImage());
                        playerAristocrat.setFitWidth(150);
                        playerAristocrat.setFitHeight(150);
                        playersAristocratesHB.getChildren().add(playerAristocrat);
                    });
            playersAristocratesHB.setAlignment(Pos.CENTER);
            playersAristocratesHB.setPrefWidth(400);
            playersAristocratesHB.setPrefHeight(250);
        }
    }
}