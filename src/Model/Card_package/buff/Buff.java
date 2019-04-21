package Model.Card_package.buff;



public class Buff {
    BuffType buffType;
    int time;
    BuffTime buffTime;
    public Buff(BuffType buffType, BuffTime buffTime) {
        this.buffType = buffType;
        this.buffTime = buffTime;
    }
    public Buff(BuffType buffType, int time) {
        this.buffType = buffType;
        this.time = time;
    }
}