import React, {useState} from "react"
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'
import axios from 'axios'
import SearchAreaName from "./SearchAreaName"
import ResultsAccommodation from "./ResultsAccommodation";
import Popup from "./Popup";
import SearchLocation from "./SearchLocation";



function Accommodation() {
    const  [state, setState] = useState({
        s: "",
        results: [],
        selected: {}

    });
    const apiURL ="http://localhost:8080/api/test/accomodations/search/name/{searchText}?searchText=";
    const apiURLloc = "http://localhost:8080/api/test/accomodations/search/location/{searchText}?searchText=";

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

    const location = (e) => {
        if(e.key === "Enter"){
            axios(apiURLloc  + state.s)
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


    const  openPopup = id => {
        axios(apiURL + id)
            .then(({data}) => {
                let result = data;

                console.log(result);

                setState(prevState => {
                    return {...prevState, selected: result}
                });
            });
    }

    const closePopup = () => {
        setState(prevState => {
            return{...prevState, selected: {}}
        })
    }

    return(

        <div className = "Accommodation">
            <header className = "header_acc">
                <h1 className = "h1_header_acc"> Alojamentos</h1>
            </header>
            <main className = "main_accommodations">
                <SearchAreaName handleInput = {handleInput} search = {search}/>
                <SearchLocation handleInput={handleInput} search={location}/>

                <ResultsAccommodation results={state.results} openPopup = {openPopup}/>

                {(typeof state.selected.name != "undefined") ? <Popup selected={state.selected} closePopup={closePopup}/> : false}

            </main>

        </div>
    );
}

export default Accommodation;