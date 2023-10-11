import React, { useEffect, useState } from 'react';
import { listOrders, deleteOrder } from './OrderService';
import { Link, useNavigate } from 'react-router-dom';

const ListOrderComponent = () => {
    const [orders, setOrders] = useState([]);
    const navigator = useNavigate();

    useEffect(() => {
        getAllOrders();
    }, []);

    function getAllOrders() {
        listOrders()
            .then((response) => {
                setOrders(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    function addNewOrder() {
        navigator('/add-order');
    }

    function updateOrder(id) {
        navigator(`/edit-order/${id}`);
    }

    function removeOrder(id) {
        console.log(id);
        deleteOrder(id)
            .then((response) => {
                getAllOrders();
            })
            .catch((error) => {
                console.error(error);
            });
    }

    return (
        <div className="container">
            <h2 className="text-center">List of Orders</h2>
            <button className="btn btn-primary mb-2" onClick={addNewOrder}>
                Adicionar Ordem
            </button>
            <table className="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Id:</th>
                    <th>Data da Questão:</th>
                    <th>Data de Conclusão:</th>
                    <th>Observações:</th>
                    <th>Análise:</th>
                    <th>Equipamento:</th>
                    <th>Assinatura do Responsável:</th>
                    <th>Assinatura do Mecânico:</th>
                    <th>Ações:</th>
                </tr>
                </thead>
                <tbody>
                {orders.map((order) => (
                    <tr key={order.id}>
                        <td>{order.id}</td>
                        <td>{order.issueData}</td>
                        <td>{order.completionData}</td>
                        <td>{order.observations}</td>
                        <td>{order.analysis}</td>
                        <td>{order.equipment}</td>
                        <td>{order.signatureResponsible}</td>
                        <td>{order.signatureMechanical}</td>
                        <td>
                            <button
                                className="btn btn-info"
                                onClick={() => updateOrder(order.id)}
                            >
                                Atualizar
                            </button>
                            <button
                                className="btn btn-danger"
                                onClick={() => removeOrder(order.id)}
                                style={{ marginLeft: '10px' }}
                            >
                                Deletar
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ListOrderComponent;
