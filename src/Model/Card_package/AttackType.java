package Model.Card_package;

public enum AttackType {
    MELEE("melee"), RANGED("ranged"), HYBRID("hybrid");

    private String string;

    AttackType(String string) {
        this.string = string;
    }

    public String toString() {
        return string;
    }
}

