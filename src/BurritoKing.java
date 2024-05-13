//
//  import java.util.HashMap;
//  
//  public class BurritoKing { private HashMap<String, Integer> sales = new
//  HashMap<>(); int Burrito_quantity; int Fries_quantity; int soda_quantity;
//  private int friesCapacity = 0; private Food burrito; private Food fries;
//  private Food soda; private Meal meal;
//  
//  
//  
//  public BurritoKing() { sales.put("meals", 0); sales.put("burritos", 0);
//  sales.put("fries", 0); sales.put("sodas", 0);
//  
//  
// // Initialize food items burrito = new Food("Burrito", 7); fries = new
//  Food("Fries", 4); soda = new Food("Soda", 2.50);
// 
//  // Initialize meal meal = new Meal(burrito, fries, soda); }
//  
//  public void orderBurrito(int Burrito_quantity) {
// 
//  sales.put("burritos", sales.get("burritos") + Burrito_quantity);
//  System.out.println("Ordered " + Burrito_quantity + " burrito(s)."); } public
//  void orderFries(int Fries_quantity) {
//  
//  if (Fries_quantity <= friesCapacity) { sales.put("fries", sales.get("fries")
//  + Fries_quantity); friesCapacity -= Fries_quantity;
//  System.out.println("Ordered " + Fries_quantity + " serve(s) of fries."); }
//  else { int additionalFries = 5; friesCapacity += additionalFries;
//  System.out.println("Not enough fries available. Cooking more.");
//  System.out.println(additionalFries + " serves of fries have been prepared.");
//  orderFries(Fries_quantity); } }
//  
//  public void orderSoda(int soda_quantity) {
//  
//  sales.put("sodas", sales.get("sodas") + soda_quantity);
//  System.out.println("Ordered " + soda_quantity + " soda(s)."); } public double
//  getOrderDetails() { double totalCost = 0; totalCost += sales.get("burritos")
//  burrito.getPrice(); totalCost += sales.get("fries") * fries.getPrice();
//  totalCost += sales.get("sodas") * soda.getPrice(); return totalCost; }
//  
// 
// 
//  public double getTotalSales() { // Adjust for the discount on meals double
//  totalSales = sales.get("meals") * 3; // Discount of $3 per meal totalSales +=
//  sales.get("burritos") * burrito.getPrice(); totalSales += sales.get("fries")
// fries.getPrice(); totalSales += sales.get("sodas") * soda.getPrice();
//  return totalSales; }
//  
//  public void printSalesReport() {
//  System.out.println("Unsold Serves of Fries: " + friesCapacity);
//  System.out.println("Total Sales:"); System.out.println("Burritos: " +
// sales.get("burritos") + " $" + (sales.get("burritos") * burrito.getPrice()));
//  System.out.println("Fries: " + sales.get("fries") + " $" +
//  (sales.get("fries") * fries.getPrice())); System.out.println("Soda: " +
//  sales.get("sodas") + " $" + (sales.get("sodas") * soda.getPrice()));
//  System.out.println("Total: $" + getTotalSales()); }
//  
// 
//  }
// 
import java.util.HashMap;

public class BurritoKing {
	 private HashMap<String, Integer> sales = new HashMap<>();
	    private int friesCapacity = 0;
	    int WarmingTray=5;
	    private Food burrito;
	    private Food fries;
	    private Food soda;
	    private Meal meal;
	    int TotalBurritoSold=0;
	    private double burritoPrice; // Add price variables
	    private double friesPrice;
	    private double sodaPrice;

	    public BurritoKing() {
	        sales.put("burritos", 0);
	        sales.put("fries", 0);
	        sales.put("sodas", 0);
	        sales.put("meals", 0);

	        // Initialize food items
	        this.burritoPrice = burritoPrice; // Initialize prices
	        this.friesPrice = friesPrice;
	        this.sodaPrice = sodaPrice;

	        // Initialize food items
	        burrito = new Food("Burrito", burritoPrice);
	        fries = new Food("Fries", friesPrice);
	        soda = new Food("Soda", sodaPrice);

	        // Initialize meal
	        meal = new Meal(burrito, fries, soda);
	    }
	    
