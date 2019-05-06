package Model.Card_package;

import Model.Card_package.minion_special_power.MinionSpecialPower;
import Model.Match_package.Player;

import java.util.ArrayList;

public class Minion extends Force {

    private ArrayList<MinionSpecialPower> specialPowers ;

    public Minion(String name, String ID, int price, int mana, int hp, int ap, String desc,
                  Player player,  AttackType attackType, int range, ArrayList<MinionSpecialPower> specialPowers) {
        super(name, ID, price, mana, desc, player, ap, hp, attackType, range);
        this.specialPowers = specialPowers;
    }

    protected Minion getCopy(Player player, String ID) {
        return new Minion(this.getName(), ID, this.getPrice(), this.getMana(), getHp(), getAp(), getDesc()
                , player, getAttackType(), getRange(), MinionSpecialPower.getCopy(this.specialPowers));

    }
}
