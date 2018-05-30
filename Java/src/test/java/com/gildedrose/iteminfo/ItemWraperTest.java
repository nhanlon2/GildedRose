package com.gildedrose.iteminfo;

import static com.gildedrose.ItemTestMother.ItemWithNoSpecialValues;
import static com.gildedrose.ItemTestMother.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gildedrose.Item;
import com.gildedrose.ItemTestMother;
import com.gildedrose.iteminfo.ItemWrapper;
import com.gildedrose.iteminfo.SulfurasItemInfo;

public class ItemWraperTest {

    private Item item;

    @Test
    public void shouldMakeSulfurasItemInfo() {
        Item item = Sulfuras();
        SulfurasItemInfo result = (SulfurasItemInfo) ItemWrapper.makeItemWrapper(item);
    }

    @Test
    public void shouldMakeAgedBrieItemInfo() {
        Item item = AgedBrie();
        AgedBrieItemInfo result = (AgedBrieItemInfo) ItemWrapper.makeItemWrapper(item);
    }

    @Test
    public void shouldMakeConjuredAgedBrieItemInfo() {
        Item item = ConjuredAgedBrie();
        ConjuredItemInfo result = (ConjuredItemInfo) ItemWrapper.makeItemWrapper(item);
        AgedBrieItemInfo inner = (AgedBrieItemInfo) result.getItemWrapper();
    }

    @Test
    public void shouldMakeBackStagePassItemInfo() {
        Item item = BackStagePasses();
        BackStagePassItemInfo result = (BackStagePassItemInfo) ItemWrapper.makeItemWrapper(item);
    }

    @Test
    public void shouldMakeConjuredBackStagePassItemInfo() {
        Item item = ConjuredBackStagePasses();
        ConjuredItemInfo result = (ConjuredItemInfo) ItemWrapper.makeItemWrapper(item);
        BackStagePassItemInfo inner = (BackStagePassItemInfo) result.getItemWrapper();
    }

    @Test
    public void shouldMakeGenericItemInfo() {
        Item item = ItemWithNoSpecialValues();
        ItemInfo result = (ItemInfo) ItemWrapper.makeItemWrapper(item);
    }

    @Test
    public void shouldMakeConjuredGenericItemInfo() {
        Item item = ConjuredItemWithNoSpecialValues();
        ConjuredItemInfo result = (ConjuredItemInfo) ItemWrapper.makeItemWrapper(item);
    }

    @Test
    public void isSulfuras() {
        item = ItemTestMother.ItemWithNoSpecialValues();
        assertFalse(ItemWrapper.isSulfuras(item));
        item.name = "Sulfuras, Hand of Ragnaros";
        assertTrue(ItemWrapper.isSulfuras(item));
    }

    @Test
    public void isAgedBrie() {
        item = ItemTestMother.ItemWithNoSpecialValues();
        assertFalse(ItemWrapper.isAgedBrie(item));
        item.name = "Aged Brie";
        assertTrue(ItemWrapper.isAgedBrie(item));
    }

    @Test
    public void isBackstagePasses() {
        item = ItemTestMother.ItemWithNoSpecialValues();
        assertFalse(ItemWrapper.isBackStagePass(item));
        item.name = "Backstage passes";
        assertTrue(ItemWrapper.isBackStagePass(item));
    }

    @Test
    public void shouldDecrementSellInWhenNotSulfuras() {
        Item item = ItemWithNoSpecialValues();
        int sell = item.sellIn;
        ((ItemWrapper) ItemWrapper.makeItemWrapper(item)).decrementSellIn();
        assertEquals(sell - 1, item.sellIn);
    }

    @Test
    public void shouldNotDecrementSellInWhenSulfuras() {
        Item item = Sulfuras();
        int sell = item.sellIn;
        ((ItemWrapper) ItemWrapper.makeItemWrapper(item)).decrementSellIn();
        assertEquals(sell, item.sellIn);
    }

    @Test
    public void shouldNotModifyQualityWhenSulfuras() {
        Item item = Sulfuras();
        int quality = item.quality;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(quality, item.quality);
    }

    @Test
    public void shouldDecreaseQualityWhenGenericItem() {
        Item item = ItemWithNoSpecialValues();
        int quality = item.quality;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(quality - 1, item.quality);
    }

