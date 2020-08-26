import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import PropTypes from 'prop-types';


const AccommodationCard = props => {

    const { name, location } = props.accommodation || {};

    return (
        <div className="col-sm-6 col-md-4 accommodation-card">

                <div className="px-3">

                    <span className="accommodation-name text-dark d-block font-weight-bold">{ name }</span>

                    <span className="accommodation-location text-secondary text-uppercase">{ location }</span>

                </div>
        </div>
    )
}

AccommodationCard.propTypes = {
    accommodation: PropTypes.shape({
        id: PropTypes.string,
        location: PropTypes.string,
        name: PropTypes.shape({
            common: PropTypes.string
        })
    })
};


export default AccommodationCard;