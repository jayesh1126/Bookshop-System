import java.util.Comparator;

public class SortListeningLength  implements Comparator<audioBook>{
	@Override
	public int compare(audioBook book1, audioBook book2) {
		Integer length1 = (int) book1.getListeningLength();
		Integer length2 = (int) book2.getListeningLength();
		return length2.compareTo(length1);
	}
}
