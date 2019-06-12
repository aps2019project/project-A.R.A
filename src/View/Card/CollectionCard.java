package View.Card;

import Model.Unit;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class CollectionCard extends StackPane {
    private Image avatar;
    private Label HP;
    private Label AP;
    private Label description;

    CollectionCard(Unit unit) {
        initBackground();
        setAvatar("resource\\Collection\\dafault avatar.png");
        addLabels();
    }

    private void addLabels() {
        HP = new Label("HP");
        HP.setFont(Font.font(15));
        HP.setTextFill(Color.RED);
        HP.setTranslateX(48);
        HP.setTranslateY(25);
        HP.setEffect(new Glow(0.7));
        this.getChildren().add(HP);

        AP = new Label("AP");
        AP.setFont(Font.font(15));
        AP.setTextFill(Color.GOLD);
        AP.setTranslateX(-48);
        AP.setTranslateY(25);
        AP.setEffect(new Glow(0.7));
        this.getChildren().add(AP);


        Label descriptionTitle = new Label("DESCRIPTION");
        descriptionTitle.setFont(Font.font(10));
        descriptionTitle.setTextFill(Color.WHITE);
        descriptionTitle.setEffect(new MotionBlur(40, 2));
        descriptionTitle.setTranslateY(50);
        this.getChildren().add(descriptionTitle);

        description = new Label("description about the card e.g. how it's specialPower works");
        description.setMaxWidth(100);
        description.setFont(Font.font(8));
        description.setTextFill(Color.GRAY);
        description.setTranslateY(75);
        description.setWrapText(true);
        this.getChildren().add(description);
    }

    void setAvatar(String url) {
        try {
            avatar = new Image(new FileInputStream(url));
            ImageView imageView = new ImageView(avatar);
            imageView.setFitWidth(avatar.getWidth() * 0.4);
            imageView.setFitHeight(avatar.getHeight() * 0.4);
            imageView.setTranslateY(-60);
            this.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initBackground() {
        try {
            Image bg = new Image(new FileInputStream("resource\\Collection\\hero-background.png"));
            ImageView imageView = new ImageView(bg);
            imageView.setFitWidth(bg.getWidth() * 0.8);
            imageView.setFitHeight(bg.getHeight() * 0.8);
            this.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
