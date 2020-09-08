import React from "react";

import {
    Jumbotron,
} from "react-bootstrap";



function addComment ({selected}){



        return (
            <div>

                <header>
                    <Jumbotron className = "jumbo-home">
                        <h1>Adicionar Comentários aos Alojamentos</h1>
                    </Jumbotron>
                </header>
                <header className = "content">

                    <h2>
                        {selected.name}
                        <span>
                        ({selected.location})
                    </span>
                    </h2>

                </header>

                <main className = "plot">


                    <h4> Descrição: {selected.description}</h4>
                    <p>Preço: {selected.price}€</p>
                </main>

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

export default addComment;