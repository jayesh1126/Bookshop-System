import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class CustomerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2205505846577458064L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public CustomerFrame(Customer user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewBook = new JButton("View Book");
		btnViewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerViewBookFrame viewFrame = null;
				try {
					viewFrame = new CustomerViewBookFrame(user);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				viewFrame.setVisible(true);
				dispose();
			}
		});
		btnViewBook.setBounds(139, 74, 208, 31);
		contentPane.add(btnViewBook);
		
		JButton btnAddBasket = new JButton("Add book to basket");
		btnAddBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookBasketFrame basketFrame = null;
				try {
					basketFrame = new addBookBasketFrame(user);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				basketFrame.setVisible(true);
				dispose();
			}
		});
		btnAddBasket.setBounds(139, 126, 208, 31);
		contentPane.add(btnAddBasket);
		
		JTextArea txtrWelcomeDearCustomer = new JTextArea();
		txtrWelcomeDearCustomer.setEditable(false);
		txtrWelcomeDearCustomer.setText("Welcome dear Customer");
		txtrWelcomeDearCustomer.setBounds(139, 33, 208, 31);
		contentPane.add(txtrWelcomeDearCustomer);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frame = null;
				try {
					frame = new MainFrame();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				frame.setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(10, 10, 85, 31);
		contentPane.add(btnLogout);
		
		JButton btnSearchBook = new JButton("Search Book by Genre");
		btnSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchGenreFrame viewGenreFrame = null;
				try {
					viewGenreFrame = new SearchGenreFrame(user);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				viewGenreFrame.setVisible(true);
				dispose();
			}
		});
		btnSearchBook.setBounds(139, 181, 208, 31);
		contentPane.add(btnSearchBook);
		
		JButton btnSearchListening = new JButton("Search by Listening Length");
		btnSearchListening.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchListeningFrame viewListeningFrame = null;
				try {
					viewListeningFrame = new SearchListeningFrame(user);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				viewListeningFrame.setVisible(true);
				dispose();
			}
		});
		btnSearchListening.setBounds(139, 232, 208, 31);
		contentPane.add(btnSearchListening);
		

	}
}
