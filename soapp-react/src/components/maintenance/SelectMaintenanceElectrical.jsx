import React, { useState, useEffect } from 'react';
import Select from 'react-select';
import { listMaintenanceElectricals } from "../maintenance-electricals/MaintenanceElectricalService.js";


function MaintenanceElectricalSelect() {
    const [maintenanceOptions, setMaintenanceOptions] = useState([]);
    const [selectedMaintenance, setSelectedMaintenance] = useState([]);

    useEffect(() => {
        // Carrega a lista de manutenções elétricas quando o componente montar
        listMaintenanceElectricals()
            .then((response) => {
                // Mapeia os dados da resposta para exibir apenas o "type"
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

    const handleMaintenanceSelect = (selectedOptions) => {
        setSelectedMaintenance(selectedOptions);
    };

    return (
        <div>
            <h3>Selecione uma Manutenção Elétrica:</h3>
            <Select
                options={maintenanceOptions}
                value={selectedMaintenance}
                onChange={handleMaintenanceSelect}
                isMulti={true}
            />
        </div>
    );
}

export default MaintenanceElectricalSelect;
