package Match_package;


import Card_package.Card;

import java.util.ArrayList;

public class Cell {
    private Card card;
    private Item collectable; // ITEM
    private ArrayList<CellEffect> cellEffects = new ArrayList<>();

    void doCellEffect(){
        for(CellEffect cellEffect: cellEffects){
            switch (cellEffect){
                case FIRE:
                    if(true) // GameSituation == ChangeTurn
                    Buff.execute(card, BuffType.POISON );
                    break;
                case POISON:
                    Buff.execute(card, BuffType.POISON);
                    break;
                case HOLY:
                    Buff.execute(card, BuffType.HOLY);
                    break;
            }
        }
    }

    void assignCollectable(){
//        if(card != null) {
//            findPlayer(card).catchItem(collectable);
//            collectable = null;
//        }
    }

    boolean hasPlayerCard(Player player){
        // return findPlayer(card).equals(player);
        return true;
    }

    void setCard(Card card){
        this.card = card;
    }

    void setCollectable(Item item){
        collectable = item;
    }

    Cell addToCellEffect(CellEffect cellEffect){
        cellEffects.add(cellEffect);
        return this;
    }

    void deleteCard(){
        card = null;
    }

    Item getCollectable(){
        return collectable;
    }

    public Card getCard(){
        return card;
    }
    public boolean isEmpty() {
        if (this.card == null)
            return true;
        return false;
    }


}
