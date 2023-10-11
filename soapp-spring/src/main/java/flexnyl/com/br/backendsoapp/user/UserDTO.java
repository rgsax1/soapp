package flexnyl.com.br.backendsoapp.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String jobTitle;
	private UserAccessLevel userAccessLevel;
}
