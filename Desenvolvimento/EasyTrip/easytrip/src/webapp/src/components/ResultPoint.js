import React from "react"


function ResultPoint({result, openPopup }) {

    return(
        <div className= "result" onClick={() => openPopup (result.id)}>
            <h3> {result.name}</h3>
            <h4> {result.location_nome}</h4>

        </div>
    )

}

export default ResultPoint