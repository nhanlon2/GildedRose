package com.gildedrose.iteminfo;

import com.gildedrose.Item;

public interface ItemWrapper extends GildedRoseItemInfo {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static boolean isBackStagePass(Item item) {
        return item.name.indexOf(BACKSTAGE_PASSES) != -1;
    }

    public static boolean isConjured(Item item) {
        return item.name.indexOf("Conjured") != -1;
    }

    public static boolean isSulfuras(Item item) {
        return item.name.indexOf(SULFURAS) != -1;
    }

    static boolean isAgedBrie(Item item) {
        return item.name.indexOf(AGED_BRIE) != -1;
    }

    public static GildedRoseItemInfo makeItemWrapper(Item item) {
        if (isSulfuras(item)) {
            return new SulfurasItemInfo(new ItemInfo(item));
        } else if (isConjured(item) && isAgedBrie(item)) {
            return new ConjuredItemInfo(new AgedBrieItemInfo(new ItemInfo(item)));
        } else if (isAgedBrie(item)) {
            return new AgedBrieItemInfo(new ItemInfo(item));
        } else if (isConjured(item) && isBackStagePass(item)) {
            return new ConjuredItemInfo(new BackStagePassItemInfo(new ItemInfo(item)));
        } else if (isBackStagePass(item)) {
            return new BackStagePassItemInfo(new ItemInfo(item));
        } else if (isConjured(item)) {
            return new ConjuredItemInfo(new ItemInfo(item));
        } else {
            return new ItemInfo(item);
        }
    }

    public void decrementSellIn();

    public void incrementSellIn();

    public void incrementQuality();

    public void decrementQuality();

    public int getItemSellIn();

    public int getItemQuality();
    
    public ItemWrapper getItemWrapper();
}
