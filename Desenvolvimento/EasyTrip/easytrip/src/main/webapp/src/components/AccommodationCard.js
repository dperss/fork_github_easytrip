import React, {Component} from "react";
import {Card} from "react-bootstrap";

class AccommodationCard extends Component{

    constructor() {
        super();
    }

    render() {
        return (
            <div>
                <Card>
                    <Card.Title></Card.Title>
                    <Card.Img></Card.Img>
                </Card>
            </div>
        );
    }
}