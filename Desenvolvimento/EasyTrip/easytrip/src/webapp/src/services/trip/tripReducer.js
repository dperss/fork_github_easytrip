import {SAVE_TRIP_REQUEST, FETCH_TRIP_REQUEST, UPDATE_TRIP_REQUEST, DELETE_TRIP_REQUEST, TRIP_SUCCESS, TRIP_FAILURE} from "./tripTypes";

const initialState = {
    trip: '', error: ''
};

const tripReducer = (state = initialState, action) => {
    switch(action.type) {
        case SAVE_TRIP_REQUEST || FETCH_TRIP_REQUEST || UPDATE_TRIP_REQUEST || DELETE_TRIP_REQUEST:
            return {
                ...state
            };
        case TRIP_SUCCESS:
            return {
                trip: action.payload,
                error: ''
            };
        case TRIP_FAILURE:
            return {
                trip: '',
                error: action.payload
            };
        default: return state;
    }
};

export default tripReducer;