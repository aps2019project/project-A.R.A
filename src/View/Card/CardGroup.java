package View.Card;

import Model.Unit;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class CardGroup {
    private ArrayList<Unit> units = new ArrayList<>();

    public CardGroup(ArrayList<Unit> units) {
        this.units = units;
    }

    public ArrayList<GridPane> generate() {
        ArrayList<GridPane> gridPanes = new ArrayList<>();
        GridPane gridPane = newGridPane();

        int columnIndex = 0;
        int rowIndex = 0;
        for (int i = 0; i < units.size(); i++) {
            if (i % 8 == 0 && i != 0) {
                gridPanes.add(gridPane);
                gridPane = newGridPane();
                columnIndex = 0;
                rowIndex = 0;
            }
            if (i % 4 == 0 && i != 0 && i % 8 != 0){
                columnIndex = 0;
                rowIndex++;
            }
            gridPane.add(new CollectionCard(units.get(i)), columnIndex, rowIndex);
            columnIndex++;
        }
        gridPanes.add(gridPane);
        return gridPanes;
    }

    private GridPane newGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }
}
