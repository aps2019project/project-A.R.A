package View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


class MainMenu extends AnchorPane {
    private static MainMenu instance = new MainMenu();
    private Scene scene;

    private MainMenu() {
        scene = new Scene(this, View.WINDOW_WIDTH, View.WINDOW_HEIGHT);
        initBackground();
        initMenuList();
    }

    private void initBackground(){
        ImageView background = new ImageView(new Image("resource\\background.jpg"));
        background.setFitHeight(scene.getHeight());
        background.setFitWidth(scene.getWidth());
        this.getChildren().add(background);
        ImageView duelystTitle = new ImageView(new Image("resource\\Title.png"));
        duelystTitle.setFitWidth(400);
        duelystTitle.setFitHeight(125);
        duelystTitle.setTranslateX(200);
        duelystTitle.setTranslateY(150);
        this.getChildren().add(duelystTitle);
    }

    private void initMenuList(){
        VBox menuListBox = new VBox(40);
        menuListBox.setAlignment(Pos.CENTER);

        MainMenuButton battleBt = new MainMenuButton("Start", ()->{
           // todo ;; change menu
        });

        MainMenuButton collectionBt = new MainMenuButton("Collection", ()->{
            // todo ;; change menu
        });

        MainMenuButton shopBt = new MainMenuButton("Shop", ()->{
            // todo ;; change menu
        });

        MainMenuButton exitBt = new MainMenuButton("Exit", ()->{
            // todo ;; change menu
        });

        menuListBox.getChildren().addAll(battleBt, collectionBt, shopBt, exitBt);
        this.getChildren().add(menuListBox);
    }

    public static MainMenu getInstance() {
        return instance;
    }

    public Scene getMenuScene() {
        return scene;
    }
}

class MainMenuButton extends StackPane {
    private OnClickEvent onClick;

    MainMenuButton(String text, OnClickEvent onClick) {
        this.onClick = onClick;
        Text buttonText = new Text(text);
        buttonText.setFont(Font.font("Colonna MT", FontWeight.THIN, 20));
        buttonText.setFill(Color.WHITE);
        this.getChildren().add(buttonText);

        buttonText.setOnMouseEntered(e->{
            buttonText.setFill(Color.GOLD);
            buttonText.setEffect(new Glow());
        });

        buttonText.setOnMouseExited(e->{
            buttonText.setFill(Color.WHITE);
            buttonText.setEffect(null);
        });

        buttonText.setOnMousePressed(e-> buttonText.setEffect(new SepiaTone()));
        buttonText.setOnMouseReleased(e->{
            buttonText.setEffect(null);
            onClick.onClicked();
        });
    }
}
