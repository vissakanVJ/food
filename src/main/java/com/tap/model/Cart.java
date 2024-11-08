package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private Map<Integer, CartItem> items;
	
	public Cart() {
		items = new HashMap<>();
	}
	
	public void addItem(CartItem item) {
		int itemId = item.getItemId();
		if(items.containsKey(itemId)) {
			
		}
	}

}
