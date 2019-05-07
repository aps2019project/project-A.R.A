package Model;

import Account_package.Account;
import Menus.MenuManager;
import Model.Card_package.*;
import Model.Item_package.Item;
import Model.Match_package.Deck;
import Model.Match_package.Match;
import Model.Match_package.Player;

import java.util.ArrayList;
import java.util.Random;

public class AI extends Account {
    private static AI instance = new AI();
    private Player[] players = new Player[3];

    private AI() {
        super("Mr.Model.AI", "404");
        initDeck1();
        initDeck2();
        initDeck3();
    }

    private void initDeck1(){
        Collection collection = this.getCollection();
        collection.add(((Hero) Shop.getInstance().get("DivehSefid")));
        collection.addItem(((Item) Shop.getInstance().get("TajehDanai")));
        collection.add(((Minion) Shop.getInstance().get("KamandareFars")));
        collection.add(((Minion) Shop.getInstance().get("NeizehdarehTorani")));
        collection.add(((Minion) Shop.getInstance().get("GorzdarehTorani")));
        collection.add(((Hero) Shop.getInstance().get("DivehSefid")));
        collection.add(((Minion) Shop.getInstance().get("GholehTakCheshm")));
        collection.add(((Minion) Shop.getInstance().get("MarehSami")));
        collection.add(((Minion) Shop.getInstance().get("ShirehDarandeh")));
        collection.add(((Minion) Shop.getInstance().get("MarehGholpeikar")));
        collection.add(((Minion) Shop.getInstance().get("GorgeSefid")));
        collection.add(((Minion) Shop.getInstance().get("MarehGholpeikar")));
        collection.add(((Minion) Shop.getInstance().get("Jadogar")));
        collection.add(((Minion) Shop.getInstance().get("Siavash")));
        collection.add(((Minion) Shop.getInstance().get("NanehSarma")));
        collection.add(((Minion) Shop.getInstance().get("Arjanghdiv")));
        collection.add(((Spell) Shop.getInstance().get("TotalDisarm")));
        collection.add(((Spell) Shop.getInstance().get("LightingBolt")));
        collection.add(((Spell) Shop.getInstance().get("AllDisarm")));
        collection.add(((Spell) Shop.getInstance().get("AllPoison")));
        collection.add(((Spell) Shop.getInstance().get("Dispel")));
        collection.add(((Spell) Shop.getInstance().get("Sacrifice")));
        collection.add(((Spell) Shop.getInstance().get("Shock")));

        collection.addToDecks("DarkArmy");
        collection.setMainDeck("DarkArmy");
        Deck deck = collection.getMainDeck();
        deck.add(collection.get(Shop.getInstance().getUnitID("DivehSefid")));
        deck.add(collection.get(Shop.getInstance().getUnitID("TajehDanai")));

        deck.add(collection.get(Shop.getInstance().getUnitID("KamandareFars")));
        deck.add(collection.get(Shop.getInstance().getUnitID("NeizehdarehTorani")));
        deck.add(collection.get(Shop.getInstance().getUnitID("GorzdarehTorani")));
        deck.add(collection.get(Shop.getInstance().getUnitID("GholehTakCheshm")));
        deck.add(collection.get(Shop.getInstance().getUnitID("MarehSami")));
        deck.add(collection.get(Shop.getInstance().getUnitID("ShirehDarandeh")));
        deck.add(collection.get(Shop.getInstance().getUnitID("MarehGholpeikar")));
        deck.add(collection.get(Shop.getInstance().getUnitID("GorgeSefid")));
        deck.add(collection.get(Shop.getInstance().getUnitID("MarehGholpeikar")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Jadogar")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Siavash")));
        deck.add(collection.get(Shop.getInstance().getUnitID("NanehSarma")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Arjanghdiv")));
        deck.add(collection.get(Shop.getInstance().getUnitID("TotalDisarm")));
        deck.add(collection.get(Shop.getInstance().getUnitID("LightingBolt")));
        deck.add(collection.get(Shop.getInstance().getUnitID("AllDisarm")));
        deck.add(collection.get(Shop.getInstance().getUnitID("AllPoison")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Dispel")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Sacrifice")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Shock")));

        players[0] = new Player(getName(), deck);
    }

    private void initDeck2(){
        Collection collection = this.getCollection();
        collection.add(((Hero) Shop.getInstance().get("Zahak")));
        collection.addItem(((Item) Shop.getInstance().get("SoulEater")));
        collection.add(((Minion) Shop.getInstance().get("ShamshirzanFars")));
        collection.add(((Minion) Shop.getInstance().get("NaizehDarehFars")));
        collection.add(((Minion) Shop.getInstance().get("PahlavanehFars")));
        collection.add(((Minion) Shop.getInstance().get("GholabsangdarehTorani")));
        collection.add(((Minion) Shop.getInstance().get("ShahzadehTorani")));
        collection.add(((Minion) Shop.getInstance().get("Oghab"))); // todo
        collection.add(((Minion) Shop.getInstance().get("EjdehayeAtashandaz")));
        collection.add(((Minion) Shop.getInstance().get("Palang")));
        collection.add(((Minion) Shop.getInstance().get("Jen")));
        collection.add(((Minion) Shop.getInstance().get("Giv")));
        collection.add(((Minion) Shop.getInstance().get("Irag")));
        collection.add(((Minion) Shop.getInstance().get("Shahghol")));
        collection.add(((Spell) Shop.getInstance().get("AreaDispel")));
        collection.add(((Spell) Shop.getInstance().get("Empower")));
        collection.add(((Spell) Shop.getInstance().get("GodStrength")));
        collection.add(((Spell) Shop.getInstance().get("PoisonLake")));
        collection.add(((Spell) Shop.getInstance().get("Madness")));
        collection.add(((Spell) Shop.getInstance().get("HealthWithProfit")));
        collection.add(((Spell) Shop.getInstance().get("KingsGuard")));

        collection.addToDecks("DeadMayNeverDie");
        collection.setMainDeck("DeadMayNeverDie");

        Deck deck = collection.getMainDeck();

        deck.add(collection.get(Shop.getInstance().getUnitID("DivehSefid")));
        deck.add(collection.get(Shop.getInstance().getUnitID("TajehDanai")));

        deck.add(collection.get(Shop.getInstance().getUnitID("Zahak")));
        collection.addItem(((Item) Shop.getInstance().get("SoulEater")));
        deck.add(collection.get(Shop.getInstance().getUnitID("ShamshirzanFars")));
        deck.add(collection.get(Shop.getInstance().getUnitID("NaizehDarehFars")));
        deck.add(collection.get(Shop.getInstance().getUnitID("PahlavanehFars")));
        deck.add(collection.get(Shop.getInstance().getUnitID("GholabsangdarehTorani")));
        deck.add(collection.get(Shop.getInstance().getUnitID("ShahzadehTorani")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Oghab")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Oghab")));
        deck.add(collection.get(Shop.getInstance().getUnitID("EjdehayeAtashandaz")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Palang")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Jen")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Giv")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Irag")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Shahghol")));
        deck.add(collection.get(Shop.getInstance().getUnitID("AreaDispel")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Empower")));
        deck.add(collection.get(Shop.getInstance().getUnitID("GodStrength")));
        deck.add(collection.get(Shop.getInstance().getUnitID("PoisonLake")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Madness")));
        deck.add(collection.get(Shop.getInstance().getUnitID("HealthWithProfit")));
        deck.add(collection.get(Shop.getInstance().getUnitID("KingsGuard")));

        players[1] = new Player(getName(), deck);
    }

    private void initDeck3(){
        Collection collection = this.getCollection();
        collection.add(((Hero) Shop.getInstance().get("Zahak")));
        collection.addItem(((Item) Shop.getInstance().get("SoulEater")));
        collection.add(((Minion) Shop.getInstance().get("ShamshirzanFars")));
        collection.add(((Minion) Shop.getInstance().get("NaizehDarehFars")));
        collection.add(((Minion) Shop.getInstance().get("PahlavanehFars")));
        collection.add(((Minion) Shop.getInstance().get("GholabsangdarehTorani")));
        collection.add(((Minion) Shop.getInstance().get("ShahzadehTorani")));
        collection.add(((Minion) Shop.getInstance().get("Oghab"))); // todo
        collection.add(((Minion) Shop.getInstance().get("EjdehayeAtashandaz")));
        collection.add(((Minion) Shop.getInstance().get("Palang")));
        collection.add(((Minion) Shop.getInstance().get("Jen")));
        collection.add(((Minion) Shop.getInstance().get("Siavash")));
        collection.add(((Minion) Shop.getInstance().get("NanehSarma")));
        collection.add(((Minion) Shop.getInstance().get("Arjanghdiv")));
        collection.add(((Spell) Shop.getInstance().get("TotalDisarm")));
        collection.add(((Spell) Shop.getInstance().get("LightingBolt")));
        collection.add(((Spell) Shop.getInstance().get("AllDisarm")));
        collection.add(((Spell) Shop.getInstance().get("AllPoison")));
        collection.add(((Spell) Shop.getInstance().get("Dispel")));
        collection.add(((Spell) Shop.getInstance().get("Sacrifice")));
        collection.add(((Spell) Shop.getInstance().get("Shock")));

        collection.addToDecks("DeadMayNeverDie");
        collection.setMainDeck("DeadMayNeverDie");

        Deck deck = collection.getMainDeck();

        deck.add(collection.get(Shop.getInstance().getUnitID("DivehSefid")));
        deck.add(collection.get(Shop.getInstance().getUnitID("TajehDanai")));

        deck.add(collection.get(Shop.getInstance().getUnitID("Zahak")));
        collection.addItem(((Item) Shop.getInstance().get("SoulEater")));
        deck.add(collection.get(Shop.getInstance().getUnitID("ShamshirzanFars")));
        deck.add(collection.get(Shop.getInstance().getUnitID("NaizehDarehFars")));
        deck.add(collection.get(Shop.getInstance().getUnitID("PahlavanehFars")));
        deck.add(collection.get(Shop.getInstance().getUnitID("GholabsangdarehTorani")));
        deck.add(collection.get(Shop.getInstance().getUnitID("ShahzadehTorani")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Oghab")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Oghab")));
        deck.add(collection.get(Shop.getInstance().getUnitID("EjdehayeAtashandaz")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Palang")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Jen")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Giv")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Irag")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Shahghol")));
        deck.add(collection.get(Shop.getInstance().getUnitID("AreaDispel")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Empower")));
        deck.add(collection.get(Shop.getInstance().getUnitID("GodStrength")));
        deck.add(collection.get(Shop.getInstance().getUnitID("PoisonLake")));
        deck.add(collection.get(Shop.getInstance().getUnitID("Madness")));
        deck.add(collection.get(Shop.getInstance().getUnitID("HealthWithProfit")));
        deck.add(collection.get(Shop.getInstance().getUnitID("KingsGuard")));

        players[2] = new Player(getName(), deck);
    }
    // todo not handled

    public static AI getInstance() {
        return instance;
    }

    public Player[] getPlayers() {
        return players;
    }

    public String getCommand() {
        Match match = MenuManager.getCurrentMatch();
        Random random = new Random(46);
        ArrayList<Card> handCards = match.getOwnPlayer().getHand().getShowAbleCards();
        ArrayList<Force> targets = match.getMap().getForcesInMap(match.getOpponent());
        ArrayList<Force> ownMapCards = match.getMap().getForcesInMap(match.getOwnPlayer());
        switch (random.nextInt(7)) {
            case 0:

                return ("attack " + targets.get(random.nextInt(targets.size())).getID());
            case 1:
                return ("insert " + handCards.get(random.nextInt(handCards.size())).getID()
                        + "(" + random.nextInt(9) + "," + random.nextInt(5) + ")");
            case 2:
                return String.format("(move to (%d, %d)", random.nextInt(9), random.nextInt(5));
            case 3:
                ArrayList<Card> temp = new ArrayList<>();
                temp.addAll(handCards);
                temp.addAll(ownMapCards);
                return String.format("select %s", temp.get(random.nextInt(temp.size())).getID());
            case 4:
                return String.format("select collectable %s", match.getOwnPlayer().getCollectables().get(random.nextInt()));
            case 5:
                return String.format("use (%d,%d)", random.nextInt(9), random.nextInt(5));
            default:
                return String.format("use special power (%d,%d)", random.nextInt(9), random.nextInt(5));
        }
    }
}
