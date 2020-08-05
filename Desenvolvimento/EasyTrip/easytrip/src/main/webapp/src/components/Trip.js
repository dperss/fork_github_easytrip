import React, { Component } from 'react';
import {
    Button,
    Form,
    FormControl,
    Row,
    Tab,
    Col,
    Table,
    Jumbotron,
    Container, FormGroup, CardDeck, Card, Tabs
} from "react-bootstrap";
import uuid from "uuid";
import {Map, InfoWindow, Marker, GoogleApiWrapper} from 'google-maps-react';
import LocationSearchInput from "./component/location-search";
import { geocodeByAddress, getLatLng } from "react-places-autocomplete";

const containerStyle = {
  position: 'relative',
  width: '100%',
  height: '100%'
}
const style = {
  width: '100%',
  height: 500
}


export class Trip extends React.Component{
state = {
    wayPoints: [
      {
        id: uuid.v4(),
        fromAddress: "",
        toAddress: "",
        fromLat: 0,
        fromLng: 0,
        toLat: 0,
        toLng: 0,
        geoCodedWayPoints: []
      }
    ]
  };

fetchPlaces(mapProps, map) {
  const {google} = mapProps;
  const service = new google.maps.places.PlacesService(map);
  // ...
}

    render(){
var points = [
    { lat: 42.02, lng: -77.01 },
    { lat: 42.03, lng: -77.02 },
    { lat: 41.03, lng: -77.04 },
    { lat: 42.05, lng: -77.02 }
]
var bounds = new this.props.google.maps.LatLngBounds();
for (var i = 0; i < points.length; i++) {
  bounds.extend(points[i]);
}

    if (!this.props.loaded) {
          return <div>Loading...</div>
        }

        return(



                <Container containerStyle={containerStyle}>
                    <Row>
                        <Col sm={4}>
<div class="container">
        <div class="row">
          <LocationSearchInput
            handleFromChange={this.handleFromChange}
            handleFromSelect={this.handleFromSelect}
            handleToChange={this.handleToChange}
            handleToSelect={this.handleToSelect}
            handleAddLocation={this.handleAddLocation}
            handleDeleteLocation={this.handleDeleteLocation}
            getAllRoutes={this.getAllRoutes}
            handleSelectRoute={this.handleSelectRoute}
            wayPoints={wayPoints}
          />
        </div>
      </div>



                        </Col>
                        <Col sm={8} style={style}>

                        <Map
                                google={this.props.google}

                                initialCenter={{
                                    lat: 42.39,
                                    lng: -72.52
                                }}
                                bounds={bounds}>
                            </Map>
                        </Col>

                      </Row>



                </Container>


        );


    }
}

export default GoogleApiWrapper({
  apiKey: 'AIzaSyCTlmafkvB17b5ZsF884AusohJ9CW1aReg'
})(Trip)