import React from "react";
import {Button, Form, FormControl, Nav, Navbar, NavDropdown, Card, CardDeck, Pagination} from "react-bootstrap";

import Hoteis from "../assets/hoteis.jpg";
import Resort from "../assets/e24547b6d0b63924294191179d76e798.jpg";




export default class Alojamentos extends React.Component{
    render(){


    const cg1 = {
        marginTop: "50px",
        marginLeft: "12%",
        width: "90rem",
        backgroundColor: "secondary",


    };
    const easy = {
        fontFamily: "Hobo Std"
    };


        return(
            <div>
                <Navbar bg="dark" variant="dark">
                    <Navbar.Brand href = "/" style = {easy} >EasyTrip</Navbar.Brand>
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
                        <FormControl type="text" placeholder="Procura" className="mr-sm-4" />
                        <Button  variant="outline-light">Procura</Button>
                    </Form>

                </Navbar>
                <CardDeck style = {cg1}>
                    <Card>
                        <Card.Img variant="top" src={Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.
                            </Card.Text>
                            <Button  variant="outline-dark">Search</Button>
                        </Card.Body>

                    </Card>
                    <Card>
                        <Card.Img variant="top" src = {Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This card has supporting text below as a natural lead-in to additional
                                content.{' '}
                            </Card.Text>
                            <Button  variant="outline-dark">Search</Button>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant="top" src = {Resort} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to
                                show that equal height action.
                            </Card.Text>
                            <Button  variant="outline-dark">Search</Button>
                        </Card.Body>

                    </Card>
                </CardDeck>
                <CardDeck style = {cg1}>
                    <Card>
                        <Card.Img variant="top" src={Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.
                            </Card.Text>
                            <Button  variant="outline-dark">Search</Button>
                        </Card.Body>

                    </Card>
                    <Card>
                        <Card.Img variant="top" src = {Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This card has supporting text below as a natural lead-in to additional
                                content.{' '}
                            </Card.Text>
                            <Button  variant="outline-dark">Search</Button>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant="top" src = {Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to
                                show that equal height action.
                            </Card.Text>
                            <Button  variant="outline-dark">Search</Button>
                        </Card.Body>

                    </Card>
                </CardDeck>
                <CardDeck  style = {cg1}>
                    <Card>
                        <Card.Img variant="top" src={Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.
                            </Card.Text>
                            <Button  variant="outline-dark">Search</Button>
                        </Card.Body>

                    </Card>
                    <Card>
                        <Card.Img variant="top" src = {Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This card has supporting text below as a natural lead-in to additional
                                content.{' '}
                            </Card.Text>
                            <Button  variant="outline-dark">Search</Button>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant="top" src = {Resort} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to
                                show that equal height action.
                            </Card.Text>
                            <Button  variant="outline-dark">Search</Button>
                        </Card.Body>

                    </Card>
                </CardDeck>
                <Pagination>

                </Pagination>
            </div>


        );









    }
}