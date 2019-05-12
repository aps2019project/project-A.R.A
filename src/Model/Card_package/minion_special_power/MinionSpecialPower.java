package Model.Card_package.minion_special_power;

import Menus.MenuManager;
import Model.Card_package.Force;
import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Match_package.Match;

import java.util.ArrayList;
import java.util.Set;

public class MinionSpecialPower {
    MinionSpecialPowerActivationTime activationTime;
    MinionSpecialPowerTarget target;
    MinionSpecialPowerType type;
    ArrayList<Buff> buffs;
    ArrayList<Effect> effects;

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

    public void doMinionSpecialPowerArraylisted(Set<Force> forces) { //todo handle target
        Match match = MenuManager.getCurrentMatch();
        switch (target) {
            case HIMSELF:
            case HITED_ENEMY:
            case HITED_MINION:
            case MINION_AND_OUR_MINION_IN_NEIGHBOR:
            case ENEMY_HERO:
            case ALL_OUR_MINION:
            case MINIONS_IN_NEIGHBOR:
            case RANDOM_ENEMY_MINION:
            case UNTIL_2_DISTANCE_MINIONS:
            case ENEMY_MINIONIS_IN_NEIGHBOR:
            case RANDOM_ENEMY_FORCE_IN_NEIGHBOR:
        }

        if (type == MinionSpecialPowerType.EFFECTS)
            for (Force force : forces) {
                force.addEffectByCopy(effects);
            }
        if (type == MinionSpecialPowerType.BUFFS)
            for (Force force : forces) {
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
