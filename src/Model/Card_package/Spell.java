package Model.Card_package;

import Model.Card_package.Spells.SpellType;

public class Spell extends Card {
    SpellType spellType;

    public Spell(String ID, int cost, int mana) {
        super(ID, cost, mana);
    }

    private Spell(String ID, Spell mainSpell){
        super(ID, mainSpell);
        this.spellType = mainSpell.spellType;
    }

    public Spell getCopy(String ID) {
        return new Spell(ID, this);
    }

}
