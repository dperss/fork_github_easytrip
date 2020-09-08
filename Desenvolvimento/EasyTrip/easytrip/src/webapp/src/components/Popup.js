import React, {useState} from "react";
import axios from "axios";



function Popup ({selected, closePopup}) {

    const postContent = () =>{
        let accommodations;
        accommodations = [{
            name: selected.name,
            location: selected.location,
            description: selected.description
        }]
        axios.put("http://localhost:8080/api/test/trips",{
            accommodations: accommodations
        })
    }
    return(
        <section className = "popup">
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

            <button className = "close" onClick={closePopup}>Fechar</button>

        </section>
    )
}

export default Popup