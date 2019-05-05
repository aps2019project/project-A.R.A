package Model.Card_package;

import Model.Card_package.hero_special_power.HeroSpecialPower;
import Model.Match_package.Player;

import java.util.ArrayList;

public class Hero extends Force {

    private ArrayList<HeroSpecialPower> specialPowers;

    public Hero(String name, String ID, int price, int mana, String desc,
                Player player, int ap, int hp, AttackType attackType, int range, ArrayList<HeroSpecialPower> specialPowers) {
        super(name, ID, price, mana, desc, player, ap, hp, attackType, range);
        this.specialPowers = specialPowers;
    }

    protected Hero getCopy(Player player, String ID) {
        return new Hero(getName(), ID, getPrice(), getMana(), getDesc(), player, getAp(), getHp(),
                getAttackType(), getRange(), HeroSpecialPower.getCopy(this.specialPowers));
    }

}
