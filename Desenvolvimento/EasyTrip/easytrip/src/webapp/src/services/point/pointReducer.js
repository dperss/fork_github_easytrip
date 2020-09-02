import {SAVE_POINT_REQUEST, FETCH_POINT_REQUEST, UPDATE_POINT_REQUEST, DELETE_POINT_REQUEST, POINT_SUCCESS, POINT_FAILURE} from "./pointTypes";

const initialState = {
    point: '', error: ''
};

const pointReducer = (state = initialState, action) => {
    switch(action.type) {
        case SAVE_POINT_REQUEST || FETCH_POINT_REQUEST || UPDATE_POINT_REQUEST || DELETE_POINT_REQUEST:
            return {
                ...state
            };
        case POINT_SUCCESS:
            return {
                point: action.payload,
                error: ''
            };
        case POINT_FAILURE:
            return {
                point: '',
                error: action.payload
            };
        default: return state;
    }
};

export default pointReducer;