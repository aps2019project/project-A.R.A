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
    private Shop instance = new Shop();

    public Shop getInstance() {
        return instance;
    }

    public Unit get(String ID) {
        for (Hero hero : shopHeroes)
            if (hero.getID().equals(ID))
                return hero;
        for (Spell spell : shopSpells)
            if (spell.getID().equals(ID))
                return spell;
        for (Item item : shopItems)
            if (item.getID().equals(ID))
                return item;
        for (Minion minion : shopMinions)
            if (minion.getID().equals(ID))
                return minion;
        return null; // 404 not found
    }

    public Shop buy(Account account, String ID) {
        Unit unit = this.get(ID);
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
    }}
