package Model.Match_package.Battle_Type;

import Account_package.Account;
import Model.Card_package.Card;
import Model.Item_package.Flag;
import Model.Match_package.Coordination;
import Model.Match_package.Match;
import Model.Match_package.Player;

public class HoldFlag extends Match {
    public Flag flag = new Flag(this, new Coordination(2, 5));
    private int holdingTime; // todo increase holding time in turn change
    private final int WIN_POINT = 6; // can be taken from user

    public HoldFlag(Account account){
        super(account);
        setMatchType(MatchType.HOLD_FLAG);
        resetTime();
    }

    public Player IsWinner(Player player){
        if(holdingTime == WIN_POINT)
            return getCardOwner(flag.getFlagOwner());
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
