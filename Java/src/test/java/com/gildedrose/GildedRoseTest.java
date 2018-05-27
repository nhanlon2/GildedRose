package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {
	
	private Item[] items;
	private GildedRose app;

	@Before
	public void setUp(){
		items = new Item[] { new Item("foo", 1, 1) };
		app = new GildedRose(items);
		
	}

    @Test
    public void shouldAddNewItemToItems() {
        assertEquals("foo", app.items[0].name);
    }
    
    @Test
    public void shouldNotChangeQualityOfSulfurasWhenSellInGTZero() {
    	Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 1, 80);
    	app.items[0] = sulfuras;
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }
    
    @Test
    public void shouldNotChangeQualityOfSulfurasWhenSellInLTZero() {
    	Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", -2, 80);
    	app.items[0] = sulfuras;
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }
    
    @Test
    public void shouldNotDecreaseSellInOfSulfuras(){
    	Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 1, 80);
    	app.items[0] = sulfuras;
    	app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
    }
    
    @Test
    public void shouldDecreaseSellInOfItemIfNotSulfuras(){
    	app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }
    
    @Test
    public void shouldDecreaseQualityOfItem(){
    	app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    public void shouldNotDecreaseQualityOfItemBelowZero(){
    	app.updateQuality();
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    public void shouldDecreaseQualityOfItemTwiceAsFastOnceSellInBelowZero(){
    	items[0].quality = 10;
    	items[0].sellIn = 0; 
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    public void shouldIncreaseQualityOfAgedBrieWhenGTZeroSellIn(){
    	items[0].name = "Aged Brie";
    	app.updateQuality();
    	assertEquals(2, app.items[0].quality);
    }
    @Test
    public void shouldIncreaseQualityOfAgedBrieTwiceAsFastWhenLTZeroSellIn(){
    	items[0].name = "Aged Brie";
    	items[0].sellIn = 0; 
    	app.updateQuality();
    	assertEquals(3, app.items[0].quality);
    }
    
    @Test
    public void shouldNotIncreaseQualityOfAgedBrieAbove50WhenLTZeroSellIn(){
    	items[0].name = "Aged Brie";
    	items[0].sellIn = 0; 
    	items[0].quality = 49; 
    	app.updateQuality();
    	assertEquals(50, app.items[0].quality);
    }
    
    @Test
    public void shouldNotIncreaseQualityOfAgedBrieAbove50WhenGTZeroSellIn(){
    	items[0].name = "Aged Brie";
    	items[0].sellIn = 1; 
    	items[0].quality = 50; 
    	app.updateQuality();
    	assertEquals(50, app.items[0].quality);
    }
    
    @Test//sellin calculated differently than for other Items - apply quality change before decrement of sellIn??
    public void shouldIncreaseQualityOfBackstagePassesByOneWhenGTTenSellIn(){
    	items[0].name = "Backstage passes to a TAFKAL80ETC concert";
    	items[0].sellIn = 11; 
    	items[0].quality = 1; 
    	app.updateQuality();
    	assertEquals(2, app.items[0].quality);
    }
    @Test//sellin calculated differently than for other Items - apply quality change before decrement of sellIn??
    public void shouldIncreaseQualityOfBackstagePassesByTwoWhenLTElevenAndGTFiveSellIn(){
    	items[0].name = "Backstage passes to a TAFKAL80ETC concert";
    	items[0].sellIn = 10; 
    	items[0].quality = 1; 
    	app.updateQuality();
    	assertEquals(3, app.items[0].quality);
    	items[0].sellIn = 6; 
    	items[0].quality = 1; 
    	app.updateQuality();
    	assertEquals(3, app.items[0].quality);
    }
    
    @Test//sellin calculated differently than for other Items - apply quality change before decrement of sellIn??
    public void shouldIncreaseQualityOfBackstagePassesByThreeWhenLTSixAndGTZeroSellIn(){
    	items[0].name = "Backstage passes to a TAFKAL80ETC concert";
    	items[0].sellIn = 5; 
    	items[0].quality = 1; 
    	app.updateQuality();
    	assertEquals(4, app.items[0].quality);
    	//but test for sellin == 0 happens after decrement 
    	items[0].sellIn = 1; 
    	items[0].quality = 1; 
    	app.updateQuality();
    	assertEquals(4, app.items[0].quality);
    }
    
    @Test//sellin calculated differently than for other Items - apply quality change before decrement of sellIn??
    public void shouldsetQualityOfBackstagePasseToZeroOrLessSellIn(){
    	items[0].name = "Backstage passes to a TAFKAL80ETC concert";
    	//but test for sellin == 0 happens after decrement 
    	items[0].sellIn = 0; 
    	items[0].quality = 48; 
    	app.updateQuality();
    	assertEquals(0, app.items[0].quality);
    }
    
    @Test//sellin calculated differently than for other Items - apply quality change before decrement of sellIn??
    public void shouldNotIncreaseBackStagePassesQualityGTFityWhenSellinEqualsTen(){
    	items[0].name = "Backstage passes to a TAFKAL80ETC concert";
    	items[0].sellIn = 10; 
    	items[0].quality = 49; 
    	app.updateQuality();
    	assertEquals(50, app.items[0].quality);
    }
    
    @Test//sellin calculated differently than for other Items - apply quality change before decrement of sellIn??
    public void shouldNotIncreaseBackStagePassesQualityGTFityWhenSellinEqualsFive(){
    	items[0].name = "Backstage passes to a TAFKAL80ETC concert";
    	items[0].sellIn = 5; 
    	items[0].quality = 48; 
    	app.updateQuality();
    	assertEquals(50, app.items[0].quality);
    }
    
    

}
