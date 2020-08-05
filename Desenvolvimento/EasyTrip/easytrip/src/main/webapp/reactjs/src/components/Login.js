import React,{Component} from "react";
import 'bootstrap/dist/css/bootstrap-grid.min.css';
import {Container, Form, Jumbotron, Button, Row, Col} from "react-bootstrap";
import Background from "../assets/images/imagem.png";


import axios from 'axios';
import MyToast from './MyToast';




export default class Login extends React.Component{



    constructor(props){
        super(props)

        this.state ={
            email:'',
            password:'',
            loginErrors: ""
        };

        this.login = this.login.bind(this);
        this.onChange = this.onChange.bind(this);
        }

        login(e) {
        const{email, password} = this.state;

            axios.post("http://localhos:8081/login",
                {
                    user: {
                        email: email,
                        password: password
                    }
                },
                {withCredentials: true}
                )
                .then(response => {
                    console.log("res from login", response);
                })
                .catch(error => {
                   console.log("login error", error);

                });
            e.preventDefault();
        }

        onChange (e) {
        this.setState({[e.target.name]: e.target.value});
        }



    render() {


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
                            <Form>
                                <Form.Group >
                                    <Form.Label>Password</Form.Label>
                                    <Form.Control
                                                  type="text" name="email"
                                                  onChange={this.onChange}
                                                  placeholder="email" />
                                </Form.Group>
                            </Form>
                        </Col >
                        <Col sm>
                            <Form>
                                <Form.Group >
                                    <Form.Label>Password</Form.Label>
                                    <Form.Control
                                                  type="password" name="password"
                                                  onChange={this.onChange}
                                                  placeholder="Password" />
                                </Form.Group>
                            </Form>
                        </Col>
                    </Row>
                    <Row>
                        <Col sm>
                            <button variant="primary" type="submit" onClick={this.login}>
                                Confirmar
                            </button>
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