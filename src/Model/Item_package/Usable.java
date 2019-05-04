package Model.Item_package;

import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Item_package.item_effect.ItemEffect;

import java.util.ArrayList;

public class Usable extends Item {
    UsableActivationTime activationTime;
    UsableType usableType;
    UsableTarget usableTarget;
    ArrayList<ItemEffect> itemEffects;
    ArrayList<Buff> buffs;
    ArrayList<Effect> effects;
}
