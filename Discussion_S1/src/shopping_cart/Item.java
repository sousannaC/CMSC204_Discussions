/*
 * Student name: Sousanna Chugunova
 * Class: CMSC204 
 * Instructor: Dr. Thai
 * Platform/compiler: eclipse
 * Array based implementation needed in order to run OnlineShopper
 */

package shopping_cart;

public class Item {
	    private String name;
	    private int price;
	    
	public Item(String name, int price) {
	    this.name = name;
	    this.price = price;
}	        
	public String getName() {
	    return name;
}

	public int getPrice() {
	    return price;
}
	    
	    @Override
	public String toString() {
	    return String.format("%s\t$%.2f", name, price / 100.0);
	    }
	}