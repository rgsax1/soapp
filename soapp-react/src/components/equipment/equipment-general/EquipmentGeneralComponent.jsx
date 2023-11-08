import React, { useEffect, useState } from 'react';
import { useNavigate } from "react-router-dom";
import { getEquipmentGeneral, createEquipmentGeneral, updateEquipmentGeneral } from "./EquipmentGeneralService.js";

const EquipmentGeneralComponent = () => {
    const { id } = useParams();
    const [equipmentGeneralManufacturer, setEquipmentGeneralManufacturer] = useState('');
    const [equipmentGeneralModel, setEquipmentGeneralModel] = useState('');
    const [equipmentGeneralDescription, setEquipmentGeneralDescription] = useState('');
    const navigator = useNavigate();
    const [errors, setErrors] = useState({
        equipmentGeneralManufacturer: '',
        equipmentGeneralModel: '',
        equipmentGeneralDescription: ''
    });

    useEffect(() => {
        if (id) {
            getEquipmentGeneral(id)
                .then((response) => {
                    setEquipmentGeneralManufacturer(response.data.equipmentGeneralManufacturer);
                    setEquipmentGeneralModel(response.data.equipmentGeneralModel);
                    setEquipmentGeneralDescription(response.data.equipmentGeneralDescription);
                })
                .catch((error) => {
                    console.error(error);
                });
        }
    }, [id]);

    function saveOrUpdateEquipmentGeneral(e) {
        e.preventDefault();
        if (validateForm()) {
            const equipmentGeneral = {
                equipmentGeneralManufacturer,
                equipmentGeneralModel,
                equipmentGeneralDescription
            };
            console.log(equipmentGeneral);
            if (id) {
                updateEquipmentGeneral(id, equipmentGeneral)
                    .then((response) => {
                        console.log(response.data);
                        navigator('/equipment-generals');
                    })
                    .catch((error) => {
                        console.error(error);
                    });
            } else {
                createEquipmentGeneral(equipmentGeneral).then((response) => {
                    console.log(response.data);
                    navigator('/equipment-generals');
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

        if (equipmentGeneralManufacturer.trim()) {
            errorsCopy.equipmentGeneralManufacturer = '';
        } else {
            errorsCopy.equipmentGeneralManufacturer = 'Digite o fabricante do equipamento';
            valid = false;
        }

        if (equipmentGeneralModel.trim()) {
            errorsCopy.equipmentGeneralModel = '';
        } else {
            errorsCopy.equipmentGeneralModel = 'Digite o modelo do equipamento';
            valid = false;
        }

        if (equipmentGeneralDescription.trim()) {
            errorsCopy.equipmentGeneralDescription = '';
        } else {
            errorsCopy.equipmentGeneralDescription = 'Digite a descrição do equipamento';
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
                                    name="equipmentGeneralManufacturer"
                                    value={equipmentGeneralManufacturer}
                                    className={`form-control ${errors.equipmentGeneralManufacturer ? 'is-invalid' : ''}`}
                                    onChange={(e) => setEquipmentGeneralManufacturer(e.target.value)}
                                />
                                {errors.equipmentGeneralManufacturer && <div className="invalid-feedback">{errors.equipmentGeneralManufacturer}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Modelo do equipamento:</label>
                                <input
                                    type="text"
                                    placeholder="Digite o modelo do equipamento"
                                    name="equipmentGeneralModel"
                                    value={equipmentGeneralModel}
                                    className={`form-control ${errors.equipmentGeneralModel ? 'is-invalid' : ''}`}
                                    onChange={(e) => setEquipmentGeneralModel(e.target.value)}
                                />
                                {errors.equipmentGeneralModel && <div className="invalid-feedback">{errors.equipmentGeneralModel}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Descrição do equipamento</label>
                                <input
                                    type="text"
                                    placeholder="Digite a descrição do equipamento"
                                    name="equipmentGeneralDescription"
                                    value={equipmentGeneralDescription}
                                    className={`form-control ${errors.equipmentGeneralDescription ? 'is-invalid' : ''}`}
                                    onChange={(e) => setEquipmentGeneralDescription(e.target.value)} />
                                {errors.equipmentGeneralDescription && <div className="invalid-feedback">{errors.equipmentGeneralDescription}</div>}
                            </div>

                            <button className="btn btn-success mb-2" onClick={(e) => saveOrUpdateEquipmentGeneral(e)}>
                                Submit
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}
export default EquipmentGeneralComponent;