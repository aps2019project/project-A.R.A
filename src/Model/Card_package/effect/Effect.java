package Model.Card_package.effect;

public class Effect {
    private EffectType effectType;
    private EffectTimeType effectTimeType;
    private int time;
    private int unit;

    public Effect(EffectType effectType, EffectTimeType effectTimeType, int time, int unit) {
        this.effectType = effectType;
        this.effectTimeType = effectTimeType;
        this.time = time;
        this.unit = unit;
    }

    public Effect getCopy() {
        return new Effect(this.effectType, this.effectTimeType, this.time, this.unit);
    }

}
