import React from "react";
import {Button, Container, Form, FormControl, Nav, Navbar, NavDropdown, Table} from "react-bootstrap";

export default class PointList extends React.Component{

    render(){
        return(

            <div>

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