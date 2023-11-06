
public class User {
	// Fields
	private int userID;
	private String username;
	private String surname;
	private int address1;
	private String address2;
	private String address3;
	private String role;
	
	// Constructors
	public User(int userID, String username, String surname, int address1, String address2, String address3, String role) {
		this.userID = userID;
		this.username = username;
		this.surname = surname;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.role = role;
}
	// Method
	public String toString() {
		return (getUserID() + ", " + getUsername() + ", " + getSurname() + ", " + getAddress1() + ", " + getAddress2() + ", " + getAddress3()
		+ ", " + getRole());
	}
	
	
	public int getUserID() {
		return this.userID;
		}
	public String getUsername() {
		return this.username;
		}
	public String getSurname() {
		return this.surname;
		}
	public int getAddress1() {
		return this.address1;
		}
	public String getAddress2() {
		return this.address2;
		}
	public String getAddress3() {
		return this.address3;
		}
	public String getRole() {
		return this.role;
		}
}
