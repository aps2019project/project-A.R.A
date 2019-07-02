package Model.Card_package.usable;

import Menus.Menu;
import Menus.MenuManager;
import Model.Card_package.*;
import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Card_package.item_effect.ItemEffect;
import Model.Match_package.Player;

import java.util.ArrayList;
import java.util.HashSet;
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
//        this.setID(String.format("Usable_%s", name));
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

    public void doOnStartUsable(){
        Set<Player> targetPlayers = new HashSet<>();
        Set<Force> targetForces = new HashSet<>();
        fillOnStartUsable(targetPlayers, targetForces);
        doOnTarget(targetPlayers, targetForces);
    }

    public void doOnSpawnAMinionUsable(Minion spawnedMinion) {
        Set<Force> forces = new HashSet<>();
        fillOnSpawnAMinionUsable(spawnedMinion, forces);
        doOnTarget(new HashSet<>(), forces);
    }

    public void doOnAttackUsable(Force damagedForce, Force attackerForce) {
        Set<Force> forces = new HashSet<>();
        fillOnAttackUsable(forces, damagedForce, attackerForce);
        doOnTarget(new HashSet<>(), forces);
    }

    private void fillOnAttackUsable(Set<Force> forces, Force damagedForce, Force attackerForce) {
        if (activationTime == UsableActivationTime.OUR_HERO_ON_ATTACK && !(attackerForce instanceof Hero))
            return;
        if (activationTime == UsableActivationTime.OUR_RANGED_OR_HYBRID_HERO_ON_ATTACK)
            if (!(attackerForce instanceof Hero) || (attackerForce).getAttackType() == AttackType.MELEE)
                return;
        switch (usableTarget) {
            case DAMAGED_ENEMY:
                forces.add(damagedForce);
                break;
            case RANDOM_ENEMY_Force:
                forces.add(MenuManager.getCurrentMatch().getMap().getRandomForceInMap(
                        MenuManager.getCurrentMatch().getOpponent()));
                break;
        }
    }

    private void fillOnStartUsable(Set<Player> targetPlayers, Set<Force> targetForces) {
        switch (usableTarget) {
            case OWNER_PLAYER:
                targetPlayers.add(this.getPlayer());
                break;
            case OUR_HERO:
                targetForces.add(this.getPlayer().getHand().getHero());
                break;
            case RANGED_OR_HYBRID_ENEMY_HERO:
                if (!this.getPlayer().getHand().getHero().getAttackType().equals(AttackType.MELEE))
                    targetForces.add(this.getPlayer().getHand().getHero());
                break;
        }
    }

    private void fillOnSpawnAMinionUsable(Minion spawnedMinion, Set<Force> forces) {
        switch (usableTarget) {
            case SPAWNED_MINION:
                forces.add(spawnedMinion);
                break;
            case ENEMY_HERO:
                forces.add(MenuManager.getCurrentMatch().getOpponent().getHand().getHero());
                break;
        }
    }

    private void doOnTarget(Set<Player> targetPlayers, Set<Force> targetForces) {
        if (usableType == UsableType.BUFFS) {
            for (Force targetForce : targetForces) {
                targetForce.addBuffByCopy(buffs);
            }
        }
        else if (usableType == UsableType.EFFECTS) {
            for (Force targetForce : targetForces) {
                targetForce.addEffectByCopy(effects);
            }
        }
        else if (usableType == UsableType.ITEM_EFFECTS) {
            for (Player targetPlayer : targetPlayers) {
                targetPlayer.addItemEffectsByCopy(itemEffects);
            }
        }
    }

}
