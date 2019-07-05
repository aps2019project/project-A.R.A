package Model.Match_package.Battle_Type;

import Account_package.Account;
import Model.Card_package.Flag;
import Model.Match_package.Coordination;
import Model.Match_package.Match;
import Model.Match_package.Player;

import static Model.Match_package.Battle_Type.MatchType.HOLD_FLAG;

public class HoldFlag extends Match {
    public Flag flag = new Flag();//todo put in map
    private int holdingTime; // todo increase holding time in turn change
    private final int WIN_POINT = 6; // can be taken from user

    public HoldFlag(Account account1, Account account2) {
        super(account1, account2);
        resetTime();
    }

    protected void checkGame() {
        super.checkGame();
        //todo
    }

    public void resetTime(){
        holdingTime = 0;
    }


    public int getHoldingTime() {
        return holdingTime;
    }
}
