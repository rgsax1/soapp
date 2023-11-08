package flexnyl.com.br.backendsoapp.equipment.general;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentGeneralDTO {
    private long id;
    private String equipmentManufacturer;
    private String equipmentModel;
    private String description;
}
