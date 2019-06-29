package Model;

import Account_package.Account;
import Menus.MenuManager;
import Model.Card_package.*;
import Model.Card_package.usable.Usable;
import Model.Match_package.Deck;
import Model.Match_package.Match;
import Model.Match_package.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AI extends Account {
    private static AI[] aiAccounts ;
    private Player[] players = new Player[3];


    private AI(String name, Collection collection) {
        super(name, collection);
    }

    public static void initAIs() {
        aiAccounts = new AI[3];
        aiAccounts[0] = initAI("AI1", "DarkArmy", forceInCollectionNames1(), forceInDeckNames1());
        aiAccounts[1] = initAI("AI2", "DeadMayNeverDie", forceInCollectionNames2(), forceInDeckNames2());
        aiAccounts[2] = initAI("AI3", "DeadMayNeverDie", forceInCollectionNames3(), forceInDeckNames3());

    }
    private static AI initAI(String name, String deckName, ArrayList<String> forceInCollectionNames,
                             ArrayList<String> forceInDeckNames) {
        Collection collection = new Collection();
        for (String forceName : forceInCollectionNames) {
            collection.add(Shop.getInstance().getUnit(forceName));
        }
        collection.addToDecks(deckName);
        collection.setMainDeck(deckName);
        Deck deck = collection.getMainDeck();
        for (String forceName : forceInDeckNames) {
            deck.add(collection.get(Shop.getInstance().getUnitID(forceName)));
        }
        return new AI(name, collection);
    }

    //todo check names
    private static ArrayList<String> forceInCollectionNames1() {
        return new ArrayList<>(Arrays.asList("DivehSefid", "TajehDanai", "KamandareFars", "NeizehdarehTorani",
                "GorzdarehTorani", "DivehSefid", "GholehTakCheshm", "MarehSami", "ShirehDarandeh", "MarehGholpeikar",
                "GorgeSefid", "MarehGholpeikar", "Jadogar", "Siavash", "NanehSarma", "Arjanghdiv", "TotalDisarm",
                "LightingBolt", "AllDisarm", "AllPoison", "Dispel", "Sacrifice", "Shock"));
    }

    private static ArrayList<String> forceInDeckNames1() {
        return new ArrayList<>(Arrays.asList("DivehSefid", "TajehDanai", "KamandareFars", "NeizehdarehTorani",
                "GorzdarehTorani","GholehTakCheshm", "MarehSami", "ShirehDarandeh", "MarehGholpeikar",
                "GorgeSefid", "MarehGholpeikar", "Jadogar", "Siavash", "NanehSarma", "Arjanghdiv", "TotalDisarm",
                "LightingBolt", "AllDisarm", "AllPoison", "Dispel", "Sacrifice", "Shock"));
    }

    private static ArrayList<String> forceInCollectionNames2() {
        return new ArrayList<>(Arrays.asList("Zahak", "SoulEater", "ShamshirzanFars", "NaizehDarehFars",
                "PahlavanehFars", "GholabsangdarehTorani", "ShahzadehTorani", "Oghab", "EjdehayeAtashandaz",
                "Palang", "Jen", "Giv", "Irag", "Shahghol", "AreaDispel", "Empower", "GodStrength", "PoisonLake",
                "Madness", "HealthWithProfit", "KingsGuard"));
    }

    private static ArrayList<String> forceInDeckNames2() {
        return new ArrayList<>(Arrays.asList(
                "Zahak", "SoulEater", "ShamshirzanFars", "NaizehDarehFars",
                "PahlavanehFars", "GholabsangdarehTorani", "ShahzadehTorani", "Oghab", "Oghab",
                "EjdehayeAtashandaz", "Palang", "Jen", "Giv", "Irag", "Shahghol", "AreaDispel", "Empower",
                "GodStrength", "PoisonLake", "Madness", "HealthWithProfit", "KingsGuard"));
    }

    private static ArrayList<String> forceInCollectionNames3() {
       return new ArrayList<>(Arrays.asList("Zahak", "SoulEater", "ShamshirzanFars", "NaizehDarehFars",
               "PahlavanehFars", "GholabsangdarehTorani", "ShahzadehTorani", "Oghab", "EjdehayeAtashandaz",
               "Palang", "Jen", "Siavash", "NanehSarma", "Arjanghdiv", "TotalDisarm", "LightingBolt", "AllDisarm",
               "AllPoison", "Dispel", "Sacrifice", "Shock"));
    }

    private static ArrayList<String> forceInDeckNames3() {
        return new ArrayList<>(Arrays.asList("Zahak", "SoulEater", "ShamshirzanFars",
                "NaizehDarehFars", "PahlavanehFars", "GholabsangdarehTorani", "ShahzadehTorani", "Oghab", "Oghab",
                "EjdehayeAtashandaz", "Palang", "Jen", "Siavash", "NanehSarma", "Arjanghdiv", "TotalDisarm", "LightingBolt", "AllDisarm",
                "AllPoison", "Dispel", "Sacrifice", "Shock"));
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
                return String.format("select collectable %s", match.getOwnPlayer().getCollectAbles().get(random.nextInt()));
            case 5:
                return String.format("use (%d,%d)", random.nextInt(9), random.nextInt(5));
            default:
                return String.format("use special power (%d,%d)", random.nextInt(9), random.nextInt(5));
        }
    }
}
