package Model.Item_package;

import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Card_package.minion_special_power.MinionSpecialPower;
import Model.Item_package.item_effect.ItemEffect;

import java.util.ArrayList;

public class Collectable extends Item {
    CollectableTarget collectableTarget;
    CollectableType collectableType;
    ArrayList<Buff> buffs;
    ArrayList<Effect> effects;
    ArrayList<ItemEffect> itemEffects;
    ArrayList<MinionSpecialPower> minionSpecialPowers;
}
