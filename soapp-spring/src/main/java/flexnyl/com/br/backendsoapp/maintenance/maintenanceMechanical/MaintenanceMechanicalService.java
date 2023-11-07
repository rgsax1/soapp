package flexnyl.com.br.backendsoapp.maintenance.maintenanceMechanical;

import java.util.List;

public interface MaintenanceMechanicalService {

    MaintenanceMechanicalDTO createMaintenanceMechanical(MaintenanceMechanicalDTO maintenanceMechanicalDTO);

    MaintenanceMechanicalDTO getMaintenanceMechanicalById(long id);

    List<MaintenanceMechanicalDTO> getAllMaintenanceMechanical();

    MaintenanceMechanicalDTO updateMaintenanceMechanical(long id, MaintenanceMechanicalDTO maintenanceMechanicalDTO);

    void deleteMaintenanceMechanical(long id);
}
