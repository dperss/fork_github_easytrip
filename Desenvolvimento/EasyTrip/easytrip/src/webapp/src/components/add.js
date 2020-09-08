import React, {Component} from "react"
import axios from "axios"
import MyToast from "./MyToast";
import {
    Jumbotron,
} from "react-bootstrap";


const required = value => {
    if (!value) {
        return (
            <div className="alert alert-danger" role="alert">
                This field is required!
            </div>
        );
    }
};


class add extends Component {



    constructor(props) {
        super(props);
        this.state = {
            point : [],
            name: "",
            type_of_point: "",
            description: "",
            location_nome: "",
            successful: false,
            message: ""
        };
    }

    handleNameChange(e){
        this.setState({name: e.target.value})
    }

    handlePointChange(e){
        this.setState({type_of_point: e.target.value})
    }

    handleLocationChange(e){
        this.setState({location_nome: e.target.value})
    }

    handleDescriptionChange(e){
        this.setState({description: e.target.value})
    }


    postContent(){
        axios.post("http://easytrip-boot.herokuapp.com/api/test/point_of_interests", {
            name: this.state.name,
            type_of_point: this.state.type_of_point,
            location_nome: this.state.location_nome,
            description: this.state.description
        })

    }

    render() {

        return (
            <div className="add">
                <div style={{"display":this.state.show ? "block" : "none"}}>
                    <MyToast show = {this.state.show} message = {"Point of interest Added Successfully."} type = {"sucess"}/>
                </div>

                <header>
                    <Jumbotron className = "jumbo-home">
                        <h1>Adicionar Pontos de Interesse</h1>
                    </Jumbotron>
                </header>
                <form className = "form-add">
                    <label>
                        Nome:
                        <input className = "input-add"
                            placeholder = "Nome"
                            type="text"
                            value={this.state.name}
                            onChange={this.handleNameChange.bind(this)}
                               validations = {[required]}
                        />

                    </label>

                    <label>
                        Localização:
                        <input className = "input-add"
                            placeholder = "Localização"
                            type="text"
                            value={this.state.location_nome}
                            onChange={this.handleLocationChange.bind(this)}
                               validations = {[required]}
                        />
                    </label>

                    <label>
                        Descrição:
                        <input className = "input-add"
                            placeholder = "Descrição"
                            type="text"
                            value={this.state.description}
                            onChange={this.handleDescriptionChange.bind(this)}
                               validations = {[required]}
                        />
                    </label>


                    <label>
                        Tipo de Ponto:
                        <input className = "input-add"
                            placeholder = "Tipo de Ponto"
                            type="text"
                            value={this.state.type_of_point}
                            onChange={this.handlePointChange.bind(this)}
                               validations = {[required]}
                        />
                    </label>

                    <button className = "button-add" onClick={this.postContent.bind(this)}>Adicionar</button>
                </form>



            </div>
        )
    }
}

export default add;