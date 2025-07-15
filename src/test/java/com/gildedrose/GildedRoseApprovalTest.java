package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(DiffReporter.class)
class GildedRoseApprovalTest {

    @Test
    public void should_test_update_quality_with_combination(){
        CombinationApprovals.verifyAllCombinations(
            this::callUpdateQuality,
            new String[]{"Aged Brie","Backstage passes to a TAFKAL80ETC concert","a common item","Sulfuras, Hand of Ragnaros"},
            new Integer[]{-1,0,1,2,3,5,6,7,10,11,12,15},
            new Integer[]{-2,-1,0,5,10,20,30,40,49,50,51,100}
        );
    }

    private String callUpdateQuality(String name, Integer sellIn, Integer quality) {
        var items = new Item[]{new Item(name,sellIn,quality)};
        var gildRose = new GildedRose(items);
        gildRose.updateQuality();
        return gildRose.items[0].toString();
    }

}
