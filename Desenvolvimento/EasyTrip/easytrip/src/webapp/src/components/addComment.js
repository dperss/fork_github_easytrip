import React, {Component} from "react";
import axios from "axios"
import {
    Jumbotron,
} from "react-bootstrap";

export const postComment = commentId =>{
    axios.post("http://localhost:8080/api/test/comments", commentId
    )

}


class addComment extends Component{


    constructor(props) {
        super(props);
        this.state = {
            comment: ""
        }
    }


    handleCommentChange (e) {
        this.setState({comment: e.target.value})
    }



    render() {
        return (
            <div>

                <header>
                    <Jumbotron className = "jumbo-home">
                        <h1>Adicionar Comentários aos Alojamentos</h1>
                    </Jumbotron>
                </header>

                <form className="form-add-comm" >
                        <label className="input-group-addon">Nome:
                            <input className = "input-add-comm" type="text" placeholder="Nome" />
                        </label>

                        <label className="input-group-addon">
                            Comentário:
                            <textarea className = "input-add-comm"
                                      type="text"
                                      placeholder="Diga algo..."

                            />
                        </label>

                        <input type="submit" value="Adicionar" className="btn btn-info" />

                </form>


            </div>
        )
    }


}

export default addComment;