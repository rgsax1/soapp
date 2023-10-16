package flexnyl.com.br.backendsoapp.equipment;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/equipments")
@CrossOrigin("*")
public class EquipmentController {
	private final EquipmentService equipmentService;
	
	public EquipmentController(EquipmentService equipmentService) {
		super();
		this.equipmentService = equipmentService;
	}

	@PostMapping
	public ResponseEntity<EquipmentDTO> createEquipment(@RequestBody EquipmentDTO equipmentDTO){
		EquipmentDTO savedEquipment = equipmentService.createEquipment(equipmentDTO);
		return new ResponseEntity<>(savedEquipment, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EquipmentDTO>> getAllEquipments(){
		List<EquipmentDTO> equipments = equipmentService.getAllEquipment();
		return ResponseEntity.ok(equipments);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EquipmentDTO> getEquipmentById(@PathVariable("id") Long id){
		EquipmentDTO equipmentDTO = equipmentService.getEquipmentById(id);
		return ResponseEntity.ok(equipmentDTO);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EquipmentDTO> updatedEquipment(@PathVariable("id") Long id, @RequestBody EquipmentDTO updatedEquipment){
		EquipmentDTO equipmentDTO = equipmentService.updateEquipment(id, updatedEquipment);
		return ResponseEntity.ok(equipmentDTO);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEquipment(@PathVariable("id") Long id){
		equipmentService.deleteEquipment(id);
		return ResponseEntity.ok("Equipment deleted successfully!");
	}
	
}
