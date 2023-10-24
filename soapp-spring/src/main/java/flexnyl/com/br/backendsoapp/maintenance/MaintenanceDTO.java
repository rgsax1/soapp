package flexnyl.com.br.backendsoapp.maintenance;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MaintenanceDTO {
    private long id;
	private String maintenanceRecord;
	private int maintenanceReview;
	private String maintenanceEmissionDate;
	private long userId;
	private List<Long> maintenanceMechanicalIds;
	private List<Long> maintenanceElectricalIds;
}
