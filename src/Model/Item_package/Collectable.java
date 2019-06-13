package Model.Item_package;

import Menus.MenuManager;
import Model.Card_package.AttackType;
import Model.Card_package.Force;
import Model.Card_package.Minion;
import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Card_package.minion_special_power.MinionSpecialPower;
import Model.Item_package.item_effect.ItemEffect;
import Model.Match_package.Map;
import Model.Match_package.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Collectable extends Item {
    CollectableTarget collectableTarget;
    CollectableType collectableType;
    private ArrayList<Buff> buffs;
    private ArrayList<Effect> effects;
    private ArrayList<ItemEffect> itemEffects;
    private MinionSpecialPower minionSpecialPower;
    private boolean isUsed = false;

    public Collectable(String name, String desc, Player player, CollectableTarget target, CollectableType type,
                       ArrayList<Buff> buffs, ArrayList<Effect> effects, ArrayList<ItemEffect> itemEffects,
                       MinionSpecialPower minionSpecialPower) {
        super(name, 0, desc, player);
        this.setID(String.format("Collectable_%s" , name));
        this.collectableTarget = target;
        this.collectableType = type;
        this.buffs = buffs;
        this.effects = effects;
        this.itemEffects = itemEffects;
        this.minionSpecialPower = minionSpecialPower;
    }

    public Collectable getCopy(Player player, String ID) {
        Collectable newCollectable = new Collectable(getName(), getDesc(), player, collectableTarget, collectableType,
                Buff.getCopy(buffs), Effect.getCopy(effects), ItemEffect.getCopy(itemEffects),
                minionSpecialPower.getCopy());
        newCollectable.setID(ID);
        return newCollectable;
    }

    public void doCollectable() {
        Map map = MenuManager.getCurrentMatch().getMap();
        if (collectableTarget == CollectableTarget.OWNER_PLAYER) {
            this.getPlayer().addItemEffectsByCopy(itemEffects);
            return;
        }
        Set<Force> targets = new HashSet<>();
        int index;
        Random random = new Random();
        ArrayList<Force> forces = new ArrayList<>();
        switch (collectableTarget) {
            case RANDOM_OUR_FORCE:
                forces = map.getForcesInMap(this.getPlayer());
                index = random.nextInt(forces.size());
                targets.add(forces.get(index));
                break;
            case RANDOM_OUR_MINION:
                for (Force force : map.getForcesInMap(this.getPlayer())) {
                    if (force instanceof Minion)
                        forces.add(force);
                }
                index = random.nextInt(forces.size());
                targets.add(forces.get(index));
                break;
            case ALL_OUR_MELEE_FORCE:
                for (Force force : map.getForcesInMap(this.getPlayer())) {
                    if (force.getAttackType() == AttackType.MELEE)
                        forces.add(force);
                }
                index = random.nextInt(forces.size());
                targets.add(forces.get(index));
                break;
            case RANDOM_OUR_RANGED_OR_HYBRID_FORCE:
                for (Force force : map.getForcesInMap(this.getPlayer())) {
                    if (force.getAttackType() != AttackType.MELEE)
                        forces.add(force);
                }
                index = random.nextInt(forces.size());
                targets.add(forces.get(index));
                break;
        }
        if (collectableType == CollectableType.BUFFS || collectableType == CollectableType.EFFECTS_AND_BUFFS) {
            for (Force target : targets) {
                target.addBuffByCopy(buffs);
            }
        }
        if (collectableType == CollectableType.EFFECTS || collectableType == CollectableType.EFFECTS_AND_BUFFS) {
            for (Force target : targets) {
                target.addEffectByCopy(effects);
            }
        }
        if (collectableType == CollectableType.MINION_SPECIAL_POWER) {
            for (Force target : targets) {
                if (target instanceof Minion)
                    ((Minion) target).addSpecialPowerFromCollectAbleByCopy(minionSpecialPower);
            }
        }
    }

    public Collectable getCopy(){
        return this;
    } // never gonna get used
}
