package Model.Match_package.Battle_Type;

import Account_package.Account;
import Model.Card_package.Flag;
import Model.Match_package.Coordination;
import Model.Match_package.Match;
import Model.Match_package.Player;

import java.util.Random;

import static Model.Match_package.Battle_Type.MatchType.COLLECT_FLAG;

public class CollectFlag extends Match {
    private final int FLAG_NUMBER;



    public CollectFlag(Account account1, Account account2, int numOfFlag) {
        super(account1, account2);
        this.FLAG_NUMBER = numOfFlag;
        setRandomFlags();
    }



    private void setRandomFlags() {
        //todo
//        Random random = new Random();
//        for (int i = 0; i < FLAG_NUMBER; i++) {
//            Coordination coordination;
//            do {
//                coordination = new Coordination(random.nextInt(5), random.nextInt(9));
//            } while (coordination.equals(2, 0) || coordination.equals(2, 8)
//                    || getMap().getCell(coordination).hasCollectable());
//            flags[i] = new Flag(this, coordination);
//        }
    }


}