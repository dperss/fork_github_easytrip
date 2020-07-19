import {combineReducers} from 'redux';
import personReducer from './person/personReducer';

const rootReducer = combineReducers({
    person: personReducer
});

export default rootReducer;