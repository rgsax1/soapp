package flexnyl.com.br.backendsoapp.maintenance.maintenanceElectrical;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/maintenance-electricals")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MaintenanceElectricalController {
    private final MaintenanceElectricalService maintenanceElectricalService;
    
    public MaintenanceElectricalController(MaintenanceElectricalService maintenanceElectricalService) {
		super();
		this.maintenanceElectricalService = maintenanceElectricalService;
	}

	@PostMapping
    public ResponseEntity<MaintenanceElectricalDTO> createMaintenanceElectrical(@RequestBody MaintenanceElectricalDTO maintenanceElectricalDTO){
        MaintenanceElectricalDTO savedMaintenanceElectrical = maintenanceElectricalService.createMaintenanceElectrical(maintenanceElectricalDTO);
        return new ResponseEntity<>(savedMaintenanceElectrical, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceElectricalDTO>> getAllMaintenanceElectrical(){
        List<MaintenanceElectricalDTO> maintenanceElectricals = maintenanceElectricalService.getAllMaintenanceElectrical();
        return ResponseEntity.ok(maintenanceElectricals);
    }

    @GetMapping("{id}")
    public ResponseEntity<MaintenanceElectricalDTO> getMaintenanceElectricalById(@PathVariable("id") Long id){
        MaintenanceElectricalDTO maintenanceElectricalDTO = maintenanceElectricalService.getMaintenanceElectricalById(id);
        return ResponseEntity.ok(maintenanceElectricalDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<MaintenanceElectricalDTO> updatedMaintenanceElectrical(@PathVariable("id") Long id, @RequestBody MaintenanceElectricalDTO updatedMaintenanceElectrical ){
        MaintenanceElectricalDTO maintenanceElectricalDTO = maintenanceElectricalService.updateMaintenanceElectrical(id, updatedMaintenanceElectrical);
        return ResponseEntity.ok(maintenanceElectricalDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMaintenanceElectrical(@PathVariable("id") Long id){
        maintenanceElectricalService.deleteMaintenanceElectrical(id);
        return ResponseEntity.ok("MaintenanceElectrical deleted successfully!");
    }
}
