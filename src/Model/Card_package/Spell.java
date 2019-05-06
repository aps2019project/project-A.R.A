package Model.Card_package;

import Model.Card_package.spell_Effect.SpellEffect;
import Model.Card_package.spell_Effect.SpellTarget;
import Model.Match_package.*;

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

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Spell : ");
        stringBuilder.append("Name : " + this.getName() + "  ");
        stringBuilder.append("MP : " + this.getMana() + "  ");
        stringBuilder.append("description : " + this.getDesc() + "  ");
        return stringBuilder.toString();
    }
}
