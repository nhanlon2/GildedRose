package com.gildedrose.iteminfo;

public class SulfurasItemInfo implements ItemWrapper {

	private ItemWrapper itemWrapper;

    SulfurasItemInfo(ItemWrapper itemW) {
		this.itemWrapper = itemW;
	}

    @Override
    public void modifyQuality() {
        return;
        
    }

    @Override
    public void decrementSellIn() {
       return;
        
    }

    @Override
    public void incrementSellIn() {
        return;
        
    }

    @Override
    public void incrementQuality() {
        return;
        
    }

    @Override
    public void decrementQuality() {
        return;
        
    }

    @Override
    public int getItemSellIn() {
        return itemWrapper.getItemSellIn();
    }

    @Override
    public int getItemQuality() {
        return itemWrapper.getItemQuality();
    }

    @Override
    public ItemWrapper getItemWrapper() {
        return itemWrapper;
    }

}
