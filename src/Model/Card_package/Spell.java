package Model.Card_package;



import Model.Card_package.buff.Buff;
import Model.Card_package.effect.Effect;
import Model.Card_package.spell_Effect.SpellEffect;
import Model.Card_package.spell_Effect.SpellTarget;
import Model.Match_package.*;

import java.util.ArrayList;

public class Spell extends Card {

    SpellEffect spellEffect;

    public Spell(String name, String ID, int price, int mana, String desc, SpellEffect spellEffect, Player player) {
        super(name, ID, price, mana, desc, player);
        this.spellEffect = spellEffect;
    }


    protected Spell getCopy(Player player, String ID) {
        return new Spell(this.getName(), ID, this.getPrice(), this.getMana(), this.getDesc(),
                this.spellEffect.getCopy(), player);
    }

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
