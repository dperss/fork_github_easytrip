import axios from "axios";

const api_URL = "http://localhost:8080/api/test/accomodations";

class AccommodationService {

    accommodation(location, description, price){

        return axios
            .post(api_URL, {
                location,
                description,
                price
            })
            .then(response =>{

                if (response.data.accessToken) {
                    localStorage.setItem("accommodation", JSON.stringify(response.data));
                }

                return response.data;
            })
    }


}

export default new AccommodationService();