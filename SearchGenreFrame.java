import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchGenreFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -642519124956470437L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SearchGenreFrame(Customer user) throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFrame cFrame = new CustomerFrame(user);
				cFrame.setVisible(true);
			dispose();
			}
		});
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		
		
		
		// To read through the text file putting everything in a list of objects and then viewBook(), so print all the books to the screen.
		File dataFile = new File("StockData.txt");
		Scanner fileScanner =  new Scanner(dataFile);
		List<Book> listBook = new ArrayList<Book>();
		Paperback paper = null;
		audioBook abook = null;
		eBook ebook = null;
		
		while (fileScanner.hasNextLine()) {
			String[] details = fileScanner.nextLine().split(",");
			if (details[1].equals(" paperback")) {
				paper = new Paperback(Integer.parseInt(details[0].trim()), details[1].trim(),
						details[2].trim(), details[3].trim(), details[4].trim(),
						details[5].trim(), Float.parseFloat(details[6].trim()), Integer.parseInt(details[7].trim()),
						Integer.parseInt(details[8].trim()), details[9].trim());
				listBook.add(paper);
			}
			else if (details[1].equals(" audiobook")) {
				abook = new audioBook(Integer.parseInt(details[0].trim()), details[1].trim(),
						details[2].trim(), details[3].trim(), details[4].trim(),
						details[5].trim(), Float.parseFloat(details[6].trim()), Integer.parseInt(details[7].trim()),
						Float.parseFloat(details[8].trim()), details[9].trim());
				listBook.add(abook);
			}
			else if (details[1].equals(" ebook")) {
				ebook = new eBook(Integer.parseInt(details[0].trim()), details[1].trim(),
						details[2].trim(), details[3].trim(), details[4].trim(),
						details[5].trim(), Float.parseFloat(details[6].trim()), Integer.parseInt(details[7].trim()),
						Integer.parseInt(details[8].trim()), details[9].trim());
				listBook.add(ebook);
			}
		}
		fileScanner.close();
		
		listBook.sort(new SortGenreBook());
		Collections.reverse(listBook);
		String bookString = "";
		for (Book books : listBook) {
			bookString += books.toString()+"\n";
		}
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(20, 41, 568, 282);
		textPane.setText(bookString);
		textPane.setEditable(false);
		contentPane.add(textPane);
	}
}
