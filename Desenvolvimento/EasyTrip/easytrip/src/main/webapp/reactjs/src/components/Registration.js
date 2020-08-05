import React,{Component} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Container, Form, Jumbotron, Button} from "react-bootstrap";
import Background from "../assets/images/imagem.png";
import axios from 'axios';
import MyToast from './MyToast';


export default class Registo extends Component{

    constructor(props) {
        super(props);

        this.state = {
            email: "",
            password: "",
            password_confirmation: "",
            username: "",
            registrationError: ""
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);

    }
    handleSubmit (event){
        const {email, password, password_confirmation, username} = this.state;
        axios.post("http://localhost:8081/api/users", {
             user:{
                 email: email,
                 password: password,
                 password_confirmation: password_confirmation,
                 username: username
             }
        },
            {withCredentials: true} )
            .then(response => {
                console.log("registration res", response);
            })
            .catch(error => {
            console.log("registration error", error);
        })

        event.preventDefault();

    }

    handleChange (event) {
        this.setState({
            [event.target.name]: event.target.value
            }
        )


    }


    render(){
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




                            <Form style = {{marginTop: "5%"}} onSubmit = {this.handleSubmit} id="personFormId">

                                <Form.Group  controlId="formGridEmail">
                                    <Form.Label>Email</Form.Label>
                                    <Form.Control required
                                                  type="email" name="email"
                                                  value={this.state.email}
                                                  onChange={this.handleChange}
                                                  placeholder="Enter email" />
                                </Form.Group>

                                <Form.Group controlId="formGridPassword">
                                    <Form.Label>Password</Form.Label>
                                    <Form.Control required
                                                  type="password" name="password"
                                                  value={this.state.password}
                                                  onChange={this.handleChange}
                                                  placeholder="Password" />
                                </Form.Group>

                                <Form.Group controlId="formGridPassword_confirmation">
                                    <Form.Label>Confirm Password</Form.Label>
                                    <Form.Control required
                                                  type="password" name="password_confirmation"
                                                  value={this.state.password_confirmation}
                                                  onChange={this.handleChange}
                                                  placeholder="Confirm Password" />
                                </Form.Group>


                                <Form.Group  controlId="formGridNome">
                                    <Form.Label>Username</Form.Label>
                                    <Form.Control
                                        type="text"
                                        name="username"
                                        value={this.state.username}
                                        onChange={this.handleChange}
                                        placeholder="Username" />
                                </Form.Group>

                                <Button variant="primary" type="submit">
                                    Registo
                                </Button>
                            </Form>

                           </Container>

                       </div>
       </div>





        );
    }
}