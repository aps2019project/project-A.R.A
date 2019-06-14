package Model.Card_package;

import Exceptions.CannotPutException;
import Menus.MenuManager;
import Model.Card_package.spell_Effect.SpellEffect;
import Model.Card_package.spell_Effect.SpellTarget;
import Model.Match_package.*;
import Model.Match_package.cell.Cell;

import java.util.ArrayList;
import java.util.Random;

public class Spell extends Card {

    SpellEffect spellEffect;

    public Spell(String name, int price, int mana, String desc, SpellEffect spellEffect, Player player) {
        super(name, price, mana, desc, player);
        this.setID(String.format("Spell_%s", name));
        this.spellEffect = spellEffect;
    }

    protected Spell getCopy(Player player, String ID) {
        Spell newSpell =  new Spell(this.getName(), this.getPrice(), this.getMana(), this.getDesc(),
                this.spellEffect.getCopy(), player);
        newSpell.setID(ID);
        return newSpell;
    }

    public void put(int x, int y) {
        Match match = MenuManager.getCurrentMatch();
        Map map = match.getMap();
        ArrayList<Force> forces = new ArrayList<>();
        ArrayList<Cell> cells = new ArrayList<>();
        if (getSpellTarget() == SpellTarget.CELLS2X2){
            if (x > 2 || x < 0 || y < 0 || y > 7)
                throw new CannotPutException();
            for (int i = 0; i < 2; i++)
                for(int j = 0; j < 2; j++)
                    cells.add(map.getCell(x + i, y + j));
        }
        else if (getSpellTarget() == SpellTarget.CELLS3X3) {
            if (x > 1 || x < 0 || y < 0 || y > 6)
                throw new CannotPutException();
            for (int i = 0; i < 3; i++)
                for(int j = 0; j < 3; j++)
                    cells.add(map.getCell(x + i, y + j));
        }
        else if (getSpellTarget() == SpellTarget.ENEMY_FORCE) {
            if(map.getCell(x, y).isEmpty() || map.getCell(x, y).getForce().isTeammate(this))
                throw new CannotPutException();
            forces.add(map.getCell(x, y).getForce());
        }
        else if (getSpellTarget() == SpellTarget.OUR_FORCE) {
            if(map.getCell(x, y).isEmpty() || !map.getCell(x, y).getForce().isTeammate(this))
                throw new CannotPutException();
            forces.add(map.getCell(x, y).getForce());
        }
        else if (getSpellTarget() ==SpellTarget.ENEMY_HERO) {
            if(map.getCell(x, y).isEmpty() || map.getCell(x, y).getForce().isTeammate(this) || !(map.getCell(x,y).getForce() instanceof Hero))
                throw new CannotPutException();
            forces.add(map.getCell(x, y).getForce());
        }
        else if (getSpellTarget() == SpellTarget.OUR_HERO) {
            if(map.getCell(x, y).isEmpty() || !map.getCell(x, y).getForce().isTeammate(this) || !(map.getCell(x,y).getForce() instanceof Hero))
                throw new CannotPutException();
            forces.add(map.getCell(x, y).getForce());
        }
        else if (getSpellTarget() == SpellTarget.ENEMY_MINION) {
            if(map.getCell(x, y).isEmpty() || map.getCell(x, y).getForce().isTeammate(this) || !(map.getCell(x,y).getForce() instanceof Minion))
                throw new CannotPutException();
            forces.add(map.getCell(x, y).getForce());
        }
        else if (getSpellTarget() == SpellTarget.OUR_MINION) {
            if(map.getCell(x, y).isEmpty() || !map.getCell(x, y).getForce().isTeammate(this) || !(map.getCell(x,y).getForce() instanceof Minion))
                throw new CannotPutException();
            forces.add(map.getCell(x, y).getForce());
        }
        else if (getSpellTarget() == SpellTarget.ALL_ENEMY_FORCE) {
            for (Force force : map.getForcesInMap(match.getOpponent())) {
                forces.add(force);
            }
        }
        else if (getSpellTarget() == SpellTarget.ALL_OUR_FORCE) {
            for (Force force : map.getForcesInMap(match.getOwnPlayer())) {
                forces.add(force);
            }
        }
        else if (getSpellTarget() == SpellTarget.FORCE) {
            for (Force force : map.getForcesInMap()) {
                forces.add(force);
            }
        }
        else if (getSpellTarget() == SpellTarget.VERTICAL_ENEMY) {
            for (int i = 0; i < 5; i++) {
                if (!map.getCell(i, y).isEmpty())
                    forces.add(map.getCell(i, y).getForce());
            }
        }
        else if (getSpellTarget() == SpellTarget.RANDOM_ENEMY_MINION_IN_NEIGHBOR_OF_OUR_HERO) {
            if (map.getCell(x, y).isEmpty() || !map.getCell(x,y).getForce().isTeammate(this) || map.getCell(x, y).getForce() instanceof Minion)
                throw new CannotPutException();
            label:
            for (int k = new Random().nextInt(9), m = 0; m < 9; m ++, k ++){
                int i = k / 3 - 1, j = (k % 3) - 1;
                if (x + i < 0 || x + i >= 5 || y + j < 0 || y + j >= 9)
                    continue;
                if (!map.getCell(x + i, y + j).isEmpty() &&
                        map.getCell(x + i, y + j).getForce().getPlayer() != this.getPlayer() &&
                        map.getCell(x + i, y + j).getForce() instanceof Minion) {
                    forces.add(map.getCell(x + i, j + j).getForce());
                    break label;
                }
                if (m == 8)
                    throw new CannotPutException();
            }
        }

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
