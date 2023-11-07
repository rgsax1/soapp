package flexnyl.com.br.backendsoapp.maintenance.maintenanceMechanical;


import flexnyl.com.br.backendsoapp.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class MaintenanceMechanicalServiceImpl implements MaintenanceMechanicalService {

    private final MaintenanceMechanicalRepository maintenanceMechanicalRepository;

    @Override
    public MaintenanceMechanicalDTO createMaintenanceMechanical(MaintenanceMechanicalDTO maintenanceMechanicalDTO) {
        MaintenanceMechanical maintenanceMechanical = MaintenanceMechanicalMapper.mapToMaintenanceMechanical(maintenanceMechanicalDTO);
        MaintenanceMechanical savedMaintenanceMechanical = maintenanceMechanicalRepository.save(maintenanceMechanical);
        return MaintenanceMechanicalMapper.mapToMaintenanceMechanicalDTO(savedMaintenanceMechanical);
    }

    @Override
    public MaintenanceMechanicalDTO getMaintenanceMechanicalById(long id) {
        MaintenanceMechanical maintenanceMechanical = maintenanceMechanicalRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Electrical maintenance with id: "+id+" not found."));
        return MaintenanceMechanicalMapper.mapToMaintenanceMechanicalDTO(maintenanceMechanical);
    }

    @Override
    public List<MaintenanceMechanicalDTO> getAllMaintenanceMechanical() {
        List<MaintenanceMechanical> maintenanceMechanicals = maintenanceMechanicalRepository.findAll();
        return maintenanceMechanicals.stream().map(MaintenanceMechanicalMapper::mapToMaintenanceMechanicalDTO).collect(Collectors.toList());
    }

    @Override
    public MaintenanceMechanicalDTO updateMaintenanceMechanical(long id, MaintenanceMechanicalDTO updatedMaintenanceMechanical) {
        MaintenanceMechanical maintenanceMechanical = maintenanceMechanicalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Electrical maintenance with id: " + id+ " not found."));
        maintenanceMechanical.setType(updatedMaintenanceMechanical.getType());
        MaintenanceMechanical updatedMaintenanceMechanicalObj = maintenanceMechanicalRepository.save(maintenanceMechanical);
        return MaintenanceMechanicalMapper.mapToMaintenanceMechanicalDTO(updatedMaintenanceMechanicalObj);
    }

    @Override
    public void deleteMaintenanceMechanical(long id) {
        maintenanceMechanicalRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Maintenance with id "+id+" not found."));
        maintenanceMechanicalRepository.deleteById(id);

    }
}
