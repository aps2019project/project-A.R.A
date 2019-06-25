package View.Battle;

import Model.Unit;
import View.JavafxTest;
import View.Sprite.SpriteBase;
import View.Sprite.SpriteType;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class HandView extends StackPane {
    private HBox handCardBox;
    private HandItem selectedItem;

    public HandView(ArrayList<Unit> units) {
        handCardBox = new HBox(-20);
        for (int i = 0; i < 5; i++) {
            Unit unit = units.get(i);
            handCardBox.getChildren().add(new HandItem(unit));
        }
        Unit unit = units.get(5);
        HandItem nextCard = new HandItem(unit.getName());
        handCardBox.getChildren().add(nextCard);
        HBox.setHgrow(handCardBox, Priority.ALWAYS);
        this.getChildren().add(handCardBox);
    }

    public void setSelectedItem(HandItem selectedItem) {
        this.selectedItem = selectedItem;
        for (int i = 0; i< 5; i++){
            ((HandItem) handCardBox.getChildren().get(i)).setHighlighted(false);
        }
        selectedItem.setHighlighted(true);
    }
}

class HandItem extends StackPane {
    private Unit unit;
    private Image bgImage;
    private Image bgImageHighlight;
    private ImageView bgImageView;
    private Image manaImage;
    private ImageView manaImageView;
    private Label manaLabel;
    private GameCard gameCard;
    private boolean selected = false;


    HandItem(Unit unit) { // String unitID, int mana, String description
        this.getStylesheets().add("View/Battle/css.css");
        this.unit = unit;
        initGameCard();
        initBG(true);
        initSprite();
        initManaIcon();
        initManaLabel();
        initOnMouseEnteredSetting();
        initOnMousePressedSetting();
        setActive(true);
    }

    // todo implementation not complete
    HandItem(String unitId) { // String unit id --- >  for the next card which can't be used at the moment.
        this.getStylesheets().add("View/Battle/css.css");
        this.setMinHeight(236.8);
        this.setMinWidth(180.8);
        initBG(false);
    }

    private void initSprite(){
        ImageView spriteImageView = SpriteBase.getInstance().get(SpriteType.MINION, unit.getName());
        this.getChildren().add(spriteImageView);
    }

    private void initBG(boolean inUse) {
        bgImage = new Image(inUse ? "View/resource/Battle/card_background.png" : "View/resource/Battle/card_background_disabled.png");
        bgImageHighlight = new Image("View/resource/Battle/card_background_highlight.png");
        bgImageView = new ImageView(bgImage);
        this.getChildren().add(bgImageView);
    }

    private void initManaIcon() {
        manaImage = new Image("View/resource/Battle/icon_mana.png");
        manaImageView = new ImageView(manaImage);
        manaImageView.setFitWidth(manaImage.getWidth() / 1.5);
        manaImageView.setFitHeight(manaImage.getHeight() / 1.5);
        manaImageView.setTranslateY(60);
        this.getChildren().add(manaImageView);
    }

    private void initManaLabel() {
        manaLabel = new Label(String.valueOf(unit.getMana()));
        manaLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        manaLabel.setTranslateY(60);
        manaLabel.setLabelFor(manaImageView);
        this.getChildren().add(manaLabel);
    }

    private void initGameCard() {
        gameCard = new GameCard(unit.getName(), unit.getDesc());
        gameCard.setTranslateY(-180);
        gameCard.setVisible(false);
        this.getChildren().add(gameCard);
    }

    private void initOnMouseEnteredSetting() {
        bgImageView.setOnMouseEntered(e -> gameCard.setVisible(true));
        bgImageView.setOnMouseExited(e -> gameCard.setVisible(false));
    }

    private void initOnMousePressedSetting() {
        bgImageView.setOnMousePressed(e -> {
            setHighlighted(!selected);
            if(selected)
                JavafxTest.battleMenu.getHandView().setSelectedItem(this);
        });
    }

    private void setActive(boolean active) {
        if (active) {
            manaImageView.setEffect(null);
            manaLabel.setTextFill(Color.valueOf("#367cc1"));
        } else {
            SepiaTone sepiaTone = new SepiaTone(0.66);
            sepiaTone.setInput(new ColorAdjust(0, 0.5, 0, 0));
            manaImageView.setEffect(sepiaTone);
            manaLabel.setTextFill(Color.valueOf("#586a82"));
        }
    }

    public void setHighlighted(boolean highlighted) {
        selected = highlighted;
        if (highlighted) {
            bgImageView.setImage(bgImageHighlight);
        } else bgImageView.setImage(bgImage);
    }

    private void setUserMana(int currentUserMana) {
        setActive(currentUserMana > unit.getMana());
    }
}

class GameCard extends StackPane {

    // todo gif initialization not considered
    GameCard(String itemName, String description) {
        Image bgImage = new Image("View/resource/Battle/craftable_artifact.png");
        ImageView bgImageView = new ImageView(bgImage);
        bgImageView.setFitHeight(bgImage.getHeight() / 1.25);
        bgImageView.setFitWidth(bgImage.getWidth() / 1.25);
        this.getChildren().add(bgImageView);
        // setAvatar or gif

        Label unitName = new Label(itemName.toUpperCase());
        unitName.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        unitName.setTextFill(Color.WHITE);
        Glow glow = new Glow(0.7);
        MotionBlur blur = new MotionBlur(40, 2);
        glow.setInput(blur);
        blur.setInput(new InnerShadow(2, Color.BLACK));
        unitName.setEffect(glow);
        unitName.setTranslateY(0);
        this.getChildren().add(unitName);

        Label descLabel = new Label(description);
        descLabel.setFont(Font.font("Arial", FontWeight.THIN, 10));
        descLabel.setTextFill(Color.GRAY);
        descLabel.setEffect(new MotionBlur(40, 1));
        descLabel.setWrapText(true);
        descLabel.setTextAlignment(TextAlignment.CENTER);
        descLabel.setMaxWidth(130);
        descLabel.setTranslateY(70);
        this.getChildren().add(descLabel);
    }
}
