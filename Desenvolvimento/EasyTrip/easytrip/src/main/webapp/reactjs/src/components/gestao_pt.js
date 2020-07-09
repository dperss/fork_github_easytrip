import React from "react";
import {Button, Container, Form, FormControl, Nav, Navbar, NavDropdown, Table} from "react-bootstrap";

export default class gestao_pt extends React.Component{

    render(){
        return(

            <div>
                <Navbar bg = "dark" variant = "dark" fixed = "top">
                    <Navbar.Brand href = "/" style = {{fontFamily: "Hobo Std"}} >EasyTrip</Navbar.Brand>
                    <NavDropdown title = "" id = "basic-nav-dropdown">
                        <NavDropdown.Item href = "/login">Login</NavDropdown.Item>
                        <NavDropdown.Item href = "/registo">Registo</NavDropdown.Item>
                    </NavDropdown>
                    <Nav className="mr-auto">



                    </Nav>
                    <Form inline>
                        <FormControl type="text" placeholder="Procura" className="mr-sm-4" icon = "search" />
                        <Button  variant="outline-light" >Procura</Button>
                    </Form>

                </Navbar>
                <Container style = {{marginTop: "100px"}}>
                    <Table responsive >
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Tipo</th>
                            <th>Localização</th>
                            <th>Nome</th>
                            <th>Avaliação</th>
                            <th>Descrição</th>
                            <th>Preço</th>
                            <Button  variant = "outline-dark" >Adicionar</Button>
                            <Button  variant = "outline-dark" style = {{marginLeft: "5px"}}>Eliminar</Button>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </Table>


                </Container>

            </div>
        );


    }
}