package Match_package;

import java.util.ArrayList;

public class Match {
    protected Player ownPlayer;
    protected Player opponent;
    protected final Cell[][] cells = new Cell[5][9];
    protected int round = 1;                        // using turn not considered .
    private MatchMode matchMode;
    protected static int defaultMana = 2;

    protected void changeTurn() {
        Player temp = ownPlayer;
        ownPlayer = opponent;
        opponent = temp;
        if (round > 7)
            setDefaultMana(defaultMana + 1);

    }


    private static void setDefaultMana(int num) {
        defaultMana = num;
    }


}

class GraveYard {
}


class Player {

}

class Cell {

}

enum MatchMode {
    KILL_HERO, HOLD_FLAG, COLLECT_FLAG;
}