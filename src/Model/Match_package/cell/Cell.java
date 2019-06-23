package Model.Match_package.cell;


import Model.Card_package.Force;

import Model.Card_package.collectable.CollectAble;
import Model.Card_package.Flag;
import Model.Match_package.Coordination;

import java.util.ArrayList;

public class Cell {
    private Force force;
    private Coordination coordination;
    private CollectAble collectable; // ITEM
    private Flag flag;
    private ArrayList<CellEffect> cellEffects = new ArrayList<>();
    private boolean hasFlag = false;

    public Cell(int x, int y) {
        coordination = new Coordination(x, y);
    }

    public Coordination getCoordination() {
        return coordination;
    }

    public void holdsFlag(){
        hasFlag = true;
    }

    public void leaveFlag(){
        hasFlag = false;
    }

    public boolean hasFlag(){
        return hasFlag;
    }

    void doCellEffect() {//todo on turn
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

    public void setCollectable(CollectAble collectable) {
        this.collectable = collectable;
    }

    public void removeCollectable() {
        this.collectable = null;
    }

    public void addCellEffectByCopy(ArrayList<CellEffect> cellEffects) {
        for (CellEffect cellEffect : cellEffects)
            this.cellEffects.add(cellEffect.getCopy());
    }

    public CollectAble getCollectable() {
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

    public String toString(){
        return String.format("(%d, %d)", coordination.getX(), coordination.getY());
    }
}
