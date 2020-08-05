import React,{Component} from "react";
import 'bootstrap/dist/css/bootstrap-grid.min.css';
import {Container, Form, Jumbotron, Button, Row, Col} from "react-bootstrap";
import Background from "../assets/images/imagem.png";
import axios from 'axios';
import MyToast from './MyToast';
import { login } from "../services/person/auth";



export default class Login extends React.Component{



    constructor(props){
        super(props);
        this.state = this.initialState;
        this.state.show = false;
        this.personChange = this.personChange.bind(this);
        this.submitPerson = this.submitPerson.bind(this);
        }

        initialState ={
        email:'',
        password:'',
        };


        submitPerson = event => {

            event.preventDefault();

            const person = {
            email: this.state.email,
            password:this.state.password,
            nome:this.state.nome
            };

            if(this.state.password === this.state.confirm_password){
            axios.post("http://localhost:8081/rest/persons",person)
                .then(response => {
                    if(response.data != null){
                    this.setState({"show":true})
                    setTimeout(() => this.setState({"show":false}), 3000);
                    } else{
                    this.setState({"show":false})
                    }
                });
                this.setState(this.initialState);
             }else{
                //Meter mensagem de erro passwords não serem iguais
             }

        }

        personChange = event => {
                this.setState({
                    [event.target.name]:event.target.value
                });


        }

    render() {
    const {email,password} = this.state;

        const  jumblog =  {
            backgroundImage: `url(${Background})`,
            backgroundPosition: "center",
            backgroundSize: "cover",
        };

        const lg = {
            fontFamily: "Hobo Std",
            fontSize: "300%",
            textAlign: "left"
        };


        return (
            <div >

                <Container>
                    <Row>
                        <Col sm>
                            <Jumbotron style = {jumblog}>
                                <h1 style = {lg}>
                                    Login
                                </h1>
                            </Jumbotron>
                        </Col>
                    </Row>
                    <Row>
                        <Col sm>
                            <Form  onSubmit={this.submitPerson} id="personFormId">
                                <Form.Group  controlId="formGridEmail">
                                    <Form.Label>Email</Form.Label>
                                    <Form.Control required autoComplete="on"
                                                  type="email" name="email"
                                                  value={email}
                                                  onChange={this.personChange}
                                                  placeholder="Enter email" />
                                </Form.Group>
                            </Form>

                        </Col >
                        <Col sm>
                            <Form  onSubmit={this.submitPerson} id="personFormId">
                                <Form.Group controlId="formGridPassword">
                                    <Form.Label>Password</Form.Label>
                                    <Form.Control required autoComplete="off"
                                                  type="password" name="password"
                                                  value={password}
                                                  onChange={this.personChange}
                                                  placeholder="Password" />
                                </Form.Group>
                            </Form>
                        </Col>
                    </Row>
                    <Row>
                        <Col sm>
                            <Button variant="primary" type="submit">
                                Confirmar
                            </Button>
                        </Col>

                    </Row>
                    <Row>
                        <Col sm>
                            <p> Ainda não tem conta?
                                <a href = "/registration" > Registe-se</a>
                            </p>

                        </Col>
                    </Row>
                </Container>
            </div>
        );
    }
}