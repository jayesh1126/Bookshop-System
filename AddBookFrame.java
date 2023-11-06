import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class AddBookFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6595497440030125093L;
	private JPanel contentPane;
	private JTextField ISBNfield;
	private JTextField Typefield;
	private JTextField Titlefield;
	private JTextField Languagefield;
	private JTextField Genrefield;
	private JTextField Releasefield;
	private JTextField Pricefield;
	private JTextField QuantityField;
	private JTextField NumListfield;
	private JTextField CondiFormatfield;
	private JButton btnBack;

	/**

	 * Create the frame. 
	 */
	public AddBookFrame(User user) throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ISBNfield = new JTextField();
		ISBNfield.setBounds(124, 21, 96, 19);
		contentPane.add(ISBNfield);
		ISBNfield.setColumns(10);
		
		Typefield = new JTextField();
		Typefield.setBounds(310, 21, 96, 19);
		contentPane.add(Typefield);
		Typefield.setColumns(10);
		
		Titlefield = new JTextField();
		Titlefield.setBounds(494, 21, 96, 19);
		contentPane.add(Titlefield);
		Titlefield.setColumns(10);
		
		Languagefield = new JTextField();
		Languagefield.setBounds(124, 92, 96, 19);
		contentPane.add(Languagefield);
		Languagefield.setColumns(10);
		
		Genrefield = new JTextField();
		Genrefield.setBounds(310, 92, 96, 19);
		contentPane.add(Genrefield);
		Genrefield.setColumns(10);
		
		Releasefield = new JTextField();
		Releasefield.setBounds(494, 92, 96, 19);
		contentPane.add(Releasefield);
		Releasefield.setColumns(10);
		
		Pricefield = new JTextField();
		Pricefield.setBounds(94, 158, 96, 19);
		contentPane.add(Pricefield);
		Pricefield.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(255, 24, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setBounds(69, 24, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Title");
		lblNewLabel_2.setBounds(439, 24, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Language");
		lblNewLabel_3.setBounds(69, 95, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Genre");
		lblNewLabel_4.setBounds(255, 95, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Release Date");
		lblNewLabel_5.setBounds(418, 95, 76, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Price");
		lblNewLabel_6.setBounds(39, 161, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		QuantityField = new JTextField();
		QuantityField.setBounds(255, 158, 96, 19);
		contentPane.add(QuantityField);
		QuantityField.setColumns(10);
		
		NumListfield = new JTextField();
		NumListfield.setBounds(494, 158, 96, 19);
		contentPane.add(NumListfield);
		NumListfield.setColumns(10);
		
		CondiFormatfield = new JTextField();
		CondiFormatfield.setBounds(94, 251, 96, 19);
		contentPane.add(CondiFormatfield);
		CondiFormatfield.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Quantity");
		lblNewLabel_7.setBounds(200, 161, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Num pages/ Listening length");
		lblNewLabel_8.setBounds(364, 161, 130, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Condition / Format");
		lblNewLabel_9.setBounds(0, 254, 96, 13);
		contentPane.add(lblNewLabel_9);
		
		// To read through the text file putting everything in a list of objects.
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
		
		JButton btnNewButton = new JButton("Add a book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ISBNfield.getText().isEmpty() || Typefield.getText().isEmpty() || Titlefield.getText().isEmpty()
						 || Languagefield.getText().isEmpty() || Genrefield.getText().isEmpty() || Releasefield.getText().isEmpty()
						 || Pricefield.getText().isEmpty() || QuantityField.getText().isEmpty() || NumListfield.getText().isEmpty()
						 || CondiFormatfield.getText().isEmpty()) {
					showMessageDialog(null, "Please fill in all the informations");
				}
				else {
					int num = 0;
					for (Book books : listBook) {
						if (books.getISBN() == Integer.parseInt(ISBNfield.getText())){
							num=1;
							showMessageDialog(null, "This book is already in Stock Data");
						}
					}
					if (num==0) {
				// Writing to the text file
				FileWriter outputFile;
				try {
					outputFile = new FileWriter("StockData.txt", true);
					BufferedWriter bw = new BufferedWriter(outputFile);
					bw.write("\n" + ISBNfield.getText() + ", "+ Typefield.getText() + ", "
					+ Titlefield.getText() + ", "+ Languagefield.getText() + ", "+ Genrefield.getText() +
							", "+ Releasefield.getText() + ", " + Pricefield.getText() + ", " + QuantityField.getText() +
					 ", " + NumListfield.getText() + ", " + CondiFormatfield.getText());
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
				AdminFrame frame = new AdminFrame(user);
				frame.setVisible(true);
				}
				}
}
		});
		btnNewButton.setBounds(255, 221, 151, 51);
		contentPane.add(btnNewButton);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminFrame frame = new AdminFrame(user);
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(11, 327, 85, 21);
		contentPane.add(btnBack);
	}
}
