import React, {useEffect, useState} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import {getEquipment, createEquipment, updateEquipment} from "./EquipmentService.js";
import {listEquipmentGenerals} from "./equipment-general/EquipmentGeneralService.js";

const EquipmentComponent = () => {
    const {id} = useParams();
    const [installationDate, setInstallationDate] = useState('');
    const [equipmentSector, setEquipmentSector] = useState('');
    const [baptism, setBaptism] = useState('');
    const navigator = useNavigate();

    const [equipmentGeneralId, setEquipmentGeneralId] = useState('')
    const [equipmentGenerals, setEquipmentGenerals] = useState([])

    const [errors, setErrors] = useState({
        equipmentGeneral: '',
        installationDate: '',
        equipmentSector: '',
        baptism: '',
    });


    useEffect(() => {
        if (id) {
            getEquipment(id)
                .then((response) => {
                    setInstallationDate(response.data.installationDate);
                    setEquipmentSector(response.data.equipmentSector);
                    setBaptism(response.data.baptism);
                })
                .catch((error) => {
                    console.error(error);
                });
        }
    }, [id]);

    useEffect(() => {
        listEquipmentGenerals().then((response) => {
            setEquipmentGenerals(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, [])

    function saveOrUpdateEquipment(e) {
        e.preventDefault();
        if (validateForm()) {
            const equipment = {
                equipmentGeneralId,
                installationDate,
                equipmentSector,
                baptism
            };
            console.log(equipment);
            if (id) {
                updateEquipment(id, equipment)
                    .then((response) => {
                        console.log(response.data);
                        navigator('/equipments');
                    })
                    .catch((error) => {
                        console.error(error);
                    });
            } else {
                createEquipment(equipment).then((response) => {
                    console.log(response.data);
                    navigator('/equipments');
                })
                    .catch((error) => {
                        console.error(error);
                    });
            }
        }
    }


    function validateForm() {
        let valid = true;
        const errorsCopy = {...errors};

        if (installationDate.trim()) {
            errorsCopy.installationDate = '';
        } else {
            errorsCopy.installationDate = 'Digite a data da instalação';
            valid = false;
        }

        if (equipmentSector.trim()) {
            errorsCopy.equipmentSector = '';
        } else {
            errorsCopy.equipmentModel = 'Digite o setor do equipamento';
            valid = false;
        }

        if (baptism.trim()) {
            errorsCopy.baptism = '';
        } else {
            errorsCopy.baptism = 'Digite o batismo';
            valid = false;
        }

        if (equipmentGeneralId){
            errorsCopy.equipmentGeneral = '';
        } else {
            errorsCopy.equipmentGeneral = 'Selecione um modelo de equipamento'
            valid = false
        }

        setErrors(errorsCopy);
        return valid;

    }

    function pageTitle() {
        if (id) {
            return <h2 className="text-center">Atualizar equipamento</h2>
        } else {
            return <h2 className="text-center">Adicionar equipamento</h2>
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
                                <label className='form-label'>Selecione o modelo do equipamento:</label>
                                <select
                                    className={`form-control ${errors.equipmentGeneral ? 'is-invalid' : ''}`}
                                    value={equipmentGeneralId}
                                    onChange={(e) => setEquipmentGeneralId(e.target.value)}
                                >
                                    <option value="Selecione o modelo do equipamento">Selecione o modelo do equipamento</option>
                                    {
                                        equipmentGenerals.map(equipmentGeneral =>
                                            <option key={equipmentGeneral.id} value={equipmentGeneral.id}>{equipmentGeneral.equipmentModel}</option>
                                        )
                                    }
                                </select>
                                {errors.user && <div className='invalid-feedback'>{errors.user}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Data de instalação</label>
                                <input type="date"
                                       placeholder="Digite a data do equipamento"
                                       name="installationDate"
                                       value={installationDate}
                                       className={`form-control ${errors.installationDate ? 'is-invalid' : ''}`}
                                       onChange={(e) => setInstallationDate(e.target.value)}/>
                                {errors.installationDate &&
                                    <div className="invalid-feedback">{errors.installationDate}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Setor do equipamento</label>
                                <input type="text"
                                       placeholder="Digite o setor do equipamento"
                                       name="equipmentSector"
                                       value={equipmentSector}
                                       className={`form-control ${errors.equipmentSector ? 'is-invalid' : ''}`}
                                       onChange={(e) => setEquipmentSector(e.target.value)}/>
                                {errors.equipmentSector &&
                                    <div className="invalid-feedback">{errors.equipmentSector}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Batismo</label>
                                <input type="text"
                                       placeholder="Digite o batismo"
                                       name="baptism"
                                       value={baptism}
                                       className={`form-control ${errors.baptism ? 'is-invalid' : ''}`}
                                       onChange={(e) => setBaptism(e.target.value)}/>
                                {errors.baptism && <div className="invalid-feedback">{errors.baptism}</div>}
                            </div>


                            <button className="btn btn-success mb-2" onClick={(e) => saveOrUpdateEquipment(e)}>
                                Submit
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );

}


export default EquipmentComponent;