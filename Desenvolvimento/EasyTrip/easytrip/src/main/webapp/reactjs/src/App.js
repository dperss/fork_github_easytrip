import React from 'react';
import './App.css';

import {Container, Row, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

import NavigationBar from './components/NavigationBar';
import Home from "./components/Home";
import Login from "./components/Login";
import Registration from "./components/Registration";
import User_Management from "./components/User_Management";
import Footer from "./components/Footer";



export default function App() {


  return (
    <Router>
        <NavigationBar/>
        <Container>
            <Row>
                <Col lg={12} className={"margin-top"}>
                    <Switch>
                        <Route path="/Home" exact component={Home}/>
                        <Route path="/login" exact component={Login}/>
                        <Route path="/registration" exact component={Registration}/>
                        <Route path="/User_Management" exact component={User_Management}/>
                    </Switch>
                </Col>
            </Row>
        </Container>
        <Footer/>
    </Router>
  );
}

