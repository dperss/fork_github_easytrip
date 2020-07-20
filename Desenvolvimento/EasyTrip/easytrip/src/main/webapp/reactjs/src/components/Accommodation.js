import React from "react";
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css';
import {
    Button,
    Form,
    FormControl,
    Nav,
    Navbar,
    NavDropdown,
    Card,
    CardDeck,
    Pagination,
    Jumbotron, FormGroup
} from "react-bootstrap";


import Hoteis from "../assets/images/hoteis.jpg";
import Resort from "../assets/images/e24547b6d0b63924294191179d76e798.jpg";

import {DateRangePicker} from "react-dates";




export default class Accommodation extends React.Component{

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


                <Jumbotron style = {{width: "350px", marginLeft: "30px", marginTop: "100px" }}>
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


                <CardDeck style = {{ marginTop: "-650px",marginLeft: "117%", width: "70rem", backgroundColor: "secondary",}}>
                    <Card>
                        <Card.Img variant = "top" src={Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.
                            </Card.Text>
                            <Button   variant = "outline-dark">Mostrar</Button>
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
                            <Button  variant = "outline-dark">Mostrar</Button>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant = "top" src = {Resort} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to
                                show that equal height action.
                            </Card.Text>
                            <Button  variant = "outline-dark">Mostrar</Button>
                        </Card.Body>

                    </Card>
                </CardDeck>
                <CardDeck style = {{marginTop: "50px", marginLeft: "117%", width: "70rem", backgroundColor: "secondary",}}>
                    <Card>
                        <Card.Img variant = "top" src={Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.
                            </Card.Text>
                            <Button  variant = "outline-dark">Mostrar</Button>
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
                            <Button  variant = "outline-dark">Mostrar</Button>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant = "top" src = {Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to
                                show that equal height action.
                            </Card.Text>
                            <Button  variant = "outline-dark">Mostrar</Button>
                        </Card.Body>

                    </Card>
                </CardDeck>
                <CardDeck  style = {{marginTop: "50px",marginLeft: "117%",width: "70rem", backgroundColor: "secondary",}}>
                    <Card>
                        <Card.Img variant = "top" src={Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.
                            </Card.Text>
                            <Button  variant = "outline-dark">Mostrar</Button>
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
                            <Button  variant = "outline-dark">Mostrar</Button>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant = "top" src = {Resort} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to
                                show that equal height action.
                            </Card.Text>
                            <Button  variant = "outline-dark">Mostrar</Button>
                        </Card.Body>

                    </Card>
                </CardDeck>
                    </Jumbotron>

                <Pagination>

                </Pagination>
                <footer style = {{width: "150px"}}>
                    <a href = "/info" > Sobre EasyTrip</a>
                </footer>

            </div>


        );









    }
}