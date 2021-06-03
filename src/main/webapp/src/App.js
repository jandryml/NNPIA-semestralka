import React, {useState, useEffect} from "react";
import {Switch, Route, Link, BrowserRouter} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import Login from "./components/auth/Login";
import Register from "./components/auth/Register";
import Home from "./components/general/Home";
import Profile from "./components/auth/Profile";
import BoardUser from "./components/general/BoardUser";
import BoardModerator from "./components/general/BoardModerator";
import BoardAdmin from "./components/general/BoardAdmin";
import Navbar from "./components/general/Navbar";

const App = () => {
    return (
        <BrowserRouter>
            <div className="App">
                <Navbar/>
                <div className="content">
                    <Switch>
                        <Route exact path={["/", "/home"]} component={Home}/>
                        <Route exact path="/login" component={Login}/>
                        <Route exact path="/register" component={Register}/>
                        <Route exact path="/profile" component={Profile}/>
                        <Route path="/user" component={BoardUser}/>
                        <Route path="/mod" component={BoardModerator}/>
                        <Route path="/admin" component={BoardAdmin}/>
                    </Switch>
                </div>
            </div>
        </BrowserRouter>
    );
};

export default App;