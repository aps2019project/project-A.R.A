package Client;

public class PlayerStatus {
    private String name;
    private int initialMana;
    private int initialHp;

    public PlayerStatus(String name, int initialMana, int initialHp) {
        this.name = name;
        this.initialMana = initialMana;
        this.initialHp = initialHp;
    }

    public int getInitialMana() {
        return initialMana;
    }

    public int getInitialHp() {
        return initialHp;
    }

    public String getName() {
        return name;
    }
}
