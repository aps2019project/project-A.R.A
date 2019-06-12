package View;

import Controller.Controller;
import Model.Card_package.AttackType;
import Model.Card_package.Hero;
import Model.Card_package.hero_special_power.HeroSpecialPower;
import Model.Shop;
import Model.Unit;
import View.Card.CardGroup;
import View.Card.CollectionCard;
import com.sun.tools.javac.Main;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ShopMenu extends StackPane {
    private static ShopMenu instance = new ShopMenu();
    private Scene scene;
    private BorderPane mainLayout;
    private Label drakeLabel;
    private TabPane tabPane;
    private Tab[] tabs = new Tab[4];
    private ArrayList[] units = new ArrayList[4];
    private int[] unitGroupIndex = {0, 0, 0, 0};

    ShopMenu() {
        scene = new Scene(this, JavafxTest.stage.getWidth(), JavafxTest.stage.getHeight());

        initBackground();
        initMainLayout();
        initShopIconBar();
        initCardSection();
        initButtons();
        initArrows();
        update();
    }

    private void initArrows() {
        try {
            Image left = new Image(new FileInputStream("resource\\Shop\\left-shop.png"));
            ImageView leftImageView = new ImageView(left);
            leftImageView.setTranslateX(400);
            leftImageView.setTranslateY(320);
            leftImageView.setOnMousePressed(e -> {
                for (int i = 0; i < 4; i++)
                    if (tabPane.getTabs().get(i).equals(tabPane.getSelectionModel().getSelectedItem()))
                        if (unitGroupIndex[i] > 0)
                            tabPane.getTabs().get(i).setContent((GridPane) units[i].get(--unitGroupIndex[i]));
            });
            this.getChildren().add(leftImageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Image right = new Image(new FileInputStream("resource\\Shop\\right-shop.png"));
            ImageView rightImageView = new ImageView(right);
            rightImageView.setTranslateX(430);
            rightImageView.setTranslateY(320);
            rightImageView.setOnMousePressed(e -> {
                for (int i = 0; i < 4; i++)
                    if (tabPane.getTabs().get(i).equals(tabPane.getSelectionModel().getSelectedItem()))
                        if (unitGroupIndex[i] < units[i].size() - 1)
                            tabPane.getTabs().get(i).setContent((GridPane) units[i].get(++unitGroupIndex[i]));
            });
            this.getChildren().add(rightImageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initButtons() {
        HBox buttonBar = new HBox(75);
        buttonBar.setAlignment(Pos.CENTER);
        buttonBar.setPadding(new Insets(0, 300, 50, 300));
        buttonBar.setTranslateY(360);

        Button buyBt = new Button("Buy");
        buyBt.setPrefWidth(150);
        buyBt.setOnMouseReleased(e -> {
            for (ArrayList unitGroup : units) {
                for (Object gridPane : unitGroup) {
                    for (Node node : ((GridPane) gridPane).getChildren()) {
                        CollectionCard card = (CollectionCard) node;
                        if (node != null) {
                            if (card.isSelected())
                                if (Controller.getInstance().buy(card.getUnitName())) {
                                    card.setSelected(false);
                                    card.setOwned(true);
                                    update();
                                }
                        }
                    }
                }
            }
        });

        Button sellBt = new Button("Sell");
        sellBt.setPrefWidth(150);
        sellBt.setOnMouseReleased(e -> {
            for (ArrayList unitGroup : units) {
                for (Object gridPane : unitGroup) {
                    for (Node node : ((GridPane) gridPane).getChildren()) {
                        CollectionCard card = (CollectionCard) node;
                        if (node != null) {
                            if (card.isSelected() && card.isOwned())
                                if (Controller.getInstance().sell(card.getUnitName())) {
                                    card.setSelected(false);
                                    card.setOwned(false);
                                    update();
                                }
                        }
                    }
                }
            }
        });

        Button backBt = new Button("back to Main Menu");
        backBt.setPrefWidth(150);
        backBt.setOnMouseReleased(e -> {
            JavafxTest.changeMenu(MainMenu.getInstance().getMenuScene());
        });

        buttonBar.getChildren().addAll(buyBt, sellBt, backBt);
        this.getChildren().add(buttonBar);
    }

    private void initCardSection() {
        tabPane = new TabPane();
        tabPane.setPadding(new Insets(50, 300, 200, 300));
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setTabMinWidth(150);
        tabPane.setTranslateY(100);
        tabs[0] = new Tab("Hero");
        tabs[1] = new Tab("Minion");
        tabs[2] = new Tab("Spell");
        tabs[3] = new Tab("Item");
        tabPane.getTabs().addAll(tabs);

        for (int i = 0; i < 4; i++) units[i] = new ArrayList<GridPane>();

        this.getChildren().add(tabPane);
    }

    private void initMainLayout() {
        mainLayout = new BorderPane();
        this.getChildren().add(mainLayout);
    }

    private void initShopIconBar() {
        StackPane topBar = new StackPane();
        topBar.setAlignment(Pos.TOP_RIGHT);

        try {
            ImageView imageView = new ImageView(new Image(new FileInputStream("resource\\Shop\\shopTab2.png")));
            topBar.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ImageView shopIcon = new ImageView(new Image(new FileInputStream("resource\\Shop\\shop-icon.png")));
            shopIcon.setTranslateX(-90);
            shopIcon.setTranslateY(25);
            Glow glow = new Glow();
            glow.setLevel(1);
            shopIcon.setEffect(glow);
            topBar.getChildren().add(shopIcon);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        drakeLabel = new Label("Money");
        drakeLabel.setStyle("-fx-text-fill: Linear-gradient(from 20% 20% to 80% 80%, #e5e11d , #ddae37);");
        drakeLabel.setFont(Font.font(40));
        drakeLabel.setTranslateX(-200);
        drakeLabel.setTranslateY(30);
        Glow glow = new Glow(1);
        glow.setInput(new InnerShadow(1, Color.YELLOWGREEN));
        drakeLabel.setEffect(glow);
        topBar.getChildren().add(drakeLabel);

        mainLayout.setTop(topBar);
    }

    private void initBackground() {
        ImageView shopBackground;
        try {
            shopBackground = new ImageView(new Image(new FileInputStream("resource\\Shop\\shop-background.jpg")));
            shopBackground.setFitWidth(scene.getWidth());
            shopBackground.setFitHeight(scene.getHeight());
            shopBackground.setEffect(new BoxBlur());
            shopBackground.setFitWidth(JavafxTest.stage.getWidth());
            shopBackground.setFitHeight(JavafxTest.stage.getHeight());
            this.getChildren().add(shopBackground);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void update() {
        setDrake();
        units[0] = new CardGroup(new ArrayList<Unit>(Shop.getInstance().getShopHeroes())).generate();
        tabs[0].setContent(((GridPane) units[0].get(unitGroupIndex[0])));

        units[1] = new CardGroup(new ArrayList<Unit>(Shop.getInstance().getShopMinions())).generate();
        tabs[1].setContent(((GridPane) units[1].get(unitGroupIndex[1])));

        units[2] = new CardGroup(new ArrayList<Unit>(Shop.getInstance().getShopSpells())).generate();
        tabs[2].setContent(((GridPane) units[2].get(unitGroupIndex[2])));

        units[3] = new CardGroup(new ArrayList<Unit>(Shop.getInstance().getShopUsables())).generate();
        tabs[3].setContent(((GridPane) units[3].get(unitGroupIndex[3])));
    }

    private void setDrake() {
//        drakeLabel.setText(String.format("%s $", Accounts.getCurrentAccount().getDrake()));
        drakeLabel.setText(String.format("%s $", 16000));
    }

    public static ShopMenu getInstance() {
        return instance;
    }

    Scene getMenuScene() {
        return scene;
    }
}


