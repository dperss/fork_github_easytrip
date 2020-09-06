import React, { Component,Image } from "react";
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
        axios.post("http://easytrip-boot.herokuapp.com/api/test/images/upload",formData,config)
            .then((response) => {
                alert("The file is successfully uploaded");
            }).catch((error) => {
        });
    }
    onChange(e) {
        this.setState({file:e.target.files[0]});

    }







    render() {
    if (this.state.redirect) {
      return <Redirect to={this.state.redirect} />
    }



    const { currentUser,file } = this.state;


    return (
      <div className="container">
        {(this.state.userReady) ?
        <div>
        <header className="jumbotron-prof">
          <h3>
            <strong>{currentUser.username}</strong> Profile
          </h3>
        </header>
            <h1 className = "h1-prof"> As minhas informações</h1>
        <p>
          {currentUser.accessToken.substring(0, 20)} ...{" "}
          {currentUser.accessToken.substr(currentUser.accessToken.length - 20)}
        </p>
        <p>
          <strong>Id:</strong>{" "}
          {currentUser.id}
        </p>
        <p>
          <strong>Email:</strong>{" "}
          {currentUser.email}
        </p>
        <p>

         <strong>Foto:</strong>{" "}
                <form onSubmit={this.onFormSubmit}>
                <h1>File Upload</h1>
                <input type="file" name="myImage" onChange= {this.onChange} />
                <button type="submit">Upload</button>
            </form>
        </p>

        <div >
          <strong className = "ul-prof">Descrição:</strong>{" "}

          <input
          type="text"
          placeholder="Insira uma descrição"
          value={this.state.description}

          />
          {currentUser.description}
        </div>
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
