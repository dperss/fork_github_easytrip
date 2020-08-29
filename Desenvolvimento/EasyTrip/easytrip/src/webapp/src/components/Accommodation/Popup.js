import React from "react";

function Popup({selected, closePopup}) {

    return(
        <section className="popup">
            <div className="content">
                <h2>{selected.name}
                    <span>{selected.location}</span>
                </h2>
                <button className="close" onClick={closePopup}> Fechar</button>

            </div>

        </section>
    )
}

export default Popup;