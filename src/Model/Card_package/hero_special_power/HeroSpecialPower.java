package Model.Card_package.hero_special_power;

import Exceptions.HeroSpecialPowerIsnotUsableException;
import Exceptions.NotEnoughManaException;
import Exceptions.RemainCoolDownException;
import Exceptions.UseHeroSpecialPowerInvalidcoordinationException;
import Menus.MenuManager;
import Model.Card_package.Force;
import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Match_package.cell.Cell;
import Model.Match_package.cell.CellEffect;
import Model.Match_package.Coordination;
import Model.Match_package.Match;

import java.util.ArrayList;

public class HeroSpecialPower {
    private int mana;
    private int coolDown;
    private int remainCoolDown;
    HeroSpecialPowerTarget target;
    HeroSpecialPowerActivationTime activationTime;
    HeroSpecialPowerType type;
    ArrayList<Buff> buffs;
    ArrayList<Effect> effects;
    ArrayList<CellEffect> cellEffects;

    public HeroSpecialPower(int mana, int coolDown, HeroSpecialPowerTarget target,
                            HeroSpecialPowerActivationTime activationTime, HeroSpecialPowerType type,
                            ArrayList<Buff> buffs, ArrayList<Effect> effects, ArrayList<CellEffect> cellEffects) {
        this.mana = mana;
        this.coolDown = coolDown;
        this.remainCoolDown = 0;
        this.target = target;
        this.activationTime = activationTime;
        this.type = type;
        this.buffs = buffs;
        this.effects = effects;
        this.cellEffects = cellEffects;
    }


    public HeroSpecialPower getCopy() {
        return new HeroSpecialPower(mana, coolDown, target, activationTime, type,
                Buff.getCopy(buffs), Effect.getCopy(effects), CellEffect.getCopy(cellEffects));
    }

    public HeroSpecialPowerActivationTime getActivationTime() {
        return activationTime;
    }

    public boolean canUseHeroSpecialPower(int x, int y){
        if (activationTime != HeroSpecialPowerActivationTime.ON_USE)
            throw new HeroSpecialPowerIsnotUsableException();
        Match match = MenuManager.getCurrentMatch();
        if (mana > match.getOwnPlayer().getMana()) {
            throw new NotEnoughManaException();
        }
        if (remainCoolDown > 0)
            throw new RemainCoolDownException();
        switch (target) {
            case HIMSELF:
                return true;
            case ALL_ENEMY_FORCE_IN_ITS_ROW:
                Coordination coordination = match.getMap().getCoordination(match.getOwnPlayer().getDeck().getHero());
                for (Force force : match.getMap().getForcesInMap(match.getOwnPlayer(), coordination.getX(), 0, coordination.getX(), 8)) {
                    if (force.getPlayer().equals(match.getOpponent())) {
                        return true;
                    }
                }
                throw new UseHeroSpecialPowerInvalidcoordinationException();
            case ALL_ENEMY_FORCE:
                return true;
            case ENEMY_FORCE:
                if (match.getMap().getCell(x, y).hasForce() && match.getMap().getCell(x, y).getForce().getPlayer().equals(match.getOpponent()))
                    return true;
                throw new UseHeroSpecialPowerInvalidcoordinationException();
            case CELL:
                return true;
        }
        return true;
    }

    public void doOnUseHeroSpecialPower(int x, int y) {
        Match match = MenuManager.getCurrentMatch();
        remainCoolDown = coolDown;// todo reduce when our turn finished
        match.getOwnPlayer().reduceMana(mana);
        ArrayList<Force> forcesTarget = new ArrayList<>();
        ArrayList<Cell> cellsTarget = new ArrayList<>();
        switch (target) {
            case HIMSELF:
                forcesTarget.add(match.getOwnPlayer().getDeck().getHero());
                break;
            case CELL:
                cellsTarget.add(match.getMap().getCell(x, y));
                break;
            case ENEMY_FORCE:
                forcesTarget.add(match.getMap().getCell(x, y).getForce());
                break;
            case ALL_ENEMY_FORCE:
                for (Force force : match.getMap().getForcesInMap(match.getOpponent())) {
                    forcesTarget.add(force);
                }
                break;
            case ALL_ENEMY_FORCE_IN_ITS_ROW:
                Coordination coordination = match.getMap().getCoordination(match.getOwnPlayer().getDeck().getHero());
                for (Force force : match.getMap().getForcesInMap(match.getOwnPlayer(), coordination.getX(), 0, coordination.getX(), 8)) {
                    if (force.getPlayer().equals(match.getOpponent())) {
                        forcesTarget.add(force);
                    }
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
    }


    public HeroSpecialPowerTarget getTarget() {
        return target;
    }
}
