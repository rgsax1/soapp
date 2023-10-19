package flexnyl.com.br.backendsoapp.maintenance;

import java.util.List;
import java.util.stream.Collectors;

import flexnyl.com.br.backendsoapp.user.User;
import flexnyl.com.br.backendsoapp.user.UserRepository;
import flexnyl.com.br.backendsoapp.maintenanceElectrical.MaintenanceElectrical;
import flexnyl.com.br.backendsoapp.maintenanceElectrical.MaintenanceElectricalRepository;
import flexnyl.com.br.backendsoapp.maintenanceMechanical.MaintenanceMechanical;
import flexnyl.com.br.backendsoapp.maintenanceMechanical.MaintenanceMechanicalRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import flexnyl.com.br.backendsoapp.exception.ResourceNotFoundException;


@AllArgsConstructor
@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
	private final UserRepository userRepository;
	private final MaintenanceElectricalRepository maintenanceElectricalRepository;
	private final MaintenanceMechanicalRepository maintenanceMechanicalRepository;

	@Override
	public MaintenanceDTO createMaintenance(MaintenanceDTO maintenanceDTO) {

		Maintenance maintenance = MaintenanceMapper.mapToMaintenance(maintenanceDTO);

		User user = userRepository.findById(maintenanceDTO.getUserId())
				.orElseThrow(()-> new ResourceNotFoundException("User with id "+ maintenanceDTO.getUserId() + "not found."));

		maintenance.setUser(user);
		
		MaintenanceElectrical maintenanceElectrical = maintenanceElectricalRepository.findById(maintenanceDTO.getMaintenanceElectricalId())
				.orElseThrow(()-> new ResourceNotFoundException("Maintenance Electrical with id: "+ maintenanceDTO.getMaintenanceElectricalId() + "not found."));

		maintenance.setMaintenanceElectrical(maintenanceElectrical);
		
		MaintenanceMechanical maintenanceMechanical = maintenanceMechanicalRepository.findById(maintenanceDTO.getMaintenanceMechanicalId())
				.orElseThrow(()-> new ResourceNotFoundException("Maintenance Mechanical with id: "+ maintenanceDTO.getMaintenanceMechanicalId() + "not found."));

		maintenance.setMaintenanceMechanical(maintenanceMechanical);

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
