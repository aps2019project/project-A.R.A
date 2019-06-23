package Model.Card_package.usable;

public enum UsableTarget {
    OWNER_PLAYER,                // game start
    OUR_HERO,                    // game start
    RANGED_OR_HYBRID_ENEMY_HERO, //game start
    ENEMY_HERO,     //on spawn a minion
    SPAWNED_MINION, // on spawn a minion
    RANDOM_ENEMY_Force, // on attack
    DAMAGED_ENEMY,      // on attack, our hero on attack, our ranged or hybrid hero on attack
    RANDOM_OUR_FORCE, // on death of our minion
}
