package Menus;

import java.util.ArrayList;
import java.util.Arrays;

public enum Menus {
    MAIN(new ArrayList<>(Arrays.asList("Battle", "shop", "Collection", "Exit", "ShowMenu")), new ArrayList<>(Arrays.asList("Battle", "shop", "Collection", "Exit")))
    , ACCOUNT(new ArrayList<>(), new ArrayList<>(Arrays.asList("Login","Create Account", "Exit")))
    , GAME_MODE_CHOOSE(new ArrayList<>(Arrays.asList("Multi player" , "Single Player"))
            , new ArrayList<>(Arrays.asList("single Player", "multi player")))
    , COLLECTION(new ArrayList<>()
            , new ArrayList<>(Arrays.asList("Create deck", " delete deck", "add (id) to deck (name), validate deck (name)",
            "remove (id) from deck (name)", "save", "search (name)", "select deck (name)", "show all decks", "show deck (name)", "show","Exit","help")))
    , SHOP(new ArrayList<>(), new ArrayList<>(Arrays.asList("buy (name)", "sell (id)", "search collection (name)","search (name)"
            , "show", "show collection", "Exit" )))
    , SINGLE_PLAYER(new ArrayList<>(Arrays.asList("Story", "Custom Game")), new ArrayList<>(Arrays.asList("custom", "story")))
    , STORY(new ArrayList<>(Arrays.asList("start", "start level 2", "start level 3")), new ArrayList<>(Arrays.asList("start", "start level 2", "start level 3")))
    , CUSTOM_GAME(new ArrayList<>(Arrays.asList("start game")), new ArrayList<>(Arrays.asList("start game")))
    , GRAVE_YARD(new ArrayList<>(), new ArrayList<>(Arrays.asList("show all cards", "show info (cardID)")))
    , GAME_END(new ArrayList<>(), new ArrayList<>(Arrays.asList("endGame")))
    , BATTLE(new ArrayList<>(), new ArrayList<>(Arrays.asList("attack", "combo attack", "end turn", "enter graveyard"
            , "game info", "insert", "move", "select", "select collectable", "show info (id)", "show info", "show collectables"
            , "show hand", "show my minions", "show opponent minions", "show next card", "use special power", "use [location]", "Leave")))
    , MULTI_PLAYER(new ArrayList<>(), new ArrayList<>(Arrays.asList("select (username)", "start multiPlayer game")));

    private ArrayList<String> subItems;
    private ArrayList<String> commands;

    Menus(ArrayList<String> subItems, ArrayList<String> commands) {
        this.subItems = subItems;
        this.commands = commands;
    }

    public ArrayList getSubItems(){
        return subItems;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }
}
