package Model.Item_package;

import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Card_package.minion_special_power.MinionSpecialPower;
import Model.Item_package.item_effect.ItemEffect;
import Model.Match_package.Player;

import java.util.ArrayList;

public class Collectable extends Item {
    CollectableTarget collectableTarget;
    CollectableType collectableType;
    ArrayList<Buff> buffs;
    ArrayList<Effect> effects;
    ArrayList<ItemEffect> itemEffects;
    ArrayList<MinionSpecialPower> minionSpecialPowers;
    private boolean isUsed = false;

    public Collectable(String name, String ID, String desc, Player player, CollectableTarget target, CollectableType type,
                       ArrayList<Buff> buffs, ArrayList<Effect> effects, ArrayList<ItemEffect> itemEffects,
                       ArrayList<MinionSpecialPower> minionSpecialPowers) {
        super(name, ID, 0, desc, player);
        this.collectableTarget = target;
        this.collectableType = type;
        this.buffs = buffs;
        this.effects = effects;
        this.itemEffects = itemEffects;
        this.minionSpecialPowers = minionSpecialPowers;
    }

    public Collectable getCopy(Player player, String ID) {
        return new Collectable(getName(), ID, getDesc(), player, collectableTarget, collectableType,
                Buff.getCopy(buffs), Effect.getCopy(effects), ItemEffect.getCopy(itemEffects),
                MinionSpecialPower.getCopy(minionSpecialPowers));
    }

    public Collectable getCopy(){
        return this;
    } // never gonna get used
}
