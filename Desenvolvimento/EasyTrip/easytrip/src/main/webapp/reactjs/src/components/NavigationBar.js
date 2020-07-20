import React,{Component} from "react";
import {Navbar,Nav,Image,Dropdown} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import favicon from '../assets/images/favicon.jpeg';
import person from '../assets/images/default-user.png';


export default class NavigationBar extends Component{

constructor(props) {
    super(props);
    this.handleLoginClick = this.handleLoginClick.bind(this);
    this.handleLogoutClick = this.handleLogoutClick.bind(this);
    this.state = {isLoggedIn: false};
  }

  handleLoginClick() {
    this.setState({isLoggedIn: true});
  }

  handleLogoutClick() {
    this.setState({isLoggedIn: false});
  }


    render(){
    const isLoggedIn = this.state.isLoggedIn;
        let button;
        if (isLoggedIn) {
          button = <LogoutButton onClick={this.handleLogoutClick} />;
        } else {
          button = <LoginButton onClick={this.handleLoginClick} />;
        }

    return (



        <Navbar bg="dark" variant="dark" fixed = "top" >
            <Link to={"Home"} className="navbar-brand">
                <img src={favicon} width="25" height="25" alt="0"/>
            </Link>


             <Greeting isLoggedIn={isLoggedIn} />
             {button}


        </Navbar>

    );
    }
}




function UserGreeting(props) {
  return (

  <Nav className="mr-auto">
    <Link to={"Travel"} className="nav-link">Viajar</Link>
    <Link to={"Accommodation"} className="nav-link">Alojamento</Link>
    <Link to={"PersonList"} className="nav-link">Gestão de Pessoas</Link>
    <Link to={"PointList"} className="nav-link">Lista de pontos</Link>
    <Link to={"Profile"} className="nav-link">Perfil</Link>
  </Nav>

  /*<Dropdown >
        <Dropdown.Toggle variant="success" id="dropdown-basic" >
            <Image src={person} roundedCircle width="35" height="35" alt="0" />
        </Dropdown.Toggle>
        <Dropdown.Menu >
            <Dropdown.Item href="/Perfil">Perfil</Dropdown.Item>
            <Dropdown.Item href="/Logout">Logout</Dropdown.Item>
        </Dropdown.Menu>
  </Dropdown>*/

)
};

function GuestGreeting(props) {
  return (
  <Nav className="mr-auto">
    <Link to={"Home"} className="nav-link">Home</Link>
    <Link to={"Login"} className="nav-link">Login</Link>
    <Link to={"Registration"} className="nav-link">Registo</Link>
  </Nav>
)
};

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
};

function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
};

function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
};
