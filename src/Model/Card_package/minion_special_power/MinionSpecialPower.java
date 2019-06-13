package Model.Card_package.minion_special_power;

import Menus.MenuManager;
import Model.Card_package.Force;
import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Match_package.Match;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static ArrayList<MinionSpecialPower> getCopy(ArrayList<MinionSpecialPower> specialPowers) {
        if (specialPowers == null)
            return null;
        ArrayList<MinionSpecialPower> copy = new ArrayList<>();
        for (MinionSpecialPower specialPower : specialPowers)
            copy.add(specialPower.getCopy());
        return copy;
    }

    public void doOnSpawnSpecialPower(int x, int y) {
        Set<Force> targetForce = new HashSet<>();
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
        if (type == MinionSpecialPowerType.EFFECTS)
            for (Force force : targetForce) {
                force.addEffectByCopy(effects);
            }
        if (type == MinionSpecialPowerType.BUFFS)
            for (Force force : targetForce) {
                force.addBuffByCopy(buffs);
            }
    }




    public MinionSpecialPowerActivationTime getActivationTime() {
        return activationTime;
    }

    public MinionSpecialPower getCopy() {
        return new MinionSpecialPower(this.activationTime, this.target, this.type, Buff.getCopy(buffs), Effect.getCopy(effects));
    }

}
