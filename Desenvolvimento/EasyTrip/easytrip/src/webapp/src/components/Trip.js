import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Row, Col, Button, Jumbotron} from "react-bootstrap";
import {DateRangePicker} from "react-dates";
import Background from "../assets/images/imagem.png";
import {Itinerary} from "./Itinerary";
import ResultsAccommodation from "./ResultsAccommodation";
import axios from 'axios';


export class Trip extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            startDate: null,
            endDate: null,
            CurrentAccomodations : [],
            currentPage : -1,
            personsPerPage : 5,
            sortDir: "asc"
        }
    }
    componentDidMount() {
            this.findAllAccommodations(this.state.currentPage);
    }
    findAllPersons(currentPage) {
                currentPage -= 1;
                axios.get("http://localhost:8081/api/test/accommodations?pageNumber="+currentPage+"&pageSize="+this.state.personsPerPage+"&sortBy=id&sortDir="+this.state.sortDir)
                    .then(response => response.data)
                    .then((data) => {
                        this.setState({
                            persons: data.content,
                            totalPages: data.totalPages,
                            totalElements: data.totalElements,
                            currentPage: data.number + 1
                        });
                    });
            };


    render() {

        const  jumbstyle = {
            backgroundImage: `url(${Background})`,
            backgroundPosition: 'top',
            backgroundSize: 'cover',

        };
        const {
              allCountries,
              CurrentAccomodations,
              currentPage,
              totalPages
            } = this.state;



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
                     {CurrentAccomodations.map(accomodation => (
                         <ResultsAccommodation key={accomodation.id} />
                     ))}
                </Row>

                <Row>
                    <h5>TRANSPORTES</h5>
                </Row>

                <Row>
                    <Col>
                        <h5> ITINERÁRIO: </h5>
                    </Col>
                    <Col>
                        <Itinerary/>
                    </Col>

                </Row>
            </div>
        );
    }
}