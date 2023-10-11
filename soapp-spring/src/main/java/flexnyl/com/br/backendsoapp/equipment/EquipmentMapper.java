package flexnyl.com.br.backendsoapp.equipment;

public class EquipmentMapper {


    public static Equipment mapToEquipment(EquipmentDTO equipmentDTO){
        return new Equipment(
            equipmentDTO.getId(),
            equipmentDTO.getEquipmentName(),
            equipmentDTO.getEquipmentSector(),
            equipmentDTO.getEquipmentManufacturer(),
            equipmentDTO.getEquipmentModel()
        );
    }

    public static EquipmentDTO mapToEquipmentDTO (Equipment equipment){
        return new EquipmentDTO(
            equipment.getId(),
            equipment.getEquipmentName(),
            equipment.getEquipmentSector(),
            equipment.getEquipmentManufacturer(),
            equipment.getEquipmentModel()
        );
    }
}