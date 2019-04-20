package Model.Match_package;

import Model.Card_package.Card;

public class Flag extends Item{
    private boolean possesed = false;
    private Coordination coordination;
    private Card flagOwner;

    Flag(Coordination coordination){
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
