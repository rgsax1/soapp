package flexnyl.com.br.backendsoapp.maintenance;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import flexnyl.com.br.backendsoapp.user.User;
import flexnyl.com.br.backendsoapp.user.UserRepository;
import org.springframework.stereotype.Service;

import flexnyl.com.br.backendsoapp.exception.ResourceNotFoundException;


@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
	private final UserRepository userRepository;

	public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository, UserRepository userRepository) {
		this.maintenanceRepository = maintenanceRepository;
		this.userRepository = userRepository;
	}

	@Override
	public MaintenanceDTO createMaintenance(MaintenanceDTO maintenanceDTO) {

		Maintenance maintenance = MaintenanceMapper.mapToMaintenance(maintenanceDTO);

		Optional<User> userOptional = userRepository.findByUserName(maintenanceDTO.getUserNameFk());

		if (userOptional.isPresent()) {
			User user = userOptional.get();

			maintenance.setUser(user);

			Maintenance savedMaintenance = maintenanceRepository.save(maintenance);

			MaintenanceDTO mappedMaintenanceDTO = MaintenanceMapper.mapToMaintenanceDTO(savedMaintenance);
			mappedMaintenanceDTO.setUserNameFk(user.getUserName());

			return mappedMaintenanceDTO;
		} else {
			throw new ResourceNotFoundException("User is not exists with userNameFk: " + maintenanceDTO.getUserNameFk());
		}
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
