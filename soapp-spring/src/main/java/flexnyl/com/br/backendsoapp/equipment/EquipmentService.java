package flexnyl.com.br.backendsoapp.equipment;

import java.util.List;


public interface EquipmentService {

    EquipmentDTO createEquipment(EquipmentDTO equipmentDTO);

    EquipmentDTO getEquipmentById(long id);

    List<EquipmentDTO> getAllEquipment();

    EquipmentDTO updateEquipment(long id, EquipmentDTO equipment);

    void deleteEquipment(long id);

}
