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
	public void isSulfuras() {
		item = ItemTestMother.ItemWithNoSpecialValues();
		assertFalse(ItemInfo.isSulfuras(item));
		item.name = "Sulfuras, Hand of Ragnaros";
		assertTrue(ItemInfo.isSulfuras(item));
	}

	@Test
	public void isAgedBrie() {
		item = ItemTestMother.ItemWithNoSpecialValues();
		assertFalse(ItemInfo.isAgedBrie(item));
		item.name = "Aged Brie";
		assertTrue(ItemInfo.isAgedBrie(item));
	}

	@Test
	public void isBackstagePasses() {
		item = ItemTestMother.ItemWithNoSpecialValues();
		assertFalse(ItemInfo.isBackStagePass(item));
		item.name = "Backstage passes";
		assertTrue(ItemInfo.isBackStagePass(item));
	}

	@Test
	public void shouldDecrementSellInWhenNotSulfuras() {
		Item item = ItemWithNoSpecialValues();
		int sell = item.sellIn;
		ItemInfo.makeItemInfo(item).decrementSellIn();
		assertEquals(sell - 1, item.sellIn);
	}

	@Test
	public void shouldNotDecrementSellInWhenSulfuras() {
		Item item = Sulfuras();
		int sell = item.sellIn;
		ItemInfo.makeItemInfo(item).decrementSellIn();
		assertEquals(sell, item.sellIn);
	}

	@Test
	public void shouldNotModifyQualityWhenSulfuras() {
		Item item = Sulfuras();
		int quality = item.quality;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(quality, item.quality);
	}

	@Test
	public void shouldDecreaseQualityWhenGenericItem() {
		Item item = ItemWithNoSpecialValues();
		int quality = item.quality;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(quality - 1, item.quality);
	}
	
	@Test
	public void shouldDecreaseQualityTwiceAsFastWhenGenericConjuredItem() {
		Item item = ConjuredItemWithNoSpecialValues();
		item.quality = 10;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(8, item.quality);
	}

	@Test
	public void shouldDecreaseSellInWhenGenericItem() {
		Item item = ItemWithNoSpecialValues();
		int sellin = item.sellIn;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(sellin - 1, item.sellIn);
	}

	@Test
	public void shouldDecreaseSellInWhenAgedBrie() {
		Item item = AgedBrie();
		int sellin = item.sellIn;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(sellin - 1, item.sellIn);
	}

	@Test
	public void shouldDecreaseSellInWhenBackStagePasses() {
		Item item = BackStagePasses();
		int sellin = item.sellIn;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(sellin - 1, item.sellIn);
	}

	@Test
	public void shouldDecreaseSellInWhenSulfuras() {
		Item item = Sulfuras();
		int sellin = item.sellIn;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(sellin, item.sellIn);
	}

	@Test
	public void shouldNotDecreaseQualityBelowZeroWhenGenericItemSellInPositive() {
		Item item = ItemWithNoSpecialValues();
		item.quality = 0;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(0, item.quality);
	}

	@Test
	public void shouldDecreaseQualityTwiceWhenGenericItemWithSellinLtZero() {
		Item item = ItemWithNoSpecialValues();
		item.sellIn = 0;
		int quality = item.quality;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(quality - 2, item.quality);
	}

	@Test
	public void shouldNotDecreaseQualityBelowZeroWhenGenericItemWithSellinLtZero() {
		Item item = ItemWithNoSpecialValues();
		item.sellIn = 0;
		item.quality = 1;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(0, item.quality);
	}

	@Test
	public void shouldIncreaseQualityWhenAgedBrieWithSellInGtZeroItem() {
		Item item = AgedBrie();
		int quality = item.quality;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(quality + 1, item.quality);
	}

	@Test
	public void shouldIncreaseQualityTwiceWhenAgedBrieWithSellInLtZeroItem() {
		Item item = AgedBrie();
		item.sellIn = 0;
		int quality = item.quality;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(quality + 2, item.quality);
	}

	@Test
	public void shouldNotIncreaseQualityGTFiftyAgedBrieSellinPositive() {
		Item item = AgedBrie();
		item.sellIn = 1;
		item.quality = 50;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(50, item.quality);
	}

	@Test
	public void shouldNotIncreaseQualityGTFiftyAgedBrieSellinNegative() {
		Item item = AgedBrie();
		item.sellIn = 0;
		item.quality = 49;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(50, item.quality);
	}

	@Test // sellin calculated differently than for other Items - apply quality
			// change before decrement of sellIn??
	public void shouldIncreaseQualityOfBackstagePassesByOneWhenGTTenSellIn() {
		Item item = BackStagePasses();
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(2, item.quality);
	}

	@Test // sellin calculated differently than for other Items - apply quality
			// change before decrement of sellIn??
	public void shouldIncreaseQualityOfBackstagePassesByTwoWhenLTElevenAndGTFiveSellIn() {
		Item item = BackStagePasses();
		item.sellIn = 10;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(3, item.quality);
		item.sellIn = 6;
		item.quality = 1;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(3, item.quality);
	}

	@Test // sellin calculated differently than for other Items - apply quality
			// change before decrement of sellIn??
	public void shouldIncreaseQualityOfBackstagePassesByThreeWhenLTSixAndGTZeroSellIn() {
		Item item = BackStagePasses();
		item.sellIn = 5;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(4, item.quality);
		item.sellIn = 1;
		item.quality = 1;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(4, item.quality);
	}

	@Test // sellin calculated differently than for other Items - apply quality
			// change before decrement of sellIn??
	public void shouldsetQualityOfBackstagePasseToZeroWhenSellInZeroOrLess() {
		Item item = BackStagePasses();
		item.sellIn = 0;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(0, item.quality);
	}

	@Test // sellin calculated differently than for other Items - apply quality
			// change before decrement of sellIn??
	public void shouldNotIncreaseBackStagePassesQualityGTFityWhenSellinEqualsEleven() {
		Item item = BackStagePasses();
		item.quality = 50;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(50, item.quality);
	}

	@Test // sellin calculated differently than for other Items - apply quality
			// change before decrement of sellIn??
	public void shouldNotIncreaseBackStagePassesQualityGTFityWhenSellinEqualsTen() {
		Item item = BackStagePasses();
		item.sellIn = 10;
		item.quality = 49;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(50, item.quality);
	}

	@Test // sellin calculated differently than for other Items - apply quality
			// change before decrement of sellIn??
	public void shouldNotIncreaseBackStagePassesQualityGTFityWhenSellinEqualsFive() {
		Item item = BackStagePasses();
		item.sellIn = 5;
		item.quality = 48;
		ItemInfo.makeItemInfo(item).modifyQuality();
		assertEquals(50, item.quality);
	}
}
