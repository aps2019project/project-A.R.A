package Model.Item_package;

import Model.Card_package.Force;
import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Item_package.item_effect.ItemEffect;
import Model.Match_package.Player;

import java.util.ArrayList;
import java.util.Set;

public class Usable extends Item {
    private UsableActivationTime activationTime;
    private UsableType usableType;
    private UsableTarget usableTarget;
    private ArrayList<ItemEffect> itemEffects;
    private ArrayList<Buff> buffs;
    private ArrayList<Effect> effects;

    public Usable(String name, int price, String desc, Player player, UsableActivationTime activationTime,
                  UsableType type, UsableTarget target, ArrayList<ItemEffect> itemEffects,
                  ArrayList<Buff> buffs, ArrayList<Effect> effects) {
        super(name, price, desc, player);
        this.setID(String.format("Usable_%s", name));
        this.activationTime = activationTime;
        this.usableType = type;
        this.usableTarget = target;
        this.itemEffects = itemEffects;
        this.buffs = buffs;
        this.effects = effects;
    }

    public Usable getCopy(Player player, String ID) {
        Usable newUsable =  new Usable(getName(), getPrice(), getDesc(), player, activationTime, usableType, usableTarget,
                ItemEffect.getCopy(itemEffects), Buff.getCopy(buffs), Effect.getCopy(effects));
        newUsable.setID(ID);
        return newUsable;
    }

    public UsableActivationTime getActivationTime() {
        return activationTime;
    }

    public void doUsable(Set<Force> targets){//targets contain hitted enemy or spawned minion
        if (usableTarget == UsableTarget.OWNER_PLAYER) {
            this.getPlayer().addItemEffectsByCopy(itemEffects);
        }

    }
}
