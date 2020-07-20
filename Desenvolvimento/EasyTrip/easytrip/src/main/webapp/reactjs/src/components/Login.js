import React,{Component} from "react";
import 'bootstrap/dist/css/bootstrap-grid.min.css';
import {Container, Form, Jumbotron, Button} from "react-bootstrap";
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

        return (
            <div >

                <Container>
                <Jumbotron style = {{backgroundImage: `url(${Background})`, backgroundPosition: "center", backgroundSize: "cover", width: "115%"}}>
                    <h1 style = {{fontFamily: "Hobo Std", fontSize: "70px", textAlign: "left"}}>
                    Login
                    </h1>
                </Jumbotron>
                </Container>
                <Container >
                            <Form style = {{marginTop: "5%"}} onSubmit={this.submitPerson} id="personFormId">
                            <Form.Group  controlId="formGridEmail">
                                <Form.Label>Email</Form.Label>
                                <Form.Control required autoComplete="on"
                                type="email" name="email"
                                value={email}
                                onChange={this.personChange}
                                placeholder="Enter email" />
                            </Form.Group>

                            <Form.Group controlId="formGridPassword">
                                <Form.Label>Password</Form.Label>
                                <Form.Control required autoComplete="off"
                                type="password" name="password"
                                value={password}
                                onChange={this.personChange}
                                placeholder="Password" />
                            </Form.Group>
                            <p> Ainda não tem conta?
                                <a href = "/registration" > Registe-se</a>
                            </p>


                            <Button variant="primary" type="submit">
                               Submit
                            </Button>

                        </Form>

            </Container>
            </div>
        );
    }
}