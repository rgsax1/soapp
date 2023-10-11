package flexnyl.com.br.backendsoapp.maintenanceMechanical;


import flexnyl.com.br.backendsoapp.maintenance.Maintenance;
import jakarta.persistence.*;

import java.util.Collection;

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

    @OneToMany(mappedBy = "maintenanceMechanicals")
    private Collection<Maintenance> maintenance;

    public Collection<Maintenance> getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Collection<Maintenance> maintenance) {
        this.maintenance = maintenance;
    }
}
