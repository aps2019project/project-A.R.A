package Model;

import Account_package.Account;
import Model.Card_package.*;
import Model.Card_package.buff.Buff;
import Model.Card_package.buff.BuffTimeType;
import Model.Card_package.buff.BuffType;
import Model.Card_package.effect.Effect;
import Model.Card_package.effect.EffectTimeType;
import Model.Card_package.effect.EffectType;
import Model.Card_package.minion_special_power.MinionSpecialPower;
import Model.Card_package.minion_special_power.MinionSpecialPowerActivationTime;
import Model.Card_package.minion_special_power.MinionSpecialPowerTarget;
import Model.Card_package.minion_special_power.MinionSpecialPowerType;
import Model.Card_package.minion_special_power.sub_classes.BecomeStrongerByHit;
import Model.Card_package.minion_special_power.sub_classes.Combo;
import Model.Card_package.spell_Effect.SpellEffect;
import Model.Card_package.spell_Effect.SpellEffectType;
import Model.Card_package.spell_Effect.SpellTarget;
import Model.Item_package.Item;
import Model.Match_package.CellEffect;
import Model.Match_package.CellEffectType;

import javax.lang.model.type.ArrayType;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;

public class Shop {
    private ArrayList<Hero> shopHeroes = new ArrayList<>();
    private ArrayList<Minion> shopMinions = new ArrayList<>();
    private ArrayList<Item> shopItems = new ArrayList<>();
    private ArrayList<Spell> shopSpells = new ArrayList<>();

    public ArrayList<Unit> shopUnits = new ArrayList<>();

    private Shop() { }

    private static Shop instance = new Shop();

    public static Shop getInstance() {
        return instance;
    }

    public Unit get(String name) {
        for (Unit unit : shopUnits)
            if (unit.getName().equals(name))
                return unit;
        return null; // 404 not found
    }

    public Unit getBasedOnType(String type) {
        for (Unit unit : shopUnits)
            if (unit.getName().equals(type))
                return unit;
        return null;
    }

    public Shop buy(Account account, String name) {
        Unit unit = this.get(name);
        if (unit == null) {
            // show error
            return this;
        }
        if (unit instanceof Card)
            account.getCollection().add((Card) unit);
        else
            account.getCollection().addItem((Item) unit);
        account.pay(unit.getPrice());
        return this;
    }

    public Shop sell(Account account, String ID) {
        if (!account.getCollection().hasUnit(ID))
            return this;

        Unit unit = account.getCollection().get(ID);
        if (unit instanceof Card)
            account.getCollection().deleteCard((Card) unit);
        else
            account.getCollection().deleteItem((Item) unit);
        account.earn(unit.getPrice());
        return this;
    }

    public boolean hasUnit(String name) {
        for (Unit unit : shopUnits)
            if (unit.getName().equals(name))
                return true;
        return false;
    }

    public boolean hasHero(String name){
        for(Hero hero:shopHeroes)
            if(hero.getName().equals(name))
                return true;
            return false;
    }

    public boolean hasMinion(String name){
        for(Minion minion:shopMinions)
            if(minion.getName().equals(name))
                return true;
        return false;
    }

    public boolean hasItem(String name){
        for(Item item:shopItems)
            if(item.getName().equals(name))
                return true;
        return false;
    }

    public boolean hasSpell(String name){
        for(Spell spell:shopSpells)
            if(spell.getName().equals(name))
                return true;
        return false;
    }

    public String getUnitID(String name) {
        for (Unit unit : shopUnits)
            if (unit.getName().equals(name))
                return unit.getID();
        return null; // never gonna happen
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder("not handled !!");
        //buffer.append(......);
        return buffer.toString();
    }


    public void initCards() {
        initSpellCards();
        initMinionCards();
    }

