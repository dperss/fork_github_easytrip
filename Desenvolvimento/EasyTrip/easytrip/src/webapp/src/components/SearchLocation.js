import React from "react";

function SearchLocation({handleInput, search}) {

    return(
        <section className="searchbox-wrap">

            <input
                type = "text"
                placeholder = "Pesquise pela localização do alojamento.."
                className = "searchboxloc"
                onChange={handleInput}
                onKeyPress={search}
            />
        </section>

    );
}

export default SearchLocation;