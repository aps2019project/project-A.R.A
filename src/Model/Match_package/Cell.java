package Model.Match_package;


import Model.Card_package.Card;
import Model.Card_package.Force;

import Model.Item_package.Collectable;
import Model.Item_package.Flag;
import Model.Item_package.Item;
import Model.Item_package.Usable;

import java.util.ArrayList;

public class Cell {
    private Force force;
    private Collectable collectable; // ITEM
    private ArrayList<CellEffect> cellEffects = new ArrayList<>();
    private Flag flag;
    private Coordination coordination;

    Cell(int x, int y) {
        coordination = new Coordination(x, y);
    }

    public Coordination getCoordination() {
        return coordination;
    }

    void doCellEffect() {
//        for(CellEffect cellEffect: cellEffects){
//            switch (cellEffect.getCellEffectType()){
//                case FIRE:
//                    if(true) // GameSituation == ChangeTurn
//                    Buff.execute(force, BuffType.POISON );
//                    break;
//                case POISON:
//                    Buff.execute(force, BuffType.POISON);
//                    break;
//                case HOLY:
//                    Buff.execute(force, BuffType.HOLY);
//                    break;
//            }
//        }
    }

    void assignCollectable() {
//        if(card != null) {
//            findPlayer(card).catchItem(item);
//            item = null;
//        }
    }

    public void setCollectable(Collectable collectable) {
        this.collectable = collectable;
    }

    public void removeCollectable() {
        this.collectable = null;
    }

    public void addCellEffectByCopy(ArrayList<CellEffect> cellEffects) {
        for (CellEffect cellEffect : cellEffects)
            this.cellEffects.add(cellEffect.getCopy());
    }

    public Collectable getCollectable() {
        return collectable;
    }


    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public void removeFlag() {
        this.flag = null;
    }

    public Flag getFlag() {
        return flag;
    }

    public Force getForce() {
        return force;
    }

    public boolean hasForce() {
        return force != null;
    }

    public boolean hasCollectable(){
        return collectable != null;
    }


    public boolean hasForce(Force force) {
        return force.equals(this.force);
    }

    public void deleteForce() {
        force = null;
    }

    public void setForce(Force force) {
        this.force = force;
    }

    public boolean isEmpty(){
        return !(hasForce() || hasCollectable());
    }
}
