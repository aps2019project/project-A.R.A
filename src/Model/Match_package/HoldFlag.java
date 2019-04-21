package Model.Match_package;

import Model.Card_package.Card;

public class HoldFlag extends Match {
    public Flag flag = new Flag(new Coordination(2, 5));
    public Card flagHolder;
    private int holdingTime;
    private final int WIN_POINT = 6;

    HoldFlag(){
        super();
        resetTime();
    }

    public Player checkGame(){
        if(holdingTime == WIN_POINT)
            return getInstance().getCardOwner(flagHolder);
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
