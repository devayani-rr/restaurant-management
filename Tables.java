package restaurant;
public class Tables {
		
	private static int tableCount = 0;
	public int tableNumber;
	public int orderID = 0;
	
	//Creates new Table object
	public Tables() {
		this.tableNumber = ++tableCount;
		System.out.println("TABLE " + tableNumber  +  " CREATED");
	}
	
	//Sets present order id of the table
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	//Gets present order ID of the table
	public int getOrderID() {
		return orderID;
	}
	
}