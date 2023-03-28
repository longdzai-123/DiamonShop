package DiamonShop.Entity;

public class Users {

	private long id;
	private String user;
	private String password;
	private String display_name;
	private String address;
	private int id_categorymember=1;

	public Users() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId_categorymember() {
		return id_categorymember;
	}

	public void setId_categorymember(int id_categorymember) {
		this.id_categorymember = id_categorymember;
	}

}
