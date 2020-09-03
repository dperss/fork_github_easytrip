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

                <form className="comment-form form-group" >
                    <div className="input-group">
                        <span className="input-group-addon">Nome:</span>
                        <input type="text" placeholder="Nome" className="form-control" />
                    </div>
                    <div className="input-group">
                        <span className="input-group-addon">Comentário</span>
                        <input
                            type="text"
                            placeholder="Diga algo..."
                            className="form-control"
                        />
                    </div>
                    <input type="submit" value="Adicionar" className="btn btn-info" />
                </form>


            </div>
        )
    }


}

export default addComment;