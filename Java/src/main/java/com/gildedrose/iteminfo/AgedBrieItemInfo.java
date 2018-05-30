package com.gildedrose.iteminfo;
//TODO - alternatively, have all the concrete classes extend ItemInfo - then make the ItemWrapper interface smaller
public class AgedBrieItemInfo implements ItemWrapper {

	private ItemWrapper itemWrapper;

    AgedBrieItemInfo(ItemWrapper itemW) {
		this.itemWrapper = itemW;
	}

	@Override
	public void modifyQuality() {
		incrementQuality();
		decrementSellIn();
		if (itemWrapper.getItemSellIn() < 0) {
			incrementQuality();
		}
	}

    @Override
    public void decrementSellIn() {
        itemWrapper.decrementSellIn();
    }

    @Override
    public void incrementQuality() {
        itemWrapper.incrementQuality();
    }

    @Override
    public int getItemSellIn() {
        return itemWrapper.getItemSellIn();
    }

    @Override
    public void incrementSellIn() {
        itemWrapper.incrementSellIn();
        
    }

    @Override
    public void decrementQuality() {
        itemWrapper.decrementQuality();
        
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
