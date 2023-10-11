import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {createMaintenance, getMaintenance, updateMaintenance} from "./MaintenanceService.js";
import {listUsers} from "../user/UserService.js";

const MaintenanceComponent = () => {

    const { id } = useParams();
    const [maintenanceRecord, setMaintenanceRecord] = useState('')
    const [maintenanceReview, setMaintenanceReview] = useState('')
    const [maintenanceEmissionDate, setMaintenanceEmissionDate] = useState('')
    const [selectedUser, setSelectedUser] = useState('')
    const [userList, setUserList] = useState([])
    const navigator = useNavigate();
    const [errors, setErrors] = useState ({
            maintenanceRecord: '',
            maintenanceReview: '',
            maintenanceEmissionDate: '',
            user: '',
    })

    useEffect(() => {
        // Função para buscar a lista de usuários do serviço
        async function fetchUserList() {
            try {
                const response = await listUsers();
                setUserList(response.data); // Define a lista de usuários no estado
            } catch (error) {
                console.error("Erro ao buscar a lista de usuários:", error);
            }
        }

        // Chame a função assíncrona dentro do useEffect
        fetchUserList();
    }, []);



    useEffect(() => {
        if (id) {
            getMaintenance(id).then((response) => {
                setMaintenanceRecord(response.data.maintenanceRecord);
                setMaintenanceReview(response.data.maintenanceReview);
                setMaintenanceEmissionDate(response.data.maintenanceEmissionDate);
            }).catch(error => {
                console.error(error);
            })
        }
    }, [id]);

    function saveOrUpdateMaintenance(e){
        e.preventDefault();
        if (validateForm()) {
            const maintenance = {maintenanceRecord, maintenanceReview, maintenanceEmissionDate, user: selectedUser}
            console.log(maintenance)
            if (id) {
                updateMaintenance(id, maintenance).then((response) => {
                    console.log(response.data);
                    navigator('/maintenances');
                }).catch(error => {
                    console.error(error);
                })
            } else {
                createMaintenance(maintenance).then((response) => {
                    console.log(response.data);
                    navigator('/maintenances')
                }).catch(error => {
                    console.error(error);
                })
            }
        }
    }

    function validateForm() {
        let valid = true;
        const errorsCopy = { ...errors};

        if (maintenanceRecord.trim()){
            errorsCopy.maintenanceReview = '';
        } else {
            errorsCopy.maintenanceReview = 'Digite a revisão';
            valid = false;
        }

        if (maintenanceReview.trim()){
            errorsCopy.maintenanceRecord = '';
        } else {
            errorsCopy.maintenanceRecord = 'Digite o registro'
        }

        if (maintenanceEmissionDate.trim()){
            errorsCopy.maintenanceEmissionDate = '';
        } else {
            errorsCopy.maintenanceEmissionDate = 'Digite a data'
        }

        setErrors(errorsCopy);
        return valid;
    }

    function pageTitle() {
        if (id){
            return <h2 className="text-center">Atualizar ficha de manutenção</h2>
        } else {
            return <h2 className="text-center">Criar ficha de manutenção</h2>
        }
    }

    return (
        <div className="container">
            <br></br>
            <div className="row">
                <div className="card col-md-6 offset-md-3">
                    {pageTitle()}
                    <div className="card-body">
                        <form>
                            <div className="form-group mb-2">
                                <label className="form-label">Ficha de manutenção:</label>
                                <input
                                    type='text'
                                    placeholder='FM'
                                    name='maintenanceRecord'
                                    value={maintenanceRecord}
                                    className={`form-control ${errors.maintenanceRecord ? 'is-invalid' : ''}`}
                                    onChange={(e) => setMaintenanceRecord(e.target.value)}
                                >
                                </input>
                                {errors.maintenanceRecord && <div className='invalid-feedback'>{errors.maintenanceRecord}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Revisão:</label>
                                <input
                                    type='text'
                                    placeholder='Revisão'
                                    name='maintenanceReview'
                                    value={maintenanceReview}
                                    className={`form-control ${errors.maintenanceReview ? 'is-invalid' : ''}`}
                                    onChange={(e) => setMaintenanceReview(e.target.value)}
                                >
                                </input>
                                {errors.maintenanceRecord && <div className='invalid-feedback'>{errors.maintenanceRecord}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Data de emissão:</label>
                                <input
                                    type='text'
                                    placeholder='DD/MM/YYYY'
                                    name='maintenanceEmissionDate'
                                    value={maintenanceRecord}
                                    className={`form-control ${errors.maintenanceEmissionDate ? 'is-invalid' : ''}`}
                                    onChange={(e) => setMaintenanceEmissionDate(e.target.value)}
                                >
                                </input>
                                {errors.maintenanceRecord && <div className='invalid-feedback'>{errors.maintenanceRecord}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Usuário</label>
                                <select
                                    value={selectedUser} // Use selectedUser em vez de user
                                    onChange={(e) => setSelectedUser(e.target.value)}
                                    className="form-control"
                                >
                                    <option value="">Selecione um usuário</option>
                                    {userList.map((user) => (
                                        <option key={user.id} value={user.userName}>
                                            {user.userName} {/* Substitua 'name' pelo campo correto do usuário */}
                                        </option>
                                    ))}
                                </select>
                            </div>




                            <button className="btn btn-success mb-2" onClick={(e) => saveOrUpdateMaintenance(e)}>Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default MaintenanceComponent;