package View.Card;

import Model.Card_package.Force;
import Model.Card_package.Hero;
import Model.Card_package.Minion;
import Model.Card_package.Spell;
import Model.Item_package.Item;
import Model.Unit;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Glow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CollectionCard extends StackPane {
    private Unit unit;
    private Image avatar;
    private ImageView avatarImageView;
    private Label HP;
    private Label AP;
    private Label description;
    private boolean selected = false;
    private boolean owned = false;


    CollectionCard(Unit unit) {
        try {
            avatar = new Image(new FileInputStream("resource\\Cards\\dafault avatar.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.unit = unit;
        if (unit instanceof Hero) {
            initBackground("resource\\Cards\\hero-background.png");
            setAvatar("resource\\Cards\\dafault avatar.png");
            addLabels(UnitType.HERO);
        } else if (unit instanceof Minion) {
            initBackground("resource\\Cards\\minion-background.png");
            setAvatar("resource\\Cards\\dafault avatar.png");
            addLabels(UnitType.MINION);
        }else if(unit instanceof Spell){
            initBackground("resource\\Cards\\spell-background.png");
            setAvatar("resource\\Cards\\dafault avatar.png");
            addLabels(UnitType.SPELL);
        }else if(unit instanceof Item){
            initBackground("resource\\Cards\\item-background.png");
            setAvatar("resource\\Cards\\dafault avatar.png");
            addLabels(UnitType.SPELL);
        }
        eventHandle();
    }

    private void eventHandle() {
        this.setOnMousePressed(e -> {
            setSelected(!selected);
            if (selected) this.setEffect(new ColorAdjust(0.57, 0, 0, 0));
            else setDefaultEffect();
        });
    }

    private void setDefaultEffect() {
        if (owned) this.setEffect(new ColorAdjust(-0.5, 0, 0, 0));
        else this.setEffect(null);
    }

    private void addLabels(UnitType type) {
        HP = new Label();
        HP.setFont(Font.font(10));
        HP.setTextFill(Color.RED);
        HP.setTranslateX(48);
        HP.setTranslateY(25);
        HP.setEffect(new Glow(0.7));
        if (type.equals(UnitType.HERO) || type.equals(UnitType.MINION))
            HP.setText(String.valueOf(((Force) unit).getHp()));
        this.getChildren().add(HP);

        AP = new Label();
        AP.setFont(Font.font(10));
        AP.setTextFill(Color.GOLD);
        AP.setTranslateX(-48);
        AP.setTranslateY(25);
        AP.setEffect(new Glow(0.7));
        if (type.equals(UnitType.HERO) || type.equals(UnitType.MINION))
            AP.setText(String.valueOf(((Force) unit).getAp()));
        this.getChildren().add(AP);

        Label descriptionTitle = new Label(unit.getName().toUpperCase());
        descriptionTitle.setFont(Font.font(12));
        descriptionTitle.setTextFill(Color.WHITE);
        descriptionTitle.setEffect(new MotionBlur(40, 2));
        descriptionTitle.setTranslateY(50);
        this.getChildren().add(descriptionTitle);

        description = new Label("description about the card e.g. how it's specialPower works");
        description.setMaxWidth(100);
        description.setFont(Font.font(10));
        description.setTextFill(Color.GRAY);
        description.setTranslateY(75);
        description.setWrapText(true);
        description.setText(unit.getDesc());
        this.getChildren().add(description);
    }

    private void setAvatar(String url) {
//        try {
//            avatar = new Image(new FileInputStream(url));
            avatarImageView = new ImageView(avatar);
            avatarImageView.setFitWidth(avatar.getWidth() * 0.4);
            avatarImageView.setFitHeight(avatar.getHeight() * 0.4);
            avatarImageView.setTranslateY(-60);
            this.getChildren().add(avatarImageView);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    private void initBackground(String url) {
        try {
            Image bg = new Image(new FileInputStream(url));
            ImageView imageView = new ImageView(bg);
            imageView.setFitWidth(bg.getWidth() * 0.8);
            imageView.setFitHeight(bg.getHeight() * 0.8);
            this.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public String getUnitName() {
        return unit.getName();
    }
}

enum UnitType {
    HERO, MINION, SPELL, ITEM
}
