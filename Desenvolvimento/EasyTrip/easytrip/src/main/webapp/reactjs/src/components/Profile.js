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
    Image,
} from "react-bootstrap";


import Background from "../assets/images/imagem.png";




export default class Profile extends React.Component {

    render() {







        return (

            <div>


                <Container>
                    <Jumbotron style = {{backgroundImage: `url(${Background})`,
                        backgroundPosition: "center",
                        backgroundSize: "cover",
                        height: "180px"}}>
                        <h1 style = {{textAlign: "left", fontFamily: "Hobo Std", fontSize: "70px"}}>
                            Perfil
                         </h1>


                     </Jumbotron>
                    <Tab.Container id="left-tabs-example" defaultActiveKey="first" >
                         <Row style = {{marginTop: "100px"}}>
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
                                        <h2 style = {{fontStyle: "italic", textDecorationLine: "underline"}}> Informações adicionais</h2>
                                            <Jumbotron >

                                                <Form>

                                                    <Image style = {{height: "150px",width: "150px",marginTop: "-50px", marginRight: "650px"}}  id = "exampleFormControlFile1"  thumbnail />
                                                    <Form.Group style={{textAlign: "right", marginTop: "10px"}}>


                                                        <input  type="file" className = "form-control-file" id = "exampleFormControlFile1"/>
                                                    </Form.Group>

                                                    <Form.Group style = {{textAlign: "right",marginTop: "-100px",marginLeft: "-15px"}} as={Col} xs = {8} controlId="formGridEmail">

                                                        <Form.Label>Contacto</Form.Label>
                                                        <Form.Control style = {{marginLeft: "280px"}} type="email" placeholder = "Email" />

                                                    </Form.Group>
                                                    <Form.Group  style = {{textAlign: "left"}} controlId="exampleForm.ControlTextarea1">
                                                        <Form.Label >Descrição</Form.Label>
                                                        <Form.Control as="textarea" rows="3" placeholder = "Insira uma descrição" />
                                                    </Form.Group>
                                                    <Button variant="outline-dark" type="submit">Confirmar</Button>
                                                    <Form.Check style = {{textAlign: "right", fontFamily: "Times New Roman"}} type = "checkbox" label = "Tornar público" />
                                                </Form>

                                            </Jumbotron>

                                                <h2 style = {{fontStyle: "italic", textDecorationLine: "underline"}}> Configurar geral </h2>

                                                <Form>
                                                    <Jumbotron >
                                                        <h5 style = {{fontWeight: "bold", textAlign: "left"}}> Alteração do Username</h5>
                                                            <Form.Group  as={Col} md="4" controlId="validationCustomUsername" style = {{marginLeft: "220px"}}>
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
                                                        <Button style = {{marginTop: "5px"}} variant="outline-dark" type="submit">Confirmar</Button>
                                                    </Jumbotron>

                                                    <Jumbotron >
                                                        <h5 style = {{fontWeight: "bold", textAlign: "left"}}> Alteração da Password</h5>

                                                            <Form.Group style = {{marginLeft: "220px"}} as={Col} md="5" controlId="formGroupPassword">
                                                                <Form.Label>Atual</Form.Label>
                                                                <Form.Control type="password" placeholder="Password" />
                                                            </Form.Group>
                                                            <Form.Group style = {{marginLeft: "220px"}} as={Col} md="5" controlId="formGroupPassword">
                                                                <Form.Label>Nova  </Form.Label>
                                                                <Form.Control type="password" placeholder="Nova Password" />
                                                            </Form.Group>
                                                        <Button variant="outline-dark" type="submit">Confirmar</Button>
                                                    </Jumbotron>


                                                </Form>

                                    </Tab.Pane>
                                    <Tab.Pane eventKey="second">
                                    <Nav variant="pills" defaultActiveKey="/home">
                                        <Nav.Item>
                                            <Nav.Link href="/home">Active</Nav.Link>
                                        </Nav.Item>
                                        <Nav.Item>
                                            <Nav.Link eventKey="link-1">Option 2</Nav.Link>
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