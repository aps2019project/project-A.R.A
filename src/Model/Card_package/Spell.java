package Model.Card_package;



import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Card_package.spell_Effect.SpellEffect;
import Model.Card_package.spell_Effect.SpellTarget;
import Model.Match_package.*;

import java.util.ArrayList;

public class Spell extends Card {
    static ArrayList<Spell> spells = new ArrayList<>();

    SpellEffect spellEffect;

    private Spell(String name, String ID, int cost, int mana, SpellTarget target, ArrayList<Effect> effects,
                  ArrayList<Buff> buffs, ArrayList<CellEffect> cellEffects) {
        super(name, ID, cost, mana);
        this.target = target;
        this.effects = effects;
        this.buffs = buffs;
        this.cellEffects = cellEffects;
    }

    private Spell(Spell mainSpell , Player player, String ID) {
        super(mainSpell, player, ID);
        this.target = mainSpell.target;

        this.effects = new ArrayList<>();
        for (Effect effect : mainSpell.effects)
            this.effects.add(effect.getCopy());

        this.buffs = new ArrayList<>();
        for (Buff buff : mainSpell.buffs)
            this.buffs.add(buff.getCopy());

        this.cellEffects = new ArrayList<>();
        for (CellEffect cellEffect : mainSpell.cellEffects)
            this.cellEffects.add(cellEffect.getCopy());
    }

    public static void addSpell(String name, String ID, int cost, int mana, SpellTarget target, ArrayList<Effect> effects,
                                ArrayList<Buff> buffs, ArrayList<CellEffect> cellEffects) {
        spells.add(new Spell(name, ID, cost, mana, target, effects, buffs, cellEffects));
    }

    public Spell getCopy(Player player, String ID) {
        return new Spell(this, player, ID);
    } //get copy for shop

    public Spell getCopy(String ID) {
        return new Spell(this, this.getPlayer(), ID);
    }//get copy for deck

    public boolean canPut(Coordination coordination) {
        if (!super.canPut(coordination)) {
            //todo handle err
            return false;
        }
        if (!SpellTarget.canPutSpellOn(this, coordination)) {
            //todo handle err
            return false;
        }
        return true;
    }

    public SpellTarget getSpellTarget() {
        return spellEffect.getTarget();
    }
}
