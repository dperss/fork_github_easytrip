import React from "react";
import {
 Card
} from "react-bootstrap";

export default class AccommodationDetail extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            title: '' ,
            description: '',
            location: '',
            price: '',
            photo: ''
        };
    }

    render() {
        return(

                    <Card >
                        <Card.Header>
                            Nome: {this.state.title}
                        </Card.Header>
                        <Card.Img>
                            {this.state.phone}
                        </Card.Img>
                        <Card.Body>
                            <Card.Title>
                                Localização: {this.state.location}
                            </Card.Title>
                            <Card.Text>
                                Neste alojamento pode contar: {this.state.description}
                            </Card.Text>
                        </Card.Body>
                    </Card>

        );
    }


}