import React from 'react';

import {Navbar,Nav,Image,Dropdown} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import favicon from '../assets/images/favicon.jpeg';
import person from '../assets/images/default-user.png';

export default function NavigationBar() {


    return (
        <Navbar bg="dark" variant="dark" fixed = "top">
            <Link to={"Home"} className="navbar-brand">
                <img src={favicon} width="25" height="25" alt="0"/>
            </Link>
            <Nav className="mr-auto">
                <Link to={"Home"} className="nav-link">Home</Link>
                <Link to={"Login"} className="nav-link">Login</Link>
                <Link to={"Registration"} className="nav-link">Registo</Link>
                <Link to={"PersonList"} className="nav-link">Gestão de Pessoas</Link>
            </Nav>

            <Dropdown >
              <Dropdown.Toggle variant="success" id="dropdown-basic" >
                <Image src={person} roundedCircle width="35" height="35" alt="0" />
              </Dropdown.Toggle>

              <Dropdown.Menu >
                <Dropdown.Item href="/Perfil">Perfil</Dropdown.Item>
                <Dropdown.Item href="/Logout">Logout</Dropdown.Item>
              </Dropdown.Menu>
            </Dropdown>

        </Navbar>
    );
}
