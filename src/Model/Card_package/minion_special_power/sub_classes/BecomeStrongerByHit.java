package Model.Card_package.minion_special_power.sub_classes;

import Model.Card_package.Force;
import Model.Card_package.minion_special_power.MinionSpecialPower;

import java.util.HashMap;

public class BecomeStrongerByHit extends MinionSpecialPower {
    private HashMap<Force, Integer> hitedCards = new HashMap<>();
    private int unit;
}
