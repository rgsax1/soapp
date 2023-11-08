import React from 'react';
import { NavLink } from 'react-router-dom';

const HeaderComponent = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <div className="container-fluid">
                <a className="navbar-brand" href="#">Navbar</a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <NavLink className='nav-link' to='/login' exact activeClassName='active'>Login</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className='nav-link' to='/users' activeClassName='active'>Usuários</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className='nav-link' to='/equipments' activeClassName='active'>Equipamentos</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className='nav-link' to='/equipment-generals' activeClassName='active'>Equipamentos Gerais</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className='nav-link' to='/maintenances' activeClassName='active'>Fichas de Manutenção</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className='nav-link' to='/maintenance-mechanicals' activeClassName='active'>Manutenções Mecânicas</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className='nav-link' to='/maintenance-electricals' activeClassName='active'>Manutenções Elétricas</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className='nav-link' to='/orders' activeClassName='active'>Ordens de Serviço</NavLink>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    );
};

export default HeaderComponent;
