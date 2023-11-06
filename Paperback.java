

public class Paperback extends Book {
	private int numbPages;
	private String condition;
	
// Constructor
	public Paperback(int ISBN, String type, String title, String language, String genre, String releaseDate, float price, int quantity, int numbPages, String condition) {
		super(ISBN, type, title, language, genre, releaseDate, price, quantity);
		this.numbPages = numbPages;
		this.condition = condition;
	}
	
	public int getnumbPages() {
		return this.numbPages;
		}
	public String getCondition() {
		return this.condition;
		}
	
	// method
	@Override
	public String toString() {
	return (getISBN() + ", " + getType() + ", " + getTitle() + ", " + getLanguage() + ", " + getGenre() + ", " + getReleaseDate() + ", " + getPrice()
	+ ", " + getQuantity() + ", " + this.numbPages + ", " + this.condition);
	}
}
