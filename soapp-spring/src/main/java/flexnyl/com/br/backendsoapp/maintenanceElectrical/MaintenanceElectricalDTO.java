package flexnyl.com.br.backendsoapp.maintenanceElectrical;


public class MaintenanceElectricalDTO {
    private long id;
    private String type;
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
	public MaintenanceElectricalDTO(long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
    
    public MaintenanceElectricalDTO() {
    	
    }
}
