package Model.Card_package.minion_special_power.sub_classes;

import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Card_package.minion_special_power.MinionSpecialPower;
import Model.Card_package.minion_special_power.MinionSpecialPowerActivationTime;
import Model.Card_package.minion_special_power.MinionSpecialPowerTarget;
import Model.Card_package.minion_special_power.MinionSpecialPowerType;

import java.util.ArrayList;

public class Combo  extends MinionSpecialPower {
    public Combo() {
        super(MinionSpecialPowerActivationTime.ON_ATTACK, MinionSpecialPowerTarget.HITED_ENEMY, MinionSpecialPowerType.COMBO, null, null);
    }
}
