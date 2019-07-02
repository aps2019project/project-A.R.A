package Model.Card_package.minion_special_power.sub_classes;

import Model.Card_package.minion_special_power.MinionSpecialPower;
import Model.Card_package.minion_special_power.MinionSpecialPowerActivationTime;
import Model.Card_package.minion_special_power.MinionSpecialPowerTarget;
import Model.Card_package.minion_special_power.MinionSpecialPowerType;

public class Combo  extends MinionSpecialPower {
    public Combo() {
//        super(MinionSpecialPowerActivationTime.COMBO, MinionSpecialPowerTarget.DAMAGED_ENEMY,
//                MinionSpecialPowerType.COMBO, null, null); todo handle
        super(MinionSpecialPowerActivationTime.COMBO, MinionSpecialPowerTarget.DAMAGED_ENEMY,
                null, null, null);
    }
}
