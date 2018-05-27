package com.gildedrose;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
}

