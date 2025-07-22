package com.gildedrose;

import java.util.ArrayList;
import java.util.Arrays;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        /// /////////////////////////mon code //////////////////////////////
        Arrays.stream(items).forEach(item -> {
            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros") && item.quality > 50 && item.sellIn < 0) {
                    item.quality = item.quality - 1;
                    item.sellIn = item.sellIn - 1;
                } else {
                    item.quality = 0;
                }

            } else {
                item.quality = item.quality + 1;
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////////


    }
}