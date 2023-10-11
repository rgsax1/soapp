package flexnyl.com.br.backendsoapp.equipment;


import org.springframework.data.jpa.repository.JpaRepository;

import flexnyl.com.br.backendsoapp.equipment.Equipment;

public interface EquipmentRepository extends JpaRepository <Equipment, Long> {
    
}
