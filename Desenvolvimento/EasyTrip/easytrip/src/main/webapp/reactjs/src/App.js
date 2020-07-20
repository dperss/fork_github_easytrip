import React from 'react';
import './App.css';

import {Container, Row, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

import NavigationBar from './components/NavigationBar';
import Home from "./components/Home";
import Login from "./components/Login";
import Registration from "./components/Registration";
import PersonList from "./components/PersonList";
import Footer from "./components/Footer";
import Perfil from "./components/Perfil";


export default function App() {



  return (
    <Router>
        <NavigationBar/>
        <Container>
            <Row>
                <Col lg={12} className={"margin-top"}>
                    <Switch>
                        <Route path="/" exact component={Home} />
                        <Route path="/Home" exact component={Home}/>
                        <Route path="/Login" exact component={Login}/>
                        <Route path="/Registration" exact component={Registration}/>
                        <Route path="/PersonList" exact component={PersonList}/>
                        <Route path="/Perfil" exact component={Perfil}/>
                    </Switch>
                </Col>
            </Row>
        </Container>
        <Footer/>
    </Router>
  );

}

