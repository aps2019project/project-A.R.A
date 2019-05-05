package Model;

import Account_package.Account;
import Model.Card_package.Card;
import Model.Card_package.Hero;
import Model.Card_package.Minion;
import Model.Card_package.Spell;
import Model.Card_package.buff.Buff;
import Model.Card_package.buff.BuffTimeType;
import Model.Card_package.buff.BuffType;
import Model.Card_package.effect.Effect;
import Model.Card_package.effect.EffectTimeType;
import Model.Card_package.effect.EffectType;
import Model.Card_package.spell_Effect.SpellEffect;
import Model.Card_package.spell_Effect.SpellEffectType;
import Model.Card_package.spell_Effect.SpellTarget;
import Model.Item_package.Item;
import Model.Match_package.CellEffect;
import Model.Match_package.CellEffectType;

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
}

