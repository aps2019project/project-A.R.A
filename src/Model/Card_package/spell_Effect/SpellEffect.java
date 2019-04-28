package Model.Card_package.spell_Effect;

public class SpellEffect {
    private SpellEffectType spellEffectType;
    private SpellEffectTimeType spellEffectTimeType;
    private int time;
    private int unit;

    public SpellEffect(SpellEffectType spellEffectType, SpellEffectTimeType spellEffectTimeType, int time, int unit) {
        this.spellEffectType = spellEffectType;
        this.spellEffectTimeType = spellEffectTimeType;
        this.time = time;
        this.unit = unit;
    }

    public SpellEffect getCopy() {
        return new SpellEffect(this.spellEffectType, this.spellEffectTimeType, this.time, this.unit);
    }

}
