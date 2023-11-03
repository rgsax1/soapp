package flexnyl.com.br.backendsoapp.order;
import flexnyl.com.br.backendsoapp.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "service_order")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "user_operator")
	@NotNull
	private User userOperator;

	private String issueDate;
	private String startServiceDate;
	private String finishServiceDate;
	private String defect;
	private String activityPerformed;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "user_responsible")
	@NotNull
	private User userResponsible;
}
