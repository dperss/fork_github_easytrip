import {SAVE_ACCOMMODATION_REQUEST, FETCH_ACCOMMODATION_REQUEST, UPDATE_ACCOMMODATION_REQUEST, DELETE_ACCOMMODATION_REQUEST, ACCOMMODATION_SUCCESS, ACCOMMODATION_FAILURE} from "./accommodationTypes";

const initialState = {
    accommodation: '', error: ''
};

const accommodationReducer = (state = initialState, action) => {
    switch(action.type) {
        case SAVE_ACCOMMODATION_REQUEST || FETCH_ACCOMMODATION_REQUEST || UPDATE_ACCOMMODATION_REQUEST || DELETE_ACCOMMODATION_REQUEST:
            return {
                ...state
            };
        case ACCOMMODATION_SUCCESS:
            return {
                accommodation: action.payload,
                error: ''
            };
        case ACCOMMODATION_FAILURE:
            return {
                accommodation: '',
                error: action.payload
            };
        default: return state;
    }
};

export default accommodationReducer;