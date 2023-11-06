import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4004287291865062891L;
	private JPanel contentPane;
	private JTextField txtUserSelect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public MainFrame() throws FileNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List<ShoppedBook> ShoppingBasket = new ArrayList<ShoppedBook>();
		
		
		// Retrieve information about the text file to display it
		File accountFile =  new File("UserAccounts.txt");
		Scanner accountScanner = new Scanner(accountFile);
		List<User> listUser =  new ArrayList<User>();
		List<Customer> listCustomer =  new ArrayList<Customer>();
		User account = null;
		Customer customer = null;
		String BasketString = "";
		
		while(accountScanner.hasNextLine()) {
			String[] accounts = accountScanner.nextLine().split(",");
				account =  new User(Integer.parseInt(accounts[0].trim()), accounts[1].trim(), accounts[2].trim(), Integer.parseInt(accounts[3].trim()),
						accounts[4].trim(), accounts[5].trim(), accounts[6].trim());
				listUser.add(account);
				customer =  new Customer(Integer.parseInt(accounts[0].trim()), accounts[1].trim(), accounts[2].trim(), Integer.parseInt(accounts[3].trim()),
						accounts[4].trim(), accounts[5].trim(), accounts[6].trim(), ShoppingBasket, BasketString);
				listCustomer.add(customer);
			}
		accountScanner.close();
		
		JButton btnAdmin = new JButton("Smith");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFrame aFrame = new AdminFrame(listUser.get(0));
				aFrame.setVisible(true);
				dispose();
			}
		});
		
		btnAdmin.setBounds(10, 112, 85, 21);
		contentPane.add(btnAdmin);
		
		JButton btnCustomer1 = new JButton("Williams");
		btnCustomer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFrame cFrame = new CustomerFrame(listCustomer.get(1));
				cFrame.setVisible(true);
				dispose();
			}
		});
		btnCustomer1.setBounds(123, 112, 85, 21);
		contentPane.add(btnCustomer1);
		
		JButton btnCustomer2 = new JButton("Taylor");
		btnCustomer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFrame cFrame = new CustomerFrame(listCustomer.get(2));
				cFrame.setVisible(true);
				dispose();
			}
		});
		btnCustomer2.setBounds(235, 112, 85, 21);
		contentPane.add(btnCustomer2);
		
		JButton btnCustomer3 = new JButton("Lee");
		btnCustomer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFrame cFrame = new CustomerFrame(listCustomer.get(3));
				cFrame.setVisible(true);
				dispose();
			}
		});
		btnCustomer3.setBounds(341, 112, 85, 21);
		contentPane.add(btnCustomer3);
		
		txtUserSelect = new JTextField();
		txtUserSelect.setEditable(false);
		txtUserSelect.setText("Select the user you want to logged into");
		txtUserSelect.setBounds(92, 10, 250, 78);
		contentPane.add(txtUserSelect);
		txtUserSelect.setColumns(10);
		
		
		
		JTextArea txtUserDisplay = new JTextArea();
		txtUserDisplay.setEditable(false);
		txtUserDisplay.setText(listUser.get(0).toString() + "\n" + listUser.get(1).toString() + "\n" + listUser.get(2).toString()
				 + "\n" + listUser.get(3).toString());
		txtUserDisplay.setBounds(20, 143, 406, 110);
		contentPane.add(txtUserDisplay);
	}
}
