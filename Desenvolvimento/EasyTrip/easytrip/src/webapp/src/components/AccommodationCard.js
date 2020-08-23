import React, { Component } from "react";
import {
 Card
} from "react-bootstrap";
import axios from "axios";


class AccommodationCard extends Component{


    render() {
        const { id: id = "", name = {} } =
              this.props.accommodation || {};

        return(
            <div className="px-3">

                          <span className="country-region text-secondary text-uppercase">
                            {name}
                          </span>
                        </div>



        );
    }


}
export default AccommodationCard;