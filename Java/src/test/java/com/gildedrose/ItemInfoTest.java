package com.gildedrose;

import static com.gildedrose.ItemTestMother.ItemWithNoSpecialValues;
import static com.gildedrose.ItemTestMother.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gildedrose.itemInfo.ItemInfo;

public class ItemInfoTest {
	
	private Item item;
	

	@Test
	public void isSulfuras(){
		item = ItemTestMother.ItemWithNoSpecialValues();
		assertFalse(ItemInfo.isSulfuras(item));
		item.name = "Sulfuras, Hand of Ragnaros";
		assertTrue(ItemInfo.isSulfuras(item));
	}
	
	@Test
	public void isAgedBrie(){
		item = ItemTestMother.ItemWithNoSpecialValues();
		assertFalse(ItemInfo.isAgedBrie(item));
		item.name = "Aged Brie";
		assertTrue(ItemInfo.isAgedBrie(item));
	}
	
	@Test
	public void isBackstagePasses(){
		item = ItemTestMother.ItemWithNoSpecialValues();
		assertFalse(ItemInfo.isBackStagePass(item));
		item.name = "Backstage passes";
		assertTrue(ItemInfo.isBackStagePass(item));
	}
	
	@Test
	public void shouldDecrementSellInWhenNotSulfuras(){
		Item item = ItemWithNoSpecialValues();
		int sell = item.sellIn;
		ItemInfo.makeItemInfo(item).decrementSellIn();
		assertEquals(sell-1,item.sellIn);
	}
	
	@Test
	public void shouldNotDecrementSellInWhenSulfuras(){
		Item item = Sulfuras();
		int sell = item.sellIn;
		ItemInfo.makeItemInfo(item).decrementSellIn();
		assertEquals(sell,item.sellIn);
	}
	
	@Test
	public void shouldNotModifyQualityWhenSulfuras(){
		Item item = Sulfuras();
		int quality = item.quality;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(quality,item.quality);
	}
	
	@Test
	public void shouldDecreaseyQualityWhenGenericItem(){
		Item item = ItemWithNoSpecialValues();
		int quality = item.quality;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(quality-1,item.quality);
	}
	
	@Test
	public void shouldIncreaseQualityWhenAgedBrieWithSellInGtZeroItem(){
		Item item = AgedBrie();
		int quality = item.quality;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(quality+1,item.quality);
	}
}

