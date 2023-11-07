package flexnyl.com.br.backendsoapp.maintenance.maintenanceMechanical;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "maintenance_mechanical")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceMechanical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    @Column(name = "type")
    private String type;
}
