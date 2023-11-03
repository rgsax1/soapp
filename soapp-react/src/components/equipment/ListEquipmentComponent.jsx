import React, { useEffect, useState } from 'react';
import { deleteEquipment, listEquipments, updateEquipment } from './EquipmentService.js';
import { useNavigate } from 'react-router-dom';

const ListEquipmentComponents = () => {
    const [equipments, setEquipments] = useState([]);
    const navigator = useNavigate();

    useEffect(() => {
        listEquipments()
            .then((response) => {
                setEquipments(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }, []);

    function getAllEquipments() {
        listEquipments().then((response) => {
            setEquipments(response.data);
        }).catch(error => {
            console.error(error);
        });
    }

    function addNewEquipment() {
        navigator('/add-equipment');
    }

    function updateEquipment(id) {
        navigator(`/edit-equipment/${id}`);
    }

    function removeEquipment(id) {
        console.log(id);
        deleteEquipment(id).then((response) => {
            getAllEquipments();
        }).catch(error => {
            console.error(error);
        });
    }

    return (
        <div className="container">
            <h2 className="text-center">List of Equipments</h2>
            <button className="btn btn-primary mb-2" onClick={addNewEquipment}>
                Adicionar Equipamento
            </button>
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Id:</th>
                        <th>Setor do Equipamento:</th>
                        <th>Fabricante do Equipamento:</th>
                        <th>Modelo do Equipamento:</th>
                        <th>Descrição:</th>
                        <th>Data de Instalação:</th>
                        <th>Batismo:</th>
                        <th>Ações:</th>
                    </tr>
                </thead>
                <tbody>
                    {equipments.map((equipment) => (
                        <tr key={equipment.id}>
                            <td>{equipment.id}</td>
                            <td>{equipment.equipmentSector}</td>
                            <td>{equipment.equipmentManufacturer}</td>
                            <td>{equipment.equipmentModel}</td>
                            <td>{equipment.description}</td>
                            <td>{equipment.installationDate}</td>
                            <td>{equipment.baptism}</td>
                            <td>
                                <button className="btn btn-info" onClick={() => updateEquipment(equipment.id)}>
                                    Atualizar
                                </button>
                                <button className="btn btn-danger" onClick={() => removeEquipment(equipment.id)} style={{ marginLeft: '10px' }}>
                                    Deletar
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
                <thead>
                </thead>
            </table>
        </div>
    );
}

export default ListEquipmentComponents;
