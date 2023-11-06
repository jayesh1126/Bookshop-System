import java.util.Comparator;

public class SortBook implements Comparator<Book>{
	@Override
	public int compare(Book book1, Book book2) {
		Integer price1 = (int) book1.getPrice();
		Integer price2 = (int) book2.getPrice();
		return price2.compareTo(price1);
	}
} 
