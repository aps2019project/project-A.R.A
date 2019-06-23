package View.Sprite;

import javafx.scene.image.ImageView;

public class Sprite extends ImageView{
    private ImageView imageView;
    private SpriteAnimation animation;

    public Sprite(ImageView imageView, SpriteAnimation animation) {
        this.imageView = imageView;
        this.animation = animation;
    }

    public ImageView getImageView() {
        animation.play();
        this.maxHeight(animation.getHeight());
        this.maxWidth(animation.getWidth());
        return imageView;
    }
}
