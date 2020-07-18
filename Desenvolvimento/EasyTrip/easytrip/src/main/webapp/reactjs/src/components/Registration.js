import React,{Component} from "react";
import {Card,Table} from 'react-bootstrap';

import 'bootstrap/dist/css/bootstrap.min.css';

import {Container, Form, InputGroup, Col, Jumbotron, Button} from "react-bootstrap";
import Background from "../assets/images/imagem.png";
import axios from 'axios';


export default class Registo extends Component{

    constructor(props){
    super(props);
    this.state = this.initialState;
    this.personChange = this.personChange.bind(this);
    this.submitPerson = this.submitPerson.bind(this);
    }

    initialState ={
    email:'',
    password:'',
    nome:''
    };

    submitPerson = event => {

        event.preventDefault();

        const person = {
        email: this.state.email,
        password:this.state.password,
        nome:this.state.nome
        };

        axios.post("http://localhost:8081/rest/persons",person)
            .then(response => {
                if(response.data != null){
                this.setState(this.initialState);
                alert("Person  Sucessfully");
                }
            });
    }

    personChange = event => {
            this.setState({
                [event.target.name]:event.target.value
            });
    }



    render(){
    const {email,password,nome} = this.state;
       return (
           <div >
               <Container>

                   <Jumbotron style = {{backgroundImage: `url(${Background})`, backgroundPosition: "center", backgroundSize: "cover", width: "100vh"}}>
                       <h1 style = {{fontFamily: "Hobo Std", fontSize: "70px", textAlign: "left"}}>
                           Registo
                       </h1>
                   </Jumbotron>




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

                      <Form.Group controlId="formGridConfirm_Password">
                        <Form.Label>Confirm Password</Form.Label>
                        <Form.Control required autoComplete="off"
                        type="password" name="confirm_password"
                         placeholder="Confirm Password" />
                      </Form.Group>


                        <Form.Group  controlId="formGridNome">
                          <Form.Label>Nome</Form.Label>
                          <Form.Control autoComplete="off"
                          type="text"
                          name="nome"
                          value={nome}
                          onChange={this.personChange}
                          placeholder="Nome" />
                        </Form.Group>

                      <Button variant="primary" type="submit">
                        Submit
                      </Button>
                </Form>

               </Container>

           </div>



        );
    }
}