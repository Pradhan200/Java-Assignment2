
public class Meal {
	private Food burrito;
    private Food fries;
    private Food soda;
    private double price;

    public Meal(Food burrito, Food fries, Food soda) {
        burrito = new Food("Burrito", 7);
        fries = new Food("Fries", 4);
        soda = new Food("Soda", 2.50);
        this.burrito = burrito;
        this.fries = fries;
        this.soda = soda;
        this.price =calculatePrice(burrito.getPrice(), fries.getPrice(), soda.getPrice()); // Discount $1 for each item
    }
    public static double calculatePrice(double burritoPrice, double friesPrice, double sodaPrice) {
        final double discountPerItem = 1.0; // Discount amount for each item in a meal
        return burritoPrice + friesPrice + sodaPrice - (discountPerItem * 3);
    }

    public double getPrice() {
        return price;

    }



}
