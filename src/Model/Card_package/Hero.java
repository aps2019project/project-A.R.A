package Model.Card_package;

import Exceptions.HeroHasNotSpecilaPowerException;
import Model.Card_package.hero_special_power.HeroSpecialPower;
import Model.Match_package.Player;

public class Hero extends Force {

    private HeroSpecialPower specialPower;

    public Hero(String name, int price, int hp, int ap, String desc,
                Player player, AttackType attackType, int range, HeroSpecialPower specialPower) {
        super(name, price, 0, desc, player, ap, hp, attackType, range);
        this.setID(String.format("Hero_%s" , name));
        this.specialPower = specialPower;
    }

    protected Hero getCopy(Player player, String ID) {
        Hero newHero = new Hero(getName(), getPrice(), getHp(), getAp(), getDesc(), player,
                getAttackType(), getRange(), this.specialPower.getCopy());
        newHero.setID(ID);
        return newHero;
    }

    public void useSpecialPower(int x, int y) {
        if (specialPower == null) {
            throw new HeroHasNotSpecilaPowerException();
        }
        specialPower.canUseHeroSpecialPower(x, y);
        specialPower.doOnUseHeroSpecialPower(x, y);
    }

    public HeroSpecialPower getSpecialPower() {
        return specialPower;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Hero :  ");
        stringBuilder.append("Name : " + this.getName() + " ");
        stringBuilder.append("AP : " + this.getAp() + " ");
        stringBuilder.append("HP : " + this.getHp() + " ");
        stringBuilder.append("Class : " + this.getAttackType().toString() + " ");
        stringBuilder.append("SpecialPower : " + getDesc());
        return stringBuilder.toString();
    }
}