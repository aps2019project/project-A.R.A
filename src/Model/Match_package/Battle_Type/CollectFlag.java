package Model.Match_package.Battle_Type;

import Account_package.Account;
import Model.Item_package.Flag;
import Model.Match_package.Coordination;
import Model.Match_package.Match;
import Model.Match_package.Player;

import java.util.Random;

import static Model.Match_package.Battle_Type.MatchType.COLLECT_FLAG;

public class CollectFlag extends Match {
    final int FLAG_NUMBER;
    Flag[] flags;

    public CollectFlag(Account account, int numOfFlags) {
        super(account);
        this.FLAG_NUMBER = numOfFlags;
        flags= new Flag[FLAG_NUMBER];
        setMatchType(COLLECT_FLAG);
        setRandomFlags();
    }

    private void setRandomFlags(){
        Random random = new Random();
        for (int i = 0; i < FLAG_NUMBER; i++) {
            Coordination coordination;
            do {
                coordination = new Coordination(random.nextInt(5), random.nextInt(9));
            } while (coordination.equals(2, 0) || coordination.equals(2, 8)
                    || getMap().getCell(coordination).hasItem());
            flags[i] = new Flag(coordination);
        }
    }

    public Player checkGame() {
        return null; // just for now .
    }
}
