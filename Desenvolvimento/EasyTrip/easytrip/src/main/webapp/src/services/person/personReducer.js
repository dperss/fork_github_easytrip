import {SAVE_PERSON_REQUEST, FETCH_PERSON_REQUEST, UPDATE_PERSON_REQUEST, DELETE_PERSON_REQUEST, PERSON_SUCCESS, PERSON_FAILURE} from "./personTypes";

const initialState = {
    person: '', error: ''
};

const reducer = (state = initialState, action) => {
    switch(action.type) {
        case SAVE_PERSON_REQUEST || FETCH_PERSON_REQUEST || UPDATE_PERSON_REQUEST || DELETE_PERSON_REQUEST:
            return {
                ...state
            };
        case PERSON_SUCCESS:
            return {
                person: action.payload,
                error: ''
            };
        case PERSON_FAILURE:
            return {
                person: '',
                error: action.payload
            };
        default: return state;
    }
};

export default reducer;