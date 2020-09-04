import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import AuthService from "./services/auth/auth.service";
import axios from 'axios';

import Home from "./components/Home";
import Login from "./components/Login";
import Registration from "./components/Registration";
import UserList from "./components/UserList";
import Profile from "./components/Profile";
import Info from "./components/Info";
import PointList from "./components/PointList";
import Accommodation from "./components/Accommodation";
import {Itinerary} from "./components/Itinerary";
import add from "./components/add";
import addComment from "./components/addComment";
import Trip from "./components/Trip";


const user = JSON.parse(localStorage.getItem('user'));
axios.defaults.headers.common = {'Authorization': `Bearer ${user.accessToken}`}


class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showUserList: false,
      showAdminBoard: false,
      currentUser: undefined
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user,
        showAdminBoard: user.roles.includes("ROLE_ADMIN")
      });
    }
  }

  logOut() {
    AuthService.logout();
  }

  render() {
    const { currentUser, showAdminBoard } = this.state;

    return (
      <Router>
        <div>
          <nav className="navbar navbar-expand navbar-dark bg-dark">
            <Link to={"/"} className="navbar-brand">
              EasyTrip
            </Link>
            <div className="navbar-nav mr-auto">

              {showAdminBoard && (
                <li className="nav-item">
                  <Link to={"/PointList"} className="nav-link">
                    Lista de Pontos
                  </Link>
                </li>
              )}
              {showAdminBoard && (
                  <li className="nav-item">
                    <Link to={"/UserList"} className="nav-link">
                      Lista de Pessoas
                    </Link>
                  </li>
              )}

              {currentUser && (
                <li className="nav-item">
                  <Link to={"/Trip"} className="nav-link">
                    Viagem
                  </Link>
                </li>
              )}
            </div>




            {currentUser ? (
              <div className="navbar-nav ml-auto">
                <li className="nav-item">
                  <Link to={"/profile"} className="nav-link">
                    {currentUser.username}
                  </Link>
                </li>
                <li className="nav-item">
                  <a href="/login" className="nav-link" onClick={this.logOut}>
                    LogOut
                  </a>
                </li>
              </div>
            ) : (
              <div className="navbar-nav ml-auto">
                <li className="nav-item">
                  <Link to={"/login"} className="nav-link">
                    Login
                  </Link>
                </li>

                <li className="nav-item">
                  <Link to={"/Registration"} className="nav-link">
                    Sign Up
                  </Link>
                </li>
              </div>
            )}
          </nav>

          <div className="container mt-3">
            <Switch>
              <Route exact path={["/", "/home"]} component={Home} />
              <Route exact path="/Login" component={Login} />
              <Route exact path="/Registration" component={Registration} />
              <Route exact path="/Profile" component={Profile} />
              <Route path="/Profile" component={Profile} />
              <Route path="/Info" component={Info} />
              <Route path="/PointList" component={PointList} />
              <Route path="/UserList" component={UserList} />
              <Route path = "/Trip" component={Trip}/>
              <Route path= "/Accommodation" component={Accommodation}/>
              <Route path = "/Itinerary" component={Itinerary}/>
              <Route path = "/add" component={add}/>
              <Route path = "/addComment" component={addComment}/>

            </Switch>
          </div>

        </div>
      </Router>
    );
  }
}

export default App;