import React from "react";
import {BrowserRouter,Route,Switch} from "react-router-dom";
import {LoginScreen} from "./screen/LoginScreen";
import {HomeScreen} from "./screen/HomeScreen";

export class Router extends React.Component{
    constructor(props) {
        super(props);
    }
    render() {
        return(
            <BrowserRouter>
                <Switch>
                    <Route path={'/login'} component={LoginScreen}/>
                    <Route path={'/'} component={HomeScreen}/>
                </Switch>
            </BrowserRouter>
        )
    }
}
