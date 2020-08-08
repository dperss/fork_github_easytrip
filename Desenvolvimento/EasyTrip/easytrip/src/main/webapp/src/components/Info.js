import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import {Container, Jumbotron, Nav,Tab, Row, Col} from "react-bootstrap";
import Background from "../assets/images/imagem.png";


export default class Info extends React.Component{
    render(){




        return(
            <div>


                <Container>
                    <Row>
                        <Col>
                            <Jumbotron style = {{backgroundImage: `url(${Background})`,backgroundPosition: "center",backgroundSize: "cover", width: "115%"}}>
                                <h1 style = {{textAlign: "left",fontFamily: "Hobo Std",fontSize: "70px"}}>
                                    Informações
                                </h1>

                            </Jumbotron>
                        </Col>
                    </Row>
                    <Row>
                        <Tab.Container id="left-tabs-example" defaultActiveKey="first" >
                            <Row style = {{marginTop: "100px"}}>
                                <Col sm={3}>
                                    <Nav variant="pills" className="flex-column" >
                                        <Nav.Item>
                                            <Nav.Link eventKey="first">EasyTrip</Nav.Link>
                                        </Nav.Item>
                                        <Nav.Item>
                                            <Nav.Link eventKey="second">Quem Somos?</Nav.Link>
                                        </Nav.Item>
                                        <Nav.Item>
                                            <Nav.Link eventKey="third">Contactos</Nav.Link>
                                        </Nav.Item>
                                    </Nav>
                                </Col>
                                <Col sm={9}>
                                    <Tab.Content>
                                        <Tab.Pane eventKey="first">
                                            Fundada em 2020, em Bragança, por dois estudantes do Instituto politécnico de Bragança, no âmbito da cadeira
                                            de projeto da licenciatura de Engenharia Informática.
                                            Pretendemos que os nossos clientes tenham todas as informações necessárias para o melhor planeamento da sua viagem.
                                            Para tal resolveu-se integrar várias plataformas juntas.
                                            Esperamos que consigam planear a vossa viagem da melhor forma.
                                        </Tab.Pane>
                                        <Tab.Pane eventKey="second">
                                            <p>Claudia Beleza Alves, 21 anos.</p>
                                            <p>Diogo Paulo Ramos, 22 anos.</p>
                                        </Tab.Pane>
                                        <Tab.Pane eventKey="third">
                                            <p>Para informações com a Claudia contactar: a36737@alunos.ipb.pt</p>
                                            <p>Para informações com o Diogo contactar: a39954@alunos.ipb.pt</p>
                                        </Tab.Pane>
                                    </Tab.Content>
                                </Col>
                            </Row>
                        </Tab.Container>
                    </Row>




                </Container>

            </div>

        );









    }
}