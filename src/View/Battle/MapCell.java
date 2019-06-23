package View.Battle;

import View.Sprite.Sprite;
import View.Sprite.SpriteBase;
import View.Sprite.SpriteType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapCell extends StackPane {
    MapCell() {
        Rectangle rectangle = new Rectangle(100,100);
        rectangle.setFill(Color.DARKBLUE);
        rectangle.setOpacity(0.1);
        this.getChildren().add(rectangle);
    }

    void addSprite(ImageView sprite){
        this.getChildren().add(sprite);
    }

    void removeSprite(ImageView sprite){
        this.getChildren().remove(sprite);
    }
}
