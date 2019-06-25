package View.Battle;

import Model.Unit;
import View.JavafxTest;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.util.ArrayList;

public class GraveYardView extends StackPane {
    private ListView<GraveyardItem> listView;
    private ImageView expandImageView;
    private ImageView collapseImageView;
    private boolean expanded = false;

    // todo wrong array type passed
    public GraveYardView(ArrayList<Unit> units) {
        this.setTranslateX(120);
        initBG();
        initButtons();
        initListView(units);
    }

    private void initBG() {
        Image bgImage = new Image("View/resource/Graveyard/grave-yard-bg.png");
        ImageView bgImageView = new ImageView(bgImage);
        bgImageView.setFitWidth(bgImage.getWidth() * 1.25);
        bgImageView.setFitHeight(bgImage.getHeight() * 1.25);
        this.getChildren().add(bgImageView);
    }

    private void initButtons() {
        Image expandImage = new Image("View/resource/Graveyard/graveyard-button-expand.png");
        Image collapseImage = new Image("View/resource/Graveyard/graveyard-button-collapse.png");
        expandImageView = new ImageView(expandImage);
        collapseImageView = new ImageView(collapseImage);
        expandImageView.setFitWidth(expandImageView.getImage().getWidth() / 1.5);
        expandImageView.setFitHeight(expandImageView.getImage().getHeight() / 1.5);
        expandImageView.setTranslateX(-30);
        expandImageView.setTranslateY(155);
        this.getChildren().add(expandImageView);

        collapseImageView.setFitWidth(collapseImageView.getImage().getWidth() / 1.5);
        collapseImageView.setFitHeight(collapseImageView.getImage().getHeight() / 1.5);
        collapseImageView.setTranslateX(-30);
        collapseImageView.setTranslateY(155);
        collapseImageView.setVisible(false);
        this.getChildren().add(collapseImageView);

        Image titleImage = new Image("View/resource/Graveyard/GraveYard .png");
        ImageView titleImageView = new ImageView(titleImage);
        titleImageView.setFitHeight(titleImage.getHeight() / 2.7);
        titleImageView.setFitWidth(titleImage.getWidth() / 2.7);
        titleImageView.setTranslateX(-35);
        titleImageView.setTranslateY(90);
        Glow glow = new Glow(1);
        glow.setInput(new DropShadow(5, Color.BLACK));
        titleImageView.setEffect(glow);
        titleImageView.setRotate(-90);

        this.setOnMousePressed(e -> {
            expand();
        });
        this.getChildren().add(titleImageView);
    }

    private void initListView(ArrayList<Unit> units) {
        listView = new ListView<>();
        listView.setOrientation(Orientation.VERTICAL);
        listView.setStyle("-fx-background-color: transparent");
        for (Unit unit : units) {
            GraveyardItem item = new GraveyardItem(unit);
            item.setMaxHeight(90);
            item.setMaxWidth(30);
            listView.getItems().add(item);
        }
        listView.setMaxSize(120, 500);
        listView.setTranslateX(40);
        this.getChildren().add(listView);
    }

    private void expand() {
        expanded = !expanded;
        collapseImageView.setVisible(true);
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), this);
        transition.setToX(expanded ? 2 : 120);
        transition.play();
        FadeTransition expandFadeTransition = new FadeTransition(Duration.millis(1000), expandImageView);
        expandFadeTransition.setFromValue(expanded ? 1 : 0);
        expandFadeTransition.setToValue(expanded ? 0 : 1);
        expandFadeTransition.play();

        FadeTransition collapseFadeTransition = new FadeTransition(Duration.millis(1000), collapseImageView);
        collapseFadeTransition.setFromValue(expanded ? 0 : 1);
        collapseFadeTransition.setToValue(expanded ? 1 : 0);
        collapseFadeTransition.play();
    }

    // todo not implemented
    void update(){
//        units = Controller.getDeadCards();
    }
}

class GraveyardItem extends StackPane {
    private GameCard gameCard;

    GraveyardItem(Unit unit) {
        Image bgImage = new Image("View/resource/Battle/card_background_disabled.png");
        ImageView bgImageView = new ImageView(bgImage);
        bgImageView.setFitHeight(bgImage.getHeight() / 1.5);
        bgImageView.setFitWidth(bgImage.getWidth() / 1.5);

        gameCard = new GameCard(unit.getName(), unit.getDesc());
        gameCard.setVisible(false);
        this.getChildren().add(bgImageView);


        // todo set relation with another view class via controller
        this.setOnMouseEntered(e -> {
            JavafxTest.battleMenu.setVisibleCardStatus(gameCard);
            gameCard.setVisible(true);
        });
        this.setOnMouseExited(e->gameCard.setVisible(false));
    }
}
