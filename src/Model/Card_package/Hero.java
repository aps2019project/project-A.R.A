package Model.Card_package;

import Model.Card_package.hero_special_power.HeroSpecialPower;
import Model.Match_package.Player;

public class Hero extends Force {

    private HeroSpecialPower heroSpecialPower;

    public Hero(String name, String ID, int price, int mana, String desc,
                Player player, int ap, int hp, AttackType attackType, int range, HeroSpecialPower heroSpecialPower) {
        super(name, ID, price, mana, desc, player, ap, hp, attackType, range);
        this.heroSpecialPower = heroSpecialPower;
    }

    public Hero getCopy(Player player, String ID) {
        return new Hero(getName(), ID, getPrice(), getMana(), getDesc(), player, getAp(), getHp(),
                getAttackType(), getRange(), heroSpecialPower.getCopy());
    }

}
