import React, {Component} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Row} from "react-bootstrap";

import GoogleMapReact from 'google-map-react';

const AnyReactComponent = ({ text }) => <div>{text}</div>;

export class Itinerary extends Component{

    static defaultProps = {
        center: {
            lat: 39.557191,
            lng: -7.8536599
        },
        zoom: 6
    };

    render() {
        return (

            <div style={{ height: '70vh', width: '70%' }}>
                <Row>

                </Row>
                <GoogleMapReact
                    bootstrapURLKeys={{ key:  "AIzaSyCTlmafkvB17b5ZsF884AusohJ9CW1aReg"}}
                    defaultCenter={this.props.center}
                    defaultZoom={this.props.zoom}
                >
                    <AnyReactComponent
                        lat={39.557191}
                        lng={-7.8536599}
                        text="My Marker"
                    />
                </GoogleMapReact>
            </div>
        );
    }

}
export default Itinerary;