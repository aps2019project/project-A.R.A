package Model.Card_package;



import Model.Card_package.buff.*;
import java.util.ArrayList;
import java.util.HashMap;

abstract public class Force extends Card {
    protected ArrayList<Buff> buffs = new ArrayList<>();
    private int ap, hp;


    protected Force(String ID, int cost, int mana, int ap, int hp) {
        super(ID, cost, mana);
        this.ap = ap;
        this.hp = hp;
    }

    protected Force(String ID, Force mainForce) {
        super(ID, mainForce);
        this.ap = mainForce.ap;
        this.hp = mainForce.hp;
    }
    public Force addBuff(Buff buff) {
        this.buffs.add(buff);
        return this;
    }

    public void removePositiveBuffs() {
        for (Buff buff : this.getBuffs())
            if (buff.isPositiveBuff())
                this.buffs.remove(buff);

    }
    public void removeNegativeBuffs() {
        for (Buff buff : this.getBuffs())
            if (!buff.isPositiveBuff())
                this.buffs.remove(buff);
    }
    public ArrayList<Buff> getBuffs() {
        return (ArrayList<Buff>) buffs.clone();
    }
    public void increaseAp(int number) {
        ap += number;
    }
    public void decreaseHp(int number) {
        hp -= number;
    }
}
