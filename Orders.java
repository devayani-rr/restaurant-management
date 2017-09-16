package restaurant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Orders extends Tables{
		
	private static int orderCount;
	private int orderID;
	private int tableNumber;
	private String timeOfOrder;
	private String itemOrderedString;
	private int orderTotal;
	private int orderTotalObjects;
	
	private HashMap<String, Integer> orderContents = new HashMap<String, Integer>();	
	private ArrayList<ItemObject> orderItemObjects = new ArrayList<ItemObject>();
	public Orders(int tableNumber) {
		this.orderID = ++orderCount; // Ensures the order starts at 1 instead of 0
		this.tableNumber = tableNumber;
                
		this.setTime(); // get the time of order
		System.out.println("ORDER " + orderID + " CREATED");
		}
	
	public void addItemBuffer(ItemObject item) {
		orderItemObjects.add(item);
		// updates order string when item added 
		itemsOrderedString();
	}
	 
	//Adds multiple items objects to be stored in the order
	public void addMultipleItemBuffer(ArrayList<ItemObject> items) {
		for (ItemObject item : items ) {
			addItemBuffer(item);
		}
	}
	
	//Removes an item object from the order and updates the order string
	public void removeItemBuffer(ItemObject item) {
		orderItemObjects.remove(item);
		// update the order string when item removed
		itemsOrderedString();
	}
	
	//Returns a list of the order's item objects
	public ArrayList<ItemObject> orderItemObjects() {
		return this.orderItemObjects;
	}
	
	//Returns total amount of an order
	public int getOrderTotalObjects() {
		int total = 0;
		for (ItemObject item : orderItemObjects) {
			total += item.getPrice();
		}	
		this.orderTotalObjects = total;
		return orderTotalObjects;
	}
	
	public void addOrderItem(String item, int quantity) {

		if (this.orderContents.containsKey(item) == true) {
			int currentQuantity = this.orderContents.get(item);
			this.orderContents.put(item, currentQuantity + quantity);
		}

		else { this.orderContents.put(item, quantity); }
	}
	 
	//Adds multiple items to the user's order
	public void addMultipleOrderItems(HashMap<String, Integer> order) {		
		for (Map.Entry<String, Integer> pair : order.entrySet()) {
			String foodItem = pair.getKey();
			int quantityToAdd = pair.getValue();
			this.addOrderItem(foodItem, quantityToAdd);
		}
	}
 
	//Displays details of an order
	public void displayOrder() {
		for (Map.Entry<String, Integer> entry : this.orderContents.entrySet()) {
			System.out.println(entry.getKey() + " | " + "x " +  entry.getValue() + " | £" + Items.getItemPrice(entry.getKey()) );
		}
		System.out.println("ORDER TIME: " + this.timeOfOrder);
		System.out.println("TABLE: " + this.tableNumber);
		System.out.println("ORDER TOTAL: £" + this.getOrderTotal());
	}
	 
	//Returns details of an order
	public String orderDetails() {
		
		String details = "Restaurant Management System \n";
		
		for (Map.Entry<String, Integer> entry : this.orderContents.entrySet()) {
			details += entry.getKey() + " | " + "x " +  entry.getValue() + " | £" + Items.getItemPrice(entry.getKey()) + "\n";
		}
		
		details = details +"ORDER TIME: " + this.timeOfOrder + "\n";
		details = details +"TABLE: " + this.tableNumber + "\n";
		details = details +"ORDER TOTAL: £" + this.getOrderTotal();
		
		return details;
	}
		
	//Gets the order id of this order
	public int getOrderID() { 
		return this.orderID;
	}
	
	//Sets orderID of the order
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	//Gets total amount of the order
	public int getOrderTotal() {
		int total = 0;
		for (ItemObject item : orderItemObjects) {
			total += item.getPrice();
		}
		
		this.orderTotal = total;
		return orderTotal;
	}
	
	//Sets time and date of the order
	void setTime() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.timeOfOrder = dateFormat.format(date); //2017/09/16 23:08:25
	}
	
	//Sets time and date of the order
	public void setTimeOfOrder(String timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
	}
	
	
	/**
	 * Get the time of the order.
	 * @return
	 */
	public String getTimeOfOrder() {
		return timeOfOrder;
	}
	
	//Gets table number of the order
	public int getTableNumber() {
		return tableNumber;
	}
	
	//Sets table number of the order
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	
	//Sets string of all of the items ordered
	public void itemsOrderedString() {
		String itemString = "";
		for (ItemObject item : orderItemObjects) {
			itemString +=  item.getName() + " ";
		}
		this.itemOrderedString = itemString;	
	}
	
	//Gets string of all of the items ordered
	public String getItemOrderedString() {
		return itemOrderedString;
	}


}