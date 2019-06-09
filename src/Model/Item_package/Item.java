package Model.Item_package;

import Model.Match_package.Player;
import Model.Unit;

abstract public class Item extends Unit {

    protected Item(String name, int price, String desc, Player player) {
        super(name, price, 0, desc, player);
    }


    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Item :  ");
        stringBuilder.append("Name : " + this.getName() + " ");
        stringBuilder.append("Description : " + this.getDesc());
        return stringBuilder.toString();
    }
}
