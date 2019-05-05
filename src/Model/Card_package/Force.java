package Model.Card_package;

import Model.Card_package.buff.Buff;
import Model.Match_package.Player;

import java.util.ArrayList;

abstract public class Force extends Card {
    private int ap, hp;
    private AttackType attackType;
    private int range;

    protected Force(String name, String ID, int price, int mana, String desc,
                    Player player, int ap, int hp, AttackType attackType, int range) {
        super(name, ID, price, mana, desc, player);
        this.ap = ap;
        this.hp = hp;
        this.attackType = attackType;
        this.range = range;
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
