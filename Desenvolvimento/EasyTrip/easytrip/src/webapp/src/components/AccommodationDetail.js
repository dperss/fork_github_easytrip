import React from "react";
import {
   Card
} from "react-bootstrap";
import axios from "axios";

axios.defaults.headers.common = {'Authorization': `Bearer ${"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjbGF1ZGlhIiwiaWF0IjoxNTk4MDk1NDA3LCJleHAiOjE1OTg1OTU0MDd9.FtQIrA-z7sY92YGPjyt6LV8QIS5Tn_FwTCYkmBevVVA"}`};

export default class AccommodationDetail extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            accommodations: [],
        };
    }
    componentDidMount() {
        this.getAllAccommodationData();
    }


    getAllAccommodationData() {
        axios.get("http://localhost:8080/api/test/accomodations/5")
            .then(response => {
                const data = response.data
                console.log(data)
                const accommodation = [data].map( a =>
                    <div >
                        <Card style = {{width: "500px", height: "300px"}}>
                            <Card.Header> {a.name}</Card.Header>
                            <Card.Body>
                                <p>{a.location}</p>
                                <p> {a.description}</p>
                                <button> Adicionar</button>

                            </Card.Body>
                        </Card>


                    </div>)

                this.setState({
                    accommodation
                })



            })
            .catch((error) => {
                console.log(error)
            })
    };






    render() {


        return(
            <div>
                {this.state.accommodation}
            </div>


        );
    }


}
