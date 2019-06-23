package Model.Card_package.collectable;

import Menus.MenuManager;
import Model.Card_package.AttackType;
import Model.Card_package.Force;
import Model.Card_package.Minion;
import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Card_package.minion_special_power.MinionSpecialPower;
import Model.Card_package.Item;
import Model.Card_package.item_effect.ItemEffect;
import Model.Match_package.Map;
import Model.Match_package.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CollectAble extends Item {
    private CollectAbleTarget collectableTarget;
    private CollectAbleType collectableType;
    private ArrayList<Buff> buffs;
    private ArrayList<Effect> effects;
    private ArrayList<ItemEffect> itemEffects;
    private MinionSpecialPower minionSpecialPower;

    public CollectAble(String name, String desc, Player player, CollectAbleTarget target, CollectAbleType type,
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

    public CollectAble getCopy(Player player, String ID) { //get copy when pick it from map and put in players collectAbles
        CollectAble newCollectAble = new CollectAble(getName(), getDesc(), player, collectableTarget, collectableType,
                Buff.getCopy(buffs), Effect.getCopy(effects), ItemEffect.getCopy(itemEffects),
                minionSpecialPower.getCopy());
        newCollectAble.setID(ID);
        return newCollectAble;
    }

    public CollectAble getCopy(){ // get copy for put in new match
        return new CollectAble(getName(), getDesc(), getPlayer(), collectableTarget, collectableType,
                Buff.getCopy(buffs), Effect.getCopy(effects), ItemEffect.getCopy(itemEffects), minionSpecialPower.getCopy());
    }

    public void doOnUseCollectAble() {
        Set<Force> targets = new HashSet<>();
        Set<Player> targetPlayer = new HashSet<>();
        fillTargets(targets, targetPlayer);
        doOnTarget(targets, targetPlayer);
    }

    private void fillTargets(Set<Force> targets, Set<Player> targetPlayer) {
        int index;
        Random random = new Random();
        ArrayList<Force> forces = new ArrayList<>();
        Map map = MenuManager.getCurrentMatch().getMap();
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
            case OWNER_PLAYER:
                targetPlayer.add(this.getPlayer());
        }
    }

    private void doOnTarget(Set<Force> targets, Set<Player> targetPlayer) {
        if (collectableType == CollectAbleType.BUFFS || collectableType == CollectAbleType.EFFECTS_AND_BUFFS) {
            for (Force target : targets) {
                target.addBuffByCopy(buffs);
            }
        }
        if (collectableType == CollectAbleType.EFFECTS || collectableType == CollectAbleType.EFFECTS_AND_BUFFS) {
            for (Force target : targets) {
                target.addEffectByCopy(effects);
            }
        }
        if (collectableType == CollectAbleType.MINION_SPECIAL_POWER) {
            for (Force target : targets) {
                if (target instanceof Minion)
                    ((Minion) target).addSpecialPowerFromCollectAbleByCopy(minionSpecialPower);
            }
        }
        if (collectableType == CollectAbleType.ITEM_EFFECTS) {
            for (Player player : targetPlayer) {
                player.addItemEffectsByCopy(itemEffects);
            }
        }
    }
}
