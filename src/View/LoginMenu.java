package View;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginMenu extends VBox {
    private static LoginMenu instance = new LoginMenu();
    private Scene scene;
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 500;
    private TextField usernameTF;
    private TextField passwordTF;

    private LoginMenu() {
        scene = new Scene(this, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setPadding(new Insets(50));
        this.setSpacing(30);
        this.setAlignment(Pos.CENTER);

        initTitle();
        initTextFields();
        initButtons();
    }

    private void initTitle() {
        Label title = new Label("Duelyst");
        title.setFont(Font.font("Cambria", FontWeight.BOLD, 20));
        title.setTextFill(Color.PURPLE);
        this.getChildren().add(title);
    }

    private void initTextFields() {
        usernameTF = new TextField();
        usernameTF.setPrefWidth(300);
        usernameTF.setPromptText("Username");

        passwordTF = new TextField();
        passwordTF.setPrefWidth(300);
        passwordTF.setPromptText("password");

        this.getChildren().addAll(usernameTF, passwordTF);
    }

    private void initButtons() {
        HBox hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER);

        loginMenuButton login = new loginMenuButton("Login", (OnClickEvent) () -> {
           // todo for login
        });

        loginMenuButton newAccount = new loginMenuButton("new Account", (OnClickEvent) () -> {
            // todo for create account
        });

        hBox.getChildren().addAll(login, newAccount);
        this.getChildren().add(hBox);
    }

    public static LoginMenu getInstance() {
        return instance;
    }

    public Scene getMenuScene() {
        return scene;
    }
}

class loginMenuButton extends StackPane {
    private OnClickEvent onClickEvent;

    loginMenuButton(String text, OnClickEvent onClickEvent) {
        Rectangle rectangle = new Rectangle(80, 20, Color.DARKBLUE);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        this.getChildren().add(rectangle);
        this.onClickEvent = onClickEvent;

        Text text1 = new Text(text);
        text1.setFill(Color.WHITE);
        this.getChildren().add(text1);

        this.setOnMouseReleased(e ->
                onClickEvent.onClicked()
        );


        this.setOnMouseEntered(e->this.setEffect(new Reflection()));
        this.setOnMouseExited(e-> this.setEffect(null));
    }
}

