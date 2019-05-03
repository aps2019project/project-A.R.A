package Menus;

import java.util.ArrayList;
import java.util.Arrays;

public enum Menus {
    MAIN(new ArrayList<>(Arrays.asList("Battle", "shop", "Collection", "Exit", "Help")))
    , ACCOUNT(new ArrayList<>(Arrays.asList("Login","Create Account", "Exit", "Help")))
    , BATTLE_TYPE_CHOOSE(new ArrayList<>(Arrays.asList("Kill Hero", "Collect Flag", "Hold Flag", "Help")))
    , GAME_MODE_CHOOSE(new ArrayList<>(Arrays.asList("Single Player", "Multi Player", "Help")))
    , COLLECTION(new ArrayList<>())
    , SHOP(new ArrayList<>())
    , SINGLE_PLAYER(new ArrayList<>(Arrays.asList("Story", "Custom Game")))
    , STORY(new ArrayList<>())
    , CUSTOM_GAME(new ArrayList<>())
    , GRAVE_YARD(new ArrayList<>())
    , GAME_END(new ArrayList<>())
    , BATTLE(new ArrayList<>());

    private ArrayList<String> subItems = new ArrayList<>();

    Menus(ArrayList<String> subItems) {
        this.subItems = subItems;
    }

    public ArrayList getSubItmes(){
        return subItems;
    }
}
