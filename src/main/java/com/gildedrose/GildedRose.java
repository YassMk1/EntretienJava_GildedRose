package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void update () {
    	 for (Item item : items) {
    		 
    		 switch (item.name) {
    		 	case "Aged Brie":
    		 		updateBrie(item);
    		 		break;
    		 	case "Backstage passes to a TAFKAL80ETC concert":
    		 		updatePass(item);
    		 		break;
    		 	case "Sulfuras, Hand of Ragnaros":
    		 		updateSulfuras(item);
    		 		break;
    		 	case "Conjured":
    		 		updateConjured(item);
    		 		break;
    		 	default:
    		 		updateNormalItems(item);
    		 }
    		 
    		 afterUpdateSellIn(item);
    		 
    		 
    	 }    	
    }
    
	private void updateNormalItems(Item item) {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
        }
		updateSellIn(item);
		if (item.sellIn < 0 && item.quality > 0) {
            	item.quality = item.quality - 1;
            }
    }

	private void updateConjured(Item item) {
		// TODO Auto-generated method stub
	}

	private void updateSulfuras(Item item) {
		// nothing to do
	}

	private void updatePass(Item item) {
		 if (item.quality < 50) {
             item.quality = item.quality + 1;
             
             if (item.sellIn < 11) {
                 if (item.quality < 50) {
                     item.quality = item.quality + 1;
                 }
             } if (item.sellIn < 6) {
                 if (item.quality < 50) {
                     item.quality = item.quality + 1;
                 }
             }
         }
		 updateSellIn(item);
		 if (item.sellIn < 0) {
			 item.quality = item.quality - item.quality;
         }
		
	}

	private void updateBrie(Item item) {
		if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
		updateSellIn(item);
		if (item.sellIn < 0 && item.quality < 50) {
                    item.quality = item.quality + 1;
            }
    }
	
	private void updateSellIn(Item item) {
    	if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
	}

	private void afterUpdateSellIn(Item item) {
		// TODO Auto-generated method stub
	}
	
	/*
	public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }*/
}