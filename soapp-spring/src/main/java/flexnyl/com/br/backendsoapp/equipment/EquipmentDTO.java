package flexnyl.com.br.backendsoapp.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {
    private long id;
    private String equipmentManufacturer;
    private String equipmentModel;
    private String description;
    private String installationDate;
    private String equipmentSector;
    private String baptism;
}
