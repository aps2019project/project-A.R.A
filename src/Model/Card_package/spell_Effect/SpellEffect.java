package Model.Card_package.spell_Effect;

import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Match_package.CellEffect;

import java.util.ArrayList;

public class SpellEffect {
    private SpellTarget target;
    private ArrayList<Effect> effects;
    private ArrayList<Buff> buffs;
    private ArrayList<CellEffect> cellEffects;
}
