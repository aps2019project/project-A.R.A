package Model.Card_package.hero_special_power;

import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
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
}
