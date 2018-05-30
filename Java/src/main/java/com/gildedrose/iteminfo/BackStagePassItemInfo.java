package com.gildedrose.iteminfo;

public class BackStagePassItemInfo implements ItemWrapper {

	private ItemWrapper itemWrapper;

    protected BackStagePassItemInfo(ItemWrapper itemW) {
		this.itemWrapper=itemW;
	}

	@Override
	public void modifyQuality() {
		if (itemWrapper.getItemSellIn() == 0) {
			while(getItemQuality()>0) {
			    decrementQuality();
			}
		} else {
			incrementQuality();
			if (itemWrapper.getItemSellIn() < 11) {
				incrementQuality();
			}
			if (itemWrapper.getItemSellIn()< 6) {
				incrementQuality();
			}
		}
		decrementSellIn();
	}

    @Override
    public void decrementSellIn() {
        itemWrapper.decrementSellIn();
        
    }

    @Override
    public void incrementSellIn() {
        itemWrapper.incrementSellIn();
        
    }

    @Override
    public void incrementQuality() {
        itemWrapper.incrementQuality();
        
    }

    @Override
    public void decrementQuality() {
       itemWrapper.decrementQuality();
        
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
