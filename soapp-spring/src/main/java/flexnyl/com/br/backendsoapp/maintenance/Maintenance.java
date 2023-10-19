package flexnyl.com.br.backendsoapp.maintenance;
import flexnyl.com.br.backendsoapp.maintenanceElectrical.MaintenanceElectrical;
import flexnyl.com.br.backendsoapp.maintenanceMechanical.MaintenanceMechanical;
import flexnyl.com.br.backendsoapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table (name = "maintenance")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Maintenance {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String maintenanceRecord;
	private int maintenanceReview;
	

	@Column(name = "maintenance_emission_date")
	private String maintenanceEmissionDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "equipment_electrical_id")
	private MaintenanceElectrical maintenanceElectrical;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "equipment_mechanical_id")
	private MaintenanceMechanical maintenanceMechanical;
	
}
