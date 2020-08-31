import React from "react"
import ResultPoint from "./ResultAccommodation";


function ResultsPoint({results, openPopup}) {
    return(
        <section className = "results">
            {results.map (result => (
                <ResultPoint key = {result.id} result = {result} openPopup = {openPopup}/>
            ))}

        </section>
    )

}

export default ResultsPoint