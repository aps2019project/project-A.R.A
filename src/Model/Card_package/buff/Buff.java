package Model.Card_package.buff;


import java.util.ArrayList;


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

    public static ArrayList<Buff> getCopy(ArrayList<Buff> buffs) {
        if (buffs == null)
            return null;
        ArrayList<Buff> copy = new ArrayList<>();
        for (Buff buff : buffs)
            copy.add(buff.getCopy());
        return copy;
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


