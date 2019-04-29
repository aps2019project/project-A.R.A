package Model.Card_package.buff;


import Model.Card_package.Force;
import Model.Match_package.Player;


public class Buff {
    private BuffType buffType;
    private BuffTimeType buffTimeType;
    private int time;
    private int unit;

    public Buff(BuffType buffType, BuffTimeType buffTimeType, int time, int unit) {
        this.buffType = buffType;
        this.buffTimeType = buffTimeType;
        this.time = time;
        this.unit = unit;
    }



    public boolean isPositiveBuff() {
        switch (this.buffType) {
            case HOLY:
            case POWER_AP:
            case POWER_HP:
                return true;
        }
        return false;
    }

    public Buff getCopy() {
        return new Buff(this.buffType, this.buffTimeType, this.time, this.unit);
    }



}


