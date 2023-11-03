import React, {useEffect, useState} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import {getEquipment, createEquipment, updateEquipment} from "./EquipmentService.js";


const EquipmentComponent = () => {
    const {id} = useParams();
    const [equipmentManufacturer, setEquipmentManufacturer] = useState('');
    const [equipmentModel, setEquipmentModel] = useState('');
    const [description, setDescription] = useState('');
    const [installationDate, setInstallationDate] = useState('');
    const [equipmentSector, setEquipmentSector] = useState('');
    const [baptism, setBaptism] = useState('');
    const navigator = useNavigate();
    const [errors, setErrors] = useState({
        equipmentManufacturer: '',
        equipmentModel: '',
        description: '',
        installationDate: '',
        equipmentSector: '',
        baptism: '',
    });


    useEffect(() => {
        if (id) {
            getEquipment(id)
                .then((response) => {
                    setEquipmentManufacturer(response.data.equipmentManufacturer);
                    setEquipmentModel(response.data.equipmentModel);
                    setDescription(response.data.description);
                    setInstallationDate(response.data.installationDate);
                    setEquipmentSector(response.data.equipmentSector);
                    setBaptism(response.data.baptism);
                })
                .catch((error) => {
                    console.error(error);
                });
        }
    }, [id]);

    function saveOrUpdateEquipment(e) {
        e.preventDefault();
        if (validateForm()) {
            const equipment = {
                equipmentManufacturer,
                equipmentModel,
                description,
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
                createEquipment(equipment)
                    .then((response) => {
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

        if (equipmentManufacturer.trim()) {
            errorsCopy.equipmentManufacturer = '';
        } else {
            errorsCopy.equipmentManufacturer = 'Digite o fabricante do equipamento';
            valid = false;
        }

        if (equipmentModel.trim()) {
            errorsCopy.equipmentModel = 'Digite o modelo do equipamento';
        } else {
            errorsCopy.equipmentModel = '';
            valid = false;
        }

        if (description.trim()) {
            errorsCopy.description = '';
        } else {
            errorsCopy.description = 'Digite a descrição do equipamento';
            valid = false;
        }

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
                                <label className="form-label">Fabricante do equipamento:</label>
                                <input
                                    type="text"
                                    placeholder="Digite o fabricante do equipamento"
                                    name="equipmentManufacturer"
                                    value={equipmentManufacturer}
                                    className={`form-control ${errors.equipmentManufacturer ? 'is-invalid' : ''}`}
                                    onChange={(e) => setEquipmentManufacturer(e.target.value)}
                                />
                                {errors.equipmentManufacturer &&
                                    <div className="invalid-feedback">{errors.equipmentManufacturer}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Modelo do equipamento:</label>
                                <input
                                    type="text"
                                    placeholder="Digite o modelo do equipamento"
                                    name="equipmentModel"
                                    value={equipmentModel}
                                    className={`form-control ${errors.equipmentModel ? 'is-invalid' : ''}`}
                                    onChange={(e) => setEquipmentModel(e.target.value)}
                                />
                                {errors.equipmentModel &&
                                    <div className="invalid-feedback">{errors.equipmentModel}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Descrição do equipamento</label>
                                <input
                                    type="text"
                                    placeholder="Digite a descrição do equipamento"
                                    name="description"
                                    value={description}
                                    className={`form-control ${errors.description ? 'is-invalid' : ''}`}
                                    onChange={(e) => setDescription(e.target.value)}/>
                                {errors.description && <div className="invalid-feedback">{errors.description}</div>}
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