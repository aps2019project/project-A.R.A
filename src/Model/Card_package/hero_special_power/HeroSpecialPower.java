package Model.Card_package.hero_special_power;

import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Match_package.Cell;
import Model.Match_package.CellEffect;

import java.util.ArrayList;

public class HeroSpecialPower {
    private int mana;
    private int cooldown;
    private int remainCooldown;
    HeroSpecialPowerTarget target;
    HeroSpecialPowerActivationTime activationTime;
    HeroSpecialPowerType type;
    ArrayList<Buff> buffs;
    ArrayList<Effect> effects;
    ArrayList<CellEffect> cellEffects;

    public HeroSpecialPower(int mana, int cooldown, HeroSpecialPowerTarget target,
                            HeroSpecialPowerActivationTime activationTime, HeroSpecialPowerType type,
                            ArrayList<Buff> buffs, ArrayList<Effect> effects, ArrayList<CellEffect> cellEffects) {
        this.mana = mana;
        this.cooldown = cooldown;
        this.remainCooldown = 0;
        this.target = target;
        this.activationTime = activationTime;
        this.type = type;
        this.buffs = buffs;
        this.effects = effects;
        this.cellEffects = cellEffects;
    }

    public HeroSpecialPower getCopy() {
        return new HeroSpecialPower(mana, cooldown, target, activationTime, type,
                Buff.getCopy(buffs), Effect.getCopy(effects), CellEffect.getCopy(cellEffects));
    }
}
