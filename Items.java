package restaurant;

import java.util.HashMap;

public class Items {
	public static HashMap<String, Integer> items = new HashMap<String, Integer>();
	public static HashMap<String, ItemObject> itemObjects = new HashMap<String, ItemObject>();
	public static void addItem(String name, int price) {
		items.put(name, price);
		System.out.println("ITEM ADDED: " + name + " £" + price);
		itemObjects.put(name, new ItemObject(name, price, "1"));
	}
	
	public static void removeItem(String name) {
		items.remove(name);
		itemObjects.remove(name);
		
		System.out.println("ITEM REMOVED: " + name);
	}

	//Gets the list of the item objects
	public static HashMap<String, ItemObject> getItemObjects() {
		return itemObjects;
	}

	//Gets the price of an item given the name of item 
	public static int getItemPrice(String name) {
		return items.get(name);
	}
	
}