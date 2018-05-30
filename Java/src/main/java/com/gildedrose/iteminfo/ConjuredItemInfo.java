package com.gildedrose.iteminfo;

public class ConjuredItemInfo implements ItemWrapper {
    
    private ItemWrapper itemWrapper;

    public ConjuredItemInfo(ItemWrapper itemW) {
        this.itemWrapper = itemW;
    }

    @Override
    public void decrementSellIn() {
        itemWrapper.decrementSellIn();

    }

    @Override
    public void modifyQuality() {
       itemWrapper.modifyQuality();
       incrementSellIn();
       itemWrapper.modifyQuality();
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
