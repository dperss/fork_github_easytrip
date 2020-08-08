import React from "react";
import moment from "moment";
import 'react-dates/initialize';
import 'react-dates/lib/css/_datepicker.css';
import "react-datepicker/dist/react-datepicker.css";
import 'bootstrap/dist/css/bootstrap.min.css';

import Background from "../assets/images/imagem.png";
import {
    Jumbotron,
    Form,
    Row,
    Button,
    Col, Card,
} from "react-bootstrap";
import {DateRangePicker} from "react-dates";




moment.locale("pt");




export default class Home extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            startDate: null,
            endDate: null

        }
        this.state = {
            name: null,
            description: null,
            img: null
        }

    }


    render() {



        const  jumbstyle = {
            backgroundImage: `url(${Background})`,
            backgroundPosition: 'top',
            backgroundSize: 'cover',

        };

        const bvindo = {
            fontFamily: 'Hobo Std',
            fontSize: '300%',
            textAlign: 'left'
        };

        return (

            <div >
                <Row>
                    <Col lg = {true}>
                        <Jumbotron style = {jumbstyle}>
                            <h1 style = {bvindo}>
                                Bem Vindo!
                            </h1>
                        </Jumbotron>
                    </Col>
                </Row>
                <Row>
                    <Col sm >
                        <Form>
                            <DateRangePicker
                                startDate = {this.state.startDate}
                                startDateId = "your_unique_start_date_id"
                                endDate = {this.state.endDate}
                                endDateId = "your_unique_end_date_id"
                                onDatesChange = {({ startDate, endDate }) => this.setState({ startDate, endDate })}
                                focusedInput = {this.state.focusedInput}
                                onFocusChange = {focusedInput => this.setState({ focusedInput })}

                            />
                        </Form>
                    </Col>
                    <Col sm >
                        <Form  >
                            <Form.Control  type = "text" placeholder = "  Para onde vai?" />

                        </Form>
                    </Col>

                    <Col sm >
                        <Button  variant="outline-dark" type="submit" href = "/viajar"> Viajar</Button>

                    </Col>
                </Row>

                <Row style = {{marginTop: "3%"}}>

                </Row>
                <Row>
                    <Card>
                        <Card.Body>
                            <Card.Title/>
                        </Card.Body>
                    </Card>

                </Row>


            </div>
        );
    }
}