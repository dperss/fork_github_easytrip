import React from "react";
import {
 Card
} from "react-bootstrap";
import axios from "axios";


export default class AccommodationDetail extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            accommodations: []

        };
    }

    getAccommodationData(){
            axios.get("http://localhost:8080/api/test/accomodations/4", {})
                .then(res => {
                const data = res.data
                console.log(data)
                    const accommodation = [data].map( a =>
                        <div >
                            <Card>
                                <Card.Header>
                                    Nome : {a.name}
                                </Card.Header>
                                <Card.Body>
                                    <Card.Title>
                                        {a.location}
                                    </Card.Title>
                                    <Card.Text>
                                        {a.description}

                                    </Card.Text>
                                </Card.Body>
                            </Card>


                        </div>



                    )
                    this.setState({
                        accommodation
                    })



            })
                .catch((error) => {
                    console.log(error)
                })
    }

    componentDidMount() {
        this.getAccommodationData()

    }



    render() {


        return(
            <div>
                {this.state.accommodation}
            </div>


        );
    }


}