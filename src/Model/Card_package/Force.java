package Model.Card_package;

import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Match_package.Player;

import java.util.ArrayList;

abstract public class Force extends Card {
    private int ap, hp;
    private AttackType attackType;
    private int range;
    ArrayList<Flag> flags = new ArrayList<>();
    private boolean movedInThisTurn, attackedInThisTurn;
    ArrayList<Buff> buffs = new ArrayList<>();
    ArrayList<Effect> effects = new ArrayList<>();
    boolean hasFlag = false;

    protected Force(String name, int price, int mana, String desc,
                    Player player, int ap, int hp, AttackType attackType, int range) {
        super(name, price, mana, desc, player);
        this.ap = ap;
        this.hp = hp;
        this.attackType = attackType;
        this.range = range;
        movedInThisTurn = true;
        attackedInThisTurn = true;
    }

    public void getFlag() {
        hasFlag = true;
    }

    public void leaveFlag() {
        hasFlag = false;
    }

    public boolean hasFlag() {
        return hasFlag;
    }

    public void addBuffByCopy(ArrayList<Buff> buffs) {
        for (Buff buff : buffs) {
            this.buffs.add(buff.getCopy());
        }
    }

    public void addEffectByCopy(ArrayList<Effect> effects) {
        for (Effect effect : effects) {
            this.effects.add(effect.getCopy());
        }
        //todo handle on time effects
        // it mean that if add an effect on force it should be considered on time
    }

    public void setAttackedInThisTurn(boolean attackedInThisTurn) {
        this.attackedInThisTurn = attackedInThisTurn;
    }

    public void setMovedInThisTurn(boolean movedInThisTurn) {
        this.movedInThisTurn = movedInThisTurn;
    }

    public int getAp() {
        return ap;
    }

    public int getHp() {
        return hp;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public int getRange() {
        return range;
    }

    public void addFlag(Flag flag) {
        flags.add(flag);
    }
}
