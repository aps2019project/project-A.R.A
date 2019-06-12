package View;

import Account_package.Accounts;
import Model.Card_package.AttackType;
import Model.Card_package.Hero;
import Model.Card_package.hero_special_power.HeroSpecialPower;
import Model.Unit;
import Model.UnitType;
import View.Card.CardGroup;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private ArrayList<GridPane> cardGridPanes;
    private int cardGroupIndex = 0;
    private ImageView right;
    private ImageView left;


    CollectionMenu() {
        scene = new Scene(this, JavafxTest.stage.getWidth(), JavafxTest.stage.getHeight());
        initBackground();
        initMenuList();
        initTitle();
        initCategoryList();
        initCreateDeckBt();
        addDecks();
        initArrows();
    }

    private void showCardGroup(){
        if(cardGridPanes != null){
            GridPane gridPane = cardGridPanes.get(cardGroupIndex);
            gridPane.setTranslateX(300);
            gridPane.setTranslateY(250);
            this.getChildren().add(gridPane);
        }
    }

    private void initCategoryList() {
        box = new VBox(10);
        box.setTranslateX(1270);
        box.setTranslateY(300);

        categories[0] = new CollectionItem("Heroes", "resource\\Collection\\hero-icon2.png", Accounts.getCurrentAccount().getCollection().getUnitsOfType(UnitType.HERO));
        categories[1] = new CollectionItem("Minions", "resource\\Collection\\minion icon2.png", Accounts.getCurrentAccount().getCollection().getUnitsOfType(UnitType.MINION));
        categories[2] = new CollectionItem("Spells", "resource\\Collection\\spell-icon2.png", Accounts.getCurrentAccount().getCollection().getUnitsOfType(UnitType.SPELL));
        categories[3] = new CollectionItem("Items", "resource\\Collection\\spell-icon2.png", Accounts.getCurrentAccount().getCollection().getUnitsOfType(UnitType.ITEM));

        box.getChildren().addAll(categories);

        for (CollectionItem category : categories) {
            category.setOnMousePressed(e -> {
                setCardGridPanes(new CardGroup(category.getUnits()).generate());
                category.setSelected(true);
                createDeck.requestFocus();
                for (CollectionItem category1 : categories)
                    if (!category.equals(category1))
                        category1.setSelected(false);
            });
        }
        this.getChildren().add(box);
    }

    private void initArrows(){
        try {
            Image image = new Image(new FileInputStream("resource\\Collection\\right.png"));
            right = new ImageView(image);
            right.setTranslateX(1000);
            right.setTranslateY(800);
            right.setVisible(false);
            right.setOnMousePressed(e->{
                if(cardGroupIndex<cardGridPanes.size()-1){
                    cardGroupIndex++;
                    showCardGroup();
                }
            });
            this.getChildren().add(right);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Image image = new Image(new FileInputStream("resource\\Collection\\left.png"));
            left = new ImageView(image);
            left.setTranslateX(400);
            left.setTranslateY(800);
            left.setVisible(false);
            left.setOnMousePressed(e->{
                if(cardGroupIndex>0){
                    cardGroupIndex--;
                    showCardGroup();
                }
            });

            this.getChildren().add(left);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setCardGridPanes(ArrayList<GridPane> gridPanes){
        cardGridPanes = gridPanes;
        cardGroupIndex = 0;
        showCardGroup();
        right.setVisible(true);
        left.setVisible(true);
    }

    private void initCreateDeckBt(){
        createDeck = new CollectionItem();
        createDeck.setPadding(new Insets(10, 0, 0, 0));
        box.getChildren().add(createDeck);
    }

    private void addDecks(){
        ArrayList<Unit> units = new ArrayList<>();
        for(int i = 0; i<11; i++){
            units.add(new Hero("hi", 4, 4,4,"desc", null, AttackType.MELEE, 4, new ArrayList<HeroSpecialPower>()));
        }

        CollectionItem item = new CollectionItem("hoooo", units);
        item.setOnMousePressed(e->{item.setSelected(true);
            setCardGridPanes(new CardGroup(item.getUnits()).generate());
        });
        box.getChildren().add(item);
    }

    private void initMenuList() {
        Rectangle rectangle = new Rectangle(1200, 0, 400, 1000);
        rectangle.setStyle("-fx-background-color: #1A1D37; -fx-stroke-width: 2; -fx-stroke: gray; -fx-opacity: 0.4; -fx-border-width: 0 0 0 4; -fx-stroke-dash-array: 12 10 8 2;");
        rectangle.setEffect(new DropShadow());
        this.getChildren().add(rectangle);
    }

    private void initTitle() {
        try {
            Image image = new Image(new FileInputStream("resource\\Collection\\COLLECTION.png"));
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 4; i++) {
            Rectangle rectangle = new Rectangle(1215, 240 + 4 * i, 315, 2);
            rectangle.setFill(Color.LIGHTGREEN);
            rectangle.setOpacity(0.6);
            rectangle.setEffect(new Glow(1));
            this.getChildren().add(rectangle);
        }
    }

    private void initBackground() {
        try {
            Image bg = new Image(new FileInputStream("resource\\Collection\\collection-background.jpg"));
            ImageView imageView = new ImageView(bg);
            imageView.setFitHeight(bg.getHeight() / 1.5);
            imageView.setFitWidth(bg.getWidth() / 1.5);
            Glow glow = new Glow();
            BoxBlur boxBlur = new BoxBlur();
            glow.setInput(boxBlur);
            boxBlur.setInput(new ColorAdjust(0, 0, -0.5, 0.25));
            imageView.setEffect(glow);
            this.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Scene getMenuScene() {
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
    private boolean selected;
    private boolean isCategory;
    private ArrayList<Unit> units;


    CollectionItem(String text, String iconURL, ArrayList<Unit> units) {
        this.units = units;
        isCategory = true;
        initialize();
        initText(text);
        initIcon(iconURL);
        setSelectRectangle();
    }

    CollectionItem(String deckName, ArrayList<Unit> units){
        this.units = units;
        isCategory = false;
        initialize();
        initText(deckName);
        initIcon("resource\\Collection\\deck-icon.png");
    }

    CollectionItem() {
        initialize();
        initTextField();
        initPlusBt();
    }

    private void initialize() {
        this.setEffect(new DropShadow(5, Color.valueOf("#073006")));
        this.setAlignment(Pos.CENTER_RIGHT);
        hBox = new HBox(20);
        hBox.setPadding(new Insets(0, 20, 0, 0));
        hBox.setAlignment(Pos.CENTER_RIGHT);
        initBackground();
        this.getChildren().add(hBox);
    }

    private void initPlusBt() {
        try {
            Image image = new Image(new FileInputStream("resource\\Collection\\+.png"));
            plusBt = new ImageView(image);
            plusBt.setEffect(new MotionBlur(40, 3));
            plusBt.setFitWidth(image.getWidth() / 7);
            plusBt.setFitHeight(image.getHeight() / 7.2);

            hBox.getChildren().add(plusBt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        try {
            Image image = new Image(new FileInputStream(url));
            ImageView imageView = new ImageView(image);
            imageView.setEffect(new Glow());
            imageView.setFitHeight(image.getHeight() / 2);
            imageView.setFitWidth(image.getWidth() / 2);
            imageView.setOpacity(0.85);
            imageView.setTranslateX(-30);
            this.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        selectRectangle.setTranslateX(5);
        selectRectangle.setVisible(false);
        this.getChildren().add(selectRectangle);
    }

    private void initBackground() {
        bg = new Rectangle(200, 40);
        bg.setStroke(Color.valueOf("#073006"));
        bg.setFill(Paint.valueOf("#141428"));
        bg.setStrokeWidth(1);
        bg.setOpacity(0.8);
        this.getChildren().add(bg);
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
            if(selected){
                text.setTextFill(Color.PURPLE);
            }else text.setTextFill(Color.DARKGREEN);
        }
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }
}
