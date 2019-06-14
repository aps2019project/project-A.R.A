package Model.Card_package.spell_Effect;

import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Match_package.cell.CellEffect;

import java.util.ArrayList;

public class SpellEffect {
    private SpellTarget target;
    private SpellEffectType spellEffectType;
    private ArrayList<Effect> effects;
    private ArrayList<Buff> buffs;
    private ArrayList<CellEffect> cellEffects;

    public SpellEffect(SpellTarget target, SpellEffectType spellEffectType, ArrayList<Effect> effects, ArrayList<Buff> buffs, ArrayList<CellEffect> cellEffects) {
        this.target = target;
        this.spellEffectType = spellEffectType;
        this.effects = effects;
        this.buffs = buffs;
        this.cellEffects = cellEffects;
    }

    public SpellEffect getCopy() {
        return new SpellEffect(this.target, spellEffectType, Effect.getCopy(this.effects), Buff.getCopy(this.buffs), CellEffect.getCopy(this.cellEffects));
    }

    public SpellTarget getTarget() {
        return target;
    }

    public SpellEffectType getSpellEffectType() {
        return spellEffectType;
    }

    public ArrayList<Buff> getBuffs() {
        return buffs;
    }

    public ArrayList<CellEffect> getCellEffects() {
        return cellEffects;
    }

    public ArrayList<Effect> getEffects() {
        return effects;
    }
}
