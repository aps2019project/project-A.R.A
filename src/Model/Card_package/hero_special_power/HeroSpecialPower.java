package Model.Card_package.hero_special_power;

import Exceptions.HeroSpecialPowerIsnotUsableException;
import Exceptions.NotEnoughManaException;
import Exceptions.RemainCoolDownException;
import Exceptions.UseHeroSpecialPowerInvalidcoordinationException;
import Menus.MenuManager;
import Model.Card_package.Force;
import Model.Card_package.Minion;
import Model.Card_package.buff.Buff;
import Model.Card_package.buff.BuffType;
import Model.Card_package.effect.Effect;
import Model.Card_package.minion_special_power.MinionSpecialPowerType;
import Model.Match_package.Player;
import Model.Match_package.cell.Cell;
import Model.Match_package.cell.CellEffect;
import Model.Match_package.Coordination;
import Model.Match_package.Match;

import java.util.ArrayList;

public class HeroSpecialPower {
    private int mana;
    private int coolDown;
    private int remainCoolDown;
    private HeroSpecialPowerTarget target;
    private HeroSpecialPowerActivationTime activationTime;
    private HeroSpecialPowerType type;
    private ArrayList<Buff> buffs;
    private ArrayList<Effect> effects;
    private ArrayList<CellEffect> cellEffects;

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

    public void canUseHeroSpecialPower(int x, int y){
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
                return;
            case ALL_ENEMY_FORCE_IN_ITS_ROW:
                Coordination coordination = match.getMap().getCoordination(match.getOwnPlayer().getHand().getHero());
                for (Force force : match.getMap().getForcesInMap(match.getOwnPlayer(), coordination.getX(), 0, coordination.getX(), 8)) {
                    if (force.getPlayer().equals(match.getOpponent())) {
                        return;
                    }
                }
                throw new UseHeroSpecialPowerInvalidcoordinationException();
            case ALL_ENEMY_FORCE:
                return;
            case ENEMY_FORCE:
                if (match.getMap().getCell(x, y).hasForce() && match.getMap().getCell(x, y).getForce().getPlayer().equals(match.getOpponent()))
                    return;
                throw new UseHeroSpecialPowerInvalidcoordinationException();
            case CELL:
        }
    }

    public void doOnUseHeroSpecialPower(int x, int y) {
        Match match = MenuManager.getCurrentMatch();
        remainCoolDown = coolDown;// todo reduce when our turn finished
        match.getOwnPlayer().reduceMana(mana);
        ArrayList<Force> forcesTarget = new ArrayList<>();
        ArrayList<Cell> cellsTarget = new ArrayList<>();
        fillOnUseHeroSpecialPower(x, y, match, forcesTarget, cellsTarget);
        affectOnTarget(forcesTarget, cellsTarget);
    }

    private void fillOnUseHeroSpecialPower(int x, int y, Match match, ArrayList<Force> forcesTarget, ArrayList<Cell> cellsTarget) {
        switch (target) {
            case HIMSELF:
                forcesTarget.add(match.getOwnPlayer().getHand().getHero());
                break;
            case CELL:
                cellsTarget.add(match.getMap().getCell(x, y));
                break;
            case ENEMY_FORCE:
                forcesTarget.add(match.getMap().getCell(x, y).getForce());
                break;
            case ALL_ENEMY_FORCE:
                forcesTarget.addAll(match.getMap().getForcesInMap(match.getOpponent()));
                break;
            case ALL_ENEMY_FORCE_IN_ITS_ROW:
                Coordination coordination = match.getMap().getCoordination(match.getOwnPlayer().getHand().getHero());
                for (Force force : match.getMap().getForcesInMap(match.getOwnPlayer(), coordination.getX(), 0, coordination.getX(), 8)) {
                    if (force.getPlayer().equals(match.getOpponent())) {
                        forcesTarget.add(force);
                    }
                }
                break;
        }
    }

    public void doOnStartHeroSpecialPower(Player player) {
        ArrayList<Force> forcesTarget = new ArrayList<>();
        switch (target) {
            case HIMSELF:
                forcesTarget.add(player.getHand().getHero());
                break;
        }
        affectOnTarget(forcesTarget, new ArrayList<>());
    }

    public void doOnAttackHeroSpecialPower(Force damagedForce) {
        ArrayList<Force> forces = new ArrayList<>();
        forces.add(damagedForce);
        affectOnTarget(forces, new ArrayList<>());
    }

    private void affectOnTarget(ArrayList<Force> forcesTarget, ArrayList<Cell> cellsTarget) {
        Match match = Match.getCurrentMatch();

        if (type == HeroSpecialPowerType.CELL_EFFECT) {
            for (Cell cell : cellsTarget) {
                cell.addCellEffectByCopy(cellEffects);
            }
        }
        else if (type == HeroSpecialPowerType.BUFFS ) {
            for (Force force : forcesTarget) {
                if (force.getPlayer().equals(match.getOpponent()) && force instanceof Minion &&
                        ((Minion)force).getSpecialPower() != null) {
                    if (((Minion) force).getSpecialPower().getType() == MinionSpecialPowerType.UN_POISON) {
                        force.addBuffByCopy(buffs, BuffType.POISON);
                        return;
                    }
                    if (((Minion) force).getSpecialPower().getType() == MinionSpecialPowerType.UN_DISARM) {
                        force.addBuffByCopy(buffs, BuffType.DISARM);
                        return;
                    }
                }
                force.addBuffByCopy(buffs);
            }
        }
        else if (type == HeroSpecialPowerType.EFFECTS) {
            for (Force force : forcesTarget) {
                if (force.getPlayer().equals(match.getOpponent()) && force instanceof Minion &&
                        ((Minion)force).getSpecialPower() != null &&
                        ((Minion)force).getSpecialPower().getType() == MinionSpecialPowerType.ANTI_BAD_EFFECT )
                    force.addPositiveEffectByCopy(effects);
                else
                    force.addEffectByCopy(effects);
            }
        }
    }

    public HeroSpecialPowerTarget getTarget() {
        return target;
    }

    public void decreamentRemainCoolDown() {
        remainCoolDown --;
        if (remainCoolDown < 0)
            remainCoolDown = 0;
    }
}
