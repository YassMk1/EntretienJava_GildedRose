package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals("foo", app.items[0].name);
    }
    
    @Test
    void agedBrie_checkQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 1) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }
    
    @Test
    void agedBrie_checkQualityDouble_sellInBelow0() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }
    
    @Test
    void agedBrie_checkQuality_Upper50() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void sulfuras_notIncrement() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }
    
    @Test
    void passes_checkQualityIncrease_normal() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(11, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    
    @Test
    void passes_checkQualityIncrease_sellInBelow10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    void passes_checkQualityIncrease_sellInBelow5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }
    
    @Test
    void passes_checkQuality_endOfSale() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void item_checkQuality() {
        Item[] items = new Item[] { new Item("item", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }
    
    @Test
    void item_checkQuality_sellInBelow0() {
        Item[] items = new Item[] { new Item("item", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    } 
    
    @Test
    void conjured_checkQuality() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    } 
    
    @Test
    void conjured_checkQuality_sellInBelow0() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }
    
    @Test
    void conjured_checkQuality2() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 14, 10) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(13, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    void conjured_checkQuality3() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void conjured_checkQuality4() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 3) };
        GildedRose app = new GildedRose(items);
        app.update();

        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
}
