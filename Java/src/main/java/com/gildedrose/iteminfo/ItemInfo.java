package com.gildedrose.iteminfo;

import com.gildedrose.Item;

public class ItemInfo implements ItemWrapper {
	
	protected Item item;

	protected ItemInfo(Item item) {
		this.item=item;
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

	public void decrementQuality() {
		if (item.quality == 0) {
			return;
		} else {
			item.quality--;
		}
	}

	public void incrementQuality() {
		if (item.quality == 50) {
			return;
		} else {
			item.quality++;
		}
	}

    @Override
    public int getItemSellIn() {
        return item.sellIn;
    }

    @Override
    public void incrementSellIn() {
        item.sellIn++;
        
    }

    @Override
    public int getItemQuality() {
        return item.quality;
    }

    @Override
    public ItemWrapper getItemWrapper() {
        return null;
    }
}
