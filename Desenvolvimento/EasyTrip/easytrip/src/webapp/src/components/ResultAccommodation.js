import React from "react"


function ResultAccommodation({result }) {

    return(
        <div className= "result">
            <h3> {result.name}</h3>
            <h4> {result.location}</h4>

        </div>
    )

}

export default ResultAccommodation