package flexnyl.com.br.backendsoapp.maintenance;

import java.util.List;
import java.util.stream.Collectors;

import flexnyl.com.br.backendsoapp.user.User;
import flexnyl.com.br.backendsoapp.user.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import flexnyl.com.br.backendsoapp.exception.ResourceNotFoundException;


@AllArgsConstructor
@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
	private final UserRepository userRepository;
	
	@Override
	public MaintenanceDTO createMaintenance(MaintenanceDTO maintenanceDTO) {
	    Maintenance maintenance = MaintenanceMapper.mapToMaintenance(maintenanceDTO);

	    User user = userRepository.findById(maintenanceDTO.getUserId())
	            .orElseThrow(() -> new ResourceNotFoundException("User with id " + maintenanceDTO.getUserId() + " not found."));

	    maintenance.setUser(user);

	    List<Long> electricalIds = maintenanceDTO.getMaintenanceElectricalIds();
	    maintenance.setMaintenanceElectricalIds(electricalIds);
	    
	    List<Long> mechanicalIds = maintenanceDTO.getMaintenanceMechanicalIds();
	    maintenance.setMaintenanceMechanicalIds(mechanicalIds);
	    

	    Maintenance savedMaintenance = maintenanceRepository.save(maintenance);

	    return MaintenanceMapper.mapToMaintenanceDTO(savedMaintenance);
	}




	@Override
    public MaintenanceDTO getMaintenanceById(long id) {
    	Maintenance maintenance = maintenanceRepository.findById(id)
    			.orElseThrow(()-> new ResourceNotFoundException("Maintenance with id: "+id+ "not found."));
    	return MaintenanceMapper.mapToMaintenanceDTO(maintenance);
    }

    @Override
    public List<MaintenanceDTO> getAllMaintenance() {
    	List<Maintenance> maintenances = maintenanceRepository.findAll();
    	return maintenances.stream().map(MaintenanceMapper::mapToMaintenanceDTO)
    			.collect(Collectors.toList());
    }

    @Override
    public MaintenanceDTO updateMaintenance(long id, MaintenanceDTO updatedMaintenance) {
    	Maintenance maintenance = maintenanceRepository.findById(id).orElseThrow(
    			() -> new ResourceNotFoundException("Maintenance with id: "+id+ "not found.")
    			);
    	maintenance.setMaintenanceEmissionDate(updatedMaintenance.getMaintenanceEmissionDate());
    	maintenance.setMaintenanceRecord(updatedMaintenance.getMaintenanceRecord());
    	maintenance.setMaintenanceReview(updatedMaintenance.getMaintenanceReview());
    	
    	Maintenance updatedMaintenanceObj = maintenanceRepository.save(maintenance);
    	return MaintenanceMapper.mapToMaintenanceDTO(updatedMaintenanceObj);
    }

    @Override
    public void deleteMaintenance(long id) {
    	maintenanceRepository.findById(id).orElseThrow(
    			() -> new ResourceNotFoundException("Maintenance with id: "+id+ "not found."));
    	maintenanceRepository.deleteById(id);
    }

}
