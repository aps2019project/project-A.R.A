package Model.Card_package.buff;

public enum BuffType {
    HOLY, POWER_AP, POWER_HP, POISON, WEAKNESS_AP, WEAKNESS_HP,//increase time each turn for countable
    STUN, DISARM //increase time each 2 turn for countable
                     // stun ; when our turn finished
                     // disarm : when enemy turn finished
}
