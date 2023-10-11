package flexnyl.com.br.backendsoapp.equipment;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import flexnyl.com.br.backendsoapp.exception.ResourceNotFoundException;


@Service
public class EquipmentServiceImpl implements EquipmentService {

    private EquipmentRepository equipmentRepository;
    
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
		super();
		this.equipmentRepository = equipmentRepository;
	}

	@Override
    public EquipmentDTO createEquipment(EquipmentDTO equipmentDTO) {
        Equipment equipment = EquipmentMapper.mapToEquipment(equipmentDTO);
        Equipment savedEquipment = equipmentRepository.save(equipment);
        return EquipmentMapper.mapToEquipmentDTO(savedEquipment);
    }

    @Override
    public EquipmentDTO getEquipmentById(long id) {
    	Equipment equipment = equipmentRepository.findById(id)
    	.orElseThrow(()-> new ResourceNotFoundException("Equipment with id: "+ id +" not found."));
    	return EquipmentMapper.mapToEquipmentDTO(equipment);
    }

    @Override
    public List<EquipmentDTO> getAllEquipment() {
    	List<Equipment> equipments = equipmentRepository.findAll();
    	return equipments.stream().map((equipment) -> EquipmentMapper.mapToEquipmentDTO(equipment))
    	.collect(Collectors.toList());	
    }

    @Override
    public EquipmentDTO updateEquipment(long id, EquipmentDTO updatedEquipment) {
    	Equipment equipment = equipmentRepository.findById(id).orElseThrow(
    	() -> new ResourceNotFoundException("Equipment with id: "+ id +" not found.")
    	);
    	equipment.setEquipmentManufacturer(updatedEquipment.getEquipmentManufacturer());
    	equipment.setEquipmentModel(updatedEquipment.getEquipmentModel());
    	equipment.setEquipmentName(updatedEquipment.getEquipmentName());
    	equipment.setEquipmentSector(updatedEquipment.getEquipmentSector());
    	
    	Equipment updatedEquipmentObj = equipmentRepository.save(equipment);
    	return EquipmentMapper.mapToEquipmentDTO(updatedEquipmentObj);
    }

    @Override
    public void deleteEquipment(long id) {
    	equipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipment with id: "+ id + "not found"));
    	equipmentRepository.deleteById(id);
    }


}
