package com.gildedrose;
import static com.gildedrose.iteminfo.ItemInfo.*;
public class ItemTestMother {

	public static Item ItemWithZeroSellInAndQuality(){
		return new Item("item",0,0);
	}
	
	public static Item ItemWithMinusSellInAndTwoQuality(){
		return new Item("item",-1,2);
	}
	
	public static Item ItemWithNoSpecialValues(){
		return new Item("item",2,2);
	}
	
	public static Item ConjuredItemWithNoSpecialValues(){
		return new Item("Conjured item",2,2);
	}
	
	public static Item ConjuredAgedBrie(){
	    return new Item("Conjured "+ AGED_BRIE,1,1);
    }
	
	public static Item Sulfuras(){
		return new Item(SULFURAS,1,80);
	}
	
	public static Item AgedBrie(){
		return new Item(AGED_BRIE,1,1);
	}
	
	public static Item BackStagePasses(){
		return new Item(BACKSTAGE_PASSES,11,1);
	}
	
	public static Item ConjuredBackStagePasses(){
        return new Item("Conjured "+ BACKSTAGE_PASSES,11,1);
    }
	
}
