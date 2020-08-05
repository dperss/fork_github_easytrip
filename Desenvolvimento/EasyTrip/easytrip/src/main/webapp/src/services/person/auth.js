import axios from 'axios';


export const LOGIN = "LOGIN";
export const LOGOUT = "LOGOUT";

export const login = person => {
  return {
    type: LOGIN,
    payload: person
  };
};

export const logout = () => {
  return {
    type: LOGOUT
  };
};

