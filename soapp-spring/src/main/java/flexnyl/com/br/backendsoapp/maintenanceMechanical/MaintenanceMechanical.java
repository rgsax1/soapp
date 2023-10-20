package flexnyl.com.br.backendsoapp.maintenanceMechanical;

import jakarta.persistence.*;
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

    private String type;

   
}
