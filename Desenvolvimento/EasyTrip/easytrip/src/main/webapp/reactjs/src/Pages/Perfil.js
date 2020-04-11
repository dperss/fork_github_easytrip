import React from "react";
import {
    Button,
    Col,
    Container,
    Form,
    FormControl, InputGroup,
    Jumbotron,
    Nav,
    Navbar,
    NavDropdown,
    Row,
    Tab,
} from "react-bootstrap";


import Background from "../assets/imagem.png";


export default class Perfil extends React.Component {

    render() {

        const jum = {
            backgroundImage: `url(${Background})`,
            backgroundPosition: "center",
            backgroundSize: "cover",
            height: "180px",

        };


        const r = {
            marginTop: "100px",


        };

        const perfil = {
            textAlign: "left",
            fontFamily: "Hobo Std",
            fontSize: "70px"
        };


        return (

            <div>
                <Navbar bg="dark" variant="dark">
                    <Navbar.Brand href = "/">EasyTrip</Navbar.Brand>
                    <NavDropdown title="" id="basic-nav-dropdown">
                        <NavDropdown.Item href="/info">Informações</NavDropdown.Item>


                    </NavDropdown>
                    <Nav className="mr-auto">
                        <Nav.Link href = "/alojamentos">Alojamentos</Nav.Link>
                        <Nav.Link href = "/transportes">Transportes</Nav.Link>

                    </Nav>
                    <Form inline>
                        <FormControl type="text" placeholder="Search" className="mr-sm-4" />
                        <Button  variant="outline-light">Search</Button>
                    </Form>

                </Navbar>
                <Container>
                    <Jumbotron style = {jum}>
                        <h1 style = {perfil}>
                            Perfil
                         </h1>

                     </Jumbotron>
                    <Tab.Container id="left-tabs-example" defaultActiveKey="first" >
                         <Row style = {r}>
                             <Col sm={3}>
                                 <Nav variant="pills" className="flex-column" >
                                     <Nav.Item>
                                         <Nav.Link eventKey="first">Geral</Nav.Link>
                                     </Nav.Item>
                                     <Nav.Item>
                                         <Nav.Link eventKey="second">Mensagens</Nav.Link>
                                     </Nav.Item>
                                     <Nav.Item>
                                         <Nav.Link eventKey="third">Biblioteca</Nav.Link>
                                     </Nav.Item>
                                     <Nav.Item>
                                         <Nav.Link eventKey="four">As minhas viagens</Nav.Link>
                                     </Nav.Item>
                                </Nav>
                             </Col>
                             <Col sm={9}>
                                <Tab.Content>
                                    <Tab.Pane eventKey="first">
                                            <Jumbotron >
                                                <h2> Informações adicionais</h2>
                                                <Form>
                                                    <Form.Group as={Col} controlId="formGridEmail">
                                                        <Form.Label>Contacto</Form.Label>
                                                        <Form.Control type="email" placeholder="Email" />
                                                    </Form.Group>
                                                    <Form.Group controlId="exampleForm.ControlTextarea1">
                                                        <Form.Label>Descrição</Form.Label>
                                                        <Form.Control as="textarea" rows="3" />
                                                    </Form.Group>
                                                    <Button variant="outline-dark" type="submit">Confirmar</Button>
                                                </Form>

                                            </Jumbotron>
                                            <Jumbotron>
                                                <h2> Configurar geral </h2>

                                                <Form>
                                                    <Jumbotron>
                                                        <h5> Alterar Username</h5>
                                                            <Form.Group  as={Col} md="4" controlId="validationCustomUsername">
                                                                <Form.Label>Novo Username</Form.Label>
                                                                <InputGroup>
                                                                    <InputGroup.Prepend>
                                                                        <InputGroup.Text id="inputGroupPrepend">@</InputGroup.Text>
                                                                    </InputGroup.Prepend>
                                                                    <Form.Control type="text" placeholder="Username" aria-describedby="inputGroupPrepend" required/>
                                                                    <Form.Control.Feedback type="invalid">
                                                                        Por favor escolha outro username.
                                                                    </Form.Control.Feedback>
                                                                </InputGroup>
                                                            </Form.Group>
                                                        <Button variant="outline-dark" type="submit">Confirmar</Button>
                                                    </Jumbotron>

                                                    <Jumbotron>
                                                        <h5> Alterar Password</h5>

                                                            <Form.Group as={Col} md="5"controlId="formGroupPassword">
                                                                <Form.Label>Atual</Form.Label>
                                                                <Form.Control type="password" placeholder="Password" />
                                                            </Form.Group>
                                                            <Form.Group as={Col} md="5"controlId="formGroupPassword">
                                                                <Form.Label>Nova  </Form.Label>
                                                                <Form.Control type="password" placeholder="Nova Password" />
                                                            </Form.Group>
                                                        <Button variant="outline-dark" type="submit">Confirmar</Button>
                                                    </Jumbotron>


                                                </Form>
                                            </Jumbotron>
                                    </Tab.Pane>
                                    <Tab.Pane eventKey="second">
                                    <Nav variant="pills" defaultActiveKey="/home">
                                        <Nav.Item>
                                            <Nav.Link href="/home">Active</Nav.Link>
                                        </Nav.Item>
                                        <Nav.Item>
                                            <Nav.Link eventKey="link-1">Option 2</Nav.Link>
                                        </Nav.Item>
                                        <Nav.Item>
                                            <Nav.Link eventKey="disabled" disabled>
                                                Disabled
                                            </Nav.Link>
                                        </Nav.Item>
                                    </Nav>
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