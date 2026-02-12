package com.gildedrose;

public class GildedRose {

    public static final String SULFRES_STR = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE= "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (isAgedBrie(i)) {
                if (items[i].quality > 0 && !items[i].name.equals(SULFRES_STR)) {
                        items[i].quality = items[i].quality - 1;
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(BACKSTAGE_PASSES)) {
                        if (items[i].sellIn < 11) {
                            items[i].quality = items[i].quality + 1;
                        }

                        if (items[i].sellIn < 6) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            }

            if (!items[i].name.equals(SULFRES_STR)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(AGED_BRIE)) {
                    if (isNotBackstageOrSulfuras(i)) {
                        items[i].quality = items[i].quality - 1;
                    } else {
                        items[i].quality = 0;
                    }
                } else if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                }

            }
        }
    }

    private boolean isNotBackstageOrSulfuras(int i) {
        return !items[i].name.equals(BACKSTAGE_PASSES) &&
                items[i].quality > 0 && !items[i].name.equals(SULFRES_STR);
    }

    private boolean isAgedBrie(int i) {
        return !items[i].name.equals(AGED_BRIE)
                && !items[i].name.equals(BACKSTAGE_PASSES);
    }
}