package com.gildedrose;

import org.apache.commons.lang3.StringUtils;

public class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for(Item item : items) {

            if (StringUtils.equals(item.name, AGED_BRIE)) {
                handleAgedBrieProduct(item);
            }else if(StringUtils.equals(item.name, SULFURAS_HAND_OF_RAGNAROS)) {
                handleSulfurasProduct(item);
            }else if(StringUtils.equals(item.name, BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                handleAgedBackstageProduct(item);
            }else{
                handleNormalProduct(item);
            }
        }
    }

    private void handleNormalProduct(Item item) {
        int valueToDiscount = item.sellIn >= 0 ? 1 : 2;
        item.quality = Math.max(item.quality - valueToDiscount, 0);

        item.sellIn = item.sellIn - 1;
    }

    private void handleAgedBrieProduct(Item item) {
        if(item.quality + 1 <= 50)
            item.quality = item.quality + 1;

        item.sellIn = item.sellIn - 1;
    }

    private void handleAgedBackstageProduct(Item item) {
        if(item.sellIn <= 0)
            item.quality = 0;
        else{
            int value = 1;
            if(item.sellIn <= 5)
                value = 3;
            else if(item.sellIn <= 10)
                value = 2;
            item.quality = item.quality - value;
        }

        item.sellIn = item.sellIn - 1;

    }

    private void handleSulfurasProduct(Item item) {
        // nothing to do here : legendary product can't be sold / have their quality decrease
    }


}