import React from "react";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faComment} from "@fortawesome/free-solid-svg-icons";
import {Link} from "react-router-dom";
function AddCom({selected, closeAddCom}) {

    return(

        <section className = "AddCom">
            <header className = "content">

                <h2>
                    {selected.name}
                    <span>
                        ({selected.location})
                    </span>
                </h2>
                <Link to={"addComment/"} className = "btn btn-sm btn-outline-info"> <FontAwesomeIcon icon={faComment}/></Link>
            </header>

            <main className = "plot">


                <h4> Descrição: {selected.description}</h4>
                <p>Preço: {selected.price}€</p>
            </main>
            <button className = "close" onClick={closeAddCom}>Fechar</button>

        </section>
    )
}

export default AddCom