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
    Button,
    Col
} from "react-bootstrap";
import {DateRangePicker} from "react-dates";
import Accommodation from "./Accommodation";
import Point from "./Point";




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

            <div >
                <header>
                    <Jumbotron className = "jumbo-home">
                        <h1> Bem vindo!</h1>
                    </Jumbotron>
                </header>
                <main>

                    <section>
                        <Accommodation/>
                        <Point/>
                    </section>
                </main>



            </div>
        );
    }
}