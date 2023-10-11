package flexnyl.com.br.backendsoapp.maintenanceMechanical;


public class MaintenanceMechanicalDTO {
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

	public MaintenanceMechanicalDTO(long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
    
    public MaintenanceMechanicalDTO() {
    	
    }
}
