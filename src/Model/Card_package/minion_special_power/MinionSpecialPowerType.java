package Model.Card_package.minion_special_power;

public enum MinionSpecialPowerType {
    BUFFS, EFFECTS,   // this type have arrayList
    BECOME_STRONGER_BY_HIT, COMBO, //these types have class and mean in attack
    IGNORE_ENEMY_HOLY_BUFF, REMOVE_POSITIVE_EFFECTS,
    UN_DISARM, UN_POISON, ANTI_BAD_EFFECT, DO_NOT_RECEIVE_ATTACK_BY_WEAKER_FORCE
    //these types would handle by type in and mean in attack
,}
