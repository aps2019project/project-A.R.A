package View.MainMenu;

import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

class MainMenuButton extends StackPane {
    private OnClickEvent onClick;

    MainMenuButton(String text, OnClickEvent onClick) {
        this.onClick = onClick;
        Text buttonText = new Text(text);
        buttonText.setFont(Font.font("Colonna MT", FontWeight.BOLD, 40));
        buttonText.setFill(Color.WHITE);
        this.getChildren().add(buttonText);

        buttonText.setOnMouseEntered(e -> {
            buttonText.setFill(Color.GOLD);
            buttonText.setEffect(new Glow());
        });

        buttonText.setOnMouseExited(e -> {
            buttonText.setFill(Color.WHITE);
            buttonText.setEffect(null);
        });

        buttonText.setOnMousePressed(e -> buttonText.setEffect(new SepiaTone()));
        buttonText.setOnMouseReleased(e -> {
            buttonText.setEffect(null);
            onClick.onClicked();
        });
    }
}
