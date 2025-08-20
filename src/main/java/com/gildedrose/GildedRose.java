package com.gildedrose;

import java.util.stream.Stream;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    static boolean isNotLegendary(Item item) {
        return "Sulfuras".equals(item.name);
    }

    public void updateQuality() {
        Stream.of(items).filter(GildedRose::isNotLegendary).forEach(GildedRose::updateItemQ);

    }

    static void updateItemQ(Item item) {
        if ("Backstage".equals(item.name) && canInc(item)) {
            if (item.sellIn < 11 ) {
                item.quality = item.quality + 2;
            }
            if (item.sellIn < 6) {
                item.quality = item.quality + 3;
            }
            if (item.sellIn < 1) {
                item.quality = 0;
            }
            }
            if ("Aged Brie".equals(item.name) && canInc(item)) {
            if (item.sellIn < 51) {
                item.quality++;
            }
            }
        else
            if (canDisc(item))
            {  item.quality--;
                if (item.sellIn<0 && canDisc(item)){
                    item.quality--;
                    if("Conjured".equals(item.name) && canDisc(item)){
                        item.quality--;
                    }
                }
            }



    }
    static boolean canInc(Item item) {
        return item.quality <51;
    }
    static  boolean canDisc(Item item) {
        return item.quality >0 && !"Aged Brie".equals( item.name );
    }
}