package com.gildedrose.itemInfo;

import com.gildedrose.Item;

public class AgedBrieItemInfo extends ItemInfo {

	AgedBrieItemInfo(Item item) {
		super(item);
	}
	
	@Override
	public void modifyQuality() {
		item.quality++;
	}

}
