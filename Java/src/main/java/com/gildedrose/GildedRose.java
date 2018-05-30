package com.gildedrose;

import com.gildedrose.iteminfo.ItemWrapper;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	ItemWrapper.makeItemWrapper(items[i]).modifyQuality();
        }
    }
}