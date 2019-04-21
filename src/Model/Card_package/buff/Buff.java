package Model.Card_package.buff;


import Model.Card_package.Force;

public class Buff {
    private BuffType buffType;
    private int time;
    private BuffTime buffTime;
    private Force force;
    public Buff(Force force, BuffType buffType, BuffTime buffTime) {
        this.buffType = buffType;
        this.buffTime = buffTime;
        this.force = force;
    }
    public Buff(Force force, BuffType buffType, int time) {
        this.buffType = buffType;
        this.time = time;
        this.force = force;
    }
    public boolean isPositiveBuff() {
        switch (buffType){
            case HOLY:
            case POWER_AP:
            case POWER_HP:
                return true;
        }
        return false;
    }
}