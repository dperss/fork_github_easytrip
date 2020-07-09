import React from "react";
import moment from "moment";
import 'react-dates/initialize';
import 'react-dates/lib/css/_datepicker.css';
import "react-datepicker/dist/react-datepicker.css";
import 'bootstrap/dist/css/bootstrap.min.css';

import Background from "../assets/images/imagem.png";
import {
    Jumbotron,
    Form,
    FormControl,
    Button,
    FormGroup,
    Card,
    CardDeck
} from "react-bootstrap";
import {DateRangePicker} from "react-dates";
import Hoteis from "../assets/images/hoteis.jpg";
import Resort from "../assets/images/e24547b6d0b63924294191179d76e798.jpg";

moment.locale("pt");




export default class Home extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            startDate: null,
            endDate: null

        }
    }


    render() {




        return (

            <div  >


                        <Form inline>
                            <FormControl type="text" placeholder="Procura" className="mr-sm-4" />
                            <Button  variant="outline-light">Procura</Button>
                        </Form>





                    <Jumbotron  style = {{backgroundImage: `url(${Background})`, backgroundPosition: "center", backgroundSize: "cover", height: "180px"}}>

                        <h1 style = {{fontFamily: "Hobo Std", fontSize: "70px",textAlign: "left"}}>
                            Bem Vindo!
                        </h1>

                    </Jumbotron>

                <FormGroup style = {{ padding: "10px" }}>
                        <Form.Control  style = {{width: "800px", marginLeft: "400px"}} type = "text" placeholder = "  Para onde vai?" />

                </FormGroup>
                <FormGroup>
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
                <Button variant="outline-dark" type="submit" href = "/viajar"> Viajar</Button>
                <h2 style = {{marginTop: "100px"}}> Melhores classificados </h2>
                <CardDeck style = {{marginTop: "50px", marginLeft: "3%",width: "90rem",backgroundColor: "secondary",}}>

                    <Card>
                        <Card.Img variant="top" src={Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.
                            </Card.Text>
                            <Button  variant="outline-dark">Procurar</Button>
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
                            <Button  variant="outline-dark">Procurar</Button>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant="top" src = {Resort} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to
                                show that equal height action.
                            </Card.Text>
                            <Button  variant="outline-dark">Procurar</Button>
                        </Card.Body>

                    </Card>
                </CardDeck>
                <h2 style = {{marginTop: "100px"}}> Mais vistos </h2>
                <CardDeck style = {{marginTop: "50px", marginLeft: "3%",width: "90rem",backgroundColor: "secondary",}}>

                    <Card>
                        <Card.Img variant="top" src={Hoteis} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This content is a little bit longer.
                            </Card.Text>
                            <Button  variant="outline-dark">Procurar</Button>
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
                            <Button  variant="outline-dark">Procurar</Button>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Img variant="top" src = {Resort} />
                        <Card.Body>
                            <Card.Title>Card title</Card.Title>
                            <Card.Text>
                                This is a wider card with supporting text below as a natural lead-in to
                                additional content. This card has even longer content than the first to
                                show that equal height action.
                            </Card.Text>
                            <Button  variant="outline-dark">Procurar</Button>
                        </Card.Body>

                    </Card>
                </CardDeck>



        <footer style = {{width: "150px"}}>
            <a href = "/info" > Sobre EasyTrip</a>
        </footer>














            </div>
        );
    }
}