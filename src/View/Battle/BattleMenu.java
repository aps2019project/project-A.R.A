package View.Battle;

import Controller.Controller;
import View.JavafxTest;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;


public class BattleMenu extends BorderPane {
    private Scene scene;
    private HandView handView;
    private HBox bottomBox;
    private PlayerStatusView player1;
    private PlayerStatusView player2;
    private StackPane cardStatus;


    public BattleMenu() {
        scene = new Scene(this, JavafxTest.stage.getWidth(), JavafxTest.stage.getHeight());
        scene.getStylesheets().add("View/Battle/css.css");
        this.setId("pane");

        initPlayerBar();
        this.setCenter(new BattleMap());


        this.setRight(new GraveYardView(new ArrayList<>()));

        handView = new HandView(Controller.getInstance().getHandCards());
        bottomBox = new HBox(50);
        bottomBox.getChildren().add(handView);
        bottomBox.setTranslateY(-200);
        initButtonBox();
        this.setBottom(bottomBox);

        initCardStatusSection();
    }

    private void initPlayerBar() {
        player1 = new PlayerStatusView(Controller.getInstance().getOwnPlayerStatus(), true);
        player2 = new PlayerStatusView(Controller.getInstance().getOpponentStatus(), false);

        HBox playerBar = new HBox(320);
        playerBar.getChildren().addAll(player1, player2);
        playerBar.setPadding(new Insets(-20, 0, 0, 0));
        this.setTop(playerBar);
    }

    // todo not completed
    private void initButtonBox() {
        VBox buttons = new VBox(0);
        BattleButton battleButton = new BattleButton("End Turn", "View/resource/Battle/button_end_turn_finished.png");
        // setOnMousePressed()

        HBox bottomButtons = new HBox(5);
        BattleButton menuBt = new BattleButton("Menu", "View/resource/Battle/button_primary_left_glow.png");
        BattleButton graveYardBt = new BattleButton("Grave Yard", "View/resource/Battle/button_primary_right.png");
        bottomButtons.getChildren().addAll(menuBt, graveYardBt);

        buttons.getChildren().addAll(battleButton, bottomButtons);
        bottomBox.getChildren().add(buttons);
    }

    private void initCardStatusSection() {
        cardStatus = new StackPane();
        cardStatus.setPadding(new Insets(-100, 0, 100, 50));
        this.setLeft(cardStatus);
    }

    void setVisibleCardStatus(GameCard gameCard) {
        this.setLeft(gameCard);
        gameCard.setPadding(new Insets(-100, 0, 100, 50));
    }

    public HandView getHandView() {
        return handView;
    }

    public Scene getMenuScene() {
        return scene;
    }
}
