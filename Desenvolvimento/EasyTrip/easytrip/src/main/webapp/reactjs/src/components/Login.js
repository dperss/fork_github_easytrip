import React from "react";
import 'bootstrap/dist/css/bootstrap-grid.min.css';
import Background from '../assets/images/imagem.png';



import {Form, Button, Container, Jumbotron} from 'react-bootstrap';



export default class Login extends React.Component{

    constructor(props){
    super(props);
    this.state = this.initialState;

    }

    initialState ={
    id:'',
    email:'',
    password:'',
    };


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


                            <Button style = {{marginTop: "20px"}} variant = "dark" type="submit" href = "/">
                                Confirmar
                            </Button>

                        </Form>

            </Container>
            </div>
        );
    }
}