package flexnyl.com.br.backendsoapp.equipment;

import jakarta.persistence.*;

@Table
@Entity
public class Equipment {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String equipmentName;
	private String equipmentSector;
	private String equipmentManufacturer;
	private String equipmentModel;
	
	public Equipment(long id, String equipmentName, String equipmentSector, String equipmentManufacturer,
			String equipmentModel) {
		super();
		this.id = id;
		this.equipmentName = equipmentName;
		this.equipmentSector = equipmentSector;
		this.equipmentManufacturer = equipmentManufacturer;
		this.equipmentModel = equipmentModel;
	}
	
	public Equipment() {
		
	}

	public long getId() {
		return id;
	}

	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getEquipmentSector() {
		return equipmentSector;
	}
	public void setEquipmentSector(String equipmentSector) {
		this.equipmentSector = equipmentSector;
	}
	public String getEquipmentManufacturer() {
		return equipmentManufacturer;
	}
	public void setEquipmentManufacturer(String equipmentManufacturer) {
		this.equipmentManufacturer = equipmentManufacturer;
	}
	public String getEquipmentModel() {
		return equipmentModel;
	}
	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}
	
	

}
