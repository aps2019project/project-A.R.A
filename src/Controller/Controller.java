package Controller;

import Account_package.Accounts;
import Client.PlayerStatus;
import Exceptions.*;
import Model.Match_package.Deck;
import Model.Shop;
import sample.UnitPhaseTwoTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    private static Controller instance = new Controller();

    public PlayerStatus getOpponentStatus(){
        return new PlayerStatus("Seyyed", 2,25);
    }

    // todo just for test - not implemented exactly
    public PlayerStatus getOwnPlayerStatus(){
        return new PlayerStatus("Reza", 2, 25);
    }

    // todo not implemented
    public ArrayList<UnitPhaseTwoTest> getHandCards() {
        UnitPhaseTwoTest unit = new UnitPhaseTwoTest("DiveSiah", 5, "hp : 25 and ap : 2");
        UnitPhaseTwoTest unit2 = new UnitPhaseTwoTest("dive sefid", 3, "Some desciption for card useful in battle");
        UnitPhaseTwoTest unit3 = new UnitPhaseTwoTest("Simorgh", 2, "for sure is a general");
        ArrayList<UnitPhaseTwoTest> units = new ArrayList<>(Arrays.asList(unit, unit2, unit3, unit2, unit, unit3));
        return units;
    }

    public void setMainDeck(String deckName) {
        Accounts.getCurrentAccount().getCollection().setMainDeck(deckName);
    }

    public boolean addUnit(String deckName, String unitName) {
        try {
            Accounts.getCurrentAccount().getCollection().addToDeck(deckName, unitName);
            return true;
        } catch (DuplicateUnitException | FullDeckException e) {
            return false;
        }
    }

    public void removeUnit(String deckName, String unitName) {
        Accounts.getCurrentAccount().getCollection().getDeck(deckName).deleteUnit(unitName);
    }

    public boolean createDeck(String deckName) {
        try {
            Accounts.getCurrentAccount().getCollection().addToDecks(deckName);
            return true;
        } catch (DuplicateDeckNameException e) {
            return false;
        }
    }

    public boolean sell(String unitName) {
        try {
            Shop.getInstance().sell(Accounts.getCurrentAccount(), unitName);
        } catch (UnitNotFoundException e) {
            return false;
        }
        return true;
    }

    public boolean buy(String unitName) {
        try {
            Shop.getInstance().buy(Accounts.getCurrentAccount(), unitName);
        } catch (NotEnoughDrakeException e) {
            return false;
        }
        return true; // todo ought to change on net programming.
    }

    public void login(String username, String password) throws NotAValidAccountException {
        if (!Accounts.getInstance().login(username, password))
            throw new NotAValidAccountException();
    }

    public void register(String username, String password) {
        if (!Accounts.getInstance().createNewAccount(username, password))
            throw new NotAValidAccountException();
    }

    public boolean hasUnit(String name) {
        return Accounts.getCurrentAccount().getCollection().hasUnit(name);
    }

    public ArrayList<Deck> getDecks() {
        return Accounts.getCurrentAccount().getCollection().getDecks();
    }

    public String getMainDeckName() {
        Deck mainDeck = Accounts.getCurrentAccount().getCollection().getMainDeck();
        if (mainDeck != null) return mainDeck.getDeckName();
        else return "";
    }

    public int getUserDrakes() {
        return Accounts.getCurrentAccount().getDrake();
    }

    public static Controller getInstance() {
        return instance;
    }
}
