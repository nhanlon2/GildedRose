package com.gildedrose;

public class ItemBuilder {
	private int sellin;
	private int quality;
	private String name;

	public ItemBuilder sellIn(int si) {
		this.sellin = si;
		return this;
	}

	public ItemBuilder quality(int q) {
		this.quality = q;
		return this;
	}

	public ItemBuilder name(String name) {
		this.name = name;
		return this;
	}

	public Item build() {
		return new Item(name, sellin, quality);
	}
}
