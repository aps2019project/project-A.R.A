package View.Sprite;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;

public class SpriteBase {
    private static SpriteBase instance = new SpriteBase();
    private ArrayList<Sprite> heroSprites = new ArrayList<>();
    private ArrayList<ImageView> minionSprite = new ArrayList<>();


    private SpriteBase() {
        load();
    }

    private void load() {
        loadHeroSprites();
        loadMinionSprites();
    }

    private void loadHeroSprites() {
        Image heroSpriteImage = new Image("View/resource/Sprite/Heroes/hero1.png");
        ImageView heroSpriteImageView = new ImageView(heroSpriteImage);
//        heroSpriteImageView.setViewport(new Rectangle2D(0, 0, 1024, 1024));
        final SpriteAnimation animation = new SpriteAnimation(
                heroSpriteImageView,
                Duration.millis(1000),
                8, 10, 10,
                0, 0,
                102, 102,
                new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0)),
                new ArrayList<>(Arrays.asList(7, 6, 5, 4, 3, 2, 1, 0)));
        animation.setCycleCount(Animation.INDEFINITE);
        heroSprites.add(new Sprite(heroSpriteImageView, animation));
    }

    private void loadMinionSprites() {
        Image heroSpriteImage = new Image("View/resource/Sprite/Minions/minion1.gif");
        ImageView heroSpriteImageView = new ImageView(heroSpriteImage);
        minionSprite.add(heroSpriteImageView);
    }

    public ImageView get(SpriteType type, String unitName) {
        if (type.equals(SpriteType.HERO))
            return heroSprites.get(0).getImageView();
        else return minionSprite.get(0);
    }

    public static SpriteBase getInstance() {
        return instance;
    }
}

