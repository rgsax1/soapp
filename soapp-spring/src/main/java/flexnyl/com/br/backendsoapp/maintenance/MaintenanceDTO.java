package flexnyl.com.br.backendsoapp.maintenance;

import java.util.Calendar;
import java.util.List;

import flexnyl.com.br.backendsoapp.maintenanceElectrical.MaintenanceElectrical;
import flexnyl.com.br.backendsoapp.maintenanceMechanical.MaintenanceMechanical;
import flexnyl.com.br.backendsoapp.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceDTO {
    private long id;
	private String maintenanceRecord;
	private int maintenanceReview;
	private Calendar maintenanceEmissionDate;
	private User user;
	private MaintenanceElectrical maintenanceElectricals;
	private MaintenanceMechanical maintenanceMechanicals;
}
