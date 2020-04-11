import React from "react";
import {Button, Form, FormControl, Nav, Navbar, NavDropdown, Carousel} from "react-bootstrap";

import Hoteis from "../assets/hoteis.jpg";
import Resort from "../assets/e24547b6d0b63924294191179d76e798.jpg";




export default class Alojamentos extends React.Component{
    render(){
    const c1 = {
        height: "300px",
        positionAlign: "center",
        size: "cover"

    };


        return(
            <div>
                <Navbar bg="dark" variant="dark">
                    <Navbar.Brand >EasyTrip</Navbar.Brand>
                    <NavDropdown title = "" id = "basic-nav-dropdown">
                        <NavDropdown.Item href = "/login">Login</NavDropdown.Item>
                        <NavDropdown.Item href = "/registo">Registo</NavDropdown.Item>
                        <NavDropdown.Item href = "/info">Informações</NavDropdown.Item>
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
                <Carousel>
                    <Carousel.Item style={c1}>
                        <img
                            className="d-block w-100"
                            src={Hoteis}
                            alt="Hoteis"
                        />
                        <Carousel.Caption>

                            <p>Venha descobrir os melhores hóteis</p>
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item style={c1} >
                        <img
                            className="d-block w-100"
                            src = {Resort}
                            alt="Resort"
                        />
                        <Carousel.Caption>

                            <p>Os Resorts estão à espera</p>
                        </Carousel.Caption>
                    </Carousel.Item>
                </Carousel>








            </div>

        );









    }
}