    @Test
    public void shouldDecreaseQualityTwiceAsFastWhenConjuredGenericItem() {
        Item item = ConjuredItemWithNoSpecialValues();
        int quality = item.quality;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(quality - 2, item.quality);
    }

    @Test
    public void shouldDecreaseSellInWhenGenericItem() {
        Item item = ItemWithNoSpecialValues();
        int sellin = item.sellIn;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(sellin - 1, item.sellIn);
    }

    @Test
    public void shouldDecreaseSellInWhenAgedBrie() {
        Item item = AgedBrie();
        int sellin = item.sellIn;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(sellin - 1, item.sellIn);
    }

    @Test
    public void shouldDecreaseSellInWhenConjuredAgedBrie() {
        Item item = ConjuredAgedBrie();
        int sellin = item.sellIn;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(sellin - 1, item.sellIn);
    }

    @Test
    public void shouldDecreaseSellInWhenBackStagePasses() {
        Item item = BackStagePasses();
        int sellin = item.sellIn;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(sellin - 1, item.sellIn);
    }

    @Test
    public void shouldDecreaseSellInWhenConjuredBackStagePasses() {
        Item item = ConjuredBackStagePasses();
        int sellin = item.sellIn;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(sellin - 1, item.sellIn);
    }

    @Test
    public void shouldNotDecreaseSellInWhenSulfuras() {
        Item item = Sulfuras();
        int sellin = item.sellIn;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(sellin, item.sellIn);
    }