	    public void orderBurrito(int quantity) {
	    	TotalBurritoSold+=quantity;
	    	
	        sales.put("burritos", sales.get("burritos") + quantity);
	       
	        System.out.println("Ordered " + quantity + " burrito(s).");
	    }
	    public Meal getMeal() {
	        return meal;
	    }
	    

	    public void orderFries(int quantity) {
	        if (quantity <= friesCapacity) {
	            sales.put("fries", sales.get("fries") + quantity);
	            friesCapacity -= quantity;
	            System.out.println("Ordered " + quantity + " serve(s) of fries.");
	        } else {
	            int additionalFries = 5;
	            friesCapacity += additionalFries;
	            System.out.println("Not enough fries available. Cooking more.");
	            System.out.println(additionalFries + " serves of fries have been prepared.");
	            orderFries(quantity);
	        }
	    }
	    public void setPrices(double burritoPrice, double friesPrice, double sodaPrice) {
	        burrito.setPrice(burritoPrice);
	        fries.setPrice(friesPrice);
	        soda.setPrice(sodaPrice);
	    }
	   
	    public void orderSoda(int quantity) {
	        sales.put("sodas", sales.get("sodas") + quantity);
	        System.out.println("Ordered " + quantity + " soda(s).");
	    }
	    public double getOrderDetails(int burritosold, int friessold,int sodasold) {
	        double totalCost = 0;
	        totalCost += sales.get("burritos") * burrito.getPrice();
	        totalCost += sales.get("fries") * fries.getPrice();
	        totalCost += sales.get("sodas") * soda.getPrice();
	        return totalCost;
	    }

	    
	    
	    public double getTotalSales() {
	        // Adjust for the discount on meals
	        double totalSales = sales.get("meals") * 3; // Discount of $3 per meal
	        totalSales += sales.get("burritos") * burrito.getPrice();
	        totalSales += sales.get("fries") * fries.getPrice();
	        totalSales += sales.get("sodas") * soda.getPrice();
	        return totalSales;
	    }

	    public void printSalesReport() {
	        System.out.println("Unsold Serves of Fries: " + friesCapacity);
	        System.out.println("Total Sales:");
	        System.out.println("Burritos: " + sales.get("burritos") + " $" + (sales.get("burritos") * burrito.getPrice()));
	        System.out.println("Fries: " + sales.get("fries") + " $" + (sales.get("fries") * fries.getPrice()));
	        System.out.println("Soda: " + sales.get("sodas") + " $" + (sales.get("sodas") * soda.getPrice()));
	        System.out.println("Total: $" + getTotalSales());
	    }
	    public int getFriesCapacity() {
	        return friesCapacity;
	    }
	    public int Preparation_Time_Burritos(int Burrito_quantity,int Fries_quantity) {
	    	int burritoTimePerBatch=9;
	    	int friesTimePerBatch=8;
	    	
	    	 int burritoBatches = (int) Math.ceil((double) Burrito_quantity / 2); // Up to 2 burritos per batch

	    	    // Calculate the total preparation time for burritos
	    	    int totalBurritoTime = burritoBatches * burritoTimePerBatch;

	        int totalFriesTime;
	        if (Fries_quantity < WarmingTray) {
	            // Fries can be served instantly if available
	            totalFriesTime = 0;
	        } else {
	            // Calculate the number of batches required for fries
	            int friesBatches = (int) Math.ceil((double) Fries_quantity / 5); // Each batch contains 5 serves

	            // Calculate the total preparation time for fries
	            totalFriesTime = friesBatches * friesTimePerBatch;
	        }

	        // Return the maximum of the two preparation times
	        return Math.max(totalBurritoTime, totalFriesTime);
	    }
	    
	    public void updatePrices(double burritoPrice, double friesPrice, double sodaPrice) {
	        this.burritoPrice = burritoPrice;
	        this.friesPrice = friesPrice;
	        this.sodaPrice = sodaPrice;

	        // Update prices for food items
	        burrito.setPrice(burritoPrice);
	        fries.setPrice(friesPrice);
	        soda.setPrice(sodaPrice);
	    }

}
