import React from "react"
import ResultAccommodation from "./ResultAccommodation";


function ResultsAccommodation({results, openPopup}) {
    return(
        <section className = "results">
            {results.map (result => (
                <ResultAccommodation key = {result.id} result = {result} openPopup = {openPopup}/>
            ))}

        </section>
    )

}

export default ResultsAccommodation