import React, {useState} from "react"
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'
import axios from 'axios'
import SearchArea from "./SearchArea"
import ResultsAccommodation from "./ResultsAccommodation";


function Accommodation() {
    const  [state, setState] = useState({
        s: "",
        results: [],
        selected: {}

    });
    const apiURL ="http://localhost:8080/api/test/accomodations/search/name/{searchText}?searchText=";

    const search = (e) => {
        if(e.key === "Enter"){
            axios(apiURL  + state.s)
                .then(({data}) => {
                    let results = data.content;
                    setState(prevState => {
                        return {...prevState, results: results}
                    })
                });

        }
    }


    const handleInput = (e) => {

        let s = e.target.value;

        setState(prevState => {
            return{...prevState, s: s}
        });
    }

    return(

        <div className = "Accommodation">
            <header className = "header_acc">
                <h1 className = "h1_header_acc"> Alojamentos</h1>
            </header>
            <main className = "main_accommodations">
                <SearchArea handleInput = {handleInput} search = {search}/>
                <ResultsAccommodation results={state.results}/>
            </main>

        </div>
    );
}

export default Accommodation;