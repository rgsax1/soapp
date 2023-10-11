package flexnyl.com.br.backendsoapp.maintenance;

import java.util.Calendar;

import flexnyl.com.br.backendsoapp.maintenanceElectrical.MaintenanceElectrical;
import flexnyl.com.br.backendsoapp.maintenanceMechanical.MaintenanceMechanical;
import flexnyl.com.br.backendsoapp.user.User;


public class MaintenanceDTO {
    private long id;
	private String maintenanceRecord;
	private int maintenanceReview;
	private Calendar maintenanceEmissionDate;
	private User user;
	private MaintenanceElectrical maintenanceElectricals;
	private MaintenanceMechanical maintenanceMechanicals;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMaintenanceRecord() {
		return maintenanceRecord;
	}
	public void setMaintenanceRecord(String maintenanceRecord) {
		this.maintenanceRecord = maintenanceRecord;
	}
	public int getMaintenanceReview() {
		return maintenanceReview;
	}
	public void setMaintenanceReview(int maintenanceReview) {
		this.maintenanceReview = maintenanceReview;
	}
	public Calendar getMaintenanceEmissionDate() {
		return maintenanceEmissionDate;
	}
	public void setMaintenanceEmissionDate(Calendar maintenanceEmissionDate) {
		this.maintenanceEmissionDate = maintenanceEmissionDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MaintenanceElectrical getMaintenanceElectricals() {
		return maintenanceElectricals;
	}
	public void setMaintenanceElectricals(MaintenanceElectrical maintenanceElectricals) {
		this.maintenanceElectricals = maintenanceElectricals;
	}
	public MaintenanceMechanical getMaintenanceMechanicals() {
		return maintenanceMechanicals;
	}
	public void setMaintenanceMechanicals(MaintenanceMechanical maintenanceMechanicals) {
		this.maintenanceMechanicals = maintenanceMechanicals;
	}
	public MaintenanceDTO(long id, String maintenanceRecord, int maintenanceReview, Calendar maintenanceEmissionDate,
			User user, MaintenanceElectrical maintenanceElectricals, MaintenanceMechanical maintenanceMechanicals) {
		super();
		this.id = id;
		this.maintenanceRecord = maintenanceRecord;
		this.maintenanceReview = maintenanceReview;
		this.maintenanceEmissionDate = maintenanceEmissionDate;
		this.user = user;
		this.maintenanceElectricals = maintenanceElectricals;
		this.maintenanceMechanicals = maintenanceMechanicals;
	}
	
	public MaintenanceDTO() {
		
	}
	
	
}
