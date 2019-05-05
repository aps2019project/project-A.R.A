package Model.Card_package.effect;

import java.util.ArrayList;

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

    public static ArrayList<Effect> getCopy(ArrayList<Effect> effects) {
        ArrayList<Effect> copy = new ArrayList<>();
        for (Effect effect : effects)
            copy.add(effect.getCopy());
        return copy;
    }

    public Effect getCopy() {
        return new Effect(this.effectType, this.effectTimeType, this.time, this.unit);
    }



}
