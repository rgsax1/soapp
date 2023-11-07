package flexnyl.com.br.backendsoapp.maintenance.maintenanceElectrical;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "maintenance_electrical")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceElectrical {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String type;

}
