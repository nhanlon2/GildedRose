package com.gildedrose;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;
public class TexttestFixture {
	
	private String originalText;
	private StringBuilder capturedText;
	private Item[] items;
	@Before
	public void setUp() throws IOException {
    	originalText = new String(Files.readAllBytes(Paths.get("src/test/resources/expected_legacy_output.txt")));
        capturedText = new StringBuilder();
    	items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };
	}
	@Test
	public void testLegacyTextMatchesCurrent() {
        GildedRose app = new GildedRose(items);
        String [] originalTextArr = originalText.split("\n");
        int days = 7;
        int originalLine = 0;
        for (int i = 0; i < days; i++) {
        	String day = "-------- day " + i + " --------\n";
            capturedText.append(day);
            assertEquals(originalTextArr[originalLine++]+"\n",day);
            String header = "name, sellIn, quality\n";
            capturedText.append(header);
            assertEquals(originalTextArr[originalLine++]+"\n",header);
            for (Item item : items) {
            	String thisItem = item+"\n";
            	assertEquals(originalTextArr[originalLine++]+"\n",thisItem);
                capturedText.append(thisItem);
            }
            capturedText.append("\n");
            originalLine++;
            app.updateQuality();
        }
        System.out.println(capturedText);
        assertEquals(originalText,capturedText.toString());
        
	}

}
