import React,{Component} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Container, Form, Jumbotron, Button} from "react-bootstrap";
import Background from "../assets/images/imagem.png";
import axios from 'axios';
import MyToast from './MyToast';


export default class Registo extends Component{

    constructor(props){
    super(props);
    this.state = this.initialState;
    this.state.show = false;
    this.personChange = this.personChange.bind(this);
    this.submitPerson = this.submitPerson.bind(this);
    }

    initialState ={
    id:'',
    email:'',
    password:'',
    confirm_password:'',
    nome:''
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



    render(){
    const {email,password,nome,confirm_password} = this.state;
       return (
       <div>
            <div style={{"display":this.state.show ? "block" : "none"}}>
                <MyToast show = {this.state.show} message = {"Registo bem sucedido."} type = {"success"}/>
            </div>



            <div >
                           <Container>

                               <Jumbotron style = {{backgroundImage: `url(${Background})`, backgroundPosition: "center", backgroundSize: "cover", width: "115%"}}>
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
                                    value={confirm_password}
                                    onChange={this.personChange}
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
       </div>





        );
    }
}