package Model.Match_package;


import Model.Card_package.BuffType;
import Model.Card_package.Card;

import java.util.ArrayList;

class Cell {
    private Card card;
    private Item item; // ITEM
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
//            findPlayer(card).catchItem(item);
//            item = null;
//        }
    }

    boolean hasPlayerCard(Player player){
        // return findPlayer(card).equals(player);
        return true;
    }

    void setCard(Card card){
        this.card = card;
    }

    void setItem(Item item){
        this.item = item;
    }

    Cell addToCellEffect(CellEffect cellEffect){
        cellEffects.add(cellEffect);
        return this;
    }

    void deleteCard(){
        card = null;
    }

    Item getItem(){
        return item;
    }

    Card getCard(){
        return card;
    }

    public boolean hasCard() {
        if (this.card == null)
            return false;
        return true;
    }

    public boolean hasCard(Card card){
        return this.card.equals(card);
    }

    public boolean hasItem(){
        return item != null;
    }
}
