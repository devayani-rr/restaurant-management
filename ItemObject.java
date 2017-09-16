package restaurant;

public class ItemObject {
	
	private String quantity;
	private int price;
	private String name;
	public ItemObject(String name, int price, String quantity) {
		this.quantity = quantity;
		this.price = price;
		this.name = name;
	}

	//Gets quantity of the item
	public String getQuantity() {
		return quantity;
	}

	//Sets quantity of the item
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	//Gets price of the item
	public int getPrice() {
		return price;
	}

	//Sets price of the item
	public void setPrice(int price) {
		this.price = price;
	}

	//Gets name of the item
	public String getName() {
		return name;
	}

	//Sets name of the item
	public void setName(String name) {
		this.name = name;
	}

}