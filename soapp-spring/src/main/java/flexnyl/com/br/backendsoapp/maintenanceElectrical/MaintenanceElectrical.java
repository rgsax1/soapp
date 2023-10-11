package flexnyl.com.br.backendsoapp.maintenanceElectrical;


import jakarta.persistence.*;

@Entity
@Table (name = "maintenance_electrical")
public class MaintenanceElectrical {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String type;

    public MaintenanceElectrical(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public MaintenanceElectrical() {
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
