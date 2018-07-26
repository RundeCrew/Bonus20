import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bonus20 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		Map<String, Double> inventory = new HashMap<>();  // Create a Map for items in the store
		inventory = fillInventory(inventory);  // assigns the method to a variable in the main to use
		
		ArrayList<String> shoppingCart = new ArrayList<>();		//array to add items to the shopping cart
		String cont = "y";
		String userInput;
		
		do {
			userInput = getValidInventoryChoice(scnr, "Please enter a menu item:", inventory);
			
			shoppingCart.add(userInput);  // adding items to the shoppingCart
			listPrice(shoppingCart, inventory); // Calls the method to print out the items in the cart and the prices in the cart
					
			System.out.println("Add another item? y/n");
			cont = scnr.nextLine();
			
		}while (cont.trim().toLowerCase().startsWith("y"));
		
		System.out.println("Thanks for shopping with us! \nThis is what's in your cart:");
		listPrice(shoppingCart, inventory);   // prints out columns of what's in the cart and their price
		average(shoppingCart, inventory);   // calls the average method
		highest(shoppingCart, inventory);   // calls the highest method
		lowest(shoppingCart, inventory);   // calls the lowest method
	}

	private static Map<String, Double> fillInventory(Map<String, Double> inventory) {
		 
		inventory.put("Salad", 3.99);
		inventory.put("Bread", 0.99);
		inventory.put("Soup", 2.99);
		inventory.put("Banana", 0.29);
		inventory.put("Apple", 0.59);
		inventory.put("Pie", 1.99);
		inventory.put("Coffee", 0.89);
		inventory.put("Tea", 1.99);
		
		String format = "%s\t\t%s";
		System.out.println("Welcome to Justin's Awesome Market!\n");
		System.out.printf(format, "Item", "Price");
		System.out.println("\n======================");
		for (Map.Entry<String, Double> entry : inventory.entrySet()) {
			System.out.println(entry.getKey() + "\t\t$" + entry.getValue());
		}
		
		return inventory;
	}
	
	public static String getValidInventoryChoice (Scanner scnr, String prompt, Map<String, Double> inventory) {
		String userInput = null;
		boolean inputIsValid = false;

		do {
			System.out.println(prompt);
			userInput = scnr.nextLine();
			if (inventory.keySet().contains(userInput)) {
				break; // Break the loop
			} else {
				System.out.println("We don't offer this item, please try again.");
				continue;
			}
		} while (inputIsValid == false);
		
		return userInput;
	}
	
	private static void average(ArrayList<String> shoppingCart, Map<String, Double> inventory) {
		double sum = 0;//the total price, added together
		int count = 0; //the number of individual items
		for ( String fruit : shoppingCart ) {
			
			//sum get from the inventory,
			//the "value" of the "key" in this case fruit!
			sum += inventory.get(fruit);
			count++;
		}
		System.out.println("Average price: " + sum/count);
	}
	
	private static void highest(ArrayList<String> shoppingCart, Map<String, Double> inventory) {
		double highest = 0.0;
		
		for ( String fruit : shoppingCart) {
			
			if (highest < inventory.get(fruit)   ) {
				highest = inventory.get(fruit);
			}
		}
		System.out.println("Highest Price: " + highest);
		
	}
	
	private static void lowest(ArrayList<String> shoppingCart, Map<String, Double> inventory) {
		double lowest = 1e9;
		
		for ( String fruit : shoppingCart) {
			
			if (lowest > inventory.get(fruit)) {
				lowest = inventory.get(fruit);
			}
		}
		System.out.println("Lowest Price: " + lowest);
		
	
}
	private static void listPrice(ArrayList<String> shoppingCart, Map<String, Double> inventory) {
		double price = 0.0;
		
		for (String item : shoppingCart) {
			price = inventory.get(item);
			System.out.println(item + "\t\t " + price);
		}
	}
	
}
