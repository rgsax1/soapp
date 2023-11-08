package flexnyl.com.br.backendsoapp.equipment;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import flexnyl.com.br.backendsoapp.equipment.general.EquipmentGeneral;
import flexnyl.com.br.backendsoapp.equipment.general.EquipmentGeneralRepository;
import flexnyl.com.br.backendsoapp.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {
	
	private final EquipmentGeneralRepository equipmentGeneralRepository;

    private final EquipmentRepository equipmentRepository;
   

	@Override
    public EquipmentDTO createEquipment(EquipmentDTO equipmentDTO) {
		Equipment equipment = EquipmentMapper.mapToEquipment(equipmentDTO);
		EquipmentGeneral equipmentGeneral = equipmentGeneralRepository.findById(equipmentDTO.getEquipmentGeneralId())
				.orElseThrow(() -> new ResourceNotFoundException("General equipment with id: "+equipmentDTO.getEquipmentGeneralId() + "not found."));
		equipment.setEquipmentGeneral(equipmentGeneral);
		
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
    	return equipments.stream().map(EquipmentMapper::mapToEquipmentDTO)
    	.collect(Collectors.toList());	
    }

@Override
public EquipmentDTO updateEquipment(long id, EquipmentDTO updatedEquipment) {
    Equipment equipment = equipmentRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Equipment with id: " + id + " not found.")
    );
    equipment.setInstallationDate(updatedEquipment.getInstallationDate());
    equipment.setEquipmentSector(updatedEquipment.getEquipmentSector());
    equipment.setBaptism(updatedEquipment.getBaptism());

    Equipment updatedEquipmentObj = equipmentRepository.save(equipment);
    return EquipmentMapper.mapToEquipmentDTO(updatedEquipmentObj);
}


    @Override
    public void deleteEquipment(long id) {
    	equipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipment with id: "+ id + "not found"));
    	equipmentRepository.deleteById(id);
    }


}
