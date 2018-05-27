package com.gildedrose;
import static com.gildedrose.ItemInfo.*;

public class ItemActions {
	
	public static void decrementSellIn(Item item){
    	if (isSulfuras(item)) {
    		return;
        } else {
        	item.sellIn--;
        }
    }
	
	public static void decrementQuality(Item item){
    	if (isSulfuras(item)) {
            item.sellIn--;
        }
    }
}
