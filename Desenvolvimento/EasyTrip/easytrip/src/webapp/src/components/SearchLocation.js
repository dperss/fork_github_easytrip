import React from "react";

function SearchLocation({handleInput, search}) {

    return(
        <section className="searchbox-wrap">

            <input
                type = "text"
                placeholder = "Procure pela localização.."
                className = "searchboxloc"
                onChange={handleInput}
                onKeyPress={search}
            />
        </section>

    );
}

export default SearchLocation;