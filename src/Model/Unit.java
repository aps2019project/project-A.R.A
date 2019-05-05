package Model;

import Model.Match_package.Player;

import java.util.ArrayList;
import java.util.Random;

abstract public class Unit {
    private String name;
    private int price;
    private String ID;
    private int mana;
    private static ArrayList<Integer> IDNumbers = new ArrayList<Integer>();

    public Unit(){}

    protected Unit(String name, String ID, int price, int mana){
        this.price = price;
        this.ID = ID;
        this.mana = mana;
        this.name = name;
    }

    protected Unit(String ID, int mana){
        this.ID = ID;
        this.mana = mana;
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

    abstract public Unit getCopy(String ID);//for deck

    abstract public Unit getCopy(Player player, String ID); // for shop

    public Unit getCopy(){
        String newID = generateID();
        return getCopy(newID);
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
}

