package Model.Card_package;

import Model.Card_package.buff.Buff;
import Model.Card_package.buff.BuffType;
import Model.Card_package.effect.Effect;
import Model.Card_package.effect.EffectType;
import Model.Match_package.Player;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;

abstract public class Force extends Card {
    private int ap, hp;
    private AttackType attackType;
    private int range;
    private ArrayList<Flag> flags = new ArrayList<>();
    private boolean movedInThisTurn, attackedInThisTurn;
    private ArrayList<Buff> buffs = new ArrayList<>();
    private ArrayList<Effect> effects = new ArrayList<>();
    private boolean hasFlag = false;

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

    public void addBuffByCopy(ArrayList<Buff> buffs, BuffType exceptBuffType) {
        ArrayList<Buff> result = new ArrayList<>();
        for (Buff buff : buffs) {
            if (buff.getBuffType() == exceptBuffType)
                continue;
            result.add(buff);
        }
        addBuffByCopy(result);
    }

    public void addEffectByCopy(ArrayList<Effect> effects) {
        for (Effect effect : effects) {
            this.effects.add(effect.getCopy());
        }
        //todo handle on time effects
        // it mean that if add an effect on force it should be considered on time
        // dispel depend on is positive or negative
    }

    public void addPositiveEffectByCopy(ArrayList<Effect> effects) {
        ArrayList<Effect> positiveEffects = new ArrayList<>();
        for (Effect effect : effects) {
            if (effect.isPositive())
                positiveEffects.add(effect);
        }
        addEffectByCopy(positiveEffects);
    }

    public void removePositiveEffects() {
        ArrayList<Effect> effects = new ArrayList<>();
        for (Effect effect : this.effects) {
            if (!effect.isPositive())
                effects.add(effect);
        }
        this.effects = effects;
    }



    public void setAttackedInThisTurn(boolean attackedInThisTurn) {
        this.attackedInThisTurn = attackedInThisTurn;
    }

    public void setMovedInThisTurn(boolean movedInThisTurn) {
        this.movedInThisTurn = movedInThisTurn;
    }

    public boolean isStun() {
        for (Buff buff : buffs) {
            if (buff.getBuffType() == BuffType.STUN)
                return true;
        }
        return false;
    }
    public int getHoly(){
        int sumOfHoly = 0;
        for (Buff buff : buffs) {
            if (buff.getBuffType() == BuffType.HOLY)
                sumOfHoly += buff.getUnit();
        }
        return sumOfHoly;
    }

    public int getAp() {
        int ap = this.ap;
        for (Buff buff : buffs) {
            if (buff.getBuffType() == BuffType.POWER_AP)
                ap += buff.getUnit();
            else if (buff.getBuffType() == BuffType.WEAKNESS_AP)
                ap -= buff.getUnit();
        }
        return ap;

    }

    public int getHp() {
        int hp = this.hp;
        for (Buff buff : buffs) {
            if (buff.getBuffType() == BuffType.POWER_HP)
                hp += buff.getUnit();
            else if (buff.getBuffType() == BuffType.WEAKNESS_HP)
                hp += buff.getUnit();
        }
        return hp;
    }

    public void decreamentHp(int number) {
        hp -= number;
        if (hp <= 0) {
            hp = 0;
        }
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public int getRange() {
        return range;
    }

    public boolean isDisarm() {
        for (Buff buff : buffs) {
            if (buff.getBuffType() == BuffType.DISARM)
                return true;
        }
        return false;
    }

    public void addFlag(Flag flag) {
        flags.add(flag);
    }

    public void decrementBuffAndEffectTime() {
        for (int i = 0; i < buffs.size(); i++) {
            buffs.get(i).decrementTime();
            if (buffs.get(i).isFinished()) {
                buffs.remove(i);
                i--;
            }
        }
        for (int i = 0; i < effects.size(); i++) {
            effects.get(i).decrementTime(this);
            if (effects.get(i).isFinished()) {
                i--;
                effects.remove(i + 1);
            }
        }
    }

    public void incrementAP(int number) {
        this.ap += number;
    }

    public void incrementHp(int number) {
        hp += number;
    }
}
