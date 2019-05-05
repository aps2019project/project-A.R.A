package Model.Item_package;

import Model.Unit;

abstract public class Item extends Unit {

    Item(String type, String ID, int price, int mana){
        super(type ,ID, price, mana);
    }

    Item(String ID, int price) {
        super(ID, price);
    }

}
