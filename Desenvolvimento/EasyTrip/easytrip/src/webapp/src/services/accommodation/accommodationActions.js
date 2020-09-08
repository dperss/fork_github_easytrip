import {SAVE_ACCOMMODATION_REQUEST, FETCH_ACCOMMODATION_REQUEST, UPDATE_ACCOMMODATION_REQUEST, DELETE_ACCOMMODATION_REQUEST, ACCOMMODATION_SUCCESS, ACCOMMODATION_FAILURE} from "./accommodationTypes";
import axios from 'axios';

export const saveAccommodation = accommodation => {
    return dispatch => {
        dispatch(saveAccommodationRequest());
        axios.post("http://localhost:8080/api/test/accomodations", accommodation)
            .then(response => {
                dispatch(accommodationSuccess(response.data));
            })
            .catch(error => {
                dispatch(accommodationFailure(error));
            });
    };
};

const saveAccommodationRequest = () => {
    return {
        type: SAVE_ACCOMMODATION_REQUEST
    };
};

const fetchAccommodationRequest = () => {
    return {
        type: FETCH_ACCOMMODATION_REQUEST
    };
};

export const fetchAccommodation = accommodationId => {
    return dispatch => {
        dispatch(fetchAccommodationRequest());
        axios.get("http://localhost:8080/api/test/accomodations/"+accommodationId)
            .then(response => {
                dispatch(accommodationSuccess(response.data));
            })
            .catch(error => {
                dispatch(accommodationFailure(error));
            });
    };
};

const updateAccommodationRequest = () => {
    return {
        type: UPDATE_ACCOMMODATION_REQUEST
    };
};

export const updateAccommodation = accommodation => {
    return dispatch => {
        dispatch(updateAccommodationRequest());
        axios.put("http://localhost:8080/api/test/accomodations", accommodation)
            .then(response => {
                dispatch(accommodationSuccess(response.data));
            })
            .catch(error => {
                dispatch(accommodationFailure(error));
            });
    };
};

const deleteAccommodationRequest = () => {
    return {
        type: DELETE_ACCOMMODATION_REQUEST
    };
};

export const deleteAccommodation = accommodationId => {
    return dispatch => {
        dispatch(deleteAccommodationRequest());
        axios.delete("http://localhost:8080/api/test/accomodations/"+ accommodationId)
            .then(response => {
                dispatch(accommodationSuccess(response.data));
            })
            .catch(error => {
                dispatch(accommodationFailure(error));
            });
    };
};

const accommodationSuccess = accommodation => {
    return {
        type: ACCOMMODATION_SUCCESS,
        payload: accommodation
    };
};

const accommodationFailure = error => {
    return {
        type: ACCOMMODATION_FAILURE,
        payload: error
    };
};