    @Test
    public void shouldNotDecreaseQualityBelowZeroWhenGenericItemSellInPositive() {
        Item item = ItemWithNoSpecialValues();
        item.quality = 0;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void shouldNotDecreaseQualityBelowZeroWhenConjuredGenericItemSellInPositive() {
        Item item = ConjuredItemWithNoSpecialValues();
        item.quality = 1;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void shouldDecreaseQualityTwiceWhenGenericItemWithSellinLtZero() {
        Item item = ItemWithNoSpecialValues();
        item.sellIn = 0;
        int quality = item.quality;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(quality - 2, item.quality);
    }

    @Test
    public void shouldDecreaseQualityTwiceAsFastWhenConjuredGenericItemWithSellinLtZero() {
        Item item = ConjuredItemWithNoSpecialValues();
        item.sellIn = 0;
        item.quality = 4;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void shouldNotDecreaseQualityBelowZeroWhenGenericItemWithSellinLtZero() {
        Item item = ItemWithNoSpecialValues();
        item.sellIn = 0;
        item.quality = 1;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void shouldNotDecreaseQualityBelowZeroWhenConjuredGenericItemWithSellinLtZero() {
        Item item = ConjuredItemWithNoSpecialValues();
        item.sellIn = 0;
        item.quality = 1;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void shouldIncreaseQualityWhenAgedBrieWithSellInGtZeroItem() {
        Item item = AgedBrie();
        int quality = item.quality;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(quality + 1, item.quality);
    }

    @Test
    public void shouldIncreaseQualityTwiceAsFastWhenConjuredAgedBrieWithSellInGtZeroItem() {
        Item item = ConjuredAgedBrie();
        int quality = item.quality;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(quality + 2, item.quality);
    }

    @Test
    public void shouldIncreaseQualityTwiceWhenAgedBrieWithSellInLtZeroItem() {
        Item item = AgedBrie();
        item.sellIn = 0;
        int quality = item.quality;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(quality + 2, item.quality);
    }

    @Test
    public void shouldIncreaseQualityTwiceAsFastWhenAgedBrieWithSellInLtZeroItem() {
        Item item = ConjuredAgedBrie();
        item.sellIn = 0;
        int quality = item.quality;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(quality + 4, item.quality);
    }

    @Test
    public void shouldNotIncreaseQualityGTFiftyAgedBrieSellinPositive() {
        Item item = AgedBrie();
        item.sellIn = 1;
        item.quality = 50;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(50, item.quality);
    }

    @Test
    public void shouldNotIncreaseQualityGTFiftyConjuredAgedBrieSellinPositive() {
        Item item = ConjuredAgedBrie();
        item.sellIn = 1;
        item.quality = 50;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(50, item.quality);
    }

    @Test
    public void shouldNotIncreaseQualityGTFiftyAgedBrieSellinNegative() {
        Item item = AgedBrie();
        item.sellIn = 0;
        item.quality = 49;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(50, item.quality);
    }

    @Test
    public void shouldNotIncreaseQualityGTFiftyConjuredAgedBrieSellinNegative() {
        Item item = ConjuredAgedBrie();
        item.sellIn = 0;
        item.quality = 47;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(50, item.quality);
    }

    @Test // sellin calculated differently than for other Items - apply quality
          // change before decrement of sellIn??
    public void shouldIncreaseQualityOfBackstagePassesByOneWhenGTTenSellIn() {
        Item item = BackStagePasses();
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(2, item.quality);
    }

    @Test
    public void shouldIncreaseQualityOfConjuredBackstagePassesByTwoWhenGTTenSellIn() {
        Item item = ConjuredBackStagePasses();
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(3, item.quality);
    }

    @Test // sellin calculated differently than for other Items - apply quality
          // change before decrement of sellIn??
    public void shouldIncreaseQualityOfBackstagePassesByTwoWhenLTElevenAndGTFiveSellIn() {
        Item item = BackStagePasses();
        item.sellIn = 10;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(3, item.quality);
        item.sellIn = 6;
        item.quality = 1;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(3, item.quality);
    }

    @Test
    public void shouldIncreaseQualityOfBackstagePassesByFourWhenLTElevenAndGTFiveSellIn() {
        Item item = ConjuredBackStagePasses();
        item.sellIn = 10;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(5, item.quality);
        item.sellIn = 6;
        item.quality = 1;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(5, item.quality);
    }

    @Test // sellin calculated differently than for other Items - apply quality
          // change before decrement of sellIn??
    public void shouldIncreaseQualityOfBackstagePassesByThreeWhenLTSixAndGTZeroSellIn() {
        Item item = BackStagePasses();
        item.sellIn = 5;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(4, item.quality);
        item.sellIn = 1;
        item.quality = 1;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(4, item.quality);
    }

    @Test
    public void shouldIncreaseQualityOfBackstagePassesBySixWhenLTSixAndGTZeroSellIn() {
        Item item = ConjuredBackStagePasses();
        item.sellIn = 5;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(7, item.quality);
        item.sellIn = 1;
        item.quality = 1;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(7, item.quality);
    }

    @Test // sellin calculated differently than for other Items - apply quality
          // change before decrement of sellIn??
    public void shouldsetQualityOfBackstagePasseToZeroWhenSellInZeroOrLess() {
        Item item = BackStagePasses();
        item.sellIn = 0;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void shouldsetQualityOfConjuredBackstagePasseToZeroWhenSellInZeroOrLess() {
        Item item = ConjuredBackStagePasses();
        item.sellIn = 0;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(0, item.quality);
    }

    @Test // sellin calculated differently than for other Items - apply quality
          // change before decrement of sellIn??
    public void shouldNotIncreaseBackStagePassesQualityGTFityWhenSellinEqualsEleven() {
        Item item = BackStagePasses();
        item.quality = 50;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(50, item.quality);
    }

    @Test
    public void shouldNotIncreaseConjuredBackStagePassesQualityGTFityWhenSellinEqualsEleven() {
        Item item = ConjuredBackStagePasses();
        item.quality = 49;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(50, item.quality);
    }

    @Test // sellin calculated differently than for other Items - apply quality
          // change before decrement of sellIn??
    public void shouldNotIncreaseBackStagePassesQualityGTFityWhenSellinEqualsTen() {
        Item item = BackStagePasses();
        item.sellIn = 10;
        item.quality = 49;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(50, item.quality);
    }

    @Test
    public void shouldNotIncreaseConjuredBackStagePassesQualityGTFityWhenSellinEqualsTen() {
        Item item = ConjuredBackStagePasses();
        item.sellIn = 10;
        item.quality = 47;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(50, item.quality);
    }

    @Test // sellin calculated differently than for other Items - apply quality
          // change before decrement of sellIn??
    public void shouldNotIncreaseBackStagePassesQualityGTFityWhenSellinEqualsFive() {
        Item item = BackStagePasses();
        item.sellIn = 5;
        item.quality = 48;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(50, item.quality);
    }

    @Test
    public void shouldNotIncreaseConjuredBackStagePassesQualityGTFityWhenSellinEqualsFive() {
        Item item = ConjuredBackStagePasses();
        item.sellIn = 5;
        item.quality = 45;
        ItemWrapper.makeItemWrapper(item).modifyQuality();
        assertEquals(50, item.quality);
    }
}
