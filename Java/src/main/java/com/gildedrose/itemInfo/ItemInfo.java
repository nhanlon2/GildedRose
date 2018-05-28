package com.gildedrose.itemInfo;

import com.gildedrose.Item;

public class ItemInfo {
	public static final String AGED_BRIE = "Aged Brie";
	public static final String BACKSTAGE_PASSES = "Backstage passes";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

	public static boolean isBackStagePass(Item item) {
		return item.name.indexOf(BACKSTAGE_PASSES) != -1;
	}

	public static boolean isSulfuras(Item item) {
		return item.name.equals(SULFURAS);
	}

	public static boolean isAgedBrie(Item item) {
		return item.name.equals(AGED_BRIE);
	}

	public static ItemInfo makeItemInfo(Item item) {
		if (isSulfuras(item)) {
			return new SulfurasItemInfo(item);
		} else if (isAgedBrie(item)) {
			return new AgedBrieItemInfo(item);
		} else if(isBackStagePass(item)){
			return new BackStagePassItemInfo(item);
		}
		else {
			return new ItemInfo(item);
		}
	}

	protected Item item;

	protected ItemInfo(Item item) {
		this.item = item;
	}

	public void decrementSellIn() {
		item.sellIn--;
	}

	public void modifyQuality() {
		decrementQuality();
		decrementSellIn();
		if (item.sellIn < 0) {
			decrementQuality();
		}
	}

	protected void decrementQuality() {
		if (item.quality == 0) {
			return;
		} else {
			item.quality--;
		}
	}

	protected void incrementQuality() {
		if (item.quality == 50) {
			return;
		} else {
			item.quality++;
		}
	}
}
