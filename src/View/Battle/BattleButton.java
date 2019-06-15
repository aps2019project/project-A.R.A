package View.Battle;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BattleButton extends StackPane {
    private Image bgImage;
    private Image inactiveImage;
    private ImageView bgImageView;
    private Label buttonLabel;

    public BattleButton(String title, String url) {
        bgImage = new Image(url);
        inactiveImage = new Image("View/resource/Battle/button_end_turn_enemy.png"); // just used for end turn button
        bgImageView = new ImageView(bgImage);
        bgImageView.setEffect(new DropShadow());

        buttonLabel = new Label(title);
        buttonLabel.setTextFill(Color.WHITE);
        buttonLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        buttonLabel.setEffect(new MotionBlur(40, 2));
        this.getChildren().addAll(bgImageView, buttonLabel);
    }

    void setTurn(boolean onTurn){
        bgImageView.setImage(onTurn? bgImage :inactiveImage);
        buttonLabel.setText(onTurn?"End Turn":"Waiting ..");
    }
}
