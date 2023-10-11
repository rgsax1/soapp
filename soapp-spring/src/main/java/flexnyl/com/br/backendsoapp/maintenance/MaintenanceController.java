package flexnyl.com.br.backendsoapp.maintenance;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/maintenances")
@CrossOrigin(origins = "http://localhost:3000")
public class MaintenanceController {
	private MaintenanceService maintenanceService;
	
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
	
	@PutMapping("{id}")
	public ResponseEntity<MaintenanceDTO> updatedMaintenance(@PathVariable("id") Long id, @RequestBody MaintenanceDTO updatedMaintenance ){
		MaintenanceDTO maintenanceDTO = maintenanceService.updateMaintenance(id, updatedMaintenance);
		return ResponseEntity.ok(maintenanceDTO);
	}
	
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMaintenance(@PathVariable("id") Long id){
        maintenanceService.deleteMaintenance(id);
        return ResponseEntity.ok("Maintenance deleted successfully!");
    }
}
