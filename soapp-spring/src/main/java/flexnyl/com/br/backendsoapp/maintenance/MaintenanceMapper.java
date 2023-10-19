package flexnyl.com.br.backendsoapp.maintenance;


public class MaintenanceMapper {


    public static Maintenance mapToMaintenance(MaintenanceDTO maintenanceDTO) {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceRecord(maintenanceDTO.getMaintenanceRecord());
        maintenance.setMaintenanceReview(maintenanceDTO.getMaintenanceReview());
        maintenance.setMaintenanceEmissionDate(maintenanceDTO.getMaintenanceEmissionDate());
        return maintenance;
    }

    public static MaintenanceDTO mapToMaintenanceDTO(Maintenance maintenance) {
        return new MaintenanceDTO(
                maintenance.getId(),
                maintenance.getMaintenanceRecord(),
                maintenance.getMaintenanceReview(),
                maintenance.getMaintenanceEmissionDate(),
                maintenance.getUser().getId(),
                maintenance.getMaintenanceElectrical().getId(),
                maintenance.getMaintenanceMechanical().getId()
        );
    }
}