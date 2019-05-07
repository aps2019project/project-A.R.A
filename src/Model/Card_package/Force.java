package Model.Card_package;

import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Match_package.Player;

import java.util.ArrayList;

abstract public class Force extends Card {
    private int ap, hp;
    private AttackType attackType;
    private int range;
    ArrayList<Buff> buffs = new ArrayList<>();
    ArrayList<Effect> effects = new ArrayList<>();

    protected Force(String name, String ID, int price, int mana, String desc,
                    Player player, int ap, int hp, AttackType attackType, int range) {
        super(name, ID, price, mana, desc, player);
        this.ap = ap;
        this.hp = hp;
        this.attackType = attackType;
        this.range = range;
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
}
