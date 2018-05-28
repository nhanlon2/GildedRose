package com.gildedrose.itemInfo;

import com.gildedrose.Item;

public class AgedBrieItemInfo extends ItemInfo {

	AgedBrieItemInfo(Item item) {
		super(item);
	}
	
	@Override
	public void modifyQuality() {
		incrementQuality();
		decrementSellIn();
		if(item.sellIn<0){
			incrementQuality();
		}
	}

}
