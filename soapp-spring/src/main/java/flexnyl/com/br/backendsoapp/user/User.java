package flexnyl.com.br.backendsoapp.user;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "tb_user")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String jobTitle;
	private UserAccessLevel userAccessLevel;
}
