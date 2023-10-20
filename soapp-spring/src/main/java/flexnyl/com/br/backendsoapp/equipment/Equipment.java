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
	private String equipmentName;
	private String equipmentSector;
	private String equipmentManufacturer;
	private String equipmentModel;
	
}
