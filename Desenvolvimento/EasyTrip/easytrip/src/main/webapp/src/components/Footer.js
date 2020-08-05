import React, {Component } from 'react';
import {Link} from 'react-router-dom';
import {Navbar, Container, Col} from 'react-bootstrap';

export default class Footer extends Component {
    render() {
        let fullYear = new Date().getFullYear();

        return (
            <Navbar fixed="bottom" bg="light" variant="dark">
                <Container>
                    <Col lg={12} className="text-center text-muted">
                        <div>{2020}-{fullYear+1}, All Rights Reserved by EasyTrip
                        <Link to={"Info"} className="nav-link">Info</Link></div>
                    </Col>
                </Container>
            </Navbar>
        );
    }
}