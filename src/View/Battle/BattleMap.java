package View.Battle;

import javafx.geometry.Insets;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;

public class BattleMap extends GridPane {
    ArrayList<ArrayList<MapCell>> mapColumns;

    public BattleMap() {
        mapColumns = new ArrayList<>();
        this.setVgap(5);
        this.setHgap(5);
        for(int i = 0; i< 9; i++){
            ArrayList<MapCell> mapCells = new ArrayList<>();
            for(int j = 0; j<5; j++){
                MapCell cell = new MapCell();
                mapCells.add(cell);
                this.add(cell, i, j);
            }
            mapColumns.add(mapCells);
        }
        this.setPadding(new Insets(50));

        PerspectiveTransform e = new PerspectiveTransform();
        e.setUlx(370);
        e.setUly(0);
        e.setUrx(1230);
        e.setUry(0);
        e.setLlx(220);
        e.setLly(450);
        e.setLrx(1330);
        e.setLry(450);
        this.setEffect(e);
    }
}