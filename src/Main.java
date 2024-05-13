
public class Main {

	public static void main(String[] args) {
		BurritoKing bk = new BurritoKing();
		UpdatePrice updatePrice = new UpdatePrice(7.0, 4.0, 2.5); // Initial prices
        Menu menu = new Menu(bk, updatePrice);
		menu.displayMenu();
		

	}

}
