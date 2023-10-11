import React, {useEffect, useState} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import {getEquipment, createEquipment, updateEquipment} from "./EquipmentService.js";


const EquipmentComponent = () => {
    const [equipmentName, setEquipmentName] = useState('')
    const [equipmentSector, setEquipmentSector] = useState('')
    const [equipmentManufacturer, setEquipmentManufacturer] = useState('')
    const [equipmentModel, setEquipmentModel] = useState('')
    // const [equipmentPhoto, setEquipmentPhoto] = useState(null);
    const {id} = useParams();
    const navigator = useNavigate();
    const [errors, setErrors] = useState({
        equipmentName: '', equipmentSector: '', equipmentManufacturer: '', equipmentModel: ''
    })

    {/*
    function EquipmentPhotoUploader(e) {
        const file = e.target.files[0];
        setEquipmentPhoto(file);
    }

    */}

    useEffect(() => {
        if (id) {
            getEquipment(id).then((response) => {
                setEquipmentName(response.data.equipmentName);
                setEquipmentSector(response.data.equipmentSector);
                setEquipmentManufacturer(response.data.equipmentManufacturer);
                setEquipmentModel(response.data.equipmentModel);
                // setEquipmentPhoto(response.data.equipmentPhoto);
            }).catch(error => {
                console.error(error);
            })
        }
    }, [id]);

    function saveOrUpdateEquipment(e) {
        e.preventDefault();
        if (validateForm()) {
            const equipment = {
                equipmentName, equipmentModel, equipmentManufacturer, equipmentSector, //equipmentPhoto
            }
            console.log(equipment)
            if (id) {
                updateEquipment(id, equipment).then((response) => {
                    console.log(response.data);
                    navigator('/equipments');
                }).catch(error => {
                    console.error(error);
                })
            } else {
                createEquipment(equipment).then((response) => {
                    console.log(response.data);
                    navigator('/equipments')
                }).catch(error => {
                    console.error(error);
                })
            }
        }
    }

    function validateForm() {
        let valid = true;
        const errorsCopy = {...errors};

        if (equipmentName.trim()) {
            errorsCopy.equipmentName = '';
        } else {
            errorsCopy.equipmentName = 'Digite o nome do equipamento';
            valid = false;
        }

        if (equipmentModel.trim()) {
            errorsCopy.equipmentModel = '';
        } else {
            errorsCopy.equipmentModel = 'Digite o modelo do equipamento';
            valid = false;
        }

        if (equipmentManufacturer.trim()) {
            errorsCopy.equipmentManufacturer = '';
        } else {
            errorsCopy.equipmentManufacturer = 'Digite o fabricante do equipamento';
            valid = false;
        }

        if (equipmentSector.trim()) {
            errorsCopy.equipmentSector = '';
        } else {
            errorsCopy.equipmentSector = 'Digite o setor do equipamento';
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

    return (<div className="container">
            <br></br>
            <div className="row">
                <div className="card col-md-6 offset-md-3">
                    {pageTitle()}
                    <div className="card-body">
                        <form>
                            <div className="form-group mb-2">
                                <label className="form-label">Nome do equipamento:</label>
                                <input type='text'
                                       placeholder="Digite o nome do equipamento"
                                       name="equipmentName"
                                       value={equipmentName}
                                       className={`form-control ${errors.equipmentName ? 'is-invalid' : ''}`}
                                       onChange={(e) => setEquipmentName(e.target.value)}>
                                </input>
                                {errors.equipmentName && <div className="invalid-feedback">{errors.equipmentName}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Modelo do equipamento:</label>
                                <input type="text"
                                       placeholder="Digite o modelo do equipamento"
                                       name="equipmentModel"
                                       value={equipmentModel}
                                       className={`form-control ${errors.equipmentModel ? 'is-invalid' : ''}`}
                                       onChange={(e) => setEquipmentModel(e.target.value)}>
                                </input>
                                {errors.equipmentModel &&
                                    <div className="invalid-feedback">{errors.equipmentModel}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Fabricante do equipamento:</label>
                                <input type="text"
                                       placeholder="Digite o fabricante do equipamento"
                                       name="equipmentManufacturer"
                                       value={equipmentManufacturer}
                                       className={`form-control ${errors.equipmentManufacturer ? 'is-invalid' : ''}`}
                                       onChange={(e) => setEquipmentManufacturer(e.target.value)}>
                                </input>
                                {errors.equipmentManufacturer &&
                                    <div className="invalid-feedback">{errors.equipmentManufacturer}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Setor do equipamento:</label>
                                <input type="text"
                                       placeholder="Digite o setor do equipamento:"
                                       name="equipmentSector"
                                       value={equipmentSector}
                                       className={`form-control ${errors.equipmentSector ? 'is-invalid' : ''}`}
                                       onChange={(e) => setEquipmentSector(e.target.value)}>
                                </input>
                                {errors.equipmentSector &&
                                    <div className="invalid-feedback">{errors.equipmentSector}</div>}
                            </div>


                            {/*
                            <div className="form-group mb-2">
                                <label className="form-label">Adicionar foto do equipamento:</label>
                                <div className="row">
                                    <div className="col-md-6">
                                        <div className="form-group">
                                            <input
                                                type="file"
                                                className="form-control "
                                                id="equipmentPhoto"
                                                accept="image/*"
                                                onChange={EquipmentPhotoUploader}
                                            />
                                        </div>

                                        {equipmentPhoto && (
                                            <div className="mt-3">
                                            <h4>Prévia da Foto:</h4>
                                            <img
                                            src={URL.createObjectURL(equipmentPhoto)}
                                            alt="Preview"
                                            className="img-thumbnail"/>
                                            </div>
                                        )}
                                    </div>
                                </div>
                            </div>
*/}

                            <button className='btn btn-success mb-2' onClick={(e) => saveOrUpdateEquipment(e)}>Submit
                            </button>
                        </form>
                    </div>
                </div>
            </div>

        </div>)
}


export default EquipmentComponent;