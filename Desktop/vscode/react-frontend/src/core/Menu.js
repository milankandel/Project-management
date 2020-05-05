import React from 'react'
import { Link, withRouter } from 'react-router-dom'
import {isAuthenticated,signout} from '../auth/index'



const isActive = (history, pathname) => {
    if (history.location.pathname === pathname) return { color: "#ff9900" }
    else return { color: "#ffffff" }
}

const Menu = ({ history }) => (
    <div>
        <ul className="nav nav-tabs bg-primary">

            <li className="nav-item">
                <Link className="nav-link" style={isActive(history, "/")} to="/">Home</Link>
            </li>
            <li className="nav-item">
                <Link className="nav-link" style={isActive(history, "/users")} to="/users">Users</Link>
            </li>            

            {!isAuthenticated()&& (
                <>
                  <li className="nav-item">
                    <Link className="nav-link" style={isActive(history, "/signin")} to="/signin">Signin</Link>
                </li>    
                <li className="nav-item">
                    <Link className="nav-link" style={isActive(history, "/signup")} to="/signup">Signup</Link>
                </li>
              

                </>
            )}

            {isAuthenticated() &&(
                <>
              <li className="nav-item">
              <span className="nav-link" style={isActive(history, "/signout"), { cursor: "pointer", color: "white" }}
                  onClick={() => signout(() => history.push('/'))}
              >Sign out</span>
          </li>

          <li className="nav-item">
 
                  <Link className="nav-link" to={`/user/${isAuthenticated().user._id}`} style={(isActive(history,`/user/${isAuthenticated().user._id}`))}>
                  {`${isAuthenticated().user.name}'s Profile`}
                
                  </Link>
              
          </li>
          </>
            )}
          
        </ul>
    </div>


)
export default withRouter(Menu);



