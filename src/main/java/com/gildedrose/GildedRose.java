package com.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void checkQualityNotNull(Item item) {
        if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void QualiteNeDepassePas50(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            checkBackstagePassesAugmenteQualite(item);
        }
    }

    private void checkBackstagePassesAugmenteQualite(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11) {
                checkNotGreaterThan50(item);
            }

            if (item.sellIn < 6) {
                checkNotGreaterThan50(item);
            }
        }
    }

    private void checkNotGreaterThan50(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void checkSulfurasNeChangePas(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void checkQualiteAgedBrieAugmenteApresDate(Item item) {
        checkSellInGreaterThanZero(item);
    }

    private void checkSellInGreaterThanZero(Item item) {
        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                checkMethodBackstagePassesToaName(item);
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private void checkMethodBackstagePassesToaName(Item item) {
        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            item.quality = item.quality - item.quality;
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                checkQualityNotNull(items[i]);
            } else {
                QualiteNeDepassePas50(items[i]);
            }
            checkSulfurasNeChangePas(items[i]);

            checkQualiteAgedBrieAugmenteApresDate(items[i]);
        }
    }
}