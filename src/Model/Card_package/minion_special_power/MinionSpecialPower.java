package Model.Card_package.minion_special_power;

import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;

import java.util.ArrayList;

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

    public MinionSpecialPower getCopy() {
        return new MinionSpecialPower(this.activationTime, this.target, this.type, Buff.getCopy(buffs), Effect.getCopy(effects));
    }
}
