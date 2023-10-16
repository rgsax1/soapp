package flexnyl.com.br.backendsoapp.maintenance;
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
	

	@Column(name = "maintenance_emission_date")
	private String maintenanceEmissionDate;
	
	@ManyToOne
	@JoinColumn (name = "user_id")
	private User user;


	public Maintenance(long id, String maintenanceRecord, int maintenanceReview, String maintenanceEmissionDate, User user) {
		this.id = id;
		this.maintenanceRecord = maintenanceRecord;
		this.maintenanceReview = maintenanceReview;
		this.maintenanceEmissionDate = maintenanceEmissionDate;
		this.user = user;
	}

	public Maintenance(){

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

	public String getMaintenanceEmissionDate() {
		return maintenanceEmissionDate;
	}

	public void setMaintenanceEmissionDate(String maintenanceEmissionDate) {
		this.maintenanceEmissionDate = maintenanceEmissionDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
