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
        return format(date, 'dd/MM/yyyy'); // Formate a data como 'dd-MM-yyyy'
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
            .then((response) => {
                // Aqui a manutenção foi excluída com sucesso, você pode fazer algo se necessário
                console.log("Manutenção excluída com sucesso");
                return getAllMaintenances(); // Retorna a chamada para que você possa lidar com a resposta em outro lugar
            })
            .then((response) => {
                // Aqui, você lida com a resposta da getAllMaintenances após a exclusão
                console.log("Lista de manutenções atualizada após exclusão:", response);

                // Você pode fazer algo mais aqui, como atualizar a interface do usuário
            })
            .catch((error) => {
                // Aqui ocorreu um erro ao excluir a manutenção
                console.error("Erro ao excluir a manutenção:", error);

                // Se desejar, você pode exibir uma mensagem de erro para o usuário
                // ou lidar com o erro de outra forma
            });
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
                                <td>{users.find((user) => user.id === maintenance.userId)?.name}</td>
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