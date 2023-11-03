package flexnyl.com.br.backendsoapp.equipment;

import jakarta.persistence.*;
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

	@Column(name = "equipment_manufacturer")
	private String equipmentManufacturer;

	@Column(name = "equipment_model")
	private String equipmentModel;

	@Column(name = "description")
	private String description;

	@Column(name = "installation_date")
	private String installationDate;

	@Column(name = "equipment_sector")
	private String equipmentSector;

	@Column(name = "baptism")
	private String baptism;

}
