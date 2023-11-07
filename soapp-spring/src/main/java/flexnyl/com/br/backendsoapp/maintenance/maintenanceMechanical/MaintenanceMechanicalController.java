package flexnyl.com.br.backendsoapp.maintenance.maintenanceMechanical;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/maintenance-mechanicals")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MaintenanceMechanicalController {
    private final MaintenanceMechanicalService maintenanceMechanicalService;
    
    public MaintenanceMechanicalController(MaintenanceMechanicalService maintenanceMechanicalService) {
		super();
		this.maintenanceMechanicalService = maintenanceMechanicalService;
	}

	@PostMapping
    public ResponseEntity<MaintenanceMechanicalDTO> createMaintenanceMechanical(@RequestBody MaintenanceMechanicalDTO maintenanceMechanicalDTO){
        MaintenanceMechanicalDTO savedMaintenanceMechanical = maintenanceMechanicalService.createMaintenanceMechanical(maintenanceMechanicalDTO);
        return new ResponseEntity<>(savedMaintenanceMechanical, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceMechanicalDTO>> getAllMaintenanceMechanical(){
        List<MaintenanceMechanicalDTO> maintenanceMechanicals = maintenanceMechanicalService.getAllMaintenanceMechanical();
        return ResponseEntity.ok(maintenanceMechanicals);
    }

    @GetMapping("{id}")
    public ResponseEntity<MaintenanceMechanicalDTO> getMaintenanceMechanicalById(@PathVariable("id") Long id){
        MaintenanceMechanicalDTO maintenanceMechanicalDTO = maintenanceMechanicalService.getMaintenanceMechanicalById(id);
        return ResponseEntity.ok(maintenanceMechanicalDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<MaintenanceMechanicalDTO> updatedMaintenanceMechanical(@PathVariable("id") Long id, @RequestBody MaintenanceMechanicalDTO updatedMaintenanceMechanical ){
        MaintenanceMechanicalDTO maintenanceMechanicalDTO = maintenanceMechanicalService.updateMaintenanceMechanical(id, updatedMaintenanceMechanical);
        return ResponseEntity.ok(maintenanceMechanicalDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMaintenanceMechanical(@PathVariable("id") Long id){
        maintenanceMechanicalService.deleteMaintenanceMechanical(id);
        return ResponseEntity.ok("MaintenanceMechanical deleted successfully!");
    }
}
