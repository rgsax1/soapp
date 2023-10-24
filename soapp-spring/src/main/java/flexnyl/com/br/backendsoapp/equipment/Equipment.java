package flexnyl.com.br.backendsoapp.equipment;

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
	
	@NotNull
	@Column(name = "equipment_name")
	private String equipmentName;
	
	@NotNull
	@Column(name = "equipment_sector")
	private String equipmentSector;
	
	@NotNull
	@Column(name = "equipment_manufacturer")
	private String equipmentManufacturer;
	
	@NotNull
	@Column(name = "equipment_model")
	private String equipmentModel;
	
}
