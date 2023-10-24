package flexnyl.com.br.backendsoapp.maintenance;
import java.util.List;

import flexnyl.com.br.backendsoapp.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
	

	@NotNull
	@Column(name = "maintenance_emission_date")
	private String maintenanceEmissionDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "user_id")
	@NotNull
	private User user;
	

	@ElementCollection
	@CollectionTable(name = "maintenance_electrical_selections", joinColumns = @JoinColumn(name = "maintenance_id"))
	private List<Long> maintenanceElectricalIds;
	
	@ElementCollection
	@CollectionTable(name = "maintenance_mechanical_selections", joinColumns = @JoinColumn(name = "maintenance_id"))
	private List<Long> maintenanceMechanicalIds;
	
}
