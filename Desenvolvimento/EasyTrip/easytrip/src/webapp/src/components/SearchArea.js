import React from "react";

function SearchArea({handleInput, search}) {

    return(
        <section className="searchbox-wrap">

            <input
                type = "text"
                placeholder = "Procure pelo nome.."
                className = "searchbox"
                onChange={handleInput}
                onKeyPress={search}
            />
        </section>

    );
}

export default SearchArea;