import React, { Component } from 'react'
import {signup} from '../auth/index'
import {Link} from 'react-router-dom'
class Signup extends Component {
    constructor() {
        super()
        this.state = {
            name: "",
            email: "",
            password: "",
            error: "",
            open:false
        }
    }

    handleChange = (e) => {
        let { value, name } = e.target;
        this.setState({ [name]: value })
        this.setState({error:""})
    }

    clickSubmit = (e) => {
        e.preventDefault();
        const { name, email, password } = this.state;
        const user = {
            name: name,
            email: email,
            password: password
        }
        //  console.log(user)
    signup(user)
    .then(data =>{
        if(data.error) this.setState({error:data.error})
        else
        this.setState({
            error:"",
            name:"",
            email:"",
            password:"",
            open:true
            
        })
    })

    }
    

    signupForm=(name,email,password)=>(
        <form>
        <div className="form-group">
            <label className="text-muted">Name</label>
            <input type="text" name="name" value={name} onChange={this.handleChange} className="form-control"></input>

        </div>
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
        const{error,open,name,email,password}=this.state
        return (
            <div className="container">
                <h2 className="mt-5 mb-5">Signup  </h2>
                <div className="alert alert-danger" style={{display:error ? "":"none"}}>
                   {error} 
                </div> 
                <div className="alert alert-info" style={{display: open ? "":"none"}}>
                   You have signed up Please <Link to="/signin">Signin</Link> 
                </div>
            
             {this.signupForm(name,email,password)}
               
            </div>
        )
    }
}

export default Signup