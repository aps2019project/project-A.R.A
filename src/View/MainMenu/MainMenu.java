package View.MainMenu;

import Account_package.Accounts;
import View.Collection.CollectionMenu;
import View.JavafxTest;
import View.Login.LoginMenu;
import View.ModeChoose.ModeChooseMenu;
import View.Shop.ShopMenu;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainMenu extends AnchorPane {
    private static MainMenu instance = new MainMenu();
    private Scene scene;

    MainMenu() {
        scene = new Scene(this, JavafxTest.stage.getWidth(), JavafxTest.stage.getHeight()); // todo fit size to stage
        initBackground();
        initMenuList();
    }

    private void initBackground() {
        try {
            ImageView background = new ImageView(new Image(new FileInputStream("src\\View\\resource\\MainMenu\\background.jpg")));
            background.setFitHeight(scene.getHeight());
            background.setFitWidth(scene.getWidth());
            background.setOnMouseEntered(e -> background.setEffect(new MotionBlur(20, 2)));
            background.setOnMouseExited(e -> background.setEffect(null));
            this.getChildren().add(background);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        ImageView duelystTitle = new ImageView(new Image("View/resource/Title.png"));
        duelystTitle.setFitWidth(400);
        duelystTitle.setFitHeight(125);
        duelystTitle.setTranslateX(200);
        duelystTitle.setTranslateY(150);
        duelystTitle.setOnMouseEntered(e -> duelystTitle.setEffect(new MotionBlur()));
        duelystTitle.setOnMouseExited(e -> duelystTitle.setEffect(null));
        this.getChildren().add(duelystTitle);
    }

    private void initMenuList() {
        VBox menuListBox = new VBox(20);
        menuListBox.setAlignment(Pos.CENTER);
        menuListBox.setTranslateX(1100);
        menuListBox.setTranslateY(400);
        MainMenuButton battleBt = new MainMenuButton("Start Battle", () -> {
            JavafxTest.changeMenu(new ModeChooseMenu().getMenuScene());
        });

        MainMenuButton collectionBt = new MainMenuButton("Collection", () -> {
            JavafxTest.changeMenu(new CollectionMenu().getMenuScene());
        });

        MainMenuButton shopBt = new MainMenuButton("Shop", () -> {
            JavafxTest.changeMenu(new ShopMenu().getMenuScene());
        });

        MainMenuButton saveBt = new MainMenuButton("Save", () -> {
        });

        MainMenuButton exitBt = new MainMenuButton("Logout", () -> {
            Accounts.getInstance().logout();
            JavafxTest.changeMenu(new LoginMenu().getMenuScene());
        });

        menuListBox.getChildren().addAll(battleBt, collectionBt, shopBt, saveBt, exitBt);
        this.getChildren().add(menuListBox);
    }

    public static MainMenu getInstance() {
        return instance;
    }

    public Scene getMenuScene() {
        return scene;
    }
}