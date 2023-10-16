import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {createMaintenance, getMaintenance, updateMaintenance} from "./MaintenanceService.js";
import {listUsers} from "../user/UserService.js";
import {format, parse} from 'date-fns';

const MaintenanceComponent = () => {

    const { id } = useParams();
    const [maintenanceRecord, setMaintenanceRecord] = useState('')
    const [maintenanceReview, setMaintenanceReview] = useState('')
    const [maintenanceEmissionDate, setMaintenanceEmissionDate] = useState('')
    const [selectedUser, setSelectedUser] = useState(null)
    const [userList, setUserList] = useState([])
    const navigator = useNavigate();
    const [errors, setErrors] = useState ({
            maintenanceRecord: '',
            maintenanceReview: '',
            maintenanceEmissionDate: '',
            user: '',
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
                    user: selectedUser ? selectedUser.id : null,
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
                                <label className="form-label">Usuário</label>
                                <select
                                    value={selectedUser ? selectedUser.id : ''} // Use o ID do usuário como valor
                                    onChange={(e) => {
                                        const userId = e.target.value;
                                        const user = userList.find(user => user.id === userId);
                                        setSelectedUser(user);
                                    }}
                                    className="form-control"
                                >
                                    <option value="">Selecione um usuário</option>
                                    {userList.map((user) => (
                                        <option key={user.id} value={user.id}>
                                            {user.userName}
                                        </option>
                                    ))}option>
                                    ))
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