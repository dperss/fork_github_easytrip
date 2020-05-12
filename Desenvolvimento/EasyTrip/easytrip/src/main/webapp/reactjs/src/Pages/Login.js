import React from "react";
import 'bootstrap/dist/css/bootstrap-grid.min.css';
import Background from '../assets/imagem.png';



import {Form, Button, Container, Jumbotron} from 'react-bootstrap';



export default class Login extends React.Component{

    render() {







        return (
            <div >

                <Container>
                <Jumbotron style = {{backgroundImage: `url(${Background})`, backgroundPosition: "center",backgroundSize: "cover"}}>
                    <h1  style = {{fontFamily: "Hobo Std",fontSize: "70px",textAlign: "left"}}>
                        Login
                    </h1>
                </Jumbotron>
                </Container>
                <Container >
                        <Form style = {{marginTop: "100px",width: "500px",marginLeft: "300px"}}>
                            <Form.Group controlId="formBasicEmail">
                                <Form.Label>Email</Form.Label>
                                <Form.Control  type = "email" placeholder = "Introduza o email" />
                            </Form.Group>

                            <Form.Group controlId="formBasicPassword">
                                <Form.Label >Password</Form.Label>
                                <Form.Control type = "password" placeholder = "Password" />
                            </Form.Group>
                            <p> Ainda não tem conta?
                                <a href = "/registo" > Registe-se</a>
                            </p>


                            <Button style = {{marginTop: "20px"}} variant = "dark" type="submit" href = "/">
                                Confirmar
                            </Button>

                        </Form>

            </Container>
            </div>
        );
    }
}