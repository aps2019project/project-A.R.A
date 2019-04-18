package Card_package;

import Card_package.Spells.SpellType;

import java.util.ArrayList;

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
