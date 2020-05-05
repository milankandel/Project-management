import React, { Component } from 'react'
import { Redirect } from 'react-router-dom';
import {signin,authenticate} from '../auth/index'
class Signin extends Component {
    constructor() {
        super()
        this.state = {

            email: "",
            password: "",
            error: "",
            redirect:false,
            loading:false

        }
    }

    handleChange = (e) => {
        let { value, name } = e.target;
        this.setState({ [name]: value })
        this.setState({ error: "" })
    }
  
    clickSubmit = (e) => {
        e.preventDefault();
        this.setState({loading:true})
        const { email, password } = this.state;
        const user = {
            
            email: email,
            password: password
        }
        //  console.log(user)
       signin(user)
            .then(data => {
                if (data.error) 
                {
                    this.setState({ error: data.error,loading:false })
                }
                else{
                 authenticate(data,()=>{
                     this.setState({redirect:true})
                 })
                }
                  
            })

    }
  

    signinForm = (email, password) => (
        <form>

            <div className="form-group">
                <label className="text-muted">Email</label>
                <input type="email" name="email" value={email} onChange={this.handleChange} className="form-control"></input>

            </div>
            <div className="form-group">
                <label className="text-muted">Password</label>
                <input type="password" name="password" value={password} onChange={this.handleChange} className="form-control"></input>

            </div>
            <button onClick={this.clickSubmit} className="btn btn-raised btn-primary">
                Submit
    </button>


        </form>
    )

    render() {
        const { error, email, password ,redirect,loading} = this.state
        if(redirect){
            return <Redirect to ="/"></Redirect>
        }
        return (
            <div className="container">
                <h2 className="mt-5 mb-5">Signin  </h2>
                <div className="alert alert-danger" style={{ display: error ? "" : "none" }}>
                    {error}
                </div>
                {loading ? <div className="jumbotron text-center">
                    <h2>Loading..</h2>
                    </div> : ""
                    }

                {this.signinForm(email, password)}

            </div>
        )
    }
}

export default Signin;