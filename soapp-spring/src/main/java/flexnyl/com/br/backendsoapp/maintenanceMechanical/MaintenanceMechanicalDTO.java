package flexnyl.com.br.backendsoapp.maintenanceMechanical;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class MaintenanceMechanicalDTO {
    private long id;
    private String type;

    public MaintenanceMechanicalDTO(){

    }

    public MaintenanceMechanicalDTO(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
