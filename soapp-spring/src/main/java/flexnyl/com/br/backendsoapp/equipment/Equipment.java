package flexnyl.com.br.backendsoapp.equipment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Equipment {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String equipmentName;
	private String equipmentSector;
	private String equipmentManufacturer;
	private String equipmentModel;

}
