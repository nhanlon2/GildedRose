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

}
