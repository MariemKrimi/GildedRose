package com.gildedrose;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

public class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        IntStream.range(0, items.length).forEach(i -> {
            String name = items[i].name;
            if (!StringUtils.isEmpty(name) && items[i].quality > 0) {
                if (!StringUtils.equalsAny
                        (name, AGED_BRIE, TAFKAL_80_ETC_CONCERT, SULFURAS_HAND_OF_RAGNAROS)
                ) {

                    items[i].quality--;

                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality++;

                        if ((name.equals(TAFKAL_80_ETC_CONCERT)) && (items[i].sellIn < 11)) {

                            items[i].quality = items[i].quality++;

                        }

                    }
                }


                if (!name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                    items[i].sellIn = items[i].sellIn--;
                }
                if (items[i].sellIn < 0) {
                    if (!name.equals(AGED_BRIE)) {
                        if (name.equals(TAFKAL_80_ETC_CONCERT)) {

                            items[i].quality = 0;

                        } else {
                            if (name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                items[i].quality = items[i].quality - 1;
                            }

                        }
                    } else {

                        items[i].quality = items[i].quality + 1;

                    }
                }
            }
        });

    }
}