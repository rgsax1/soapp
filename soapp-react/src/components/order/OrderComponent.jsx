import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import {getOrder, updateOrder} from "./OrderService.js";

const OrderComponent = () => {

    const {id} = useParams();
    const [issueData, setIssueData] = useState('')
    const [completionData, setCompletionData] = useState('')
    const [observations, setObservations] = useState('')
    const [analysis, setAnalysis] = useState('')
    const [equipment, setEquipment] = useState('')
    const [signatureResponsible, setSignatureResponsible] = useState('')
    const [signatureMechanical, setSignatureMechanical] = useState('')
    const navigator = useNavigate();
    const [error, setErrors] = useState({
        issueData: '',
        completionData: '',
        observations: '',
        analysis: '',
        equipment: '',
        signatureResponsible: '',
        signatureMechanical: '',
    })

    useEffect(() => {
        if (id) {
            getData(id).then((response) => {
                setIssueData(response.data.issueData);
                setCompletionData(response.data.completionData);
                setObservations(response.data.observations);
                setAnalysis(response.data.analysis);
                setEquipment(response.data.equipment);
                setSignatureResponsible(response.data.signatureResponsible);
                setSignatureMechanical(response.data.signatureResponsible);
            }).catch(error => {
                console.error(error);
            })
        }
    }, [id]);

    function validateForm() {
        let valid = true;
        const errorsCopy = { ...error }; // Altere de 'errors' para 'error'

        if (!issueData.trim()) {
            errorsCopy.issueData = 'Digite a data da questão';
            valid = false;
        } else {
            errorsCopy.issueData = '';
        }

        if (!completionData.trim()) {
            errorsCopy.completionData = 'Digite a data de conclusão';
            valid = false;
        } else {
            errorsCopy.completionData = '';
        }

        if (!observations.trim()) {
            errorsCopy.observations = 'Digite as observações';
            valid = false;
        } else {
            errorsCopy.observations = '';
        }

        if (!analysis.trim()) {
            errorsCopy.analysis = 'Digite a análise';
            valid = false;
        } else {
            errorsCopy.analysis = '';
        }

        if (!equipment.trim()) {
            errorsCopy.equipment = 'Digite o equipamento';
            valid = false;
        } else {
            errorsCopy.equipment = '';
        }

        if (!signatureResponsible.trim()) {
            errorsCopy.signatureResponsible = 'Digite a assinatura do responsável';
            valid = false;
        } else {
            errorsCopy.signatureResponsible = '';
        }

        if (!signatureMechanical.trim()) {
            errorsCopy.signatureMechanical = 'Digite a assinatura do mecânico';
            valid = false;
        } else {
            errorsCopy.signatureMechanical = '';
        }

        setErrors(errorsCopy);
        return valid;
    }


    function saveOrUpdateOrder(e) {
        e.preventDefault();
        if (validateForm()) {
            const order = {
                issueData,
                completionData,
                observations,
                analysis,
                equipment,
                signatureResponsible,
                signatureMechanical
            };

            console.log(order);

            if (id) {
                // Atualizar dados
                updateOrder(id, order)
                    .then((response) => {
                        console.log(response.order);
                        navigator('/users');
                    })
                    .catch((error) => {
                        console.error(error);
                    });
            } else {
                // Criar novos dados
                createOrder(order)
                    .then((response) => {
                        console.log(response.order);
                        navigator('/users');
                    })
                    .catch((error) => {
                        console.error(error);
                    });
            }
        }
    }

    function pageTitle() {
        if (id) {
            return <h2 className="text-center">Atualizar ordem de serviço</h2>
        } else {
            return <h2 className="text-center">Adicionar ordem de serviço</h2>
        }
    }




    return (
        <div className='container'>
            <br></br>
            <div className="row">
                <div className="card col-md-6 offset-md-3">
                    {pageTitle()}
                    <div className="card-body">
                        <form>
                            <div className="form-group mb-2">
                                <label className="form-label">Data da questão:</label>
                                <input
                                    type='date'
                                    className={`form-control ${error.issueData ? 'is-invalid' : ''}`}
                                    value={issueData}
                                    onChange={(e) => setIssueData(e.target.value)}
                                />
                                {error.issueData && <div className='invalid-feedback'>{error.issueData}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Data de conclusão:</label>
                                <input
                                    type='date'
                                    className={`form-control ${error.completionData ? 'is-invalid' : ''}`}
                                    value={completionData}
                                    onChange={(e) => setCompletionData(e.target.value)}
                                />
                                {error.completionData && <div className='invalid-feedback'>{error.completionData}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Observações:</label>
                                <textarea
                                    rows="4"
                                    className={`form-control ${error.observations ? 'is-invalid' : ''}`}
                                    value={observations}
                                    onChange={(e) => setObservations(e.target.value)}
                                ></textarea>
                                {error.observations && <div className='invalid-feedback'>{error.observations}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Análise:</label>
                                <textarea
                                    rows="4"
                                    className={`form-control ${error.analysis ? 'is-invalid' : ''}`}
                                    value={analysis}
                                    onChange={(e) => setAnalysis(e.target.value)}
                                ></textarea>
                                {error.analysis && <div className='invalid-feedback'>{error.analysis}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Equipamento:</label>
                                <input
                                    type='text'
                                    placeholder='Digite o equipamento'
                                    className={`form-control ${error.equipment ? 'is-invalid' : ''}`}
                                    value={equipment}
                                    onChange={(e) => setEquipment(e.target.value)}
                                />
                                {error.equipment && <div className='invalid-feedback'>{error.equipment}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Assinatura do responsável:</label>
                                <input
                                    type='text'
                                    placeholder='Digite a assinatura do responsável'
                                    className={`form-control ${error.signatureResponsible ? 'is-invalid' : ''}`}
                                    value={signatureResponsible}
                                    onChange={(e) => setSignatureResponsible(e.target.value)}
                                />
                                {error.signatureResponsible && <div className='invalid-feedback'>{error.signatureResponsible}</div>}
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Assinatura do mecânico:</label>
                                <input
                                    type='text'
                                    placeholder='Digite a assinatura do mecânico'
                                    className={`form-control ${error.signatureMechanical ? 'is-invalid' : ''}`}
                                    value={signatureMechanical}
                                    onChange={(e) => setSignatureMechanical(e.target.value)}
                                />
                                {error.signatureMechanical && <div className='invalid-feedback'>{error.signatureMechanical}</div>}
                            </div>

                            <button className='btn btn-success mb-2' onClick={(e) => saveOrUpdateData(e)}>Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );

}

export default OrderComponent;