import React, { useState, useEffect } from 'react';
import Select from 'react-select';
import { listMaintenanceElectricals } from "../maintenance-electricals/MaintenanceElectricalService.js";

function SelectMaintenanceElectrical() {
    // State para armazenar as opções de manutenção elétrica
    const [maintenanceOptions, setMaintenanceOptions] = useState([]);
    // State para armazenar as seleções feitas pelo usuário
    const [selectedMaintenance, setSelectedMaintenance] = useState([]);

    // Efeito para carregar a lista de manutenções elétricas quando o componente montar
    useEffect(() => {
        listMaintenanceElectricals()
            .then((response) => {
                // Mapeia os dados da resposta para criar as opções de seleção
                const options = response.data.map((maintenance) => ({
                    label: maintenance.type, // O tipo da manutenção elétrica
                    value: maintenance.id,
                }));
                setMaintenanceOptions(options);
            })
            .catch((error) => {
                console.error('Erro ao buscar a lista de manutenções elétricas', error);
            });
    }, []);

    // Função para lidar com a seleção de opções pelo usuário
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
            {/* Exibe os IDs selecionados (pode ser usado no envio para o backend) */}
            <div>IDs Selecionados: {getSelectedMaintenanceIDs().join(', ')}</div>
        </div>
    );
}

export default SelectMaintenanceElectrical;
