import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class AdminFrame extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3184218131945746791L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminFrame(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BtnViewBook = new JButton("View Book");
		BtnViewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewBookFrame viewFrame = null;
				try {
					viewFrame = new AdminViewBookFrame(user);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				viewFrame.setVisible(true);
				dispose();
			}
		});
		BtnViewBook.setBounds(162, 103, 96, 31);
		contentPane.add(BtnViewBook);
		
		JButton BtnAddBook = new JButton("Add a book");
		BtnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookFrame addBookFrame = null;
				try {
					addBookFrame = new AddBookFrame(user);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				addBookFrame.setVisible(true);
				dispose();
			}
		});
		BtnAddBook.setBounds(162, 171, 96, 31);
		contentPane.add(BtnAddBook);
		
		JTextArea txtrWelcomeAdmin = new JTextArea();
		txtrWelcomeAdmin.setEditable(false);
		txtrWelcomeAdmin.setText("Welcome Admin");
		txtrWelcomeAdmin.setBounds(162, 41, 110, 22);
		contentPane.add(txtrWelcomeAdmin);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame frame = null;
				try {
					frame = new MainFrame();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				frame.setVisible(true);
			}
		});
		btnLogout.setBounds(10, 10, 85, 21);
		contentPane.add(btnLogout);
	}

}
