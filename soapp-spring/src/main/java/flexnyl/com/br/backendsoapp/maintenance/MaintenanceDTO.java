package flexnyl.com.br.backendsoapp.maintenance;

import flexnyl.com.br.backendsoapp.user.User;


public class MaintenanceDTO {
    private long id;
	private String maintenanceRecord;
	private int maintenanceReview;
	private String maintenanceEmissionDate;
	private User user;

	public MaintenanceDTO(long id, String maintenanceRecord, int maintenanceReview, String maintenanceEmissionDate, User user) {
		this.id = id;
		this.maintenanceRecord = maintenanceRecord;
		this.maintenanceReview = maintenanceReview;
		this.maintenanceEmissionDate = maintenanceEmissionDate;
		this.user = user;
	}

	public MaintenanceDTO() {
	}

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
