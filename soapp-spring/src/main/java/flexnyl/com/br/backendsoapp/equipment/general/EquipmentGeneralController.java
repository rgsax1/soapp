package flexnyl.com.br.backendsoapp.equipment.general;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipment-generals")
@CrossOrigin("*")
public class EquipmentGeneralController {
    private final EquipmentGeneralService equipmentGeneralService;

    public EquipmentGeneralController(EquipmentGeneralService equipmentGeneralService) {
        this.equipmentGeneralService = equipmentGeneralService;
    }

    @PostMapping
    public ResponseEntity<EquipmentGeneralDTO> createEquipmentGeneral(@RequestBody EquipmentGeneralDTO equipmentGeneralDTO) {
        EquipmentGeneralDTO savedEquipmentGeneral = equipmentGeneralService.createEquipmentGeneral(equipmentGeneralDTO);
        return new ResponseEntity<>(savedEquipmentGeneral, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EquipmentGeneralDTO>> getAllEquipmentGenerals(){
    	List<EquipmentGeneralDTO> equipmentGenerals = equipmentGeneralService.getAllEquipmentGeneral();
    	return ResponseEntity.ok(equipmentGenerals);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentGeneralDTO> getEquipmentGeneralById(@PathVariable("id") Long id) {
        EquipmentGeneralDTO equipmentGeneralDTO = equipmentGeneralService.getEquipmentGeneralById(id);
        return ResponseEntity.ok(equipmentGeneralDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentGeneralDTO> updateEquipmentGeneral(@PathVariable("id") Long id, @RequestBody EquipmentGeneralDTO updatedEquipmentGeneral) {
        EquipmentGeneralDTO equipmentGeneralDTO = equipmentGeneralService.updateEquipmentGeneral(id, updatedEquipmentGeneral);
        return ResponseEntity.ok(equipmentGeneralDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEquipmentGeneral(@PathVariable("id") Long id) {
        equipmentGeneralService.deleteEquipmentGeneral(id);
        return ResponseEntity.ok("Equipment General deleted successfully!");
    }
}
