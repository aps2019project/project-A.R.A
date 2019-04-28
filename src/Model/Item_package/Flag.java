package Model.Item_package;

import Model.Card_package.Card;
import Model.Item_package.Item;
import Model.Match_package.Coordination;
import Model.Match_package.Match;

public class Flag extends Item {
    private boolean possesed = false;
    private Coordination coordination;
    private Card flagOwner;

    public Flag(Coordination coordination){
        this.coordination = coordination;
        Match.getInstance().getMap().getCell(coordination).setItem(this);
    }

    public boolean hasOwner(){
        return flagOwner != null;
    }

    public Coordination getCoordination(){
        return coordination;
    }

}
