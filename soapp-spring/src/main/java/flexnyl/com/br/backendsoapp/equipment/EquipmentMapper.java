package flexnyl.com.br.backendsoapp.equipment;

public class EquipmentMapper {
    public static Equipment mapToEquipment(EquipmentDTO equipmentDTO) {
    		Equipment equipment = new Equipment();
    		equipment.setEquipmentSector(equipmentDTO.getEquipmentSector());
    		equipment.setBaptism(equipmentDTO.getBaptism());
    		equipment.setInstallationDate(equipment.getInstallationDate());
            return equipment;
    }

    public static EquipmentDTO mapToEquipmentDTO(Equipment equipment) {
        return new EquipmentDTO (
            equipment.getId(),
            equipment.getEquipmentGeneral().getId(),
            equipment.getEquipmentSector(),
            equipment.getBaptism(),
            equipment.getInstallationDate());
    }
}
