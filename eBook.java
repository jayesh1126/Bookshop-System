
public class eBook extends Book {
	private int numbPages;
	private String format;
	
	// Constructor
	public eBook(int ISBN, String type, String title, String language, String genre, String releaseDate, float price, int quantity, int numbPages, String format) {
		super(ISBN, type, title, language, genre, releaseDate, price, quantity);
		this.numbPages = numbPages;
		this.format = format;
	}

	public int getnumbPages() {
		return this.numbPages;
		}
	public String getFormat() {
		return this.format;
		}
	
	// method
	@Override
	public String toString() {
	return (getISBN() + ", " + getType() + ", " + getTitle() + ", " + getLanguage() + ", " + getGenre() + ", " + getReleaseDate() + ", " + getPrice()
	+ ", " + getQuantity() + ", " + this.numbPages + ", " + this.format);
	}
}