package Model.Card_package.minion_special_power;

public enum MinionSpecialPowerTarget {
    DAMAGED_ENEMY                      // on attack,         ,        ,         ,
    , DAMAGED_MINION                   // on attack,         ,        ,         ,
    , HIMSELF                          // on attack, on spawn,        ,         , on defend
    , MINIONS_IN_NEIGHBOR              //          ,         ,        , on death,
    , UNTIL_2_DISTANCE_MINIONS         //          , on spawn,        ,         ,
    , MINION_AND_OUR_MINION_IN_NEIGHBOR//          ,         , on turn,         ,
    , RANDOM_ENEMY_MINION              //          , on spawn,        ,         ,
    , RANDOM_ENEMY_FORCE_IN_NEIGHBOR   //          ,         ,        , on death,
    , ALL_OUR_MINION                   //          ,         , on turn,         ,
    , ENEMY_MINIONS_IN_NEIGHBOR        //          , on spawn,        ,         ,
    , ENEMY_HERO                       //          ,         ,        , on death,

}
