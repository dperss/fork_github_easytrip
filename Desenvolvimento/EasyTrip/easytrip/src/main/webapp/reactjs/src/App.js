import React from 'react';

import './App.css';

import {Route} from "react-router-dom";

import Login from "./Pages/Login";
import Registo from "./Pages/Registo";
import Home from "./Pages/Home";
import info from "./Pages/info";
import Alojamentos from "./Pages/Alojamentos";
import Perfil from "./Pages/Perfil";
import viajar from "./Pages/viajar";
import gestao_pt from "./Pages/gestao_pt";
import gestao_user from "./Pages/gestao_user";



function App(){
    return (
        <div className="App">
            <Route exact path = "/" component = {Home}/>
            <Route exact path = "/login" component = {Login}/>
            <Route exact path = "/registo" component = {Registo}/>
            <Route exact path = "/info" component = {info}/>
            <Route exact path = "/alojamentos" component = {Alojamentos}/>
            <Route exact path = "/perfil" component={Perfil}/>
            <Route exact path = "/viajar" component={viajar}/>
            <Route exact path = "/gestao_pontos" component={gestao_pt}/>
            <Route exact path = "/gestao_user" component={gestao_user}/>

        </div>
    );
}



export default App;
