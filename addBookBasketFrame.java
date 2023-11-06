import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import static javax.swing.JOptionPane.showMessageDialog;

public class addBookBasketFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6004900021925690424L;
	private JPanel contentPane;
	private JTextField bookField;
	private JTextField quantityField;


	/**
	 * Create the frame.
	 */
	public addBookBasketFrame(Customer user) throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String formatted = df.format(new Date());
		
		JLabel lblNewLabel = new JLabel("Enter ISBN");
		lblNewLabel.setBounds(5, 41, 69, 28);
		contentPane.add(lblNewLabel);
		
		bookField = new JTextField();
		bookField.setBounds(85, 46, 96, 19);
		contentPane.add(bookField);
		bookField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter quantity");
		lblNewLabel_1.setBounds(284, 49, 76, 13);
		contentPane.add(lblNewLabel_1);
		
		quantityField = new JTextField();
		quantityField.setBounds(370, 46, 96, 19);
		contentPane.add(quantityField);
		quantityField.setColumns(10);
		
		JTextArea BasketArea = new JTextArea();
		BasketArea.setEditable(false);
		BasketArea.setBounds(141, 75, 522, 307);
		BasketArea.setText(" ");
		contentPane.add(BasketArea);
		
		// To read through the text file putting everything in a list of objects and then viewBook(), so print all the books to the screen.
		File dataFile = new File("StockData.txt");
		Scanner fileScanner =  new Scanner(dataFile);
		List<Book> listBook = new ArrayList<Book>();
		List<Paperback> listPaperback = new ArrayList<Paperback>();
		List<eBook> listEbook = new ArrayList<eBook>();
		List<audioBook> listAudioBook = new ArrayList<audioBook>();
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
				listPaperback.add(paper);
				
			}
			else if (details[1].equals(" audiobook")) {
				abook = new audioBook(Integer.parseInt(details[0].trim()), details[1].trim(),
						details[2].trim(), details[3].trim(), details[4].trim(),
						details[5].trim(), Float.parseFloat(details[6].trim()), Integer.parseInt(details[7].trim()),
						Float.parseFloat(details[8].trim()), details[9].trim());
				listBook.add(abook);
				listAudioBook.add(abook);
			}
			else if (details[1].equals(" ebook")) {
				ebook = new eBook(Integer.parseInt(details[0].trim()), details[1].trim(),
						details[2].trim(), details[3].trim(), details[4].trim(),
						details[5].trim(), Float.parseFloat(details[6].trim()), Integer.parseInt(details[7].trim()),
						Integer.parseInt(details[8].trim()), details[9].trim());
				listBook.add(ebook);
				listEbook.add(ebook);
			}
		}
		fileScanner.close();
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bookField.getText().isEmpty() || quantityField.getText().isEmpty() || quantityField.getText().equals("0")) {
					showMessageDialog(null, "Please fill in the informations about the book you want to add");
				}else {
				int num = 0;
				for (ShoppedBook book : user.getShoppingBasket()) {
					// This means book already Shopping Basket
					if (((book.getISBN()) == Integer.parseInt(bookField.getText()))) {
						num = 1;
						showMessageDialog(null, "Book already in Shopping Basket");
					}
				}
				if (num==0) {
					int num1 = 0;
					for (Book books : listBook) {
						if (Integer.toString(books.getISBN()).equals(bookField.getText())){
							// This checks if there is the book in stock
							if (books.getQuantity() == 0) {
								num1=1;
								showMessageDialog(null, "Book out of stock");
							}
							// Checks if quantity requested is lower than quantity in stock
							if (books.getQuantity() < Integer.parseInt(quantityField.getText())) {
								num1=1;
								showMessageDialog(null, "Quantity requested is too much");
							}
							if(num1 == 0) {
								ShoppedBook shoppedBook = null;
								shoppedBook = new ShoppedBook(books.getISBN(), books.getType(), books.getTitle(),
										books.getLanguage(), books.getGenre(), books.getReleaseDate(), books.getPrice(),
										books.getQuantity());
								user.addBookBasket(shoppedBook);
								// This sets the quantity on shopping basket for the selected book to what the user wanted
								for (ShoppedBook book : user.getShoppingBasket()) {
									if (Integer.toString(book.getISBN()).equals(bookField.getText())) {
										book.setQuantity(Integer.parseInt(quantityField.getText()));
									}
								}
								showMessageDialog(null, "Book added to shopping basket");
								break;
							}
						}
					}
					user.setBasketString("");
					for (ShoppedBook books : user.getShoppingBasket()) {
							user.addBasketString( books.toString() + "\n");
						}
					BasketArea.setText(user.getBasketString());
				}
			}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerFrame frame = new CustomerFrame(user);
				frame.setVisible(true);
			}
		});
		
		btnBack.setBounds(10, 10, 85, 21);
		contentPane.add(btnBack);
		
		btnAddBook.setBounds(509, 45, 85, 21);
		contentPane.add(btnAddBook);
		
		JButton btnPayPal = new JButton("Pay by PayPal");
		btnPayPal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.getShoppingBasket().isEmpty()) {
					showMessageDialog(null, "The Shopping Basket is empty");
				}else {
				CheckoutPaypalFrame PayPalFrame = new CheckoutPaypalFrame(user, listEbook, listAudioBook, listPaperback);
				PayPalFrame.setVisible(true);
				dispose();
				}
			}
		});
		btnPayPal.setBounds(10, 217, 121, 21);
		contentPane.add(btnPayPal);
		
		JButton btnPayCredit = new JButton("Pay by Credit Card");
		btnPayCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.getShoppingBasket().isEmpty()) {
					showMessageDialog(null, "The Shopping Basket is empty");
				}else {
				CheckoutCreditCardFrame CreditFrame = new CheckoutCreditCardFrame(user, listEbook, listAudioBook, listPaperback);
				CreditFrame.setVisible(true);
				dispose();
				}
			}
		});
		btnPayCredit.setBounds(10, 186, 121, 21);
		contentPane.add(btnPayCredit);
		

		BasketArea.setText(user.getBasketString());
		
		JButton btnCancel = new JButton("Cancel ");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasketArea.setText("");
				// Writing to the log file
				FileWriter outputFile;
				try {
					outputFile = new FileWriter("ActivityLog.txt", true);
					BufferedWriter bw = new BufferedWriter(outputFile);
					for (ShoppedBook books : user.getShoppingBasket()) {
						bw.write("\n" + user.getUserID() + ", " + user.getAddress2() + ", " +  books.getISBN() + ", " +  books.getPrice() + ", " + 
					books.getQuantity() + ", " + " cancelled" + ", , " + formatted);
					}
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				user.emptyBasket();;
			}
		});
		btnCancel.setBounds(10, 302, 85, 21);
		contentPane.add(btnCancel);
		
		
		
		
		
		
	}
}
