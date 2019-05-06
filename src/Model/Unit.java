package Model;

import Model.Match_package.Player;

import java.util.ArrayList;
import java.util.Random;

abstract public class Unit {
    private String name;
    private int price;
    private String ID;
    private int mana;
    private String desc;
    Player player;
    private static ArrayList<Integer> IDNumbers = new ArrayList<Integer>();


    protected Unit(String name, String ID, int price, int mana, String desc, Player player){
        this.price = price;
        if (ID == null)
            this.ID = generateID();
        else
            this.ID = ID;
        this.mana = mana;
        this.name = name;
        this.desc = desc;
        this.player = player;
    }


    public int getMana() {
        return this.mana;
    }

    public int getPrice() {
        return price;
    }

    public String getID() {
        return ID;
    }

    abstract protected Unit getCopy(Player player, String ID); // copy a card for copy deck

    public Unit getCopyForCopyDeck(String ID, Player player) {
        return getCopy(player, ID);
    }

    private String generateID(){
        return String.format("Card_%d", getRandomNumber());
    }

    private int getRandomNumber(){
        Random random = new Random();
        int result;
        do{
            result = random.nextInt(10000);
        }while(IDNumbers.contains(result));
        return result;
    }

    public String getName(){
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Player getPlayer() {
        return player;
    }
}

