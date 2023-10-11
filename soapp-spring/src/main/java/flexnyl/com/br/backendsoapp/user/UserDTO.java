package flexnyl.com.br.backendsoapp.user;


public class UserDTO {
	private long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String jobTitle;
	private UserAccessLevel userAccessLevel;
	
	public UserDTO(long id, String userName, String firstName, String lastName, String password, String jobTitle,
			UserAccessLevel userAccessLevel) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.jobTitle = jobTitle;
		this.userAccessLevel = userAccessLevel;
	}
	
	public UserDTO() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public UserAccessLevel getUserAccessLevel() {
		return userAccessLevel;
	}

	public void setUserAccessLevel(UserAccessLevel userAccessLevel) {
		this.userAccessLevel = userAccessLevel;
	}
	
	
}
