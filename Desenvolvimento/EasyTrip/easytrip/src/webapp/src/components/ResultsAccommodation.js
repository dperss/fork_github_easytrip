import React from "react"
import ResultAccommodation from "./ResultAccommodation";


function ResultsAccommodation({results}) {
    return(
        <section className = "results">
            {results.map (result => (
                <ResultAccommodation key = {result.id} result = {result}/>
            ))}

        </section>
    )

}

export default ResultsAccommodation