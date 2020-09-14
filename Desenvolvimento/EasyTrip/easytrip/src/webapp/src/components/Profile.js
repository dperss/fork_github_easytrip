import React, { Component} from "react";
import { Redirect } from "react-router-dom";
import AuthService from "../services/auth/auth.service";
import axios from "axios";

export default class Profile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            redirect: null,
            userReady: false,
            currentUser: { username: "" },
            file: null,
            isInEditMode: false
        };
        this.onFormSubmit = this.onFormSubmit.bind(this);
        this.onChange = this.onChange.bind(this);
    }

    componentDidMount() {
        const currentUser = AuthService.getCurrentUser();

        if (!currentUser) this.setState({ redirect: "/home" });
        this.setState({ currentUser: currentUser, userReady: true })
    }
    onFormSubmit(e){
        e.preventDefault();
        const formData = new FormData();
        formData.append('file',this.state.file);
        const config = {
            headers: {
                'content-type': 'multipart/form-data'
            }
        };
        axios.post("http://localhost:8080/api/test/images/upload",formData,config)
            .then(response => {
                alert("The file is successfully uploaded");
            }
        );
    }
    onChange(e) {
        this.setState({file:e.target.files[0]});

    }







    render() {
    if (this.state.redirect) {
      return <Redirect to={this.state.redirect} />
    }



    const { currentUser} = this.state;


    return (
      <div className="container">
        {(this.state.userReady) ?
        <div>
        <header className="jumbotron-prof">
          <h3>
             Perfil
          </h3>
        </header>
            <h1 className = "h1-prof">
                <p>{currentUser.username}</p>
                 informações
            </h1>

            <p>
                <strong>Username:</strong>{" "}
                {currentUser.username}
            </p>
        <p>
          <strong>Email:</strong>{" "}
          {currentUser.email}
        </p>

        <strong className = "ul-prof">Roles:</strong>
        <ul className = "ul-prof">
          {currentUser.roles &&
            currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
        </ul>
      </div>: null}
      </div>
    );
  }
}
