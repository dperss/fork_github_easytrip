import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Row, Col, Button, Jumbotron} from "react-bootstrap";
import {DateRangePicker} from "react-dates";
import Background from "../assets/images/imagem.png";
import {Itinerary} from "./Itinerary";


export class Trip extends React.Component{
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



        return (
            <div>

                        <Jumbotron style = {jumbstyle}>
                            <Row>
                                <Col>
                                    <label> De onde:</label>
                                    <input className={"form-control"}
                                           type={"text"}
                                    />
                                </Col>
                                <Col>
                                    <label> Para onde:</label>
                                    <input className={"form-control"}
                                           type={"text"}
                                    />
                                </Col>
                            </Row>
                            <Row style = {{justifyContent: "center", marginTop: "10px"}}>

                                <DateRangePicker
                                    startDate = {this.state.startDate}
                                    startDateId = "your_unique_start_date_id"
                                    endDate = {this.state.endDate}
                                    endDateId = "your_unique_end_date_id"
                                    onDatesChange = {({ startDate, endDate }) => this.setState({ startDate, endDate })}
                                    focusedInput = {this.state.focusedInput}
                                    onFocusChange = {focusedInput => this.setState({ focusedInput })}

                                />

                            </Row>
                            <Row style = {{justifyContent: "center", marginTop: "10px"}}>
                                <Button variant="info" > Viajar </Button>
                            </Row>
                        </Jumbotron>



                <Row>


                </Row>



                <Row>

                    <h5>ALOJAMENTOS: </h5>



                </Row>

                <Row>
                    <h5>TRANSPORTES</h5>
                </Row>

                <Row>
                    <h5> ITINERÁRIO: </h5>
                    <Itinerary/>
                </Row>
            </div>
        );
    }
}