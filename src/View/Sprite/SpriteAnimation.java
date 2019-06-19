package View.Sprite;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

class SpriteAnimation extends Transition {
    private final ImageView imageView;
    private final int count;
    private final int rows;
    private final int columns;
    private final int offsetX;
    private final int offsetY;
    private final int width;
    private final int height;
    private ArrayList<Integer> xIndexes;
    private ArrayList<Integer> yIndexes;
    private int lastIndex;
    private int drawCounter = 0;

    public SpriteAnimation(
            ImageView imageView,
            Duration duration,
            int count, int rows, int columns,
            int offsetX, int offsetY,
            int width, int height,
            ArrayList<Integer> xIndexes,
            ArrayList<Integer> yIndexes
    ) {
        this.imageView = imageView;
        this.count = count;
        this.rows = rows;
        this.columns = columns;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        this.xIndexes = xIndexes;
        this.yIndexes = yIndexes;
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double k) {
        try {
            final int index = Math.min((int) Math.floor(k * count), count - 1);
            if (k == 1) drawCounter = 0;
            if (index != lastIndex) {
                lastIndex = index;
                int x = xIndexes.get(drawCounter) * width + offsetX;
                int y = yIndexes.get(drawCounter) * height + offsetY;
                imageView.setViewport(new Rectangle2D(x, y, width, height));
                drawCounter++;
            }
        }catch (IndexOutOfBoundsException ignored){}
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }
}
