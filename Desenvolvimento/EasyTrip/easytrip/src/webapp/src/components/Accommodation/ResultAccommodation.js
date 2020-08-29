import React from "react"


function ResultAccommodation({result, openPopup }) {

    return(
        <div className= "result" onClick={ () => openPopup(result.id)}>
            <h3> {result.name}</h3>
            <h4> {result.location}</h4>

        </div>
    )

}

export default ResultAccommodation