import React, { useState, useEffect } from 'react';
import Select from 'react-select';
import { listMaintenanceMechanicals } from "../maintenance-mechanicals/MaintenanceMechanicalService.js";

function SelectMaintenanceMechanical() {
    const [maintenanceOptions, setMaintenanceOptions] = useState([]);
    const [selectedMaintenance, setSelectedMaintenance] = useState([]);

    useEffect(() => {
        // Carrega a lista de manutenções mecânicas quando o componente montar
        listMaintenanceMechanicals()
            .then((response) => {
                // Mapeia os dados da resposta para criar as opções de seleção
                const options = response.data.map((maintenance) => ({
                    label: maintenance.type, // O tipo da manutenção mecânica
                    value: maintenance.id,  // O ID da manutenção
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

    // Função para obter somente os IDs selecionados
    const getSelectedMaintenanceIDs = () => {
        return selectedMaintenance.map(option => option.value);
    };

    return (
        <div>
            <Select
                options={maintenanceOptions}
                value={selectedMaintenance}
                onChange={handleMaintenanceSelect}
                isMulti={true} // Habilita a seleção de múltiplos valores
            />
            {/* Exibe os tipos selecionados para o usuário no frontend */}
            <div>IDs Selecionados: {getSelectedMaintenanceIDs().join(', ')}</div>
        </div>
    );
}

export default SelectMaintenanceMechanical;
