package flexnyl.com.br.backendsoapp.maintenance;

import java.util.List;

public class MaintenanceMapper {


    public static Maintenance mapToMaintenance(MaintenanceDTO maintenanceDTO) {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceRecord(maintenanceDTO.getMaintenanceRecord());
        maintenance.setMaintenanceReview(maintenanceDTO.getMaintenanceReview());
        maintenance.setMaintenanceEmissionDate(maintenanceDTO.getMaintenanceEmissionDate());
        return maintenance;
    }
    
    public static MaintenanceDTO mapToMaintenanceDTO(Maintenance maintenance) {
        List<Long> electricalIds = maintenance.getMaintenanceElectricalIds();
        List<Long> mechanicalIds = maintenance.getMaintenanceMechanicalIds();

        return new MaintenanceDTO(
                maintenance.getId(),
                maintenance.getMaintenanceRecord(),
                maintenance.getMaintenanceReview(),
                maintenance.getMaintenanceEmissionDate(),
                maintenance.getUser().getId(),
                mechanicalIds,
                electricalIds
        );
    }
}