package Model.Item_package.item_effect;

import java.util.ArrayList;

public class ItemEffect {
    ItemEffectType itemEffectType;
    ItemEffectTimeType itemEffectTimeType;
    int time;
    int unit;

    public ItemEffect(ItemEffectType itemEffectType, ItemEffectTimeType itemEffectTimeType, int time, int unit) {
        this.itemEffectType = itemEffectType;
        this.itemEffectTimeType = itemEffectTimeType;
        this.time = time;
        this.unit = unit;
    }

    public static ArrayList<ItemEffect> getCopy(ArrayList<ItemEffect> itemEffects) {
        ArrayList<ItemEffect> copy = new ArrayList<>();
        for (ItemEffect itemEffect : itemEffects)
            copy.add(itemEffect.getCopy());
        return copy;
    }

    public ItemEffect getCopy() {
        return new ItemEffect(itemEffectType, itemEffectTimeType, time, unit);
    }

    public ItemEffectType getItemEffectType() {
        return itemEffectType;
    }

    public int getUnit() {
        return unit;
    }
}
