import React from "react";

function SearchAreaName({handleInput, search}) {

    return(
        <section className="searchbox-wrap">

            <input
                type = "text"
                placeholder = "Pesquise pelo nome do alojamento.."
                className = "searchbox"
                onChange={handleInput}
                onKeyPress={search}
            />
        </section>

    );
}

export default SearchAreaName;