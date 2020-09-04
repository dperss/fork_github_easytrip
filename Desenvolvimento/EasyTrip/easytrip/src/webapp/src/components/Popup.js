import React from "react";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faComment} from "@fortawesome/free-solid-svg-icons";
import {Link} from "react-router-dom";
function Popup({selected, closePopup, openPopup}) {

    return(

        <section className = "popup">
            <header className = "content">

                    <h2>
                        {selected.name}
                        <span>
                        ({selected.location})
                    </span>
                    </h2>
                <Link to={"addComment/"} className = "btn btn-sm btn-outline-info" onClick={openPopup}> <FontAwesomeIcon icon={faComment}/></Link>
            </header>

            <main className = "plot">


                <h4> Descrição: {selected.description}</h4>
                <p>Preço: {selected.price}€</p>
            </main>
            <button className = "close" onClick={closePopup}>Fechar</button>
            <button className = "close" >Adicionar</button>

        </section>
    )
}

export default Popup