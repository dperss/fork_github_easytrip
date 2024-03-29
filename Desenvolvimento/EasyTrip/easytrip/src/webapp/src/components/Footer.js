import React from 'react';
import {Link} from 'react-router-dom';
import {Navbar, Container, Col} from 'react-bootstrap';

const Footer = () => {

        let fullYear = new Date().getFullYear();

        return (
            <Navbar fixed="bottom" bg="transparent" variant="dark">
                <Container >
                    <Col lg={12} className="text-center text-muted">
                        <div>{2020}-{fullYear+1}, All Rights Reserved by EasyTrip
                        <Link to={"Info"} className="nav-link">Info</Link></div>
                    </Col>
                </Container>
            </Navbar>
        );

}

export default Footer;