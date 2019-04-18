package Match_package;

public class Match {
    protected Player ownPlayer;
    protected Player opponent;
    protected final Cell[][] cells = new Cell[5][9];
    protected int round = 1;                        // using turn not considered .
    private MatchMode matchMode;
    protected static int defaultMana = 2;
    private static Match matchInstance;

    private Match(){ }
    public void startNewMatch() {
        Match.matchInstance = new Match();
    }
    public static Match getInstance() {
        return matchInstance;
    }


    protected void changeTurn() {
        Player temp = ownPlayer;
        ownPlayer = opponent;
        opponent = temp;
    }

    protected void changeRound(){
        if (round > 7)
            setDefaultMana(defaultMana + 1);
        changeTurn();
    }

    private static void setDefaultMana(int num) {
        defaultMana = num;
    }

    void addToGraveYard(Player player, Card card){
//        player.graveYard.addCard(card);
    }
    public Cell getCell(int x, int y) {
        return cells[x][y];
    }
}



