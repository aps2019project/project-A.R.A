package Model.Card_package.minion_special_power.sub_classes;

import Model.Card_package.Force;
import Model.Card_package.minion_special_power.MinionSpecialPower;
import Model.Card_package.minion_special_power.MinionSpecialPowerActivationTime;
import Model.Card_package.minion_special_power.MinionSpecialPowerTarget;
import Model.Card_package.minion_special_power.MinionSpecialPowerType;

import java.util.HashMap;

public class BecomeStrongerByHit extends MinionSpecialPower {
    private HashMap<Force, Integer> hitedCards = new HashMap<>();
    private int unit;

    public BecomeStrongerByHit(int unit) {
        super(MinionSpecialPowerActivationTime.ON_ATTACK, MinionSpecialPowerTarget.HITED_ENEMY,
                MinionSpecialPowerType.BECOME_STRONGER_BY_HIT, null, null);
        this.unit = unit;
    }
}