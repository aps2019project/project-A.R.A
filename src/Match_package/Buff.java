package Match_package;


public class Buff {
    public static void execute(Object object, BuffType buffType, int amount) { // CARD
        switch (buffType) {
            case HOLY:
                // card.HP++;
                break;
            case STUN:
                // card.cantMove = amount;
                break;
            case DISARM:
                // card.cantCounterAttack = amount;
                break;
            case POWER_AP:
                // card.Ap += amount;
                break;
            case POWER_HP:




                // card.HP += amount;
                break;
            case WEAKNESS_AP:
                // card.AP -= amount;
                break;
            case WEAKNESS_HP:
            case POISON:
                // card.HP -= amount;
                break;
        }
    }

    static void execute(Object object, BuffType buffType) {
        execute(object, buffType, 0);
    }

}


