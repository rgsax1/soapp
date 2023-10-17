package flexnyl.com.br.backendsoapp.maintenance;

import flexnyl.com.br.backendsoapp.user.User;

import java.util.List;
import java.util.Optional;

public interface MaintenanceService {

    MaintenanceDTO createMaintenance(MaintenanceDTO maintenanceDTO);

    MaintenanceDTO getMaintenanceById(long id);

    List<MaintenanceDTO> getAllMaintenance();

    MaintenanceDTO updateMaintenance(long id, MaintenanceDTO maintenance);

    void deleteMaintenance(long id);

}
