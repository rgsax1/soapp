import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {deleteMaintenance, listMaintenances} from "./MaintenanceService.js";
import {listUsers} from "../user/UserService.js";
import { listMaintenanceElectricals } from "../maintenance-electricals/MaintenanceElectricalService.js";
import { listMaintenanceMechanicals } from "../maintenance-mechanicals/MaintenanceMechanicalService.js";
import {format} from "date-fns";





const ListMaintenanceComponent = () => {
    const [maintenances, setMaintenances] = useState([]);
    const [users, setUsers] = useState([]);
    const [maintenanceElectricals, setMaintenanceElectricals] = useState([]);
    const [maintenanceMechanicals, setMaintenanceMechanicals] = useState([]);

    const navigator = useNavigate();

    useEffect(() => {
        getAllMaintenances().then((response) =>{
            setMaintenances(response.data);
        }).catch(error => {
            console.error(error);
        });
    }, []);

    async function getAllMaintenances() {
        try {
            const maintenanceResponse = await listMaintenances();
            setMaintenances(maintenanceResponse.data);

            // Agora, após buscar as manutenções, busque a lista de usuários
            const userResponse = await listUsers();
            setUsers(userResponse.data);

            const maintenanceElectricalResponse = await listMaintenanceElectricals();
            setMaintenanceElectricals(maintenanceElectricalResponse.data);

            
            const maintenanceMechanicalResponse = await listMaintenanceMechanicals();
            setMaintenanceMechanicals(maintenanceMechanicalResponse.data);

        } catch (error) {
            console.error("Erro ao buscar as manutenções ou a lista de usuários:", error);
        }
    }

    function formatDate(isoDate) {
        if (!isoDate) return ''; // Verifique se a data não está vazia
        const date = new Date(isoDate);
        return format(date, 'dd/MM/yyyy');
    }

    function addNewMaintenance() {
        navigator('/add-maintenance')
    }

    function updateMaintenance(id){
        navigator(`/edit-maintenance/${id}`)
    }

    function removeMaintenance(id) {
        console.log(id);
        deleteMaintenance(id)
            .then( () => {
                console.log("Manutenção excluída com sucesso");
                return getAllMaintenances();
            })
            .then((response) => {
                console.log("Lista de manutenções atualizada após exclusão:", response);
            })
            .catch((error) => {
                console.error("Erro ao excluir a manutenção:", error);
            });
    }

    function mapUserIdToUserName(userId, users) {
        const user = users.find(user => user.id === userId);
        return user ? user.userName : "Usuário não encontrado";
    }

    function mapMaintenanceElectricalIdToType(maintenanceElectricalId, maintenanceElectricals) {
        const maintenanceElectrical = maintenanceElectricals.find(maintenanceElectrical => maintenanceElectrical.id === maintenanceElectricalId);
        return maintenanceElectrical ? maintenanceElectrical.type : "Manutenção elétrica não encontrada";
    }

    function mapMaintenanceMechanicallIdToType(maintenanceMechanicalId, maintenanceMechanicals) {
        const maintenanceMechanical = maintenanceMechanicals.find(maintenanceMechanical => maintenanceMechanical.id === maintenanceMechanicalId);
        return maintenanceMechanical ? maintenanceMechanical.type : "Manutenção elétrica não encontrada";
    }





    return (
        <div className="container">
            <h2 className="text-center">Fichas de Manutenções</h2>
            <button className="btn btn-primary mb-2" onClick={addNewMaintenance}>Criar nova ficha</button>
            <div className="maintenance-table">
                {
                    maintenances.map((maintenance) => (
                        <div className="maintenance-row" key={maintenance.id}>
                            <div className="maintenance-column">
                                <strong>Id:</strong> {maintenance.id}
                            </div>
                            <div className="maintenance-column">
                                <strong>Registro:</strong> {maintenance.maintenanceRecord}
                            </div>
                            <div className="maintenance-column">
                                <strong>Revisão:</strong> {maintenance.maintenanceReview}
                            </div>
                            <div className="maintenance-column">
                                <strong>Data de criação:</strong> {formatDate(maintenance.maintenanceEmissionDate)}
                            </div>
                            <div className="maintenance-column">
                                <strong>Aprovado por:</strong> {mapUserIdToUserName(maintenance.userId, users)}
                            </div>
                            <div className="maintenance-column">
                                <strong>Manutenção elétrica:</strong> {mapMaintenanceElectricalIdToType(maintenance.maintenanceElectricalId, maintenanceElectricals)}
                            </div>
                            <div className="maintenance-column">
                                <strong>Manutenção mecânica:</strong> {mapMaintenanceMechanicallIdToType(maintenance.maintenanceMechanicalId, maintenanceMechanicals)}
                            </div>

                            <div className="maintenance-actions">
                                <button className="btn btn-info" onClick={() => updateMaintenance(maintenance.id)}>
                                    Editar
                                </button>
                                <button className="btn btn-danger" onClick={() => removeMaintenance(maintenance.id)}style={{marginLeft: '10px'}}>
                                    Excluir
                                </button>
                            </div>

                        </div>
                    ))
                }
            </div>
        </div>
    );

}

export default ListMaintenanceComponent;