import React, { useState, useEffect } from 'react';
import Select from 'react-select';
import { listMaintenanceMechanicals } from "../maintenance-mechanicals/MaintenanceMechanicalService.js";

function MaintenanceMechanicalSelect() {
    const [maintenanceOptions, setMaintenanceOptions] = useState([]);
    const [selectedMaintenance, setSelectedMaintenance] = useState([]); // Usando um array para armazenar múltiplas seleções

    useEffect(() => {
        // Carrega a lista de manutenções mecânicas quando o componente montar
        listMaintenanceMechanicals()
            .then((response) => {
                // Mapeia os dados da resposta para exibir apenas o "type"
                const options = response.data.map((maintenance) => ({
                    label: maintenance.type, // O tipo da manutenção
                    value: maintenance.id,  // O ID da manutenção (pode ser removido se não for necessário)
                }));
                setMaintenanceOptions(options);
            })
            .catch((error) => {
                console.error('Erro ao buscar a lista de manutenções mecânicas', error);
            });
    }, []);

    const handleMaintenanceSelect = (selectedOptions) => {
        setSelectedMaintenance(selectedOptions);
    };

    return (
        <div>
            <h3>Selecione uma Manutenção Mecânica:</h3>
            <Select
                options={maintenanceOptions}
                value={selectedMaintenance}
                onChange={handleMaintenanceSelect}
                isMulti={true} // Habilita a seleção de múltiplos valores
            />
        </div>
    );
}

export default MaintenanceMechanicalSelect;
