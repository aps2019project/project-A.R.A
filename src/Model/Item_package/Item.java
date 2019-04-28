package Model.Item_package;

import Model.Unit;

abstract public class Item extends Unit {

    Item(String ID, int price, int mana){
        super(ID, price, mana);
    }

    Item(String ID, int price) {
        super(ID, price);
    }

    abstract public Item getCopy(String ID);
}
