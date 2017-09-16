package restaurant;
import java.util.Scanner;
import java.util.*;

public class Login{

  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String username;
    String password;
    int tableno=input.nextInt();
    String item=input.next();
    int quantity=input.nextInt();
    int orderid=input.nextInt();

    System.out.println("Log in:");
    System.out.println("username: ");
    username = input.next();

    System.out.println("password: ");
    password = input.next();

    //users check = new users(username, password);

    if(username.equals(username) && password.equals(password)) 
        System.out.println("Welcome 2 Our Restaurant\n");
           ItemObject iobj=new ItemObject(item,quantity,item);
        Orders ord=new Orders(tableno);
        ord.addItemBuffer(iobj);
        ord.addOrderItem(item, quantity);
        ord.itemsOrderedString();
        orderid=ord.getOrderID();
        ord.setOrderID(orderid);
        int tmt=input.nextInt();
        tmt=ord.getOrderTotal();
        ord.setTime();
        ArrayList<ItemObject> al=new ArrayList<ItemObject>();
        ord.addMultipleItemBuffer(al);
        al=ord.orderItemObjects();
        ord. removeItemBuffer(iobj);
        int totorders=input.nextInt();
        totorders=ord.getOrderTotalObjects();
        ord.displayOrder();
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        ord.addMultipleOrderItems(hm);
        ord.orderDetails();
        
        
  }
}