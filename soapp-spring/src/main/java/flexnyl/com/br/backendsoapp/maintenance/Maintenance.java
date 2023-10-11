package flexnyl.com.br.backendsoapp.maintenance;

import java.util.Calendar;

import flexnyl.com.br.backendsoapp.maintenanceElectrical.MaintenanceElectrical;
import flexnyl.com.br.backendsoapp.maintenanceMechanical.MaintenanceMechanical;
import flexnyl.com.br.backendsoapp.user.User;
import jakarta.persistence.*;


@Table (name = "maintenance")
@Entity
public class Maintenance {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String maintenanceRecord;
	private int maintenanceReview;
	private Calendar maintenanceEmissionDate;
	
	@ManyToOne
	@JoinColumn (name = "user_id")
	private User user;


	@ManyToOne
	@JoinColumn (name = "maintenance_electrical_id")
	private MaintenanceElectrical maintenanceEletricals;

	@ManyToOne
	@JoinColumn (name = "maintenance_mechanical_id")
	private MaintenanceMechanical maintenanceMechanicals;

	public Maintenance(long id, String maintenanceRecord, int maintenanceReview, Calendar maintenanceEmissionDate, User user, MaintenanceElectrical maintenanceEletricals, MaintenanceMechanical maintenanceMechanical) {
		this.id = id;
		this.maintenanceRecord = maintenanceRecord;
		this.maintenanceReview = maintenanceReview;
		this.maintenanceEmissionDate = maintenanceEmissionDate;
		this.user = user;
		this.maintenanceEletricals = maintenanceEletricals;
		this.maintenanceMechanicals = maintenanceMechanical;
	}

	public Maintenance() {
	}

	public long getId() {
		return id;
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

	public MaintenanceElectrical getMaintenanceEletricals() {
		return maintenanceEletricals;
	}

	public void setMaintenanceEletricals(MaintenanceElectrical maintenanceEletricals) {
		this.maintenanceEletricals = maintenanceEletricals;
	}

	public MaintenanceMechanical getMaintenanceMechanicals() {
		return maintenanceMechanicals;
	}

	public void setMaintenanceMechanicals(MaintenanceMechanical maintenanceMechanical) {
		this.maintenanceMechanicals = maintenanceMechanical;
	}
}
