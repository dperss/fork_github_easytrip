import React from "react";
import moment from "moment";
import 'react-dates/initialize';
import 'react-dates/lib/css/_datepicker.css';
import "react-datepicker/dist/react-datepicker.css";
import 'bootstrap/dist/css/bootstrap.min.css';

import {
    Jumbotron,
    Form,
    Row,
    Col,
} from "react-bootstrap";
import {DateRangePicker} from "react-dates";
import Accommodation from "./Accommodation";




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

        return (
            <div>
                <Jumbotron className = "jumbo-home">
                    Bem Vindo!
                </Jumbotron>
                <Row>
                    <Col>
                        <input type = "text"
                               placeholder = "Para onde?"
                               className = "searchbox-home"
                        />
                    </Col>

                    <Col>
                        <Form >
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
                    <Col>
                        <button className = "button-home"> Procurar</button>
                    </Col>
                </Row>
                <section>
                    <Accommodation/>
                </section>
            </div>



        );
    }
}