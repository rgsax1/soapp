package flexnyl.com.br.backendsoapp.maintenance;

import flexnyl.com.br.backendsoapp.user.User;


public class MaintenanceDTO {
    private long id;
	private String maintenanceRecord;
	private int maintenanceReview;
	private String maintenanceEmissionDate;
	private String userNameFk;


	public MaintenanceDTO(long id, String maintenanceRecord, int maintenanceReview, String maintenanceEmissionDate, String userNameFk) {
		this.id = id;
		this.maintenanceRecord = maintenanceRecord;
		this.maintenanceReview = maintenanceReview;
		this.maintenanceEmissionDate = maintenanceEmissionDate;
		this.userNameFk = userNameFk;
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

	public String getUserNameFk() {
		return userNameFk;
	}

	public void setUserNameFk(String userNameFk) {
		this.userNameFk = userNameFk;
	}
}
