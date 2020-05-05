import React from 'react'
import {Route,Switch} from 'react-router-dom'
import Home from './core/Home'
import Signup from './user/Signup'
import Signin from './user/Siginin'
import Menu from './core/Menu'
import Users from './user/Users'
import Profile from './user/Profile'
import editProfile from './user/editProfile'
import PrivateRoutes from './auth/PrivateRoutes'
const MainRouter=()=>(
    <div>
        <Menu />
        <Switch>
            <Route exact path="/" component={Home}></Route>
            <Route exact path="/users" component={Users}></Route>
            <Route path="/signup" component={Signup}></Route>
            <Route path="/signin" component={Signin}></Route>
            <PrivateRoutes path="/user/edit/:userId" component={editProfile}></PrivateRoutes>
            <PrivateRoutes path="/user/:userId" component={Profile}></PrivateRoutes>
        </Switch>
    </div>
)

export default MainRouter;