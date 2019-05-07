package Model.Card_package;

import Model.Card_package.hero_special_power.HeroSpecialPower;
import Model.Match_package.Player;

import java.util.ArrayList;

public class Hero extends Force {

    private ArrayList<HeroSpecialPower> specialPowers;

    public Hero(String name, String ID, int price, int hp, int ap, String desc,
                Player player, AttackType attackType, int range, ArrayList<HeroSpecialPower> specialPowers) {
        super(name, ID, price, 0, desc, player, ap, hp, attackType, range);
        this.specialPowers = specialPowers;
    }

    protected Hero getCopy(Player player, String ID) {
        return new Hero(getName(), ID, getPrice(), getHp(), getAp(), getDesc(), player,
                getAttackType(), getRange(), HeroSpecialPower.getCopy(this.specialPowers));
    }

    public ArrayList<HeroSpecialPower> getSpecialPowers() {
        return specialPowers;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Hero :  ");
        stringBuilder.append("Name : " + this.getName() +" ");
        stringBuilder.append("AP : " + this.getAp() +" ");
        stringBuilder.append("HP : " + this.getHp() +" ");
        stringBuilder.append("Class : " + this.getAttackType().toString() +" ");
        stringBuilder.append("SpecialPower : "  +getDesc());
        return stringBuilder.toString();
    }

}
