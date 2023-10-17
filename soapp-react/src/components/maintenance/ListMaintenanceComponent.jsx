import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {deleteMaintenance, listMaintenances} from "./MaintenanceService.js";
import {listUsers} from "../user/UserService.js";
import {format} from "date-fns";





const ListMaintenanceComponent = () => {
    const [maintenances, setMaintenances] = useState([]);
    const [users, setUsers] = useState([]);

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





    return (
        <>
            <div className="container">
                <h2 className="text-center">Fichas de Manutenções</h2>
                <button className="btn btn-primary mb-2" onClick={addNewMaintenance}>Criar nova ficha</button>
                <table className="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <td>Id:</td>
                        <td>Registro:</td>
                        <td>Revisão:</td>
                        <td>Data de criação:</td>
                        <td>Aprovado por:</td>
                        <td>Ações:</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        maintenances.map((maintenance) => (
                            <tr key={maintenance.id}>
                                <td>{maintenance.id}</td>
                                <td>{maintenance.maintenanceRecord}</td>
                                <td>{maintenance.maintenanceReview}</td>
                                <td>{formatDate(maintenance.maintenanceEmissionDate)}</td>
                                <td>{mapUserIdToUserName(maintenance.userId, users)}</td>
                                <td>
                                    <button className="btn btn-info"
                                            onClick={() => updateMaintenance(maintenance.id)}>
                                        Editar
                                    </button>
                                    <button className="btn btn-danger"
                                            onClick={() => removeMaintenance(maintenance.id)} style={{marginLeft: '10px'}}>
                                        Excluir
                                    </button>
                                </td>
                            </tr>
                        ))
                    }

                    </tbody>
                </table>
            </div>
        </>
    )
}

export default ListMaintenanceComponent;