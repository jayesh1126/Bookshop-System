
public class audioBook extends Book {
	private float listeningLength;
	private String format;
	// Constructor
	public audioBook(int ISBN, String type, String title, String language, String genre, String releaseDate, float price, int quantity, float listeningLength, String format) {
		super(ISBN, type, title, language, genre, releaseDate, price, quantity);
		this.listeningLength = listeningLength;
		this.format = format;
	}

	public float getListeningLength() {
		return this.listeningLength;
		}
	public String getFormat() {
		return this.format;
		}
	
	// method
	@Override
	public String toString() {
	return (getISBN() + ", " + getType() + ", " + getTitle() + ", " + getLanguage() + ", " + getGenre() + ", " + getReleaseDate() + ", " + getPrice()
	+ ", " + getQuantity() + ", " + this.listeningLength + ", " + this.format);
	}
}
