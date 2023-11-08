package flexnyl.com.br.backendsoapp.equipment.general;

import java.util.List;

public interface EquipmentGeneralService {
	EquipmentGeneralDTO createEquipmentGeneral(EquipmentGeneralDTO equipmentGeneralDTO);
	EquipmentGeneralDTO getEquipmentGeneralById(long id);
	List<EquipmentGeneralDTO> getAllEquipmentGeneral();
	EquipmentGeneralDTO updateEquipmentGeneral(long id, EquipmentGeneralDTO equipmentGeneral);
	void deleteEquipmentGeneral(long id);
}