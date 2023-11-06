import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
	// fields
	private List<ShoppedBook> ShoppingBasket = new ArrayList<ShoppedBook>();
	private String BasketString;
	
	// Constructors
	public Customer(int userID, String username, String surname, int address1, String address2, String address3,
			String role, List<ShoppedBook> ShoppingBasket, String BasketString) {
		super(userID, username, surname, address1, address2, address3, role);
		this.ShoppingBasket = ShoppingBasket;
		this.BasketString = BasketString;
	}
	
	
	public List<ShoppedBook> getShoppingBasket() {
		return this.ShoppingBasket;
		}
	
	public String getBasketString(){
		return this.BasketString;
	}
	
	public void setBasketString(String newString) {
		this.BasketString = newString;
	}
	
	public void addBasketString(String addString) {
		this.BasketString += addString;
	}
	
	public void emptyBasket() {
		ShoppingBasket.clear();
		BasketString = "";
	}
	
	public void addBookBasket(ShoppedBook book) {
		ShoppingBasket.add(book);
	}
}
