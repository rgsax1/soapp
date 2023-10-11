package flexnyl.com.br.backendsoapp.maintenance;


public class MaintenanceMapper {
   
	
    public static Maintenance mapToMaintenance (MaintenanceDTO maintenanceDTO){
        return new Maintenance(
        		maintenanceDTO.getId(),
        		maintenanceDTO.getMaintenanceRecord(),
        		maintenanceDTO.getMaintenanceReview(),
        		maintenanceDTO.getMaintenanceEmissionDate(),
        		maintenanceDTO.getUser(),
        		maintenanceDTO.getMaintenanceElectricals(),
        		maintenanceDTO.getMaintenanceMechanicals());
    }
        public static MaintenanceDTO mapToMaintenanceDTO (Maintenance maintenance){
        return new MaintenanceDTO(
        		maintenance.getId(),
        		maintenance.getMaintenanceRecord(),
        		maintenance.getMaintenanceReview(),
        		maintenance.getMaintenanceEmissionDate(),
        		maintenance.getUser(),
        		maintenance.getMaintenanceEletricals(),
        		maintenance.getMaintenanceMechanicals());
    }
}