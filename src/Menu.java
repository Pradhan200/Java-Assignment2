import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private BurritoKing burritoKing;
    int Burrito_quantity;
    int Fries_quantity;
    int soda_quantity;
    double BurritoPrice=7.0;
    double FriesPrice=4.0;
    double SodaPrice=2.5;
    int totalMealCost=0;
    private double mealDiscount = 1.0;
    int mealQuantity=0;
    private UpdatePrice updatePrice;
    
    
    public Menu(BurritoKing burritoKing,UpdatePrice updatePrice) {
        this.burritoKing = burritoKing;
        this.updatePrice = updatePrice;
        
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        char choice;
        do {
            System.out.println("===============================================================");
            System.out.println("Burrito King");
            System.out.println("===============================================================");
            System.out.println("a) Order");
            System.out.println("b) Show sales report");
            System.out.println("c) Update prices");
            System.out.println("d) Exit");
            System.out.print("Please select: ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a':
                    orderFromMenu(scanner);
                    break;
                case 'b':
                    burritoKing.printSalesReport();
                    break;
                case 'c':
                    
                	updatePrices(scanner);
                    break;
                    
                case 'd':
                    System.out.println("Bye Bye");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 'd');

        scanner.close();
    }

    private void orderFromMenu(Scanner scanner) {
        char itemChoice;
        double totalCost = 0;
        int burritosold=0;
        int friessold=0;
        int sodasold=0;
        double totalBurritoCost=0;
        double totalFriesCost=0;
        double totalSodaCost=0;
        
        
       
        do {
        	
            System.out.println("> Select the food item");
            System.out.println("1. Burrito");
            System.out.println("2. Fries");
            System.out.println("3. Soda");
            System.out.println("4. Meal");
            System.out.println("5. No more");
            System.out.print("Please select: ");
            itemChoice = scanner.next().charAt(0);
            switch (itemChoice) {
            
            case '1':
            	burritosold = getQuantityFromUser(scanner, "burritos");
                burritoKing.orderBurrito(burritosold);
                break;
            case '2':
            	friessold = getQuantityFromUser(scanner, "serves of fries");
                burritoKing.orderFries(friessold);
                break;
            case '3':
            	sodasold = getQuantityFromUser(scanner, "sodas");
                burritoKing.orderSoda(sodasold);
                break;
            case '4':
                // Ordering a meal
                mealQuantity = getQuantityFromUser(scanner, "meals");
                mealDiscount = this.mealDiscount * 3; // Calculate discount per meal (3 items)
                for (int i = 0; i < mealQuantity; i++) {
                    burritoKing.orderBurrito(1);
                    burritoKing.orderFries(1);
                    burritoKing.orderSoda(1);
                }
                // Update total quantities of sold items
                burritosold += mealQuantity; // Update total burritos sold
                friessold += mealQuantity; // Update total fries sold
                sodasold += mealQuantity;

                totalMealCost -= mealQuantity * mealDiscount; // Apply total discount for meals outside the loop
                break;

          	case '5':

            	Meal meal = burritoKing.getMeal();
                // Check if it's a meal or not
                if (meal!=null) {
                    // Calculate total cost using getPrice() method from Meal class
                    totalCost = totalMealCost;
                } else {
                    // Calculate total cost using getOrderDetails() method from BurritoKing class
                    	totalBurritoCost = burritosold*BurritoPrice;
                    	totalFriesCost =friessold*FriesPrice;
                    	totalSodaCost=sodasold*SodaPrice;
                    	totalCost=totalBurritoCost+totalFriesCost+totalSodaCost;
                    }
                    totalCost = (burritosold * BurritoPrice) + (friessold * FriesPrice) + (sodasold * SodaPrice);
 
                    if (totalCost > 0) {
                    
                        System.out.println("Total for " + burritosold + " Burritos and " + friessold + " fries and " + sodasold + " sodas is " + "$" + totalCost);
                    
                    handlePayment(scanner, totalCost, burritosold,friessold);
                } else {
                    System.out.println("No items ordered.");
                }
                break;
                default:
                    System.out.println("Invalid option.");
            }
            
        } while (itemChoice != '5');
    }
    
    private void handlePayment(Scanner scanner, double totalCost, int burritoQuantity, int friesQuantity) {
        double amountPaid;
        do {
        	try {
            System.out.print("Please Enter money: ");
            amountPaid = scanner.nextDouble();
            if (amountPaid < totalCost) {
                System.out.println("Sorry, that's not enough to pay for the order.");
                
            }
        	}catch(InputMismatchException e) {
        		System.out.println("Please Enter a valid amount.");
        		scanner.next(); // clear the scanner buffer
                amountPaid = 0;      		
        	}
        } while (amountPaid < totalCost);
        double change = amountPaid - totalCost;
        System.out.println("Change returned: $" + change);
        int preparationTime = burritoKing.Preparation_Time_Burritos(burritoQuantity, friesQuantity);
        System.out.println("Time taken: " + preparationTime + " minutes");
            
    }
    private int getQuantityFromUser(Scanner scanner, String itemName) {
        int quantity = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print("How many " + itemName + " would you like to buy: ");
                quantity = scanner.nextInt();
                if (quantity < 0) {
                    System.out.println("Quantity cannot be negative. Please enter a valid quantity.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid quantity.");
                scanner.next(); // clear the scanner buffer
            }
        } while (!validInput);
        return quantity;
    }


    private void updatePrices(Scanner scanner) {
        updatePrice.updatePrices(scanner); // Call updatePrices() method of UpdatePrice object
        System.out.println("Prices updated successfully!");
    }
}


