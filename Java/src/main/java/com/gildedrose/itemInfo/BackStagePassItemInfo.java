package com.gildedrose.itemInfo;

import com.gildedrose.Item;

public class BackStagePassItemInfo extends ItemInfo {

	protected BackStagePassItemInfo(Item item) {
		super(item);
	}

	@Override
	public void modifyQuality() {
		if (item.sellIn == 0) {
			item.quality = 0;
		} else {
			incrementQuality();
			if (item.sellIn < 11) {
				incrementQuality();
			}
			if (item.sellIn < 6) {
				incrementQuality();
			}
		}
		decrementSellIn();
	}

}
