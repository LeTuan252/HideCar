package demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class Account {
	public static final String ROLE_MANAGER = "MANAGER";
 //   public static final String ROLE_EMPLOYEE = "EMPLOYEE";
 
    @Id
    @Column(name = "User_Name", length = 20, nullable = false)
    private String userName;
 
    @Column(name = "Pass_word", length = 128, nullable = false)
    private String password;
 
    @Column(name = "Active", length = 1, nullable = false)
    private boolean active;
 
    @Column(name = "User_Role", length = 20, nullable = false)
    private String userRole;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	@Override
	public String toString() {
		return "[" + this.userName + "," + this.password + "," + this.userRole + "]";
	}
}
