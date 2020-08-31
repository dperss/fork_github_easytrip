import React, {Component} from "react"
import { Form} from "react-bootstrap";
import axios from "axios"
import MyToast from "./MyToast";








class add extends Component {



    constructor(props) {
        super(props);
        this.state = {
            point : [],
            name: "",
            type_of_point: "",
            description: "",
            location: ""
        };
    }

    handleChange(e){
        this.setState({name: e.target.value})
    }

    postContent(){
        axios.post("http://localhost:8080/api/test/accomodations", {
            name: this.state.name
        })

    }

    render() {

        return (
            <div className="add">
                <div style={{"display":this.state.show ? "block" : "none"}}>
                    <MyToast show = {this.state.show} message = {"Point of interest Added Successfully."} type = {"sucess"}/>
                </div>
                <input type="text" value={this.state.name} onChange={this.handleChange.bind(this)}></input>
                <button onClick={this.postContent.bind(this)}>post</button>
            </div>
        )
    }
}

export default add;