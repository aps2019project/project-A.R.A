package Model.Card_package.hero_special_power;

import Menus.MenuManager;
import Model.Card_package.Force;
import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Match_package.Cell;
import Model.Match_package.CellEffect;
import Model.Match_package.Match;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HeroSpecialPower {
    private int mana;
    private int cooldown;
    private int remainCooldown;
    HeroSpecialPowerTarget target;
    HeroSpecialPowerActivationTime activationTime;
    HeroSpecialPowerType type;
    ArrayList<Buff> buffs;
    ArrayList<Effect> effects;
    ArrayList<CellEffect> cellEffects;

    public HeroSpecialPower(int mana, int cooldown, HeroSpecialPowerTarget target,
                            HeroSpecialPowerActivationTime activationTime, HeroSpecialPowerType type,
                            ArrayList<Buff> buffs, ArrayList<Effect> effects, ArrayList<CellEffect> cellEffects) {
        this.mana = mana;
        this.cooldown = cooldown;
        this.remainCooldown = 0;
        this.target = target;
        this.activationTime = activationTime;
        this.type = type;
        this.buffs = buffs;
        this.effects = effects;
        this.cellEffects = cellEffects;
    }

    public static ArrayList<HeroSpecialPower> getCopy(ArrayList<HeroSpecialPower> specialPowers) {
        ArrayList<HeroSpecialPower> copy = new ArrayList<>();
        for (HeroSpecialPower specialPower : specialPowers)
            copy.add(specialPower.getCopy());
        return copy;
    }

    private HeroSpecialPower getCopy() {
        return new HeroSpecialPower(mana, cooldown, target, activationTime, type,
                Buff.getCopy(buffs), Effect.getCopy(effects), CellEffect.getCopy(cellEffects));
    }

    public HeroSpecialPowerActivationTime getActivationTime() {
        return activationTime;
    }

    //todo complete
    public void doMinionSpecialPower(Set<Force> forcesTarget, Set<Cell> cellsTarget) {
        Match match = MenuManager.getCurrentMatch();
        switch (target) {
            case HIMSELF:
                forcesTarget.add(match.getOwnPlayer().getDeck().getHero());
            break;
            case CELL:
            case ENEMY_FORCE:
            case HITED_FORCE:
            case ALL_ENEMY_FORCE:
                for (Force force : match.getMap().getForcesInMap(match.getOpponent())) {
                    forcesTarget.add(force);
                }
                break;
            case ALL_FORCE_IN_ITS_ROW:
                int hero_y = match.getMap().getCoordination(match.getOwnPlayer().getDeck().getHero()).getY();
                for (Force force : match.getMap().getForcesINMap(0, hero_y, 9, hero_y)) {
                    forcesTarget.add(force);
                }
                break;
        }
        if (type == HeroSpecialPowerType.CELL_EFFECT) {
            for (Cell cell : cellsTarget) {
                cell.addCellEffectByCopy(cellEffects);
            }
        }
        if (type == HeroSpecialPowerType.BUFFS ) {
            for (Force force : forcesTarget) {
                force.addBuffByCopy(buffs);
            }
        }
        if (type == HeroSpecialPowerType.EFFECTS) {
            for (Force force : forcesTarget) {
                force.addEffectByCopy(effects);
            }
        }
//                if (HeroSpecialPowerActivationTime.ON_USE) check shaved mana darad va cooldown
    }

}
