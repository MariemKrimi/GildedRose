package com.gildedrose;
import java.util.List;

public class GildedRose {
    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        items.forEach((item) -> {
            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

        });
    }

}