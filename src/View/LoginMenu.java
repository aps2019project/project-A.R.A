package View;


import Controller.Controller;
import Exceptions.NotAValidAccountException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LoginMenu extends AnchorPane {
    private Scene scene;
    private TextField usernameTF;
    private TextField passwordTF;
    private Label label;
    private VBox mainList;


    LoginMenu() {
        scene = new Scene(this, JavafxTest.stage.getWidth(), JavafxTest.stage.getHeight());
        mainList = new VBox(5);
        mainList.setTranslateX(1100);
        mainList.setTranslateY(200);
        mainList.maxWidth(300);
        mainList.setPadding(new Insets(50));
        mainList.setAlignment(Pos.CENTER);

        initBackground();
        initListBox();
    }

    private void initListBox() {

        Rectangle rectangle = new Rectangle(300, 500);
        rectangle.setTranslateX(1100);
        rectangle.setTranslateY(200);
        rectangle.setFill(Color.valueOf("#192742"));
        rectangle.setStyle("-fx-background-color: #192742; -fx-stroke-width: 3; -fx-arc-height: 50; -fx-arc-width: 50; -fx-stroke: black; -fx-opacity: 0.6;");
        this.getChildren().addAll(mainList);

        initTitle();
        initTextFields();
        initButtons();
        initLabel();
    }

    private void initBackground() {
        try {
            Image image = new Image(new FileInputStream("resource\\LoginMenu\\background.jpg"));
            ImageView bg = new ImageView(image);
            bg.setFitWidth(image.getWidth() / 1.25);
            bg.setFitHeight(image.getHeight() / 1.25);
            bg.setEffect(new ColorAdjust(0, 0, -0.1, 0));
            this.getChildren().add(bg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initLabel() {
        label = new Label();
        label.setTextFill(Color.RED);
        label.setFont(Font.font(20));
        label.setVisible(false);
        this.getChildren().add(label);
    }

    private void initTitle() {
        try {
            Image image = new Image(new FileInputStream("C:\\Users\\Re\\IdeaProjects\\Duelyst\\resource\\LoginMenu\\Title.png"));
            ImageView title = new ImageView(image);
            title.setFitHeight(image.getHeight() / 2);
            title.setFitWidth(image.getWidth() / 2);
            title.setTranslateX(300);
            title.setEffect(new DropShadow());
            title.setTranslateY(200);
            this.getChildren().add(title);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initTextFields() {
        usernameTF = new TextField();
        StackPane userNamePane = getTextField(usernameTF, "Username");

        passwordTF = new TextField();
        StackPane passwordPane = getTextField(passwordTF, "password");

        mainList.getChildren().addAll(userNamePane, passwordPane);
    }

    private StackPane getTextField(TextField textField, String text) {
        StackPane stackPane = new StackPane();
        textField.setPromptText(text);
        textField.setPrefWidth(100);
        textField.setPrefHeight(40);
        textField.setTranslateX(50);
        textField.setFont(Font.font("Arial", 18));
        textField.setEffect(new DropShadow(2, Color.GREY));
        textField.setStyle("-fx-background-color: transparent; -fx-prompt-text-fill: rgba(238,159,124,0.5); -fx-text-fill: #fffafa;");

        Rectangle rectangle = new Rectangle(200, 40, Color.TRANSPARENT);
        rectangle.setStyle(" -fx-stroke: white; -fx-stroke-width: 3; -fx-arc-width: 50; -fx-arc-height: 50; -fx-opacity: 1;");
//        rectangle.setEffect(new MotionBlur(30, 3));
        stackPane.getChildren().addAll(rectangle, textField);
        return stackPane;
    }

    private StackPane getButton(String text) {
        StackPane stackPane = new StackPane();
        stackPane.setEffect(new DropShadow());

        try {
            Image image = new Image(new FileInputStream("resource\\LoginMenu\\button.png"));
            ImageView bg = new ImageView(image);
            stackPane.setOnMousePressed(e -> stackPane.setEffect(new Glow(0.3)));

            Label label = new Label(text);
            label.setTextFill(Color.WHITE);
            label.setFont(Font.font("Wingdings 2", 15));
            label.setEffect(new DropShadow(20, Color.BLACK));

            stackPane.getChildren().addAll(bg, label);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stackPane;
    }

    private void initButtons() {

        StackPane login = getButton("Login");
        login.setOnMouseReleased(e -> {
            try {
                Controller.getInstance().login(usernameTF.getText(), passwordTF.getText());
                JavafxTest.changeMenu(MainMenu.getInstance().getMenuScene());
            } catch (NotAValidAccountException ex) {
                label.setText("Invalid username or password !! ");
                label.setVisible(true);
                login.setEffect(new DropShadow(20, Color.BLACK));
            }
        });
        login.setPadding(new Insets(20, 0, 0, 0));

        StackPane newAccount = getButton("New Account");
        newAccount.setOnMouseReleased(e -> {
            try {
                Controller.getInstance().register(usernameTF.getText(), passwordTF.getText());
                JavafxTest.changeMenu(MainMenu.getInstance().getMenuScene());
            } catch (NotAValidAccountException ex2) {
                label.setText("Duplicate userName !!");
                label.setVisible(true);
                newAccount.setEffect(new DropShadow(20, Color.BLACK));
            }
        });

        StackPane exit = getButton("Exit");
        exit.setOnMouseReleased(e -> {
            // todo
            exit.setEffect(new DropShadow(20, Color.BLACK));
            System.exit(0);
        });

        mainList.getChildren().addAll(login, newAccount, exit);
    }

    public Scene getMenuScene() {
        return scene;
    }
}

