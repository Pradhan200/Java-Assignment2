import java.util.Scanner;

public class UpdatePrice {
    private double burritoPrice;
    private double friesPrice;
    private double sodaPrice;

    public UpdatePrice(double burritoPrice, double friesPrice, double sodaPrice) {
        this.burritoPrice = burritoPrice;
        this.friesPrice = friesPrice;
        this.sodaPrice = sodaPrice;
    }

    public void updatePrices(Scanner scanner) {
        System.out.print("Enter new price for Burrito: ");
        this.burritoPrice = scanner.nextDouble();
        System.out.print("Enter new price for Fries: ");
        this.friesPrice = scanner.nextDouble();
        System.out.print("Enter new price for Soda: ");
        this.sodaPrice = scanner.nextDouble();
    }

    public double getBurritoPrice() {
        return burritoPrice;
    }

    public double getFriesPrice() {
        return friesPrice;
    }

    public double getSodaPrice() {
        return sodaPrice;
    }
}
