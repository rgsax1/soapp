package flexnyl.com.br.backendsoapp.maintenance;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/maintenances")
@CrossOrigin(origins = "http://localhost:3000")
public class MaintenanceController {
	private final MaintenanceService maintenanceService;
	
	public MaintenanceController(MaintenanceService maintenanceService) {
		super();
		this.maintenanceService = maintenanceService;
	}

	@PostMapping
	public ResponseEntity<MaintenanceDTO> createMaintenance(@RequestBody MaintenanceDTO maintenanceDTO){
		MaintenanceDTO savedMaintenance = maintenanceService.createMaintenance(maintenanceDTO);
		return new ResponseEntity<>(savedMaintenance, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<MaintenanceDTO>> getAllMaintenance(){
		List<MaintenanceDTO> maintenances = maintenanceService.getAllMaintenance();
		return ResponseEntity.ok(maintenances);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<MaintenanceDTO> getMaintenanceById(@PathVariable("id") Long id){
		MaintenanceDTO maintenanceDTO = maintenanceService.getMaintenanceById(id);
		return ResponseEntity.ok(maintenanceDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MaintenanceDTO> atualizarManutencao(@PathVariable("id") Long id, @RequestBody MaintenanceDTO updatedMaintenance) {
	    // Recupere a instância de Maintenance existente pelo ID
	    MaintenanceDTO existingMaintenance = maintenanceService.getMaintenanceById(id);

	    // Atualize as listas de identificadores
	    List<Long> updatedMechanicalIds = updatedMaintenance.getMaintenanceMechanicalIds();
	    List<Long> existingMechanicalIds = existingMaintenance.getMaintenanceMechanicalIds();
	    existingMechanicalIds.clear(); // Limpe a lista existente
	    existingMechanicalIds.addAll(updatedMechanicalIds); // Adicione os novos valores

	    List<Long> updatedElectricalIds = updatedMaintenance.getMaintenanceElectricalIds();
	    List<Long> existingElectricalIds = existingMaintenance.getMaintenanceElectricalIds();
	    existingElectricalIds.clear(); // Limpe a lista existente
	    existingElectricalIds.addAll(updatedElectricalIds); // Adicione os novos valores

	    // Chame o serviço para atualizar a instância de Maintenance
	    MaintenanceDTO maintenanceDTO = maintenanceService.updateMaintenance(id, existingMaintenance);

	    return ResponseEntity.ok(maintenanceDTO);
	}


	
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMaintenance(@PathVariable("id") Long id){
        maintenanceService.deleteMaintenance(id);
        return ResponseEntity.ok("Maintenance deleted successfully!");
    }
}
