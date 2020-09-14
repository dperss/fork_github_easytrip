import {SAVE_PERSON_REQUEST, FETCH_PERSON_REQUEST, UPDATE_PERSON_REQUEST, DELETE_PERSON_REQUEST, PERSON_SUCCESS, PERSON_FAILURE} from "./personTypes";
import axios from 'axios';

export const savePerson = person => {
    return dispatch => {
        dispatch(savePersonRequest());
        axios.post("http://localhost:8080/api/test/users", person)
            .then(response => {
                dispatch(personSuccess(response.data));
            })
            .catch(error => {
                dispatch(personFailure(error));
            });
    };
};

const savePersonRequest = () => {
    return {
        type: SAVE_PERSON_REQUEST
    };
};

const fetchPersonRequest = () => {
    return {
        type: FETCH_PERSON_REQUEST
    };
};

export const fetchPerson = personId => {
    return dispatch => {
        dispatch(fetchPersonRequest());
        axios.get("http://localhost:8080/api/test/users/"+personId)
            .then(response => {
                dispatch(personSuccess(response.data));
            })
            .catch(error => {
                dispatch(personFailure(error));
            });
    };
};

const updatePersonRequest = () => {
    return {
        type: UPDATE_PERSON_REQUEST
    };
};

export const updatePerson = person => {
    return dispatch => {
        dispatch(updatePersonRequest());
        axios.put("http://localhost:8080/api/test/users", person)
            .then(response => {
                dispatch(personSuccess(response.data));
            })
            .catch(error => {
                dispatch(personFailure(error));
            });
    };
};

const deletePersonRequest = () => {
    return {
        type: DELETE_PERSON_REQUEST
    };
};

export const deletePerson = personId => {
    return dispatch => {
        dispatch(deletePersonRequest());
        axios.delete("http://localhost:8080/api/test/users/" + personId)
            .then(response => {
                dispatch(personSuccess(response.data));
            })
            .catch(error => {
                dispatch(personFailure(error));
            });
    };
};

const personSuccess = person => {
    return {
        type: PERSON_SUCCESS,
        payload: person
    };
};

const personFailure = error => {
    return {
        type: PERSON_FAILURE,
        payload: error
    };
};