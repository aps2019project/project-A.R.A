package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ShopItem extends StackPane {
    private ImageView unitAvatar;
    private VBox mainLayout;
    private VBox attributeBox;
    private String unitName;
    private boolean selected = false;
    private boolean owned = false;


    ShopItem(String unitName, int price) {
        this.unitName = unitName;
        setBackground();
        setMainLayout();    // and adds avatar
        addMainLabels(unitName, price);
        addAttributeBox();
        addProperty("Attack Type", "ranged");
        addProperty("Attack Type", "ranged");
        addProperty("Attack Type", "ranged");
        addProperty("Attack Type", "ranged");

        this.setOnMousePressed(e->{
            setSelected(!selected);

            if(this.getEffect() == null) {
                Bloom bloom = new Bloom(0);
                bloom.setInput(new ColorAdjust(0.61, 0.5, 0, 0.5));
                this.setEffect(bloom);
            }else this.setEffect(getDefaultCardEffect());
        });
    }

    private Effect getDefaultCardEffect(){
        Bloom bloom = new Bloom(0);
        if(this.isOwned()){
            bloom.setInput(new ColorAdjust(-0.46, 0.5, 0, 0.5));
        }
        else{
//            bloom.setInput(new ColorAdjust(-0.21, 0.5, 0.5, 0.5));
            bloom = null;
        }
        return null;
    }

    private void addAttributeBox() {
        attributeBox = new VBox();
        attributeBox.setAlignment(Pos.CENTER);
        attributeBox.setPadding(new Insets(-10, 0, 0, 0));
        mainLayout.getChildren().add(attributeBox);
    }

    private void setMainLayout() {
        mainLayout = new VBox(0);
        mainLayout.setAlignment(Pos.CENTER);
        this.getChildren().add(mainLayout);

        try {
            Image image = new Image(new FileInputStream("resource\\Shop\\dafault avatar2.png"));
            unitAvatar = new ImageView(image);
            unitAvatar.setFitWidth(image.getWidth()*0.5);
            unitAvatar.setFitHeight(image.getHeight()*0.5);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mainLayout.getChildren().add(unitAvatar);
    }

    private void addMainLabels(String unitName, int price) {
        Label unitNameLabel = new Label(unitName);
        unitNameLabel.setFont(Font.font(20));
        unitNameLabel.setStyle("-fx-text-fill:  linear-gradient(from 25% 25% to 100% 100%, #926211, #fff200);");
        Glow unitNameEffect = new Glow();
        unitNameEffect.setLevel(1);
        unitNameLabel.setEffect(unitNameEffect);

        Label priceLabel = new Label(String.format("%d$", price));
        priceLabel.setFont(Font.font(15));
        priceLabel.setStyle("-fx-text-fill:  linear-gradient(from 25% 25% to 100% 100%, #0a7026, #0fff10);");
        Glow priceLabelEffect = new Glow();
        priceLabelEffect.setLevel(1);
        priceLabel.setEffect(priceLabelEffect);

        HBox mainLabelsBar = new HBox(25);
        mainLabelsBar.setAlignment(Pos.CENTER);
        mainLabelsBar.setPadding(new Insets(0, 0, 10, 0));
        mainLabelsBar.getChildren().addAll(unitNameLabel, priceLabel);

        mainLayout.getChildren().add(mainLabelsBar);
    }

    private void setBackground() {
        try {
            Image bgImage = new Image(new FileInputStream("resource\\Shop\\dark card background.jpg"));
            ImageView background = new ImageView(bgImage);
            background.setFitHeight(bgImage.getHeight()*0.5);
            background.setFitWidth(bgImage.getWidth()*0.5);
            background.setOpacity(0.9);
            background.setEffect(new BoxBlur());
            this.getChildren().add(background);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void setUnitAvatar(String url) {
        try {
            unitAvatar = new ImageView(new Image(new FileInputStream(url)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void addProperty(String property, String value) {
        HBox propertyBar = new HBox(15);
        propertyBar.setAlignment(Pos.CENTER);

        Label propertyLabel = new Label(property + ":");
        propertyLabel.setFont(Font.font(10));
        propertyLabel.setTextFill(Color.GRAY);
        propertyLabel.setEffect(new Reflection());

        Label valueLabel = new Label(value);
        valueLabel.setFont(Font.font(10));
        valueLabel.setTextFill(Color.WHITE);
        valueLabel.setEffect(new InnerShadow());
        valueLabel.setUnderline(true);

        propertyBar.getChildren().addAll(propertyLabel, valueLabel);
        attributeBox.getChildren().add(propertyBar);
    }

    public String getUnitName() {
        return unitName;
    }

    public boolean isSelected() {
        return selected;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
}
