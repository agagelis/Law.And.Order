package lno.object.model.domain;
import javax.persistence.*;

@Entity
@Table(name="users")

public class User {
	
	@Id
    @Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name="firstName", length=200, nullable=false)
	private String firstName;

	@Column(name="lastName", length=200, nullable=false)
	private String lastName;
	
	@Column(name="username", length=200, nullable=false)
	private String username;

	@Column(name="password", length=20, nullable=false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="userright", nullable=false)
	private Permission userright;
	
	public User(){
		
	}
	
	public User(String fname, String lname, String uname, String pass, Permission uright) {
		this.firstName=fname;
		this.lastName=lname;
		this.username=uname;
		this.password=pass;
		this.userright=uright;
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Permission getUserright() {
		return userright;
	}

	public void setUserright(String userright) {
		try {
			this.userright = Permission.valueOf(userright);
		} catch (Exception e) {
			this.userright = null;
		}
	}
}

