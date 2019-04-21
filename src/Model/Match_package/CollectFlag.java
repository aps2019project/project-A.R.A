package Model.Match_package;

import java.util.Random;

public class CollectFlag extends Match {
    public final int FLAG_NUMBER = 7;
    public Flag[] flag = new Flag[FLAG_NUMBER];

    CollectFlag() {
        super();
        Random random = new Random();
        for (int i = 0; i < FLAG_NUMBER; i++) {
            Coordination coordination;
            do {
                coordination = new Coordination(random.nextInt(5), random.nextInt(9));
            } while (coordination.equals(2, 0) || coordination.equals(2, 8)
                    || !getInstance().getMap().cells[coordination.getY()][coordination.getY()].hasItem());
            flag[i] = new Flag(coordination);
        }
    }

    public Player checkGame() {
        return null; // just for now .
    }
}
