import {SAVE_POINT_REQUEST, FETCH_POINT_REQUEST, UPDATE_POINT_REQUEST, DELETE_POINT_REQUEST, POINT_SUCCESS, POINT_FAILURE} from "./pointTypes";
import axios from 'axios';

export const savePoint = point => {
    return dispatch => {
        dispatch(savePointRequest());
        axios.post("http://localhost:8080/api/test/point_of_interests   ", point)
            .then(response => {
                dispatch(pointSuccess(response.data));
            })
            .catch(error => {
                dispatch(pointFailure(error));
            });
    };
};

const savePointRequest = () => {
    return {
        type: SAVE_POINT_REQUEST
    };
};

const fetchPointRequest = () => {
    return {
        type: FETCH_POINT_REQUEST
    };
};

export const fetchPoint = pointId => {
    return dispatch => {
        dispatch(fetchPointRequest());
        axios.get("http://localhost:8080/api/test/point_of_interests/"+pointId)
            .then(response => {
                dispatch(pointSuccess(response.data));
            })
            .catch(error => {
                dispatch(pointFailure(error));
            });
    };
};

const updatePointRequest = () => {
    return {
        type: UPDATE_POINT_REQUEST
    };
};

export const updatePoint = point => {
    return dispatch => {
        dispatch(updatePointRequest());
        axios.put("http://localhost:8080/api/test/point_of_interests", point)
            .then(response => {
                dispatch(pointSuccess(response.data));
            })
            .catch(error => {
                dispatch(pointFailure(error));
            });
    };
};

const deletePointRequest = () => {
    return {
        type: DELETE_POINT_REQUEST
    };
};

export const deletePoint = pointId => {
    return dispatch => {
        dispatch(deletePointRequest());
        axios.delete("http://localhost:8080/api/test/point_of_interests/"+ pointId)
            .then(response => {
                dispatch(pointSuccess(response.data));
            })
            .catch(error => {
                dispatch(pointFailure(error));
            });
    };
};

const pointSuccess = point => {
    return {
        type: POINT_SUCCESS,
        payload: point
    };
};

const pointFailure = error => {
    return {
        type: POINT_FAILURE,
        payload: error
    };
};