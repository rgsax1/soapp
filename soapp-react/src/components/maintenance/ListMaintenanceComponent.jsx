import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {deleteMaintenace, listMaintenances} from "./MaintenanceService.js";

const ListMaintenanceComponent = () => {
    const [maintenances, setMaintenances] = useState([]);
    const navigator = useNavigate();

    useEffect(() => {
        getAllMaintenances();
    }, []);

    function getAllMaintenances() {
        listMaintenances().then((response) => {
            setMaintenances(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function addNewMaintenance() {
        navigator('/add-maintenance')
    }

    function updateMaintenance(id){
        navigator(`/edit-maintenance/${id}`)
    }

    function removeMaintenance(id) {
        console.log(id);
        deleteMaintenace(id).then((response) =>{
            getAllMaintenances();
        }).catch(error => {
            console.error(error);
        })
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
                        maintenances.map(maintenance =>
                        <tr key={maintenance.id}>

                        </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>
        </>
    )
}

export default ListMaintenanceComponent;