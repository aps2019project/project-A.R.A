package Model.Card_package.effect;

import Model.Card_package.Force;

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

    public void decrementTime(Force force) {
        if (effectType == EffectType.DECREMENT_HP) {
            force.decreamentHp(unit);
        } else if (effectType == EffectType.INCREMENT_AP) {
            force.incrementAP(unit);
        } else if (effectType == EffectType.INCREMENT_HP) {
            force.incrementHp(unit);
        }
        if (effectTimeType == EffectTimeType.COUNTABLE)
            time --;
    }
    public boolean isFinished() {
        return effectTimeType == EffectTimeType.COUNTABLE && time == 0;
    }
}
