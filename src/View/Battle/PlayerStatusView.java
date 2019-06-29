package View.Battle;

import Client.PlayerStatus;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.Collections;


public class PlayerStatusView extends StackPane {
    private HBox mainLayout;
    private VBox rightLayout;
    private PlayerAvatar avatar;
    private HBox manaRow;
    private Image manaImage;
    private Image manaInactiveImage;
    private boolean leftHanded;

    PlayerStatusView(PlayerStatus player, boolean leftHanded) {
        this.leftHanded = leftHanded;
        mainLayout = new HBox();
        rightLayout = new VBox(15);
        rightLayout.setPadding(new Insets(60, 0, 0, 0));
        avatar = new PlayerAvatar(player.getName(), player.getInitialHp());
        initPlayerName(player.getName());
        initManaRow(player.getInitialMana());

        if (leftHanded) {
            mainLayout.getChildren().add(avatar);
            mainLayout.getChildren().add(rightLayout);
            rightLayout.setAlignment(Pos.CENTER_LEFT);
        } else {
            mainLayout.getChildren().add(rightLayout);
            mainLayout.getChildren().add(avatar);
            rightLayout.setAlignment(Pos.CENTER_RIGHT);
        }

        this.getChildren().add(mainLayout);
    }

    private void initPlayerName(String playerName) {
        Label PlayerNameLabel = new Label(playerName);
        PlayerNameLabel.setFont(Font.font("Arial", FontWeight.LIGHT, 30));
        PlayerNameLabel.setTextFill(Color.WHITE);
        MotionBlur shadow = new MotionBlur(30, 2);
        shadow.setInput(new Glow(1));
        PlayerNameLabel.setEffect(shadow);
        rightLayout.getChildren().add(PlayerNameLabel);
    }

    private void initManaRow(int mana) {
        manaRow = new HBox(0);
        manaImage = new Image("View/resource/Battle/icon_mana.png");
        manaInactiveImage = new Image("View/resource/Battle/icon_mana_inactive.png");
        updateMana(mana);
        rightLayout.getChildren().add(manaRow);
    }

    private void updateManaRow(int mana) {
        manaRow.getChildren().clear();
        ArrayList<ImageView> imageViewArrayList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ImageView manaImageView = new ImageView(i < mana ? manaImage : manaInactiveImage);
            manaImageView.setFitWidth(manaImageView.getImage().getWidth() / 1.5);
            manaImageView.setFitHeight(manaImageView.getImage().getHeight() / 1.5);
            imageViewArrayList.add(manaImageView);
        }
        if (!leftHanded)
            Collections.reverse(imageViewArrayList);
        manaRow.getChildren().addAll(imageViewArrayList);
    }

    void updateMana(int mana) {
        updateManaRow(mana);
    }

    void updateHP(int hp) {
        avatar.setHP(hp);
    }
}

class PlayerAvatar extends StackPane {
    private ImageView bgImageView;
    private ImageView hpImageView;
    private Label hpLabel;


    public PlayerAvatar(String playerHeroName, int initialHp) {
        initAvatarBg();
        initHPIcon(initialHp);
    }

    private void initAvatarBg() {
            Image bgImage = new Image("View/resource/Battle/general_portrait_image_hex_f6.png");
        bgImageView = new ImageView(bgImage);
        bgImageView.setFitHeight(bgImage.getHeight() / 2);
        bgImageView.setFitWidth(bgImage.getWidth() / 2);
        this.getChildren().add(bgImageView);
    }

    private void initHPIcon(int initialHp) {
        Image hpImage = new Image("View/resource/Battle/icon_general_hp.png");
        hpImageView = new ImageView(hpImage);
        hpImageView.setTranslateY(85);
        hpImageView.setTranslateX(3);
        this.getChildren().add(hpImageView);

        hpLabel = new Label(String.valueOf(initialHp));
        hpLabel.setTextFill(Color.WHITE);
        hpLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        hpLabel.setEffect(new MotionBlur(20, 2));
        hpLabel.setTranslateY(85);
        hpLabel.setTranslateX(3);
        this.getChildren().add(hpLabel);
    }

    void setActive(boolean active) {
        if (active) {
            this.setEffect(null);
        } else {
            SepiaTone tone = new SepiaTone(0.66);
            this.setEffect(tone);
        }
    }

    void setHP(int hp) {
        hpLabel.setText(String.valueOf(hp));
    }
}
