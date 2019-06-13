package Model.Card_package.hero_special_power;

public enum HeroSpecialPowerTarget {
    HIMSELF,                   // on use,          , passive on start
    ALL_ENEMY_FORCE,           // on use,          ,
    ENEMY_FORCE,               // on use,          ,
    DAMAGED_FORCE,             //       , on attack,
    ALL_ENEMY_FORCE_IN_ITS_ROW,// on use,          ,
    CELL,                      // on use,          ,
}
