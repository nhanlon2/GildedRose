package com.gildedrose.itemInfo;

import com.gildedrose.Item;

public class SulfurasItemInfo extends ItemInfo {

	 SulfurasItemInfo(Item item) {
		super(item);
	}
	 
	 @Override
	public void decrementSellIn() {
		 return;
	}
	 @Override
	public void modifyQuality() {
		return;
	}
}
