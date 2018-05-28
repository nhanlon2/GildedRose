package com.gildedrose;

import com.gildedrose.itemInfo.ItemInfo;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	ItemInfo.makeItemInfo(items[i]).modifyQuality();
        }
    }
}