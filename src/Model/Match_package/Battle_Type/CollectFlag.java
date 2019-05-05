package Model.Match_package.Battle_Type;

import Account_package.Account;
import Model.Card_package.Card;
import Model.Card_package.Force;
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
        flags = new Flag[FLAG_NUMBER];
        setMatchType(COLLECT_FLAG);
        setRandomFlags();
    }

    private void setRandomFlags() {
        Random random = new Random();
        for (int i = 0; i < FLAG_NUMBER; i++) {
            Coordination coordination;
            do {
                coordination = new Coordination(random.nextInt(5), random.nextInt(9));
            } while (coordination.equals(2, 0) || coordination.equals(2, 8)
                    || getMap().getCell(coordination).hasItem());
            flags[i] = new Flag(this, coordination);
        }
    }

    public Player checkGame(Player player) {
//        int playerFlags = 0;
//        for (Card card :ownPlayer.getAllPlayerCards()){
//            if(card instanceof Force){
//                Force force = ((Force) card);
//                if(force.hasFlag)
//                    playerFlags++;
//            }
//        }
//        if(playerFlags >=FLAG_NUMBER/2)
//            return ownPlayer;
        return null;
    }
    // todo each force can hold a flag and leave it in map when dead
}