package flexnyl.com.br.backendsoapp.equipment;

import flexnyl.com.br.backendsoapp.equipment.general.EquipmentGeneral;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "equipment_general_info_id")
	@NotNull
	private EquipmentGeneral equipmentGeneral;

	@Column(name = "installation_date")
	private String installationDate;

	@Column(name = "equipment_sector")
	private String equipmentSector;

	@Column(name = "baptism")
	private String baptism;

}
