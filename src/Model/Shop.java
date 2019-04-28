package Model;

import Model.Card_package.Hero;
import Model.Card_package.Minion;
import Model.Card_package.Spell;
import Model.Match_package.Item;

import java.util.ArrayList;

public class Shop {
    ArrayList<Hero> shopHeros = new ArrayList<>();
    ArrayList<Minion> shopMinions = new ArrayList<>();
    ArrayList<Item> shopItems = new ArrayList<>();
    ArrayList<Spell> shopSpells = new ArrayList<>();
    private Shop instance = new Shop();

    public Shop getInstance() {
        return instance;
    }

    public String get(String stuffName){
//        for(Hero hero: shopHeros)
//            if(hero.)
    }
}
