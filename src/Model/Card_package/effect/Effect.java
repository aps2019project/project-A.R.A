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
        if (effects == null)
            return null;
        ArrayList<Effect> copy = new ArrayList<>();
        for (Effect effect : effects)
            copy.add(effect.getCopy());
        return copy;
    }

    public EffectType getEffectType() {
        return effectType;
    }

    public boolean isPositive() {
        switch (effectType) {
            case INCREMENT_AP:
            case INCREMENT_HP:
            case DISPEL:
                return true;
            case DECREMENT_HP:
            case KILL:
            case NEGATIVE_HOLY_BUFF:
                return false;
        }
        return false;
    }

    public Effect getCopy() {
        return new Effect(this.effectType, this.effectTimeType, this.time, this.unit);
    }

}
