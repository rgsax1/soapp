package flexnyl.com.br.backendsoapp.equipment.general;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import flexnyl.com.br.backendsoapp.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EquipmentGeneralServiceImpl implements EquipmentGeneralService {
    private final EquipmentGeneralRepository equipmentGeneralRepository;

    @Override
    public EquipmentGeneralDTO createEquipmentGeneral(EquipmentGeneralDTO equipmentGeneralDTO) {
        // Map EquipmentGeneralDTO to EquipmentGeneral entity
        EquipmentGeneral equipmentGeneral = EquipmentGeneralMapper.mapToEquipmentGeneral(equipmentGeneralDTO);
        // Save the entity to the repository
        EquipmentGeneral savedEquipmentGeneral = equipmentGeneralRepository.save(equipmentGeneral);
        // Map the saved entity back to EquipmentGeneralDTO and return it
        return EquipmentGeneralMapper.mapToEquipmentGeneralDTO(savedEquipmentGeneral);
    }

    @Override
    public EquipmentGeneralDTO getEquipmentGeneralById(long id) {
        // Find the EquipmentGeneral entity by ID
        EquipmentGeneral equipmentGeneral = equipmentGeneralRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("EquipmentGeneral with id: " + id + " not found."));
        // Map the entity to EquipmentGeneralDTO and return it
        return EquipmentGeneralMapper.mapToEquipmentGeneralDTO(equipmentGeneral);
    }

    @Override
    public List<EquipmentGeneralDTO> getAllEquipmentGeneral() {
        // Retrieve all EquipmentGeneral entities from the repository
        List<EquipmentGeneral> equipmentGenerals = equipmentGeneralRepository.findAll();
        // Map the entities to EquipmentGeneralDTOs and return the list
        return equipmentGenerals.stream()
            .map(EquipmentGeneralMapper::mapToEquipmentGeneralDTO)
            .collect(Collectors.toList());
    }

    @Override
    public EquipmentGeneralDTO updateEquipmentGeneral(long id, EquipmentGeneralDTO equipmentGeneral) {
        // Find the EquipmentGeneral entity by ID
        EquipmentGeneral existingEquipmentGeneral = equipmentGeneralRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("EquipmentGeneral with id: " + id + " not found."));
        
        // Update the fields of the existing entity with values from the input DTO
        existingEquipmentGeneral.setEquipmentManufacturer(equipmentGeneral.getEquipmentManufacturer());
        existingEquipmentGeneral.setEquipmentModel(equipmentGeneral.getEquipmentModel());
        existingEquipmentGeneral.setDescription(equipmentGeneral.getDescription());

        // Save the updated entity to the repository
        EquipmentGeneral updatedEquipmentGeneral = equipmentGeneralRepository.save(existingEquipmentGeneral);
        // Map the updated entity back to EquipmentGeneralDTO and return it
        return EquipmentGeneralMapper.mapToEquipmentGeneralDTO(updatedEquipmentGeneral);
    }

    @Override
    public void deleteEquipmentGeneral(long id) {
        // Check if the EquipmentGeneral with the given ID exists
        equipmentGeneralRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("EquipmentGeneral with id: " + id + " not found"));
        // If it exists, delete it from the repository
        equipmentGeneralRepository.deleteById(id);
    }
}