    private void initSpellCards() {
        initSpell1();
        initSpell2();
        initSpell3();
        initSpell4();
        initSpell5();
        initSpell6();
        initSpell7();
        initSpell8();
        initSpell9();
        initSpell10();
        initSpell11();
        initSpell12();
        initSpell13();
        initSpell14();
        initSpell15();
        initSpell16();
        initSpell17();
        initSpell18();
        initSpell19();
        initSpell20();
    }
    private void initSpell1() {
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.DISARM, BuffTimeType.CONTINUAL, 0, 1));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.ENEMY_FORCE, SpellEffectType.BUFFS, null, buffs, null);
        shopSpells.add(new Spell("TotalDisarm", null, 1000, 0, "disarm enemy force", spellEffect, null));
    }
    private void initSpell2() {
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.DISPEL, EffectTimeType.COUNTABLE, 1, 1));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.CELLS2X2, SpellEffectType.EFFECTS, effects, null, null);
        shopSpells.add(new Spell("AreaDispel", null, 1500, 2, "dispel 2 * 2 cells", spellEffect, null));
    }
    private void initSpell3() {
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.INCREMENT_AP_STATIC, EffectTimeType.COUNTABLE, 1, 2));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.OUR_FORCE, SpellEffectType.EFFECTS, effects, null, null);
        shopSpells.add(new Spell("Empower", null, 250, 1, "increment ap our force", spellEffect, null));
    }
    private void initSpell4() {
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.DECREMENT_HP_STATIC, EffectTimeType.COUNTABLE, 1, 4));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.ENEMY_FORCE, SpellEffectType.EFFECTS, effects, null, null);
        shopSpells.add(new Spell("FireBall", null, 400, 1, "decrement hp 4 in enemy force", spellEffect, null));
    }
    private void initSpell5() {
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.INCREMENT_AP_STATIC, EffectTimeType.COUNTABLE, 1, 4));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.OUR_HERO, SpellEffectType.EFFECTS, effects, null, null);
        shopSpells.add(new Spell("GodStrength", null, 450, 2, "increment hero ap", spellEffect, null));
    }
    private void initSpell6() {
        ArrayList<CellEffect> cellEffects = new ArrayList<>();
        cellEffects.add(new CellEffect(CellEffectType.FIRE, 2));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.CELLS2X2, SpellEffectType.CELL_EFFECTS, null, null, cellEffects);
        shopSpells.add(new Spell("HellFire", null, 600, 3, "fire in 2*2 cell for 2 turn", spellEffect, null));
    }
    private void initSpell7() {
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.DECREMENT_HP_STATIC, EffectTimeType.COUNTABLE, 1, 8));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.ENEMY_HERO, SpellEffectType.EFFECTS, effects, null, null);
        shopSpells.add(new Spell("LightingBolt", null, 1250, 2, "increment enemy hero hp : 8", spellEffect, null));
    }
    private void initSpell8() {
        ArrayList<CellEffect> cellEffects = new ArrayList<>();
        cellEffects.add(new CellEffect(CellEffectType.FIRE, 1));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.CELLS3X3, SpellEffectType.CELL_EFFECTS, null, null, cellEffects);
        shopSpells.add(new Spell("poisonLake", null, 900, 5, "fire in 3*3 cells", spellEffect, null));
    }
    private void initSpell9() {
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.INCREMENT_AP_STATIC, EffectTimeType.COUNTABLE, 3, 4));
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.DISARM, BuffTimeType.COUNTABLE, 4, 1));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.OUR_FORCE, SpellEffectType.EFFECTS_AND_BUFFS, effects, buffs, null);
        shopSpells.add(new Spell("Madness", null, 650, 0, "in force increment ap 4 unit for 3 time but it disarm", spellEffect, null));
    }
    private void initSpell10() {
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.DISARM, BuffTimeType.COUNTABLE, 1, 1));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.ALL_ENEMY_FORCE, SpellEffectType.BUFFS, null, buffs, null);
        shopSpells.add(new Spell("AllDisarm", null, 2000, 9, "disarm all enemy force for one turn", spellEffect, null));
    }
    private void initSpell11() {
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.POISON, BuffTimeType.COUNTABLE, 4, 1));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.ALL_ENEMY_FORCE, SpellEffectType.BUFFS, null , buffs, null);
        shopSpells.add(new Spell("AllPoison", null, 1500, 8, "poison on enemy force for 4 turn", spellEffect, null));
    }
    private void initSpell12() {
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.DISPEL, EffectTimeType.COUNTABLE, 1, 1));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.FORCE, SpellEffectType.EFFECTS, effects, null, null);
        shopSpells.add(new Spell("Dispel", null, 2100, 0, "dispel", spellEffect, null));
    }
    private void initSpell13() {
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.WEAKNESS_HP, BuffTimeType.COUNTABLE, 3, 6));
        buffs.add(new Buff(BuffType.HOLY, BuffTimeType.COUNTABLE, 3, 2));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.OUR_FORCE, SpellEffectType.BUFFS, null, buffs, null);
        shopSpells.add(new Spell("HealthWithProfit", null, 2250, 0, "6 weakness hp for 3 turn and 2 holy for 3 turn too", spellEffect, null));
    }
    private void initSpell14() {
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.POWER_AP, BuffTimeType.CONTINUAL, 1, 6));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.OUR_FORCE, SpellEffectType.BUFFS, null, buffs, null);
        shopSpells.add(new Spell("PowerUP", null, 2500, 2, "power buff ap 6 unit", spellEffect, null));
    }
    private void initSpell15() {
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.POWER_AP, BuffTimeType.CONTINUAL, 1, 2));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.ALL_OUR_FORCE, SpellEffectType.BUFFS, null, buffs, null);
        shopSpells.add(new Spell("AllPower", null, 2000, 4, "power ap 2 unit continual for all our force", spellEffect, null));
    }
    private void initSpell16() {
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.DECREMENT_HP_STATIC, EffectTimeType.COUNTABLE, 1, 6));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.VERTICAL_ENEMYS, SpellEffectType.EFFECTS, effects, null, null);
        shopSpells.add(new Spell("AllAttack", null, 1500, 4, "increment all enemy in a column", spellEffect, null));
    }
    private void initSpell17() {
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.WEAKNESS_AP, BuffTimeType.CONTINUAL, 1, 4));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.ENEMY_MINION, SpellEffectType.BUFFS, null, buffs, null);
        shopSpells.add(new Spell("Weakening", null, 1000, 1, "4 unit weakness ap continual", spellEffect, null));
    }
    private void initSpell18() {
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.WEAKNESS_HP, BuffTimeType.CONTINUAL, 1, 6));
        buffs.add(new Buff(BuffType.POWER_AP, BuffTimeType.CONTINUAL, 1, 8));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.OUR_MINION, SpellEffectType.BUFFS, null, buffs, null);
        shopSpells.add(new Spell("Sacrifice", null, 1600, 2, "power ap 8 unit continual but weakness hp 6 unit", spellEffect, null));
    }
    private void initSpell19() {
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.KILL, EffectTimeType.COUNTABLE, 1, 1));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.RANDOM_ENEMY_MINION_IN_NEIGHBOR_OF_OUR_HERO, SpellEffectType.EFFECTS, effects, null, null);
        shopSpells.add(new Spell("KingsGuard", null, 1750, 9, "kill a minion in neighbor of our hero", spellEffect, null));
    }
    private void initSpell20(){
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.STUN, BuffTimeType.COUNTABLE, 2, 1));
        SpellEffect spellEffect = new SpellEffect(SpellTarget.ENEMY_FORCE, SpellEffectType.BUFFS, null, buffs, null);
        shopSpells.add(new Spell("Shock", null, 1200, 1, "stun enemy force for two turn", spellEffect, null));
    }

    private void initMinionCards() {
        initMinion1();
        initMinion2();
        initMinion3();
        initMinion4();
        initMinion5();
        initMinion6();
        initMinion7();
        initMinion8();
        initMinion9();
        initMinion10();
        initMinion11();
        initMinion12();
        initMinion13();
        initMinion14();
        initMinion15();
        initMinion16();
        initMinion17();
        initMinion18();
        initMinion19();
        initMinion20();
        initMinion21();
        initMinion22();
        initMinion23();
        initMinion24();
        initMinion25();
        initMinion26();
        initMinion27();
        initMinion28();
        initMinion29();
        initMinion30();
        initMinion31();
        initMinion32();
        initMinion33();
        initMinion34();
        initMinion35();
        initMinion36();
        initMinion37();
        initMinion38();
        initMinion39();
        initMinion40();
    }
    private void initMinion1() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("kamandare fars", null, 300, 2, 6, 4, " without special power"
                , null, AttackType.RANGED, 7, minionSpecialPowers));
    }
    private void initMinion2() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.STUN, BuffTimeType.COUNTABLE, 1, 1));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_ATTACK, MinionSpecialPowerTarget.HITED_ENEMY, MinionSpecialPowerType.BUFFS, buffs, null));
        shopMinions.add(new Minion("shamshirzan fars", null, 400, 2, 6, 4, "stun hited enemy", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion3() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("naizeh dareh fars", null, 500, 1, 5, 3, "without special power", null, AttackType.HYBRID, 3, minionSpecialPowers));
    }
    private void initMinion4() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("asbsavareh fars", null, 200, 4, 10, 6, "without special power", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion5() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        minionSpecialPowers.add(new BecomeStrongerByHit(5));
        shopMinions.add(new Minion("pahlavaneh fars", null, 600, 9, 24, 6, "Become stronger in attack a force when hitted it", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion6() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        minionSpecialPowers.add(new Combo());
        shopMinions.add(new Minion("sepahsalareh fars", null, 800, 7, 12, 4, "combo", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion7() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("kamandareh torani", null, 500, 1, 3, 4, "without speciall power", null, AttackType.RANGED, 5, minionSpecialPowers));
    }
    private void initMinion8() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("gholabsangdareh torani", null, 600, 1, 4, 2, "without special power", null, AttackType.RANGED, 7, minionSpecialPowers));
    }
    private void initMinion9() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("neizehdareh torani", null, 600, 1, 4, 4, "without special power", null, AttackType.HYBRID, 3, minionSpecialPowers));
    }
    private void initMinion10() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.DISARM, BuffTimeType.COUNTABLE, 1, 1));
        buffs.add(new Buff(BuffType.POISON, BuffTimeType.COUNTABLE, 4, 1));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_ATTACK, MinionSpecialPowerTarget.HITED_ENEMY, MinionSpecialPowerType.BUFFS, buffs, null));
        shopMinions.add(new Minion("jasoseh torani", null, 700, 4, 6, 6, "disarm enemy for one turn and poison for 4 turn", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion11() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("ghorzdareh torani", null, 450, 2, 3, 10, "without special power", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion12() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        minionSpecialPowers.add(new Combo());
        shopMinions.add(new Minion("shahzadeh torani", null, 800, 6, 6, 10, "combo", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion13() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("diveh siah", null, 300, 9, 14, 10, "without special power", null, AttackType.HYBRID, 7, minionSpecialPowers));
    }
    private void initMinion14() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("gholeh sang andaz", null, 300, 9, 12, 12, "without special poser", null, AttackType.RANGED, 7, minionSpecialPowers));
    }
    private void initMinion15() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.POWER_HP, BuffTimeType.CONTINUAL, 1, 10));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.PASSIVE_ON_SPAWN, MinionSpecialPowerTarget.HIMSELF, MinionSpecialPowerType.BUFFS, buffs, null));
        shopMinions.add(new Minion("oghab", null, 200, 2, 0, 2, "have power buf hp 10 unit", null, AttackType.RANGED, 3, minionSpecialPowers));
    }
    private void initMinion16() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("diveh ghorazsavar", null, 300, 6, 16, 8, "without special power", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion17() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.DECREMENT_HP_STATIC, EffectTimeType.COUNTABLE, 1, 2));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_DEATH, MinionSpecialPowerTarget.MINIONS_IN_NEIGHBOR, MinionSpecialPowerType.EFFECTS, null, effects));
        shopMinions.add(new Minion("gholeh tak cheshm", null, 500, 7, 12, 11, "increment 2 hp frow 8 neighbor", null, AttackType.HYBRID, 3, minionSpecialPowers));
    }
    private void initMinion18() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.POISON, BuffTimeType.COUNTABLE, 3, 1));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_ATTACK, MinionSpecialPowerTarget.HITED_ENEMY, MinionSpecialPowerType.BUFFS, buffs, null));
        shopMinions.add(new Minion("mareh sami", null, 300, 4, 5, 6, "poison on hited enemy for 3 turn", null, AttackType.RANGED, 4, minionSpecialPowers));
    }
    private void initMinion19() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("ejdehaye atashandaz", null, 250, 5, 9, 5, "without special power", null, AttackType.RANGED, 4, minionSpecialPowers));
    }
    private void initMinion20() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_ATTACK, MinionSpecialPowerTarget.HIMSELF, MinionSpecialPowerType.IGNORE_ENEMY_HOLY_BUFF, null, null));
        shopMinions.add(new Minion("shireh darandeh", null, 600, 2, 1, 8, "dis Holy", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion21() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.NEGATIVE_HOLY_BUFF, EffectTimeType.CONTINUAL, 1, 1));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_SPAWN, MinionSpecialPowerTarget.UNTIL_2_DISTANCE_MINIONS, MinionSpecialPowerType.EFFECTS, null, effects));
        shopMinions.add(new Minion("mareh gholpeikar", null, 500, 8, 14, 7, "negative holy buff for minions in 1 or 2 distance on spwan", null, AttackType.RANGED, 5, minionSpecialPowers));
    }
    private void initMinion22() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.POISON, BuffTimeType.COUNTABLE, 2, 4));
        buffs.add(new Buff(BuffType.POISON, BuffTimeType.COUNTABLE, 1, 2));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_ATTACK, MinionSpecialPowerTarget.HITED_MINION, MinionSpecialPowerType.BUFFS, buffs, null));
        shopMinions.add(new Minion("gorge sefid", null, 400, 5, 8, 2, "6 and 4 damage in next terns to hited minion", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion23() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.POISON, BuffTimeType.COUNTABLE, 1, 8));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_ATTACK, MinionSpecialPowerTarget.HITED_MINION, MinionSpecialPowerType.BUFFS, buffs, null));
        shopMinions.add(new Minion("palang", null, 400, 4, 6, 2, "8 damage for next turn to hited minion", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion24() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.POISON, BuffTimeType.COUNTABLE, 1, 6));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_ATTACK, MinionSpecialPowerTarget.HITED_MINION, MinionSpecialPowerType.BUFFS, buffs, null));
        shopMinions.add(new Minion("gorg", null, 400, 3, 6, 1, "6 damage for next turn to hited minion", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion25() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.POWER_AP, BuffTimeType.COUNTABLE, 1, 2));
        buffs.add(new Buff(BuffType.WEAKNESS_HP, BuffTimeType.COUNTABLE, 1, 1));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.PASSIVE_ON_TURN, MinionSpecialPowerTarget.MINION_AND_OUR_MINION_IN_NEIGHBOR, MinionSpecialPowerType.BUFFS, buffs, null));
        shopMinions.add(new Minion("jadogar", null, 550, 4, 5, 4, "each turn this minion and our minion in neighbor recive 2 power ap, 1 weakness hp", null, AttackType.RANGED, 3, minionSpecialPowers));
    }
    private void initMinion26() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.POWER_AP, BuffTimeType.CONTINUOUS, 1, 2));
        buffs.add(new Buff(BuffType.HOLY, BuffTimeType.CONTINUOUS, 1, 1));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.PASSIVE_ON_TURN, MinionSpecialPowerTarget.MINION_AND_OUR_MINION_IN_NEIGHBOR, MinionSpecialPowerType.BUFFS, buffs, null));
        shopMinions.add(new Minion("jadogar", null, 550, 6, 6, 6, "each turn this minion and our minion in neighbor recive 2 power ap, 1 holy in continous", null, AttackType.RANGED, 5, minionSpecialPowers));
    }
    private void initMinion27(){
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.POWER_AP, BuffTimeType.CONTINUOUS, 1, 1));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_TURN, MinionSpecialPowerTarget.ALL_OUR_MINION, MinionSpecialPowerType.BUFFS, buffs, null));
        shopMinions.add(new Minion("jen", null, 500, 5, 10, 4, "give power ap to all our minion each turn continuous", null, AttackType.RANGED, 4, minionSpecialPowers));
    }
    private void initMinion28() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_DEFEND, MinionSpecialPowerTarget.HIMSELF, MinionSpecialPowerType.UN_DISARM, null, null));
        shopMinions.add(new Minion("gorazeh vahshi", null, 500, 6, 10, 14, "disarm nemishavad", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion29() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_DEFEND, MinionSpecialPowerTarget.HIMSELF, MinionSpecialPowerType.UN_POISON, null, null));
        shopMinions.add(new Minion("piran", null, 400, 8, 20, 12, "masmom nemishavad", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion30() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_DEFEND, MinionSpecialPowerTarget.HIMSELF, MinionSpecialPowerType.UNTI_BAD_EFFECT, null, null));
        shopMinions.add(new Minion("giv", null, 450, 4, 5, 7, "done recive bad effect", null, AttackType.RANGED, 5, minionSpecialPowers));
    }
    private void initMinion31() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.DECREMENT_HP_STATIC, EffectTimeType.COUNTABLE, 1, 16));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_SPAWN, MinionSpecialPowerTarget.RANDOM_ENEMY_MINION, MinionSpecialPowerType.EFFECTS, null, effects));
        shopMinions.add(new Minion("bahman", null, 450, 8, 16, 9, "damage a random enemy minion 16 unit on spawn", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion32() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_DEFEND, MinionSpecialPowerTarget.HIMSELF, MinionSpecialPowerType.DONOT_RECIVE_ATTACK_BY_WEAKER_FORCE, null, null));
        shopMinions.add(new Minion("ashkbos", null, 400, 7, 14, 8, "done recive attack from weaker enemy", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion33() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("irag", null, 500, 4, 6, 20, "without special power", null, AttackType.RANGED, 3, minionSpecialPowers));
    }
    private void initMinion34() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        shopMinions.add(new Minion("goleh bozorg", null, 600, 9, 30, 8, "without special power", null, AttackType.HYBRID, 2, minionSpecialPowers));
    }
    private void initMinion35() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_ATTACK, MinionSpecialPowerTarget.HITED_ENEMY, MinionSpecialPowerType.REMOVE_POSITIVE_EFFECTS, null, null));
        shopMinions.add(new Minion("goleh dosar", null, 550, 4, 10, 4, "remove positive effects from hited enemy", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion36() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.STUN, BuffTimeType.COUNTABLE, 1, 1));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_SPAWN, MinionSpecialPowerTarget.ENEMY_MINIONIS_IN_NEIGHBOR, MinionSpecialPowerType.BUFFS, buffs, null));
        shopMinions.add(new Minion("naneh sarma", null, 500, 3, 3, 4, "stun enemy minion in neighbor on spawn", null, AttackType.RANGED, 5, minionSpecialPowers));
    }
    private void initMinion37() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Buff> buffs = new ArrayList<>();
        buffs.add(new Buff(BuffType.HOLY, BuffTimeType.CONTINUOUS, 1, 12));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.PASSIVE_ON_SPAWN, MinionSpecialPowerTarget.HIMSELF, MinionSpecialPowerType.BUFFS, buffs, null));
        shopMinions.add(new Minion("folad zereh", null, 650, 3, 1, 1, "have 12 holy continously", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion38() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        ArrayList<Effect> effects = new ArrayList<>();
        effects.add(new Effect(EffectType.DECREMENT_HP_STATIC, EffectTimeType.COUNTABLE, 1, 6));
        minionSpecialPowers.add(new MinionSpecialPower(MinionSpecialPowerActivationTime.ON_DEATH, MinionSpecialPowerTarget.ENEMY_HERO, MinionSpecialPowerType.EFFECTS, null, effects));
        shopMinions.add(new Minion("siavash", null, 350, 4, 8, 5, "damage 6 unit enemy hero when died", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion39() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        minionSpecialPowers.add(new Combo());
        shopMinions.add(new Minion("shahghol", null, 600, 5, 10, 4, "combo", null, AttackType.MELEE, 0, minionSpecialPowers));
    }
    private void initMinion40() {
        ArrayList<MinionSpecialPower> minionSpecialPowers = new ArrayList<>();
        minionSpecialPowers.add(new Combo());
        shopMinions.add(new Minion("arjanghdiv", null, 600, 3, 6, 6, "combo", null, AttackType.MELEE, 0, minionSpecialPowers));
    }


}