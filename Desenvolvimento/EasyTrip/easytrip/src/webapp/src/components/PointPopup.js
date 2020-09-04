import React from "react";

function PointPopup({selected, closePopup}) {

    return(

        <section className = "popup">
            <header className = "content">
                <h2>
                    {selected.name}
                    <span>
                        ({selected.location_nome})
                    </span>
                </h2>
            </header>

            <main className = "plot">


                <h4> Descrição: {selected.description}</h4>
                <p>Tipo de ponto: {selected.type_of_point}</p>
            </main>
            <button className = "close" onClick={closePopup}>Fechar</button>

        </section>
    )
}

export default PointPopup