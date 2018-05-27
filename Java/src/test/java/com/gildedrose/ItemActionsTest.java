package com.gildedrose;

import static com.gildedrose.ItemTestMother.ItemWithNoSpecialValues;
import static com.gildedrose.ItemTestMother.Sulfuras;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemActionsTest {
	@Test
	public void shouldDecrementSellInWhenNotSulfuras(){
		Item item = ItemWithNoSpecialValues();
		int sell = item.sellIn;
		ItemActions.decrementSellIn(item);
		assertEquals(sell-1,item.sellIn);
	}
	
	@Test
	public void shouldNotDecrementSellInWhenSulfuras(){
		Item item = Sulfuras();
		int sell = item.sellIn;
		ItemActions.decrementSellIn(item);
		assertEquals(sell,item.sellIn);
	}
}
