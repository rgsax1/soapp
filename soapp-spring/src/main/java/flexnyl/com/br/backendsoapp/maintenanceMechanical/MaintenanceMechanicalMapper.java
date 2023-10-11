package flexnyl.com.br.backendsoapp.maintenanceMechanical;

public class MaintenanceMechanicalMapper {

    public static MaintenanceMechanical mapToMaintenanceMechanical(MaintenanceMechanicalDTO maintenanceMechanicalDTO) {
        return new MaintenanceMechanical(
                maintenanceMechanicalDTO.getId(),
                maintenanceMechanicalDTO.getType()
        );
    }

    public static MaintenanceMechanicalDTO mapToMaintenanceMechanicalDTO(MaintenanceMechanical maintenanceMechanical) {
        return new MaintenanceMechanicalDTO(
                maintenanceMechanical.getId(),
                maintenanceMechanical.getType()
        );
    }


}
