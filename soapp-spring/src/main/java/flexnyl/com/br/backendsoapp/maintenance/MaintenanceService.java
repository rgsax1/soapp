package flexnyl.com.br.backendsoapp.maintenance;


import java.util.List;

public interface MaintenanceService {

    MaintenanceDTO createMaintenance(MaintenanceDTO maintenanceDTO);

    MaintenanceDTO getMaintenanceById(long id);

    List<MaintenanceDTO> getAllMaintenance();

    MaintenanceDTO updateMaintenance(long id, MaintenanceDTO maintenance);

    void deleteMaintenance(long id);

}
