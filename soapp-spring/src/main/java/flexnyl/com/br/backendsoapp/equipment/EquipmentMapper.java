package flexnyl.com.br.backendsoapp.equipment;

public class EquipmentMapper {
    public static Equipment mapToEquipment(EquipmentDTO equipmentDTO) {
        return new Equipment(
            equipmentDTO.getId(),
            equipmentDTO.getEquipmentManufacturer(),
            equipmentDTO.getEquipmentModel(),
            equipmentDTO.getDescription(),
            equipmentDTO.getInstallationDate(),
            equipmentDTO.getEquipmentSector(),
            equipmentDTO.getBaptism()
        );
    }

    public static EquipmentDTO mapToEquipmentDTO(Equipment equipment) {
        return new EquipmentDTO(
            equipment.getId(),
            equipment.getEquipmentManufacturer(),
            equipment.getEquipmentModel(),
            equipment.getDescription(),
            equipment.getInstallationDate(),
            equipment.getEquipmentSector(),
            equipment.getBaptism()
        );
    }
}
