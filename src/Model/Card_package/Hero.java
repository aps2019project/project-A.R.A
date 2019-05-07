package Model.Card_package;

import Exceptions.HeroHasNotSpecilaPowerException;
import Exceptions.HeroSpecialPowerIsnotUsableException;
import Menus.MenuManager;
import Model.Card_package.hero_special_power.HeroSpecialPower;
import Model.Card_package.hero_special_power.HeroSpecialPowerActivationTime;
import Model.Card_package.hero_special_power.HeroSpecialPowerTarget;
import Model.Match_package.Cell;
import Model.Match_package.Match;
import Model.Match_package.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    public void useSpecialPower(int x, int y) {
        Match match = MenuManager.getCurrentMatch();
        for (HeroSpecialPower specialPower : specialPowers) {
            specialPower.canDoHeroSpecialPower();
        }
        if (specialPowers.size() == 0)
            throw new HeroHasNotSpecilaPowerException();
        for (HeroSpecialPower specialPower : specialPowers) {
            if (specialPower.getActivationTime() != HeroSpecialPowerActivationTime.ON_USE)
                throw new HeroSpecialPowerIsnotUsableException();
            Set<Cell> cells = new HashSet<>();
            Set<Force> forces = new HashSet<>();
            if (specialPower.getTarget() == HeroSpecialPowerTarget.CELL)
                cells.add(match.getMap().getCell(x, y));
            if (specialPower.getTarget() == HeroSpecialPowerTarget.ENEMY_FORCE)
                if (!match.getMap().getCell(x, y).isEmpty())
                    forces.add(match.getMap().getCell(x, y).getForce());
            specialPower.doHeroSpecialPower(forces, cells);
        }
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
