package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testQualiteDiminueNormalement() {
        //List<Item> items = new Item[] { new Item("Produit normal", 10, 20) };
        List<Item> items = List.of(new Item("Produit normal", 10, 20))
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, items.get(0).quality);
        assertEquals(9, items.get(0).sellIn);
    }

    @Test
    void testQualiteDiminueDoubleApresDate() {
        List<Item> items = List.of( new Item("Produit normal", 0, 20) );
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(18, items.get(0).quality);
        assertEquals(-1, items.get(0).sellIn);
    }

    @Test
    void testQualiteNeDevientPasNegative() {
        List<Item> items = List.of( new Item("Produit normal", 5, 0) );
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    void testAgedBrieAugmenteQualite() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, items[0].quality);
    }

    @Test
    void testQualiteNeDepassePas50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void testSulfurasNeChangePas() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, items[0].quality);
        assertEquals(10, items[0].sellIn);
    }

    @Test
    void testBackstagePassesAugmenteQualite() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, items[0].quality);
    }

    @Test
    void testBackstagePassesAugmenteQualitePar2() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, items[0].quality);
    }

    @Test
    void testBackstagePassesAugmenteQualitePar3() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, items[0].quality);
    }

    @Test
    void testBackstagePassesQualiteTombeAZero() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    void testQualiteAgedBrieAugmenteApresDate() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, items[0].quality);
    }
}