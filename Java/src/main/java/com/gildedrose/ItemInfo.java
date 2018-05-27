package com.gildedrose;

public class ItemInfo {
	public static final String AGED_BRIE = "Aged Brie";
	public static final String BACKSTAGE_PASSES = "Backstage passes";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	
	public static boolean isBackStagePass(Item item){
    	return item.name.indexOf(BACKSTAGE_PASSES)!=-1;
    }
	
	public static boolean isSulfuras(Item item){
    	return item.name.equals(SULFURAS);
    }
	
	public static boolean isAgedBrie(Item item) {
		return item.name.equals(AGED_BRIE);
	}
}
