package flexnyl.com.br.backendsoapp.order;

import java.util.Calendar;
import flexnyl.com.br.backendsoapp.equipment.Equipment;
import flexnyl.com.br.backendsoapp.user.User;
import jakarta.persistence.*;
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
	private Calendar issueData;
	private Calendar completionData;
	private String observations;
	private String analysis;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Equipment equipment;
	private String signatureResponsible;
	private String signatureMechanical;
	
}
