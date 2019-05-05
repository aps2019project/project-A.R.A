package Model.Item_package;

import Menus.MenuManager;
import Model.Card_package.Card;
import Model.Item_package.Item;
import Model.Match_package.Coordination;
import Model.Match_package.Match;

public class Flag  {
    private boolean possesed = false;
    private Coordination coordination;
    private Card flagOwner;

    public Flag(Match match, Coordination coordination){
        this.coordination = coordination;
        match.getMap().getCell(coordination).setFlag(this);
    }

    public boolean hasOwner(){
        return flagOwner != null;
    }

    public Coordination getCoordination(){
        return coordination;
    }

    public Card getFlagOwner(){
        return flagOwner;
    }
}
