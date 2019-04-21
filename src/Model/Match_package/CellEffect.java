package Model.Match_package;

public class CellEffect {
    private CellEffectType cellEffectType;
    int time;
    public CellEffect(CellEffectType cellEffectType, int time) {
        this.cellEffectType = cellEffectType;
        this.time = time;
    }

    public CellEffectType getCellEffectType() {
        return cellEffectType;
    }
}
