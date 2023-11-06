

public abstract class Book {
	// fields
	private int ISBN;
	private String type;
	private String title;
	private String language;
	private String genre;
	private String releaseDate;
	private float price;
	private int quantity;
	

	// Constructor
	public Book(int ISBN, String type, String title, String language, String genre, String releaseDate, float price, int quantity) {
		this.ISBN = ISBN;
		this.type = type;
		this.title = title;
		this.language = language;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.price = price;
		this.quantity = quantity;
	}
	// Method
		public abstract String toString();
		
		
		public int getISBN() {
			return this.ISBN;
			}
		public String getType() {
			return this.type;
			}
		public String getTitle() {
			return this.title;
			}
		public String getLanguage() {
			return this.language;
			}
		public String getGenre() {
			return this.genre;
			}
		public String getReleaseDate() {
			return this.releaseDate;
			}
		public float getPrice() {
			return this.price;
			}
		public int getQuantity() {
			return this.quantity;
			}
		
		public void setQuantity(int i) {
			this.quantity = i;
		}
		
		public float calculateTotalPrice() {
			return this.price * this.quantity;
		}
}
