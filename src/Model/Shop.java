package Model;

import Account_package.Account;
import Model.Card_package.Card;
import Model.Card_package.Hero;
import Model.Card_package.Minion;
import Model.Card_package.Spell;
import Model.Item_package.Item;

import java.util.ArrayList;

public class Shop {
    ArrayList<Hero> shopHeroes = new ArrayList<>();
    ArrayList<Minion> shopMinions = new ArrayList<>();
    ArrayList<Item> shopItems = new ArrayList<>();
    ArrayList<Spell> shopSpells = new ArrayList<>();

    public ArrayList<Unit> shopUnits = new ArrayList<>();
    private static Shop instance = new Shop();

    public static Shop getInstance() {
        return instance;
    }

    public Unit get(String name) {
        for (Unit unit : shopUnits)
            if (unit.getName().equals(name))
                return unit;
        return null; // 404 not found
    }

    public Unit getBasedOnType(String type) {
        for (Unit unit : shopUnits)
            if (unit.getName().equals(type))
                return unit;
        return null;
    }

    public Shop buy(Account account, String name) {
        Unit unit = this.get(name);
        if (unit == null) {
            // show error
            return this;
        }
        if (unit instanceof Card)
            account.getCollection().add((Card) unit);
        else
            account.getCollection().addItem((Item) unit.getCopy());
        account.pay(unit.getPrice());
        return this;
    }

    public Shop sell(Account account, String ID) {
        if (!account.getCollection().hasUnit(ID))
            return this;

        Unit unit = account.getCollection().get(ID);
        if (unit instanceof Card)
            account.getCollection().deleteCard((Card) unit);
        else
            account.getCollection().deleteItem((Item) unit);
        account.earn(unit.getPrice());
        return this;
    }

    public boolean hasUnit(String name) {
        for (Unit unit : shopUnits)
            if (unit.getName().equals(name))
                return true;
        return false;
    }

    public boolean hasHero(String name){
        for(Hero hero:shopHeroes)
            if(hero.getName().equals(name))
                return true;
            return false;
    }

    public boolean hasMinion(String name){
        for(Minion minion:shopMinions)
            if(minion.getName().equals(name))
                return true;
        return false;
    }

    public boolean hasItem(String name){
        for(Item item:shopItems)
            if(item.getName().equals(name))
                return true;
        return false;
    }

    public boolean hasSpell(String name){
        for(Spell spell:shopSpells)
            if(spell.getName().equals(name))
                return true;
        return false;
    }

    public String getUnitID(String name) {
        for (Unit unit : shopUnits)
            if (unit.getName().equals(name))
                return unit.getID();
        return null; // never gonna happen
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder("not handled !!");
        //buffer.append(......);
        return buffer.toString();
    }


    public void initCards() {

    }

    private void initSpellCards() {

    }
}
