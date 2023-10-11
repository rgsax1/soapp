package flexnyl.com.br.backendsoapp.user;

public enum UserAccessLevel {
	USER("USER"), MANAGER("MANAGER"), ADMIN("ADMIN");
	
	private final String description;

	public String getDescription() {
		return description;
	}

	UserAccessLevel(String description) {
		this.description = description;
	}
	
	
}
