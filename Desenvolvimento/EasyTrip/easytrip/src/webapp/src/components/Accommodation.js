import React from "react";
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css';
import {
    Button,
    Form,
    FormControl,
    Card,
    CardDeck,
    Pagination,
    Jumbotron,
    FormGroup
} from "react-bootstrap";


import Hoteis from "../assets/images/hoteis.jpg";
import Resort from "../assets/images/e24547b6d0b63924294191179d76e798.jpg";





export default class Accommodation extends React.Component{

    constructor(props) {
                super(props);
                this.state = {
                    accommodation : [],
                    currentPage : 0,
                    accommodationsPerPage : 0,
                    sortDir: "asc"
                };
            }



    render(){
        const {accommodation, currentPage, totalPages, search} = this.state;
        return(
            <div>





            </div>


        );









    }
}