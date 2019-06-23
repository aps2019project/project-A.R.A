package Model.Card_package;

import Model.Match_package.Coordination;
import Model.Match_package.Match;

public class Flag  {
    private boolean possesed = false;
    private Coordination coordination;
    private Force flagOwner;

    public Flag(Match match, Coordination coordination){
        this.coordination = coordination;
        match.getMap().getCell(coordination).setFlag(this);
    }


    public Coordination getCoordination(){
        return coordination;
    }

}
