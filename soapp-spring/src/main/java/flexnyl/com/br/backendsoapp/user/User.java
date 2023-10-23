package flexnyl.com.br.backendsoapp.user;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "tb_user")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private final long id;
	
	@NotBlank
	@Column(unique = true, name = "user_name")
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String jobTitle;
	private UserAccessLevel userAccessLevel;

}
