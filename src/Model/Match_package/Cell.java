package Model.Match_package;


import Model.Card_package.buff.BuffType;

import Model.Card_package.Card;
import Card_package.Force;

import java.util.ArrayList;

public class Cell {
    private Force force;
    private Item collectable; // ITEM
    private ArrayList<CellEffect> cellEffects = new ArrayList<>();

    void doCellEffect(){
        for(CellEffect cellEffect: cellEffects){
            switch (cellEffect){
                case FIRE:
                    if(true) // GameSituation == ChangeTurn
                    Buff.execute(force, BuffType.POISON );
                    break;
                case POISON:
                    Buff.execute(force, BuffType.POISON);
                    break;
                case HOLY:
                    Buff.execute(force, BuffType.HOLY);
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

    public boolean hasPlayerCard(Player player){
        // return findPlayer(card).equals(player);
        return true;
    }

    void setForce(Force force){
        this.force = force;
    }

    void setItem(Item item){
        this.item = item;
    }

    Cell addToCellEffect(CellEffect cellEffect){
        cellEffects.add(cellEffect);
        return this;
    }

    void deleteForce(){
        force = null;
    }

    Item getItem(){
        return item;
    }

    public Force getForce(){
        return force;
    }
    public boolean isEmpty() {
        if (this.force == null)
            return true;
        return false;
    }

    public void addCellEffect(CellEffect cellEffect) {
        this.cellEffects.add(cellEffect);
    }

    public boolean hasItem(){
        return item != null;
    }
}
