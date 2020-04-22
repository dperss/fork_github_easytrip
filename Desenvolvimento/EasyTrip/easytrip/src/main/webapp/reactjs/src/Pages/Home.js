import React from "react";
import moment from "moment";
import 'react-dates/initialize';
import 'react-dates/lib/css/_datepicker.css';
import "react-datepicker/dist/react-datepicker.css";
import 'bootstrap/dist/css/bootstrap.min.css';

import Background from "../assets/imagem.png";
import {Jumbotron, Nav, Navbar, Form, FormControl, Button, NavDropdown, FormGroup} from "react-bootstrap";
import {DateRangePicker} from "react-dates";

moment.locale("pt");




export default class Home extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            startDate: null,
            endDate: null

        }
    }


    render() {




        return (

            <div  >

                    <Navbar bg = "dark" variant = "dark" fixed = "top">
                        <Navbar.Brand style = {{fontFamily: "Hobo Std"}}>EasyTrip</Navbar.Brand>
                        <NavDropdown title = "" id = "basic-nav-dropdown">
                            <NavDropdown.Item href = "/login">Login</NavDropdown.Item>
                            <NavDropdown.Item href = "/registo">Registo</NavDropdown.Item>
                            <NavDropdown.Item href = "/info">Informações</NavDropdown.Item>
                            <NavDropdown.Item href = "/perfil">Perfil</NavDropdown.Item>
                        </NavDropdown>
                        <Nav className="mr-auto">
                            <Nav.Link href="/alojamentos">Alojamentos</Nav.Link>


                        </Nav>
                        <Form inline>
                            <FormControl type="text" placeholder="Procura" className="mr-sm-4" />
                            <Button  variant="outline-light">Procura</Button>
                        </Form>

                    </Navbar>



                    <Jumbotron  style = {{backgroundImage: `url(${Background})`, backgroundPosition: "center", backgroundSize: "cover", height: "180px"}}>

                        <h1 style = {{fontFamily: "Hobo Std", fontSize: "70px",textAlign: "left"}}>
                            Bem Vindo!
                        </h1>

                    </Jumbotron>

                <FormGroup style = {{ padding: "10px" }}>
                        <Form.Control  style = {{width: "800px", marginLeft: "550px"}} type = "text" placeholder = "  Para onde vai?" />

                </FormGroup>
                <FormGroup>
                    <DateRangePicker
                        startDate = {this.state.startDate}
                        startDateId = "your_unique_start_date_id"
                        endDate = {this.state.endDate}
                        endDateId = "your_unique_end_date_id"
                        onDatesChange = {({ startDate, endDate }) => this.setState({ startDate, endDate })}
                        focusedInput = {this.state.focusedInput}
                        onFocusChange = {focusedInput => this.setState({ focusedInput })}

                    />
                    </FormGroup>
                    <Button variant="outline-dark" type="submit"> Viajar</Button>



















            </div>
        );
    }
}