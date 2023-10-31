import { useNavigate, useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { createMaintenance, getMaintenance, updateMaintenance } from "./MaintenanceService.js";
import { listUsers } from "../user/UserService.js";
import { listMaintenanceElectricals } from "../maintenance-electricals/MaintenanceElectricalService.js";
import { listMaintenanceMechanicals } from "../maintenance-mechanicals/MaintenanceMechanicalService.js";
import  SelectMaintenanceElectrical  from "./SelectMaintenanceElectrical.jsx";
import  SelectMaintenanceMechanical  from "./SelectMaintenanceMechanical.jsx";

import { format, parse } from 'date-fns';

const MaintenanceComponent = () => {

    const { id } = useParams();
    const [maintenanceRecord, setMaintenanceRecord] = useState('')
    const [maintenanceReview, setMaintenanceReview] = useState('')
    const [maintenanceEmissionDate, setMaintenanceEmissionDate] = useState('')

    const [userId, setUserId] = useState('')
    const [users, setUsers] = useState([])

    const [maintenanceElectricalId, setMaintenanceElectricalId] = useState([])

    const [maintenanceMechanicalId, setMaintenanceMechanicalId] = useState([])

    const navigator = useNavigate();

    const [errors, setErrors] = useState({
        maintenanceRecord: '',
        maintenanceReview: '',
        maintenanceEmissionDate: '',
        user: '',
        maintenanceElectrical: '',
        maintenanceMechanical: ''
    })



    const convertToISO8601 = () => {
        try {
            // Ajuste o formato da data do tipo 'yyyy-MM-dd' para 'dd-MM-yyyy'
            const formattedDate = maintenanceEmissionDate.split('-').reverse().join('-');
            const parsedDate = parse(formattedDate, 'dd-MM-yyyy', new Date());
            const iso8601Date = format(parsedDate, "yyyy-MM-dd'T'HH:mm:ss.SSSxxx");
            return iso8601Date;
        } catch (error) {
            console.error('Erro ao converter a data: ', error);
            return null; // Retorna null em caso de erro na conversão
        }
    };

    useEffect(() => {
        listMaintenanceElectricals().then((response) => {
            setMaintenanceElectricals(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, [])

    useEffect(() => {
        listMaintenanceMechanicals().then((response) => {
            setMaintenanceMechanicals(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, [])

    useEffect(() => {
        listUsers().then((response) => {
            setUsers(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, [])

    useEffect(() => {
        if (id) {
            getMaintenance(id).then((response) => {
                setMaintenanceRecord(response.data.maintenanceRecord);
                setMaintenanceReview(response.data.maintenanceReview);
                setMaintenanceEmissionDate(response.data.maintenanceEmissionDate);
                setUserId(response.data.userId);
                setMaintenanceElectricalId(response.data.maintenanceElectricalId);
                setMaintenanceMechanicalId(response.data.maintenanceMechanicalId);
            }).catch(error => {
                console.error(error);
            })
        }
    }, [id]);

    function handleElectricalMaintenanceSelect(selectedOptions) {
        // Extrai apenas os IDs das opções selecionadas
        const selectedIds = selectedOptions.map(option => option.value);
        setMaintenanceElectricalId(selectedIds);
    }



    function saveOrUpdateMaintenance(e) {
        e.preventDefault();
        const iso8601Date = convertToISO8601(); // Converte a data para ISO 8601

        if (!iso8601Date) {
            //tratamento de erro
            console.error('Data inválida');
            return;
        }


        if (validateForm()) {
            const maintenance =
                {
                    maintenanceRecord,
                    maintenanceReview,
                    maintenanceEmissionDate: iso8601Date,
                    userId,
                    maintenanceElectricalIds,
                    maintenanceMechanicalId
                };
            console.log(maintenance)
            if (id) {
                updateMaintenance(id, maintenance)
                    .then((response) => {
                        console.log(response.data);
                        navigator('/maintenances');
                    })
                    .catch((error) => {
                        console.error(error);
                    });
            } else {
                createMaintenance(maintenance)
                    .then((response) => {
                        console.log(response.data);
                        navigator('/maintenances');
                    })
                    .catch((error) => {
                        console.error(error);
                    });
            }
        }
    }

    function validateForm() {
        let valid = true;
        const errorsCopy = { ...errors };

        if (maintenanceRecord.trim()) {
            errorsCopy.maintenanceReview = '';
        } else {
            errorsCopy.maintenanceReview = 'Digite a revisão';
            valid = false;
        }

        if (maintenanceReview.trim()) {
            errorsCopy.maintenanceRecord = '';
        } else {
            errorsCopy.maintenanceRecord = 'Digite o registro'
        }

        if (maintenanceEmissionDate.trim()) {
            errorsCopy.maintenanceEmissionDate = '';
        } else {
            errorsCopy.maintenanceEmissionDate = 'Digite a data'
        }

        if (userId) {
            errorsCopy.user = '';
        } else {
            errorsCopy.user = 'Selecione um usuário'
            valid = false
        }


        setErrors(errorsCopy);
        return valid;
    }

    function pageTitle() {
        if (id) {
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
                                {errors.maintenanceReview && <div className='invalid-feedback'>{errors.maintenanceReview}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Data de emissão:</label>
                                <input
                                    type="date" // Mantenha o campo type="date" para permitir a escolha da data
                                    name="maintenanceEmissionDate"
                                    value={maintenanceEmissionDate}
                                    className={`form-control ${errors.maintenanceEmissionDate ? 'is-invalid' : ''}`}
                                    onChange={(e) => setMaintenanceEmissionDate(e.target.value)}
                                />
                                {errors.maintenanceEmissionDate && <div className='invalid-feedback'>{errors.maintenanceEmissionDate}</div>}
                            </div>




                            <div className="form-group mb-2">
                                <label className='form-label'>Selecione o usuário:</label>
                                <select
                                    className={`form-control ${errors.user ? 'is-invalid' : ''}`}
                                    value={userId}
                                    onChange={(e) => setUserId(e.target.value)}
                                >
                                    <option value="Selecione o usuário">Selecione o usuário</option>
                                    {
                                        users.map(user =>
                                            <option key={user.id} value={user.id}>{user.userName}</option>
                                        )
                                    }
                                </select>
                                {errors.user && <div className='invalid-feedback'>{errors.user}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className='form-label'>Selecione as manutenções elétricas:</label>
                                <SelectMaintenanceElectrical
                                    value={maintenanceElectricalId}
                                    onChange={(value) => setMaintenanceElectricalId(value)}
                                />
                            </div>

                            <div className="form-group mb-2">
                                <label className='form-label'>Selecione as manutenções mecânicas:</label>
                                <SelectMaintenanceMechanical
                                    value={maintenanceMechanicalId}
                                    onChange={(value) => setMaintenanceMechanicalId(value)}
                                />
                            </div>

                            <button className="btn btn-success mb-2" onClick={saveOrUpdateMaintenance}>Enviar</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default MaintenanceComponent;