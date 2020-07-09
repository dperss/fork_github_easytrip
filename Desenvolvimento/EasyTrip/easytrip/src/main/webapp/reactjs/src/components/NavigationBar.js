import React from 'react';

import {Navbar, Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import favicon from '../assets/images/favicon.jpeg';

export default function NavigationBar() {
    return (
        <Navbar bg="dark" variant="dark" fixed = "top">
            <Link to={"Home"} className="navbar-brand">
                <img src={favicon} width="25" height="25" alt=""/>
            </Link>
            <Nav className="mr-auto">
                <Link to={"Home"} className="nav-link">Home</Link>
                <Link to={"Login"} className="nav-link">Login</Link>
                <Link to={"Registration"} className="nav-link">Registo</Link>
                <Link to={"User_Management"} className="nav-link">Gestão de Pessoas</Link>
            </Nav>
        </Navbar>
    );
}
