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


class addAccommodation extends Component {



    constructor(props) {
        super(props);
        this.state = {
            accommodation : [],
            name: "",
            price: "",
            description: "",
            location: "",
            successful: false,
            message: ""
        };
    }

    handleNameChange(e){
        this.setState({name: e.target.value})
    }

    handlePointChange(e){
        this.setState({price: e.target.value})
    }

    handleLocationChange(e){
        this.setState({location: e.target.value})
    }

    handleDescriptionChange(e){
        this.setState({description: e.target.value})
    }


    postContent(){
        axios.post(" https://easytrip-boot.herokuapp.com/api/test/accomodations", {
            name: this.state.name,
            price: this.state.price,
            location: this.state.location,
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
                        <h1>Adicionar Alojamentos</h1>
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
                               value={this.state.location}
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
                        Preço:
                        <input className = "input-add"
                               placeholder = "Preço"
                               type="text"
                               value={this.state.price}
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

export default addAccommodation;