import React from "react";
function Popup({selected, closePopup}) {

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