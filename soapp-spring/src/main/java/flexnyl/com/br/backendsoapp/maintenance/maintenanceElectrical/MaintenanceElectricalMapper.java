package flexnyl.com.br.backendsoapp.maintenance.maintenanceElectrical;

public class MaintenanceElectricalMapper {

    public static MaintenanceElectrical mapToMaintenanceElectrical (MaintenanceElectricalDTO maintenanceElectricalDTO){
        return new MaintenanceElectrical(
                maintenanceElectricalDTO.getId(),
                maintenanceElectricalDTO.getType()
        );
    }

    public static MaintenanceElectricalDTO mapToMaintenanceElectricalDTO (MaintenanceElectrical maintenanceElectrical){
        return new MaintenanceElectricalDTO(
                maintenanceElectrical.getId(),
                maintenanceElectrical.getType()
        );
    }


}
