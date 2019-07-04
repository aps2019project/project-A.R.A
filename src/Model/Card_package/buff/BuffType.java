package Model.Card_package.buff;

public enum BuffType {
    HOLY, POWER_AP, POWER_HP, WEAKNESS_AP, WEAKNESS_HP, POISON,
    //poison should be countable in definition of spell buff
    //poison affect in change turn
    //holy used in attack time
    //power an weakness considered in attack and check time
    STUN, DISARM
    //stun and disarm used in attack time

}
