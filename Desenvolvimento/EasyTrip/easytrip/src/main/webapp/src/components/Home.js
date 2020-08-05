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
    Col,
    Card,
    CardDeck
} from "react-bootstrap";
import {DateRangePicker} from "react-dates";
import Hoteis from "../assets/images/hoteis.jpg";

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
                                Bem Vindos!
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
                <Row>
                    <Col >
                        <h2 style = {{marginTop: "10%"}}> Melhores classificados </h2>
                    </Col>
                </Row>
                <Row>
                    <CardDeck style = {{ width: "30rem", backgroundColor: "secondary",}}>
                        <Card>
                            <Card.Img variant="top" src={Hoteis} />
                            <Card.Body>
                                <Card.Title as = "h5" >

                                </Card.Title>
                                <Card.Text>
                                    This is a wider card with supporting text below as a natural lead-in to
                                    additional content. This content is a little bit longer.
                                </Card.Text>
                                <Button  variant="outline-dark">Procurar</Button>
                            </Card.Body>

                        </Card>
                    </CardDeck>
                </Row>
                <Row>

                </Row>


            </div>
        );
    }
}