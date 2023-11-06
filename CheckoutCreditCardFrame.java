import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;

public class CheckoutCreditCardFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2044216978342630451L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public CheckoutCreditCardFrame(Customer user, List<eBook> listEbook, List<audioBook> listAudioBook, List<Paperback> listPaperback) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea BasketArea = new JTextArea();
		BasketArea.setEditable(false);
		BasketArea.setBounds(10, 45, 732, 350);
		contentPane.add(BasketArea);
		
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String formatted = df.format(new Date());
		
		BasketArea.setText(user.getBasketString());
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				addBookBasketFrame aFrame = null;
				try {
					aFrame = new addBookBasketFrame(user);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				aFrame.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(244, 11, 171, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(503, 11, 127, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Account no.");
		lblNewLabel.setBounds(169, 14, 85, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CCV");
		lblNewLabel_1.setBounds(467, 14, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Pay");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty() || textField_1.getText().isEmpty()) {
					showMessageDialog(null, "Please fill in the informations about your credit card");
				}else {
				// Writing to the log file
				FileWriter outputFile;
				try {
					outputFile = new FileWriter("ActivityLog.txt", true);
					BufferedWriter bw = new BufferedWriter(outputFile);
					for (ShoppedBook books : user.getShoppingBasket()) {
						bw.write("\n" + user.getUserID() + ", " + user.getAddress2() + ", " +  books.getISBN() + ", " +  books.getPrice() + ", " + 
					books.getQuantity() + ", " + "purchased" + ", " + "Credit Card"+ ", " + formatted);
					}
					bw.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				// Here we are calculating the total price of the shopping basket
				float totalPrice = 0;
				for (ShoppedBook books : user.getShoppingBasket()) {
					totalPrice += books.calculateTotalPrice();
				}
				showMessageDialog(null, totalPrice + " paid using Credit Card");
				
				// Updating the listBook and then writing stock data.txt again with the new quantity of books
				for (ShoppedBook books: user.getShoppingBasket()) {
					for (eBook book : listEbook) {
						if (books.getISBN() == (book.getISBN())) {
							book.setQuantity(book.getQuantity() - books.getQuantity());
						}
					}
					for (audioBook book : listAudioBook) {
						if (books.getISBN() == (book.getISBN())) {
							book.setQuantity(book.getQuantity() - books.getQuantity());
						}
					}
					for (Paperback book : listPaperback) {
						if (books.getISBN() == (book.getISBN())) {
							book.setQuantity(book.getQuantity() - books.getQuantity());
						}
					}
				}
				FileWriter outputFile1;
				try {
					outputFile1 = new FileWriter("StockData.txt", false);
					BufferedWriter bw1 = new BufferedWriter(outputFile1);
					int num = 0;
						for (eBook books : listEbook) {
							if (num==0) {
							bw1.write(books.toString());
							num=1;
							}else {
								bw1.write("\n" + books.toString());
							}
						}
							for (audioBook books : listAudioBook) {
								if (num==0) {
								bw1.write(books.toString());
								num=1;
								}else {
									bw1.write("\n" + books.toString());
								}
						}
							for (Paperback books : listPaperback) {
								if (num==0) {
								bw1.write(books.toString());
								num=1;
								}else {
									bw1.write("\n" + books.toString());
								}
							}
					bw1.close();
					user.emptyBasket();;
					dispose();
					addBookBasketFrame aFrame = new addBookBasketFrame(user);
					aFrame.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				}
			}
		});
		btnNewButton_1.setBounds(657, 10, 85, 21);
		contentPane.add(btnNewButton_1);
	}

}
