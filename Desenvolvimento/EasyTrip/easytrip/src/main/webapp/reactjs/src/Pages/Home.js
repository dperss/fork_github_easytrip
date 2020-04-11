import React from "react";

import { Jumbotron, Nav, Navbar, Form, FormControl, Button, NavDropdown} from "react-bootstrap";
import Background from "../assets/imagem.png";



export default class Home extends React.Component{


    render() {



     const jum = {
            backgroundImage: `url(${Background})`,
            backgroundPosition: "center",
            backgroundSize: "cover",
            height: "180px",


     };
     const h1 = {
         fontFamily: "Hobo Std",
         fontSize: "70px",
         textAlign: "left"
     };




        return (

            <div>

                    <Navbar bg="dark" variant="dark">
                        <Navbar.Brand >EasyTrip</Navbar.Brand>
                        <NavDropdown title = "" id = "basic-nav-dropdown">
                            <NavDropdown.Item href = "/login">Login</NavDropdown.Item>
                            <NavDropdown.Item href = "/registo">Registo</NavDropdown.Item>
                            <NavDropdown.Item href = "/info">Informações</NavDropdown.Item>
                            <NavDropdown.Item href = "/perfil">Perfil</NavDropdown.Item>
                        </NavDropdown>
                        <Nav className="mr-auto">
                            <Nav.Link href="/alojamentos">Alojamentos</Nav.Link>
                            <Nav.Link href="/transportes">Transportes</Nav.Link>

                        </Nav>
                        <Form inline>
                            <FormControl type="text" placeholder="Search" className="mr-sm-4" />
                            <Button  variant="outline-light">Search</Button>
                        </Form>

                    </Navbar>
                    <Jumbotron  style = {jum}>

                        <h1 style = {h1}>
                            Bem Vindo!
                        </h1>

                    </Jumbotron>







            </div>
        );
    }
}