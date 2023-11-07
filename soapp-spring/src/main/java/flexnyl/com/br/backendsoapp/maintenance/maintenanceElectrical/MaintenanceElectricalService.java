package flexnyl.com.br.backendsoapp.maintenance.maintenanceElectrical;

import java.util.List;

public interface MaintenanceElectricalService {

    MaintenanceElectricalDTO createMaintenanceElectrical(MaintenanceElectricalDTO maintenanceElectricalDTO);

    MaintenanceElectricalDTO getMaintenanceElectricalById(long id);

    List<MaintenanceElectricalDTO> getAllMaintenanceElectrical();

    MaintenanceElectricalDTO updateMaintenanceElectrical(long id, MaintenanceElectricalDTO maintenanceElectricalDTO);

    void deleteMaintenanceElectrical(long id);
}
