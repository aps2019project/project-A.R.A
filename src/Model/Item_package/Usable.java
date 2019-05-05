package Model.Item_package;

import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Item_package.item_effect.ItemEffect;
import Model.Match_package.Player;

import java.util.ArrayList;

public class Usable extends Item {
    private UsableActivationTime activationTime;
    private UsableType usableType;
    private UsableTarget usableTarget;
    private ArrayList<ItemEffect> itemEffects;
    private ArrayList<Buff> buffs;
    private ArrayList<Effect> effects;

    public Usable(String name, String ID, int price, String desc, Player player, UsableActivationTime activationTime,
                  UsableType type, UsableTarget target, ArrayList<ItemEffect> itemEffects,
                  ArrayList<Buff> buffs, ArrayList<Effect> effects) {
        super(name, ID, price, desc, player);
        this.activationTime = activationTime;
        this.usableType = type;
        this.usableTarget = target;
        this.itemEffects = itemEffects;
        this.buffs = buffs;
        this.effects = effects;
    }

    public Usable getCopy(Player player, String ID) {
        return new Usable(getName(), ID, getPrice(), getDesc(), player, activationTime, usableType, usableTarget,
                ItemEffect.getCopy(itemEffects), Buff.getCopy(buffs), Effect.getCopy(effects));
    }
}
