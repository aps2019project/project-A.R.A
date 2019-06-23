package Model.Card_package.buff;

public enum BuffType {
    HOLY, POWER_AP, POWER_HP, WEAKNESS_AP, WEAKNESS_HP, POISON,//decrease time each turn for countable
    //poison should be countable in definition of spell buff
    //poison affect in change turn
    //holy used in attack time
    //power an weakness considered in attack and check time


    STUN, DISARM //decrease time each 2 turn for countable
    // stun ; when our turn finished
    // disarm : when enemy turn finished
    //stun and disarm used in attack time


}
