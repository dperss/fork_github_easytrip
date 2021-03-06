import React, {useState} from "react"
import 'react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css'
import axios from 'axios'
import SearchArea from "./SearchArea"
import SearchLocation from "./SearchLocation";
import ResultsPoint from "./ResultsPoint";
import PointPopup from "./PointPopup";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPlus} from "@fortawesome/free-solid-svg-icons";
import {Link} from "react-router-dom";



function Point() {
    const  [state, setState] = useState({
        s: "",
        results: [],
        selected: {}

    });
    const apiURL ="http://localhost:8080/api/test/point_of_interests/search/name/{searchText}?searchText=";
    const apiURLLoc = "http://localhost:8080/api/test/point_of_interests/search/location/{searchText}?searchText=";

    const searchpoint = (e) => {
        if(e.key === "Enter"){
            axios(apiURL  + state.s)
                .then(({data}) => {
                    let results = data.content;
                    setState(prevState => {
                        return {...prevState, results: results}
                    })
                });

        }
    };

    const locationpoint = (e) => {
        if(e.key === "Enter"){
            axios(apiURLLoc  + state.s)
                .then(({data}) => {
                    let results = data.content;
                    setState(prevState => {
                        return {...prevState, results: results}
                    })
                });

        }
    };


    const handleInput = (e) => {

        let s = e.target.value;

        setState(prevState => {
            return{...prevState, s: s}
        });
    };

    const openPopup = id => {

        axios("http://localhost:8080/api/test/point_of_interests/" + id)
            .then(({data}) =>{
                let result = data;

                setState(prevState => {
                    return{...prevState, selected: result}
                });
            });

    };

    const  closePopup = () =>{
        setState(prevState => {
            return{...prevState, selected: {}}
        });

    };

    return(

        <div className = "Accommodation">
            <header className = "header_acc">
                <h1 className = "h1_header_acc">
                    Pontos de Interesse
                    <Link to={"add/"} className = "btn btn-sm btn-outline-info"> <FontAwesomeIcon icon={faPlus}/></Link>
                </h1>

            </header>
            <main className = "main_accommodations">

                <SearchArea handleInput = {handleInput} search = {searchpoint}/>

                <SearchLocation handleInput = {handleInput} search = {locationpoint}/>

                <ResultsPoint results={state.results} openPopup = {openPopup}/>

                {(typeof state.selected.name != "undefined") ? <PointPopup selected={state.selected} closePopup={closePopup}/> : false}
            </main>

        </div>
    );
}

export default Point;