package Model.Match_package.Battle_Type;

import Account_package.Account;
import Model.Card_package.Card;
import Model.Item_package.Flag;
import Model.Match_package.Coordination;
import Model.Match_package.Match;
import Model.Match_package.Player;

public class HoldFlag extends Match {
    public Flag flag = new Flag(new Coordination(2, 5));
    public Card flagHolder;
    private int holdingTime;
    private final int WIN_POINT = 6; // can be taken from user

    public HoldFlag(Account account){
        super(account);
        setMatchType(MatchType.HOLD_FLAG);
        resetTime();
    }

    public Player checkGame(){
        if(holdingTime == WIN_POINT)
            return getCardOwner(flagHolder);
        else
            return null;
    }

    public void resetTime(){
        holdingTime = 0;
    }

    public void addTime(){
        holdingTime++;
    }
}
