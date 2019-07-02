package Model.Card_package.minion_special_power;

import Menus.MenuManager;
import Model.Card_package.Force;
import Model.Card_package.Minion;
import Model.Card_package.buff.Buff;
import Model.Card_package.buff.BuffType;
import Model.Card_package.effect.Effect;
import Model.Match_package.Match;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MinionSpecialPower {
    private MinionSpecialPowerActivationTime activationTime;
    private MinionSpecialPowerTarget target;
    private MinionSpecialPowerType type;
    private ArrayList<Buff> buffs;
    private ArrayList<Effect> effects;

    public MinionSpecialPower(MinionSpecialPowerActivationTime activationTime, MinionSpecialPowerTarget target,
                              MinionSpecialPowerType type, ArrayList<Buff> buffs, ArrayList<Effect> effects) {
        this.activationTime = activationTime;
        this.target = target;
        this.type = type;
        this.buffs = buffs;
        this.effects = effects;
    }

    public void doOnSpawnSpecialPower(int x, int y) {
        Set<Force> targetForce = new HashSet<>();
        fillOnSpawnSpecialPowerTarget(x, y, targetForce);
        doOnSpawnSpecialPowerTarget(targetForce);
    }

    private void fillOnSpawnSpecialPowerTarget(int x, int y, Set<Force> targetForce) {
        Match match = MenuManager.getCurrentMatch();
        switch (target) {
            case HIMSELF:
                targetForce.add(match.getMap().getCell(x, y).getForce());
                break;
            case UNTIL_2_DISTANCE_MINIONS:
                for (int i = -2; i <= 2; i++)
                    for (int j = -2; j <= 2; j++) {
                        if (0 <= x + i && x + i <= 4 && 0 <= y + j && y + j <= 8)
                            targetForce.add(match.getMap().getCell(x + i, y + j).getForce());
                    }
                break;
            case RANDOM_ENEMY_MINION:
                targetForce.addAll(match.getMap().getForcesInMap(match.getOpponent()));
                break;
            case ENEMY_MINIONS_IN_NEIGHBOR:
                targetForce.addAll(match.getMap().getForcesInMap(match.getOpponent(), Math.max(0, x - 1), Math.max(0, y - 1), Math.min(4, x + 1), Math.max(8, y + 1)));
                break;
        }
    }

    private void doOnSpawnSpecialPowerTarget(Set<Force> targetForce) {
        if (type == MinionSpecialPowerType.EFFECTS)
            for (Force force : targetForce) {
                force.addEffectByCopy(effects);
            }
        if (type == MinionSpecialPowerType.BUFFS)
            for (Force force : targetForce) {
                force.addBuffByCopy(buffs);
            }
    }

    public void doOnAttackSpecialPower(Force attacker, Force defender) {
        Set<Force> target = new HashSet<>();
        if (attacker instanceof Minion && ((Minion) attacker).getSpecialPower() != null &&
                ((Minion) attacker).getSpecialPower().type == MinionSpecialPowerType.REMOVE_POSITIVE_EFFECTS)
            defender.removePositiveEffects();
        fillOnAttackSpecialPowerTarget(target, attacker, defender);
        affectOnAttackSpecialPowerTarget(target);
    }

    private void affectOnAttackSpecialPowerTarget(Set<Force> targetForce) {
        Match match = Match.getCurrentMatch();
        if (type == MinionSpecialPowerType.EFFECTS)
            for (Force force : targetForce) {
                if (force.getPlayer().equals(match.getOpponent()) && force instanceof Minion &&
                        ((Minion)force).getSpecialPower() != null &&
                            ((Minion)force).getSpecialPower().type == MinionSpecialPowerType.ANTI_BAD_EFFECT )
                    force.addPositiveEffectByCopy(effects);
                else
                    force.addEffectByCopy(effects);
            }
        if (type == MinionSpecialPowerType.BUFFS)
            for (Force force : targetForce) {
                if (force.getPlayer().equals(match.getOpponent()) && force instanceof Minion &&
                        ((Minion)force).getSpecialPower() != null) {
                    if (((Minion) force).getSpecialPower().type == MinionSpecialPowerType.UN_POISON) {
                        force.addBuffByCopy(buffs, BuffType.POISON);
                        return;
                    }
                    if (((Minion) force).getSpecialPower().type == MinionSpecialPowerType.UN_DISARM) {
                        force.addBuffByCopy(buffs, BuffType.DISARM);
                        return;
                    }
                }
                force.addBuffByCopy(buffs);
            }
    }

    private void fillOnAttackSpecialPowerTarget(Set<Force> target, Force attacker, Force defender) {
        switch (this.target) {
            case HIMSELF:
                target.add(attacker);
                break;
            case DAMAGED_ENEMY:
                target.add(defender);
                break;
            case DAMAGED_MINION:
                if (defender instanceof Minion)
                    target.add(defender);
                break;
        }
    }


    public MinionSpecialPowerActivationTime getActivationTime() {
        return activationTime;
    }

    public MinionSpecialPowerType getType() {
        return type;
    }

    public MinionSpecialPower getCopy() {
        return new MinionSpecialPower(this.activationTime, this.target, this.type, Buff.getCopy(buffs), Effect.getCopy(effects));
    }

}
