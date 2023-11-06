import java.util.Comparator;

public class SortGenreBook implements Comparator<Book> {
	@Override
	public int compare(Book book1, Book book2) {
		return book2.getGenre().compareTo(book1.getGenre());
	}
}
