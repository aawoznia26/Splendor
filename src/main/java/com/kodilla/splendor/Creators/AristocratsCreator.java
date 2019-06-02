package com.kodilla.splendor.Creators;

import com.kodilla.splendor.Aristocrats;
import com.kodilla.splendor.Player;
import com.kodilla.splendor.Repository.AristocratsRepository;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class AristocratsCreator {

    private HBox aristocrats = new HBox();
    private AristocratsRepository aristocratsRepository = new AristocratsRepository();
    private int numberOfAristocrates = 3;
    private int aristocratsTaken = 0;

    private Player player;

    public AristocratsCreator(Player player) {
        this.player = player;
    }

    private final String BUTTON_STYLE = "-fx-background-color: transparent;";
    private final String HOVERED_BUTTON_STYLE = "-fx-background-color: rgba(212,175,55,0.5);";

    public HBox getAristocrats() {
        return aristocrats;
    }

    public void drawAristocrates() {
        aristocratsRepository.drawThreeAristocrats();
    }

    public void loadAristocrats(Player player) {
        aristocratsRepository.drawThreeAristocrats();
        try {

            for(int i = 0; i < numberOfAristocrates; i++){
                Aristocrats aristocrat = aristocratsRepository.getThreeAristocratsList().get(i);
                ImageView aristocratImgView = aristocrat.getView();
                Button aristocratButton = new Button();
                aristocratButton.setGraphic(aristocratImgView);

                aristocratImgView.setFitWidth(150);
                aristocratImgView.setFitHeight(150);


                aristocratButton.setStyle(BUTTON_STYLE);
                aristocratButton.setOnMouseEntered(e -> aristocratButton.setStyle(HOVERED_BUTTON_STYLE));
                aristocratButton.setOnMouseExited(e -> aristocratButton.setStyle(BUTTON_STYLE));
                aristocratButton.setOnAction((e) -> {
                    if (aristocratsRepository.takeAristocrat(player, aristocrat)) {
                        //loadPlayersAristocrats();
                        //loadAristocrats(player);
                        aristocratsTaken += 1;
                    }
                });
                aristocrats.getChildren().add(aristocratButton);
            }

        } catch (NullPointerException e) {
            System.out.println("No more aristocrats to take");
        }
    }


/*    public void loadPlayersAristocrats() {
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
    }*/


}
