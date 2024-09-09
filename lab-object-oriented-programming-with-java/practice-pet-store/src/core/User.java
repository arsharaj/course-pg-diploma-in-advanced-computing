package core;

public class User {
	private String loginId;
	private String password;
	private boolean isAdmin;

	public User(String loginId, String password, boolean isAdmin) {
		this.loginId = loginId;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getPassword() {
		return password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
	
}
