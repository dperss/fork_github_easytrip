import React from "react";
import {
    Card
} from "react-bootstrap";
import axios from "axios";

axios.defaults.headers.common = {'Authorization': `Bearer ${"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjbGF1ZGlhIiwiaWF0IjoxNTk4MDk1NDA3LCJleHAiOjE1OTg1OTU0MDd9.FtQIrA-z7sY92YGPjyt6LV8QIS5Tn_FwTCYkmBevVVA"}`};

export default class TransportationDetail extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            accommodations: [],
        };
    }
    componentDidMount() {
        this.getAllTransportationData();
    }


    getAllTransportationData() {
        axios.get("http://localhost:8080/api/test/transportations/1")
            .then(response => {
                const data = response.data
                console.log(data)
                const transportation = [data].map( a =>
                    <div >
                        <Card style = {{width: "320px", height: "210px"}}>
                            <Card.Header> {a.name}</Card.Header>
                            <Card.Body>
                                <p>{a.location}</p>
                                <p> {a.description}</p>

                            </Card.Body>
                        </Card>


                    </div>)

                this.setState({
                    transportation
                })



            })
            .catch((error) => {
                console.log(error)
            })
    };






    render() {


        return(
            <div>
                {this.state.transportation}
            </div>


        );
    }


}
