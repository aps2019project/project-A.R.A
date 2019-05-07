package Menus;

import Account_package.Account;
import Model.Card_package.Hero;
import Model.Card_package.Minion;
import Model.Card_package.Spell;
import Model.Collection;
import Model.Item_package.Item;
import Model.Match_package.Deck;
import Model.Match_package.Match;
import Model.Shop;
import View.View;
import java.util.ArrayList;

public class MenuManager {
    private static Menu currentMenu = new Menu(Menus.ACCOUNT, "Login");
    private static View view = new View();
    private static ArrayList<Match> matches = new ArrayList<>(3);
    // done matches are supposed to be deleted from this list.
    private static GameMode gameMode;

    public static void start() {
        setMenuRelations();
        Shop.getInstance().initCards();
    }

    public static void initialTest(){
        Collection collection = Account.getCurrentAccount().getCollection();
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

        collection.addToDecks("re");
        collection.setMainDeck("re");
        Deck deck = collection.getMainDeck();
        deck.add(collection.get(Shop.getInstance().getUnitID("DivehSefid")));
        deck.add(collection.get(Shop.getInstance().getUnitID("TajehDanai")));

        deck.add(collection.get(Shop.getInstance().getUnitID("KamandareFars")));
        deck.add(collection.get(Shop.getInstance().getUnitID("NeizehdarehTorani")));
        deck.add(collection.get(Shop.getInstance().getUnitID("GorzdarehTorani")));
        deck.add(collection.get(Shop.getInstance().getUnitID("GorzdarehTorani")));
        deck.add(collection.get(Shop.getInstance().getUnitID("DivehSefid")));
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
    }

    private static void setMenuRelations() {
        Menu main = new Menu(Menus.MAIN, "DUELYST");
        Menu shop = new Menu(Menus.SHOP, "Shop");
        Menu collection = new Menu(Menus.COLLECTION, "Collection");
        Menu modeChoose = new Menu(Menus.GAME_MODE_CHOOSE, "Choose Game Mode");
        Menu singleMode = new Menu(Menus.SINGLE_PLAYER, "single Player");
        Menu story = new Menu(Menus.STORY, "story");
        Menu custom = new Menu(Menus.CUSTOM_GAME, "Custom Game");
        Menu battle = new Menu(Menus.BATTLE, "Battle");
        Menu endGame = new Menu(Menus.GAME_END, "game ended");
        Menu graveYard = new Menu(Menus.GRAVE_YARD, "graveYard");
        Menu multiMode = new Menu(Menus.MULTI_PLAYER, "Select Your Opponent");

        currentMenu.addSubItem(main);
        main.addSubItem(shop).addSubItem(collection).addSubItem(endGame).addSubItem(modeChoose);
        modeChoose.addSubItem(singleMode).addSubItem(multiMode); // multi or single
        singleMode.addSubItem(custom).addSubItem(story);
        story.addSubItem(battle).addSubItem(endGame);
        battle.addSubItem(endGame);
        custom.addSubItem(battle);
        multiMode.addSubItem(battle);
        battle.addSubItem(graveYard);
    }

    public static void setCurrentMenu(Menu currentMenu) {
        MenuManager.currentMenu = currentMenu;
    }

    public static Menu getCurrentMenu(){
        return currentMenu;
    }

    public static Menus getCurrentMenuType(){
        return currentMenu.getType();
    }

    public static void setGameMode(GameMode gameMode){
        MenuManager.gameMode = gameMode;
    }

    public static GameMode getGameMode(){
        return gameMode;
    }

    public static void removeMatch() {
        matches.remove(0);
    }

    public static void addMatch(Match match){
        matches.add(match);
    }

    public static void deleteRecentMatch(){
        matches.remove(0);
    }

    public static Match getCurrentMatch(){
        return matches.get(0);
    }

    public static ArrayList getMatches(){
        return matches;
    }

    public static void goTo(Menus type) {
        for (Menu menu : currentMenu.getSubItems()) {
            if (menu.equals(new Menu(type, ""))) {
                currentMenu = menu;
                view.show(currentMenu.getTitle());
                view.showCurrentMenuList(); // had better modify this list -- it's gonna print something like endGame;(Maybe)
                return;
            }
        }
    }

    public static void back(Menus type) {
        for(Object menu: currentMenu.getParentMenus())
            if(((Menu) menu).getType().equals(type))
                setCurrentMenu(((Menu) menu));
        view.show(MenuManager.getCurrentMenu().getTitle());
        view.showCurrentMenuList();
    }
}
