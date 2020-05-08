import React from "react";
import {
    Button,
    Form,
    FormControl,
    Nav,
    Navbar,
    NavDropdown,
    Row,
    Tab,
    Col,
    Jumbotron,
    Container, FormGroup, CardDeck, Card,
} from "react-bootstrap";
import {DateRangePicker} from "react-dates";
import Hoteis from "../assets/hoteis.jpg";





export default class viajar extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            startDate: null,
            endDate: null

        }
    }
    render(){

        return(
            <div>
                <Navbar bg = "dark" variant = "dark" fixed = "top">
                    <Navbar.Brand href = "/" style = {{fontFamily: "Hobo Std"}} >EasyTrip</Navbar.Brand>
                    <NavDropdown title = "" id = "basic-nav-dropdown">
                        <NavDropdown.Item href = "/perfil">Perfil</NavDropdown.Item>
                        <NavDropdown.Item >LogOut</NavDropdown.Item>
                    </NavDropdown>
                    <Nav className="mr-auto">

                    </Nav>
                    <Form inline>
                        <FormControl type="text" placeholder="Procura" className="mr-sm-4" icon = "search" />
                        <Button  variant="outline-light" >Procura</Button>
                    </Form>

                </Navbar>

                    <Container>

                        <Tab.Container id="pills" defaultActiveKey="alojamentos" >
                            <Row style = {{marginTop: "100px", marginLeft: "-20%"}}>
                                <Col sm={3}>
                                    <Nav variant="pills" className="flex-column" >
                                        <Nav.Item>
                                            <Nav.Link eventKey="alojamentos">Alojamentos</Nav.Link>
                                        </Nav.Item>
                                        <Nav.Item>
                                            <Nav.Link eventKey="transportes">Transportes</Nav.Link>
                                        </Nav.Item>
                                        <Nav.Item>
                                            <Nav.Link eventKey="itinerario">Itinerário</Nav.Link>
                                        </Nav.Item>

                                    </Nav>
                                </Col>
                                <Col sm={9}>
                                    <Tab.Content>
                                        <Tab.Pane eventKey="alojamentos">
                                            <Jumbotron style = {{width: "300px", marginLeft: "20px" }}>
                                                <Form >
                                                    <FormControl type="text" placeholder = "Para onde?" className="mr-sm-4" />

                                                </Form>
                                                <FormGroup style = {{marginTop:"30px"}}>
                                                    <DateRangePicker
                                                        startDate = {this.state.startDate}
                                                        startDateId = "your_unique_start_date_id"
                                                        endDate = {this.state.endDate}
                                                        endDateId = "your_unique_end_date_id"
                                                        onDatesChange = {({ startDate, endDate }) => this.setState({ startDate, endDate })}
                                                        focusedInput = {this.state.focusedInput}
                                                        onFocusChange = {focusedInput => this.setState({ focusedInput })}

                                                    />
                                                </FormGroup>
                                                <Button variant="outline-dark" type="submit">Procurar</Button>




                                                <h1 style = {{fontFamily: "Times New Roman", marginTop: "70px"}}> Filtrar por:</h1>
                                                <h4 style = {{fontFamily: "Times New Roman", width: "50px", textDecorationLine: "underline"}}> Tipo  </h4>

                                                <Form.Group controlId = "formBasicCheckbox" style = {{fontFamily: "Times New Roman", fontSize: "15px", width: "60px"}}>
                                                    <Form.Check  type = "checkbox" label = " Hotéis"   />
                                                    <Form.Check type = "checkbox" label = "Resorts" />
                                                    <Form.Check type = "checkbox" label = "Hostel" />
                                                    <Form.Check type = "checkbox" label = "Campismo" />
                                                </Form.Group>

                                                <h4 style = {{fontFamily: "Times New Roman", width: "70px", textDecorationLine: "underline"}}> Qualidade</h4>
                                                <Form.Group controlId = "formBasicCheckbox" style = {{fontFamily: "Times New Roman", fontSize: "15px", width: "40px"}}>
                                                    <Form.Check  type = "checkbox" label = "5*"   />
                                                    <Form.Check type = "checkbox" label = "4*" />
                                                    <Form.Check type = "checkbox" label = "3*" />
                                                    <Form.Check type = "checkbox" label = "2*" />
                                                    <Form.Check type = "checkbox" label = "1*" />
                                                </Form.Group>


                                                <CardDeck style = {{ marginTop: "-670px",marginLeft: "117%", width: "50rem", backgroundColor: "secondary",}}>
                                                    <Card>
                                                        <Card.Img variant = "top" src={Hoteis} />
                                                        <Card.Body>
                                                            <Card.Title>Card title</Card.Title>
                                                            <Card.Text>
                                                                This is a wider card with supporting text below as a natural lead-in to
                                                                additional content. This content is a little bit longer.
                                                            </Card.Text>
                                                            <Button   variant = "outline-dark">Adicionar</Button>
                                                        </Card.Body>

                                                    </Card>
                                                    <Card>
                                                        <Card.Img variant="top" src = {Hoteis} />
                                                        <Card.Body>
                                                            <Card.Title>Card title</Card.Title>
                                                            <Card.Text>
                                                                This card has supporting text below as a natural lead-in to additional
                                                                content.{' '}
                                                            </Card.Text>
                                                            <Button  variant = "outline-dark">Adicionar</Button>
                                                        </Card.Body>
                                                    </Card>

                                                </CardDeck>
                                                <CardDeck style = {{ marginTop: "70px", marginLeft: "117%", width: "50rem", backgroundColor: "secondary",}}>
                                                    <Card>
                                                        <Card.Img variant = "top" src={Hoteis} />
                                                        <Card.Body>
                                                            <Card.Title>Card title</Card.Title>
                                                            <Card.Text>
                                                                This is a wider card with supporting text below as a natural lead-in to
                                                                additional content. This content is a little bit longer.
                                                            </Card.Text>
                                                            <Button  variant = "outline-dark">Adicionar</Button>
                                                        </Card.Body>

                                                    </Card>
                                                    <Card>
                                                        <Card.Img variant = "top" src = {Hoteis} />
                                                        <Card.Body>
                                                            <Card.Title>Card title</Card.Title>
                                                            <Card.Text>
                                                                This card has supporting text below as a natural lead-in to additional
                                                                content.{' '}
                                                            </Card.Text>
                                                            <Button  variant = "outline-dark">Adicionar</Button>
                                                        </Card.Body>
                                                    </Card>

                                                </CardDeck>

                                            </Jumbotron>

                                        </Tab.Pane>
                                    </Tab.Content>
                                </Col>
                            </Row>
                        </Tab.Container>
                    </Container>


            </div>

        );

    }


}