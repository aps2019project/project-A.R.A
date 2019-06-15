package View.Login;


import Controller.Controller;
import Exceptions.NotAValidAccountException;
import View.JavafxTest;
import View.MainMenu.MainMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LoginMenu extends AnchorPane {
    private Scene scene;
    private TextField usernameTF;
    private TextField passwordTF;
    private Label label;
    private VBox mainList;


    public LoginMenu() {
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
        textField.setPrefWidth(100);
        textField.setPrefHeight(40);
        textField.setTranslateX(50);
        textField.setFont(Font.font("Arial", 18));
        textField.setEffect(new MotionBlur(-40, 2));
        textField.setStyle("-fx-background-color: transparent;  -fx-text-fill: rgb(116,112,116);");

        Label label = new Label(text + " :");
        label.setTranslateX(-180);
        label.setStyle("-fx-text-fill: rgb(210,206,210)");
        label.setFont(Font.font("Berlin Sans FB Demi", 25));
        MotionBlur labelMotionBlur = new MotionBlur(-40, 4);
        labelMotionBlur.setInput(new DropShadow(2, Color.BLACK));
        label.setEffect(labelMotionBlur);

        Rectangle rectangle = new Rectangle(200, 40, Color.GRAY);
        rectangle.setStyle(" -fx-stroke: #0f16a1; -fx-stroke-width: 3; -fx-arc-width: 50; -fx-arc-height: 50; -fx-opacity: 0.2;");
        MotionBlur motionBlur = new MotionBlur(40, 12);
        motionBlur.setInput(new DropShadow(2, Color.BLACK));
        rectangle.setEffect(motionBlur);
        stackPane.getChildren().addAll(label, rectangle, textField);
        return stackPane;
    }

    private StackPane getButton(String text) {
        StackPane stackPane = new StackPane();
        stackPane.setEffect(new DropShadow());

        try {
            Image image = new Image(new FileInputStream("resource\\LoginMenu\\button-background.png"));
            ImageView bg = new ImageView(image);
            stackPane.setOnMousePressed(e -> stackPane.setEffect(new Glow(0.3)));

            Label label = new Label(text);
            label.setTextFill(Color.WHITE);
            label.setFont(Font.font("Berlin Sans FB Demi", 15));
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