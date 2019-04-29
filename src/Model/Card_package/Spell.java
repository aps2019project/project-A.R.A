package Model.Card_package;



import Model.Card_package.buff.Buff;
import Model.Card_package.spell_Effect.SpellEffect;
import Model.Match_package.*;

import java.util.ArrayList;

public class Spell extends Card {
    static ArrayList<Spell> spells = new ArrayList<>();

    private Target target;
    private ArrayList<SpellEffect> spellEffects;
    private ArrayList<Buff> buffs;
    private ArrayList<CellEffect> cellEffects;

    private Spell(String name, String ID, int cost, int mana, Target target, ArrayList<SpellEffect> spellEffects,
                  ArrayList<Buff> buffs, ArrayList<CellEffect> cellEffects) {
        super(name, ID, cost, mana);
        this.target = target;
        this.spellEffects = spellEffects;
        this.buffs = buffs;
        this.cellEffects = cellEffects;
    }

    private Spell(Spell spell , Player player) {
        super(spell, player);
        this.target = spell.target;

        this.spellEffects = new ArrayList<>();
        for (SpellEffect spellEffect : spell.spellEffects)
            this.spellEffects.add(spellEffect.getCopy());

        this.buffs = new ArrayList<>();
        for (Buff buff : spell.buffs)
            this.buffs.add(buff.getCopy());

        this.cellEffects = new ArrayList<>();
        for (CellEffect cellEffect : spell.cellEffects)
            this.cellEffects.add(cellEffect.getCopy());
    }

    public static void addSpell(String name, String ID, int cost, int mana, Target target, ArrayList<SpellEffect> spellEffects,
                                ArrayList<Buff> buffs, ArrayList<CellEffect> cellEffects) {
        spells.add(new Spell(name, ID, cost, mana, target, spellEffects, buffs, cellEffects));
    }

    public Spell getCopy(Player player) {
        return new Spell(this, player);
    }

    public boolean canPut(Coordination coordination) {
        if (!super.canPut(coordination)) {
            //todo handle err
            return false;
        }
        if (!Target.canPutSpellOn(this, coordination)) {
            //todo handle err
            return false;
        }
        return true;
    }

    public Target getTarget() {
        return target;
    }
}
