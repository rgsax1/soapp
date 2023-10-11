package flexnyl.com.br.backendsoapp.maintenanceMechanical;

import jakarta.persistence.*;


@Entity
@Table(name = "maintenance_mechanical")
public class MaintenanceMechanical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    public MaintenanceMechanical(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public MaintenanceMechanical() {
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
