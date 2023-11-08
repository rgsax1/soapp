package flexnyl.com.br.backendsoapp.equipment.general;

public class EquipmentGeneralMapper {
	public static EquipmentGeneral mapToEquipmentGeneral(EquipmentGeneralDTO equipmentGeneralDTO) {
		return new EquipmentGeneral (
				equipmentGeneralDTO.getId(),
				equipmentGeneralDTO.getEquipmentManufacturer(),
				equipmentGeneralDTO.getEquipmentModel(),
				equipmentGeneralDTO.getDescription()
				);
	}
	
	public static EquipmentGeneralDTO mapToEquipmentGeneralDTO(EquipmentGeneral equipmentGeneral) {
		return new EquipmentGeneralDTO(
				equipmentGeneral.getId(),
				equipmentGeneral.getEquipmentManufacturer(),
				equipmentGeneral.getEquipmentModel(),
				equipmentGeneral.getDescription()
				);
	}

}
