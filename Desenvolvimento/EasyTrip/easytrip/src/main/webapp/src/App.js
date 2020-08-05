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
import Profile from "./components/Profile";
import Accommodation from "./components/Accommodation";
import Trip from "./components/Trip";
import Info from "./components/Info";
import PointList from "./components/PointList";


export default function App() {


  return (
    <Router>
        <NavigationBar/>
        <Container>
            <Row>
                <Col lg={true} className={"margin-top"}>
                    <Switch>
                        <Route path="/" exact component={Home} />
                        <Route path="/Home" exact component={Home}/>
                        <Route path="/Login" exact component={Login}/>
                        <Route path="/Registration" exact component={Registration}/>
                        <Route path="/PersonList" exact component={PersonList}/>
                        <Route path="/Profile" exact component={Profile}/>
                        <Route path="/Accommodation" exact component={Accommodation}/>
                        <Route path="/Trip" exact component={Trip}/>
                        <Route path="/Info" exact component={Info}/>
                        <Route path="/PointList" exact component={PointList}/>
                    </Switch>
                </Col>
            </Row>
        </Container>
        <Footer/>
    </Router>
  );

}

