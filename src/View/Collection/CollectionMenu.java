package View.Collection;

import Account_package.Accounts;
import Controller.Controller;
import Model.Match_package.Deck;
import Model.Unit;
import Model.UnitType;
import View.Card.CardGroup;
import View.Card.CollectionCard;
import View.JavafxTest;
import View.MainMenu.MainMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CollectionMenu extends AnchorPane {
    private Scene scene;
    private CollectionItem[] categories = new CollectionItem[4];
    private CollectionItem createDeck;
    private VBox box;
    private VBox deckBox;
    private ArrayList<GridPane> cardGridPanes;
    private int cardGroupIndex = 0;
    private ImageView right;
    private ImageView left;
    private boolean onAdd = false;


    public CollectionMenu() {
        scene = new Scene(this, JavafxTest.stage.getWidth(), JavafxTest.stage.getHeight());
        initBackground();
        initMenuList();
        initTitle();
        initCategoryList();
        initCreateDeckBt();
        deckBox = new VBox(15);
        box.getChildren().add(deckBox);
        updateDecks();
        initArrows();
        initButtons();
    }

    private void initButtons() {
        StackPane addBt = getButton("ADD");
        addBt.setTranslateX(270);
        addBt.setTranslateY(750);
        addBt.setOnMouseReleased(e -> {
            addBt.setEffect(null);
            onAdd = true;
        });
        this.getChildren().add(addBt);

        StackPane removeBt = getButton("Remove");
        removeBt.setTranslateX(500);
        removeBt.setTranslateY(750);
        removeBt.setOnMouseReleased(e -> {
            removeBt.setEffect(null);
            for (Node node : deckBox.getChildren()) {
                CollectionItem deck = ((CollectionItem) node);
                if (deck.isSelected()) {
                    for (GridPane gridPane : cardGridPanes)
                        for (Node node1 : gridPane.getChildren()) {
                            CollectionCard card = ((CollectionCard) node1);
                            if (card.isSelected()) {
                                Controller.getInstance().removeUnit(deck.getDeckName(), card.getUnitName());
                                updateDecks();
                                card.setSelected(false);
                            }
                        }
                }
            }
        });
        this.getChildren().add(removeBt);

        StackPane exitBt = getButton("Exit");
        exitBt.setTranslateX(730);
        exitBt.setTranslateY(750);
        exitBt.setOnMouseReleased(e -> {
            exitBt.setEffect(null);
            JavafxTest.changeMenu(MainMenu.getInstance().getMenuScene());
        });
        this.getChildren().add(exitBt);
    }

    private StackPane getButton(String text) {
        StackPane stackPane = new StackPane();
        stackPane.setEffect(new DropShadow());
        Image image = new Image("View/resource/Collection/button-background.png");
        ImageView bg = new ImageView(image);
        stackPane.setOnMousePressed(e -> stackPane.setEffect(new Glow(0.3 + 0)));

        Label label = new Label(text);
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Wingdings 2", 15));
        label.setEffect(new DropShadow(20, Color.BLACK));

        stackPane.getChildren().addAll(bg, label);
        return stackPane;
    }

    private void updateCards() {
        if (cardGridPanes != null) {
            GridPane gridPane = cardGridPanes.get(cardGroupIndex);
            gridPane.setTranslateX(300);
            gridPane.setTranslateY(150);
            for (GridPane cardGridPane : cardGridPanes) {
                cardGridPane.setVisible(false);
            }
            gridPane.setVisible(true);
            this.getChildren().add(gridPane);
        }
    }

    private void updateDecks() {
        deckBox.getChildren().clear();
        String mainDeckName = Controller.getInstance().getMainDeckName();
        for (Deck deck : Controller.getInstance().getDecks()) {
            CollectionItem item1 = new CollectionItem(deck.getDeckName(), deck.getAllUnits());
            if (mainDeckName.equals(deck.getDeckName())) item1.setDoubleSelected(true);
            deckBox.getChildren().add(item1);
            item1.setOnMousePressed(e -> {
                if (item1.isSelected()) {
                    for (Node node : deckBox.getChildren()) {
                        ((CollectionItem) node).setDoubleSelected(false);
                    }
                    item1.setDoubleSelected(true);
                    Controller.getInstance().setMainDeck(item1.getDeckName());
                }
                item1.setSelected(true);
                setSelected(item1);
                if (onAdd) {
                    onAdd = false;
                    for (GridPane gridPane : cardGridPanes)
                        for (Node node : gridPane.getChildren()) {
                            CollectionCard card = ((CollectionCard) node);
                            if (card.isSelected()) {
                                if (!Controller.getInstance().addUnit(deck.getDeckName(), card.getUnitName())) {
                                    // do something
                                } else updateDecks();
                                card.setSelected(false);
                            }
                        }
                }
                setCardGridPanes(new CardGroup(item1.getUnits()).generate());
            });
        }
    }

    private void initCategoryList() {
        box = new VBox(10);
        box.setTranslateX(1270);
        box.setTranslateY(300);

        categories[0] = new CollectionItem("Heroes", "View/resource/Collection/hero-icon2.png", Accounts.getCurrentAccount().getCollection().getUnitsOfType(UnitType.HERO));
        categories[1] = new CollectionItem("Minions", "View/resource/Collection/minion icon2.png", Accounts.getCurrentAccount().getCollection().getUnitsOfType(UnitType.MINION));
        categories[2] = new CollectionItem("Spells", "View/resource/Collection/spell-icon2.png", Accounts.getCurrentAccount().getCollection().getUnitsOfType(UnitType.SPELL));
        categories[3] = new CollectionItem("Items", "View/resource/Collection/spell-icon2.png", Accounts.getCurrentAccount().getCollection().getUnitsOfType(UnitType.ITEM));

        box.getChildren().addAll(categories);

        for (CollectionItem category : categories) {
            category.setOnMousePressed(e -> {
                setCardGridPanes(new CardGroup(category.getUnits()).generate());
                category.setSelected(true);
                createDeck.requestFocus();
                setSelected(category);
            });
        }
        this.getChildren().add(box);
    }

    private void initArrows() {
        Image rightImage = new Image("View/resource/Collection/right.png");
        right = new ImageView(rightImage);
        right.setTranslateX(950);
        right.setTranslateY(700);
        right.setVisible(false);
        right.setOnMousePressed(e -> {
            if (cardGroupIndex < cardGridPanes.size() - 1) {
                System.out.println("in right arrow event");
                cardGroupIndex++;
                updateCards();
            }
        });
        this.getChildren().add(right);


        Image leftImage = new Image("View/resource/Collection/left.png");
        left = new ImageView(leftImage);
        left.setTranslateX(850);
        left.setTranslateY(700);
        left.setVisible(false);
        left.setOnMousePressed(e -> {
            if (cardGroupIndex > 0) {
                cardGroupIndex--;
                updateCards();
            }
        });
        this.getChildren().add(left);
    }

    private void setCardGridPanes(ArrayList<GridPane> gridPanes) {
        if (cardGridPanes != null)
            for (GridPane gridPane : cardGridPanes) {
                this.getChildren().remove(gridPane);
            }
        cardGridPanes = gridPanes;
        cardGroupIndex = 0;
        updateCards();
        right.setVisible(true);
        left.setVisible(true);
    }

    private void initCreateDeckBt() {
        createDeck = new CollectionItem(new TextFieldEvent() {
            @Override
            public void onClicked(String text) {
                if (!Controller.getInstance().createDeck(text)) {
                    // show error
                } else {
                    updateDecks();
                }
            }
        });
        createDeck.setPadding(new Insets(10, 0, 0, 0));
        box.getChildren().add(createDeck);
    }

    private void setSelected(CollectionItem selectedItem) {
        for (CollectionItem category : categories) {
            if (!category.equals(selectedItem))
                category.setSelected(false);
        }
        for (Node deck : deckBox.getChildren()) {
            if (!((CollectionItem) deck).equals(selectedItem))
                ((CollectionItem) deck).setSelected(false);
        }
    }

    private void initMenuList() {
        Rectangle rectangle = new Rectangle(1200, 0, 400, 1000);
        rectangle.setStyle("-fx-background-color: #1A1D37; -fx-stroke-width: 2; -fx-stroke: gray; -fx-opacity: 0.4; -fx-border-width: 0 0 0 4; -fx-stroke-dash-array: 12 10 8 2;");
        rectangle.setEffect(new DropShadow());
        this.getChildren().add(rectangle);
    }

    private void initTitle() {
        Image image = new Image("View/resource/Collection/COLLECTION.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(image.getWidth() / 2);
        imageView.setFitHeight(image.getHeight() / 2);

        Glow glow = new Glow(1);
        MotionBlur motionBlur = new MotionBlur(40, 3);
        motionBlur.setInput(new InnerShadow());
        glow.setInput(motionBlur);
        imageView.setEffect(glow);

        imageView.setTranslateX(1250);
        imageView.setTranslateY(160);
        this.getChildren().addAll(imageView, new Line(1250, 180, 1600, 180));

        for (int i = 0; i < 4; i++) {
            Rectangle rectangle = new Rectangle(1215, 240 + 4 * i, 315, 2);
            rectangle.setFill(Color.LIGHTGREEN);
            rectangle.setOpacity(0.6);
            rectangle.setEffect(new Glow(1));
            this.getChildren().add(rectangle);
        }
    }

    private void initBackground() {
        Image bg = new Image("View/resource/Collection/collection-background.jpg");
        ImageView imageView = new ImageView(bg);
        imageView.setFitHeight(bg.getHeight() / 1.5);
        imageView.setFitWidth(bg.getWidth() / 1.5);
        Glow glow = new Glow();
        BoxBlur boxBlur = new BoxBlur();
        glow.setInput(boxBlur);
        boxBlur.setInput(new ColorAdjust(0, 0, -0.5, 0.25));
        imageView.setEffect(glow);
        this.getChildren().add(imageView);
    }

    public Scene getMenuScene() {
        return scene;
    }
}

class CollectionItem extends StackPane {
    private HBox hBox;
    private Label text;
    private TextField textField;
    private Rectangle selectRectangle;
    private Rectangle bg;
    private ImageView plusBt;
    private ImageView icon;
    private boolean selected;
    private boolean doubleSelected = false;
    private boolean isCategory;
    private ArrayList<Unit> units;
    private String deckName;


    CollectionItem(String text, String iconURL, ArrayList<Unit> units) {
        this.units = units;
        isCategory = true;
        initialize();
        initText(text);
        initIcon(iconURL);
        setSelectRectangle();
    }

    CollectionItem(String deckName, ArrayList<Unit> units) {
        this.units = units;
        this.deckName = deckName;
        isCategory = false;
        initialize();
        initText(deckName);
        initIcon("View/resource/Collection/deck-icon.png");
    }

    CollectionItem(TextFieldEvent event) {
        initialize();
        initTextField();
        initPlusBt(event);
    }

    private void initialize() {
        this.setAlignment(Pos.CENTER_RIGHT);
        hBox = new HBox(20);
        hBox.setPadding(new Insets(0, 20, 0, 0));
        hBox.setAlignment(Pos.CENTER_RIGHT);
        initBackground();
        this.getChildren().add(hBox);
    }

    private void initPlusBt(TextFieldEvent event) {
        Image image = new Image("View/resource/Collection/+.png");
        plusBt = new ImageView(image);
        plusBt.setEffect(new MotionBlur(40, 3));
        plusBt.setFitWidth(image.getWidth() / 7);
        plusBt.setFitHeight(image.getHeight() / 7.2);
        plusBt.setOnMousePressed(e -> {
            plusBt.setTranslateX(2);
            plusBt.setTranslateY(-2);
            event.onClicked(textField.getText());
            textField.setText("");
        });
        plusBt.setOnMouseReleased(e -> {
            plusBt.setTranslateX(-2);
            plusBt.setTranslateY(2);
        });
        hBox.getChildren().add(plusBt);
    }

    private void initTextField() {
        textField = new TextField();
        textField.setPrefWidth(130);
        textField.setPromptText("create new deck");
        textField.setFont(Font.font(15));
        textField.setStyle("-fx-text-fill: darkgreen; -fx-background-color: #141428; -fx-stroke: #073006; -fx-prompt-text-fill: rgb(84,80,84)");
        hBox.getChildren().add(textField);
    }

    private void initIcon(String url) {
        Image image = new Image(url);
        icon = new ImageView(image);
        icon.setEffect(new Glow());
        icon.setFitHeight(image.getHeight() / 2);
        icon.setFitWidth(image.getWidth() / 2);
        icon.setOpacity(0.85);
        icon.setTranslateX(-30);
        this.getChildren().add(icon);
    }

    private void initText(String text) {
        this.text = new Label(text);
        this.text.setFont(Font.font(15));
        this.text.setEffect(new Glow());
        this.text.setTextFill(Color.DARKGREEN);
        this.text.setTranslateX(-120);
        this.getChildren().add(this.text);
    }

    private void setSelectRectangle() {
        selectRectangle = new Rectangle(5, 40);
        selectRectangle.setFill(Color.GREEN);
        selectRectangle.setTranslateX(-2);
        selectRectangle.setVisible(false);
        this.getChildren().add(selectRectangle);
    }

    private void initBackground() {
        bg = new Rectangle(200, 40);
        bg.setStroke(Color.valueOf("#073006"));
        bg.setFill(Paint.valueOf("#141428"));
        bg.setStrokeWidth(1);
        bg.setOpacity(0.8);
        bg.setArcHeight(50);
        bg.setArcWidth(20);
        this.setEffect(new DropShadow(5, Color.valueOf("#073006")));
        this.getChildren().add(bg);
    }

    public boolean isDoubleSelected() {
        return doubleSelected;
    }

    public void setDoubleSelected(boolean doubleSelected) {
        this.doubleSelected = doubleSelected;
        if (doubleSelected) icon.setEffect(new Glow(1));
        else icon.setEffect(null);
    }

    void setSelected(boolean selected) {
        this.selected = selected;
        if (isCategory) {
            if (selected) {
                text.setTextFill(Color.GREEN);
                text.setEffect(new Glow(1));
                selectRectangle.setVisible(true);
                bg.setOpacity(0.4);
                this.setTranslateX(10);
            } else {
                text.setEffect(new Glow());
                text.setTextFill(Color.DARKGREEN);
                bg.setOpacity(0.8);
                selectRectangle.setVisible(false);
                this.setTranslateX(-10);
            }
        } else {
            if (selected) {
                text.setTextFill(Color.PURPLE);
            } else text.setTextFill(Color.DARKGREEN);
        }
    }

    boolean isSelected() {
        return selected;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }
}
