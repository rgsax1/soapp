package flexnyl.com.br.backendsoapp.equipment.general;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipment_general_info")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EquipmentGeneral{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "equipment_manufacturer")
    private String equipmentManufacturer;

    @Column(name = "equipment_model")
    private String equipmentModel;

    @Column(name = "description")
    private String description;

}
