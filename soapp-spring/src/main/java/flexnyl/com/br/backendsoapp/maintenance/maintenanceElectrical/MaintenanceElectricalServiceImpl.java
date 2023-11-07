package flexnyl.com.br.backendsoapp.maintenance.maintenanceElectrical;


import flexnyl.com.br.backendsoapp.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MaintenanceElectricalServiceImpl implements MaintenanceElectricalService {
    private final MaintenanceElectricalRepository maintenanceElectricalRepository;
  
    @Override
    public MaintenanceElectricalDTO createMaintenanceElectrical(MaintenanceElectricalDTO maintenanceElectricalDTO) {
        MaintenanceElectrical maintenanceElectrical = MaintenanceElectricalMapper.mapToMaintenanceElectrical(maintenanceElectricalDTO);
        MaintenanceElectrical savedMaintenanceElectrical = maintenanceElectricalRepository.save(maintenanceElectrical);
        return MaintenanceElectricalMapper.mapToMaintenanceElectricalDTO(savedMaintenanceElectrical);
    }

    @Override
    public MaintenanceElectricalDTO getMaintenanceElectricalById(long id) {
        MaintenanceElectrical maintenanceElectrical = maintenanceElectricalRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Electrical maintenance with id: "+id+" not found."));
        return MaintenanceElectricalMapper.mapToMaintenanceElectricalDTO(maintenanceElectrical);
    }

    @Override
    public List<MaintenanceElectricalDTO> getAllMaintenanceElectrical() {
        List<MaintenanceElectrical> maintenanceElectricals = maintenanceElectricalRepository.findAll();
        return maintenanceElectricals.stream().map(MaintenanceElectricalMapper::mapToMaintenanceElectricalDTO).collect(Collectors.toList());
    }

    @Override
    public MaintenanceElectricalDTO updateMaintenanceElectrical(long id, MaintenanceElectricalDTO updatedMaintenanceElectrical) {
        MaintenanceElectrical maintenanceElectrical = maintenanceElectricalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Electrical maintenance with id: " + id+ " not found."));
        maintenanceElectrical.setType(updatedMaintenanceElectrical.getType());
        MaintenanceElectrical updatedMaintenanceElectricalObj = maintenanceElectricalRepository.save(maintenanceElectrical);
        return MaintenanceElectricalMapper.mapToMaintenanceElectricalDTO(updatedMaintenanceElectricalObj);
    }

    @Override
    public void deleteMaintenanceElectrical(long id) {
        maintenanceElectricalRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Maintenance with id "+id+" not found."));
        maintenanceElectricalRepository.deleteById(id);

    }
}
