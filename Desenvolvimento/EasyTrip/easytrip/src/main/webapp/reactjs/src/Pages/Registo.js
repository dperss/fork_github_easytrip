import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

import {Container, Form, InputGroup, Col, Jumbotron, Button} from "react-bootstrap";
import Background from "../assets/imagem.png";



export default class Registo extends React.Component{
    render(){

     const form = {
         marginTop: "100px"

     };
     const jum = {
            backgroundImage: `url(${Background})`,
            backgroundPosition: "center",
            backgroundSize: "cover",
            width: "100vh"

        };
        const h1 = {
            fontFamily: "Hobo Std",
            fontSize: "70px",
            textAlign: "left"
        };

        const  bt = {
            marginTop: "100px"
        };



       return (
           <div >
               <Container>

                   <Jumbotron style = {jum}>
                       <h1 style = {h1}>
                           Registo
                       </h1>
                   </Jumbotron>


                <Form style = {form}>
                    <Form.Row >
                        <Form.Group  as={Col} md="4" controlId="validationCustomUsername">
                            <Form.Label>Username</Form.Label>
                            <InputGroup>
                                <InputGroup.Prepend>
                                    <InputGroup.Text id="inputGroupPrepend">@</InputGroup.Text>
                                </InputGroup.Prepend>
                                <Form.Control type="text" placeholder="Username" aria-describedby="inputGroupPrepend" required/>
                                <Form.Control.Feedback type="invalid">
                                    Por favor escolha outro username.
                                </Form.Control.Feedback>
                            </InputGroup>
                        </Form.Group>
                    </Form.Row>
                    <Form.Row>
                        <Form.Group as={Col} md="4" controlId="validationCustom01">
                            <Form.Label>Primeiro Nome</Form.Label>
                            <Form.Control required type="text" placeholder="Primeiro Nome"/>
                        </Form.Group>
                        <Form.Group as={Col} md="4" controlId="validationCustom02">
                            <Form.Label>Último Nome</Form.Label>
                            <Form.Control required type="text" placeholder="Último Nome"/>
                        </Form.Group>

                    </Form.Row>
                    <Form.Row>
                        <Form.Group as={Col} controlId="formGridEmail">
                            <Form.Label>Email</Form.Label>
                            <Form.Control type="email" placeholder="Introduza o email" />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" placeholder="Password" />
                        </Form.Group>
                    </Form.Row>
                </Form>
                <Button style = {bt} variant="dark" type="submit">
                    Confirmar
                </Button>
               </Container>

           </div>



        );
    }
}