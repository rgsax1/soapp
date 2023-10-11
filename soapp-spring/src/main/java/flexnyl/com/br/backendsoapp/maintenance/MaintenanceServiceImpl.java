package flexnyl.com.br.backendsoapp.maintenance;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import flexnyl.com.br.backendsoapp.exception.ResourceNotFoundException;


@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private MaintenanceRepository maintenanceRepository;
    
    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
		super();
		this.maintenanceRepository = maintenanceRepository;
	}

	@Override
    public MaintenanceDTO createMaintenance(MaintenanceDTO maintenanceDTO) {
        Maintenance maintenance = MaintenanceMapper.mapToMaintenance(maintenanceDTO);
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
    	maintenance.setMaintenanceEletricals(updatedMaintenance.getMaintenanceElectricals());
    	maintenance.setMaintenanceEmissionDate(updatedMaintenance.getMaintenanceEmissionDate());
    	maintenance.setMaintenanceMechanicals(updatedMaintenance.getMaintenanceMechanicals());
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
