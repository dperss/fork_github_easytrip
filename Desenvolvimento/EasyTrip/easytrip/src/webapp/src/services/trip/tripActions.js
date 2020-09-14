import {SAVE_TRIP_REQUEST, FETCH_TRIP_REQUEST, UPDATE_TRIP_REQUEST, DELETE_TRIP_REQUEST, TRIP_SUCCESS, TRIP_FAILURE} from "./tripTypes";
import axios from 'axios';

export const saveTrip = trip => {
    return dispatch => {
        dispatch(saveTripRequest());
        axios.post(" http://localhost:8080/api/test/trips", trip)
            .then(response => {
                dispatch(tripSuccess(response.data));
            })
            .catch(error => {
                dispatch(tripFailure(error));
            });
    };
};

const saveTripRequest = () => {
    return {
        type: SAVE_TRIP_REQUEST
    };
};

const fetchTripRequest = () => {
    return {
        type: FETCH_TRIP_REQUEST
    };
};

export const fetchTrip = tripId => {
    return dispatch => {
        dispatch(fetchTripRequest());
        axios.get(" http://localhost:8080/api/test/trips/"+tripId)
            .then(response => {
                dispatch(tripSuccess(response.data));
            })
            .catch(error => {
                dispatch(tripFailure(error));
            });
    };
};

const updateTripRequest = () => {
    return {
        type: UPDATE_TRIP_REQUEST
    };
};

export const updateTrip = trip => {
    return dispatch => {
        dispatch(updateTripRequest());
        axios.put(" http://localhost:8080/api/test/trips", trip)
            .then(response => {
                dispatch(tripSuccess(response.data));
            })
            .catch(error => {
                dispatch(tripFailure(error));
            });
    };
};

const deleteTripRequest = () => {
    return {
        type: DELETE_TRIP_REQUEST
    };
};

export const deleteTrip = tripId => {
    return dispatch => {
        dispatch(deleteTripRequest());
        axios.delete(" http://localhost:8080/api/test/trips/"+ tripId)
            .then(response => {
                dispatch(tripSuccess(response.data));
            })
            .catch(error => {
                dispatch(tripFailure(error));
            });
    };
};

const tripSuccess = trip => {
    return {
        type: TRIP_SUCCESS,
        payload: trip
    };
};

const tripFailure = error => {
    return {
        type: TRIP_FAILURE,
        payload: error
    };
};