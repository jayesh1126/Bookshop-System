
public class ShoppedBook extends Book {

	public ShoppedBook(int ISBN, String type, String title, String language, String genre, String releaseDate,
			float price, int quantity) {
		super(ISBN, type, title, language, genre, releaseDate, price, quantity);
	}

	@Override
	public String toString() {
		return (getISBN() + ", " + getType() + ", " + getTitle() + ", " + getLanguage()
		+ ", " + getGenre() + ", " + getReleaseDate() + ", " + getPrice()
		+ ", " + getQuantity());
	}
	
	

}
