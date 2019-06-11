package View;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
    private ArrayList<ShopItem> shopItems = new ArrayList<>();

    private ShopMenu() {
        scene = new Scene(this, JavafxTest.stage.getWidth(), JavafxTest.stage.getHeight());

        initBackground();
        initMainLayout();
        initShopIconBar();
        update();
        initCardSection();
        initButtons();

    }

    private void initButtons() {
        HBox buttonBar = new HBox(75);
        buttonBar.setAlignment(Pos.CENTER);
        buttonBar.setPadding(new Insets(0, 300, 50, 300));

        Button buyBt = new Button("Buy");
        buyBt.setPrefWidth(150);
        buyBt.setOnMouseReleased(e -> {
            for (ShopItem shopItem : shopItems) {
                if (shopItem.isSelected()) {
                    if (!Controller.getInstance().buy(shopItem.getUnitName())) {
                        // todo set an animation on user drake showing it is low
                    }
                    else shopItem.setOwned(true);
                }
                shopItem.setSelected(false);
            }
        });

        Button sellBt = new Button("Sell");
        sellBt.setPrefWidth(150);
        sellBt.setOnMouseReleased(e -> {
            for (ShopItem shopItem : shopItems){
                if(shopItem.isOwned()){
                    if(Controller.getInstance().sell(shopItem.getUnitName())) shopItem.setOwned(false);
                }
                shopItem.setSelected(true);
            }
        });

        Button backBt = new Button("back to Main Menu");
        backBt.setPrefWidth(150);
        backBt.setOnMouseReleased(e->{
            // todo change menu to main menu
        });

        buttonBar.getChildren().addAll(buyBt, sellBt, backBt);
        mainLayout.setBottom(buttonBar);
    }

    private void initCardSection() {
        tabPane = new TabPane();
        tabPane.setPadding(new Insets(50, 300, 200, 300));
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setTabMinWidth(150);

        initHeroSection();
        initMinionSection();
        initSpellSection();
        initItemSection();

        mainLayout.setCenter(tabPane);
    }

    private void initHeroSection() {
        Tab heroTab = new Tab("Heroes");

        ListView<ShopItem> heroList = new ListView<>();
        heroList.setOrientation(Orientation.HORIZONTAL);

        heroList.getItems().add(new ShopItem("Rostam", 800));

        heroTab.setContent(heroList);
        tabPane.getTabs().add(heroTab);
    }

    private void initMinionSection() {
        Tab minionTab = new Tab("Minion");


        ListView<ShopItem> minionList = new ListView<>();
        minionList.setOrientation(Orientation.HORIZONTAL);

        minionTab.setContent(minionList);
        tabPane.getTabs().add(minionTab);
    }

    private void initSpellSection() {
        Tab spellTab = new Tab("Spell");


        ListView<ShopItem> spellList = new ListView<>();
        spellList.setOrientation(Orientation.HORIZONTAL);

        spellTab.setContent(spellList);
        tabPane.getTabs().add(spellTab);
    }

    private void initItemSection() {
        Tab itemTab = new Tab("Item");


        ListView<ShopItem> itemList = new ListView<>();
        itemList.setOrientation(Orientation.HORIZONTAL);

        itemTab.setContent(itemList);
        tabPane.getTabs().add(itemTab);
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


