import React, { Component } from 'react'
import { isAuthenticated } from '../auth/index'
import { read, update } from './apiUser'
import { Redirect } from 'react-router-dom'
import defaultImage from '../images/avatar.svg'
class editProfile extends Component {


    constructor() {
        super()
        this.state = {
            id: "",
            name: "",
            email: "",
            password: "",
            redirectToProfile: false,
            error: "",
            loading:false,
            fileSize:0,
            about:""


        }

    }

    init = (userId) => {
        const token = isAuthenticated().token
        read(userId, token).then(data => {
            if (data.error) {
                this.setState({ error: data.error })
            }
            else {
                this.setState({
                    id: data._id,
                    name: data.name,
                    email: data.email,
                    about:data.about
                })
            }
        })
    }

    handleChange =name=>e => {
        this.setState({error:""})
       const value= name==='photo' ? e.target.files[0]:e.target.value
       const fileSize=name==='photo' ? e.target.files[0].size:0
       this.userData.set(name,value)
        this.setState({ [name]: value,fileSize })

    }

    clickSubmit = (e) => {
        e.preventDefault();
        this.setState({loading:true})
        if(this.isValid()){
         
           
            const userId = this.props.match.params.userId
            const token = isAuthenticated().token;
            update(userId, token, this.userData).then(data => {
                if (data.error) {
                    this.setState({ error: data.error })
                }
                else
              
                    this.setState({
                        redirectToProfile: true
                    })
                })
                  
    
    
         
        }
        
    }



    signupForm = (name, email, password,about) => (
        <form>
            <div className="form-group">
                <label className="text-muted">Profile Photo</label>
                <input type="file" name="photo"  onChange={this.handleChange("photo")} className="form-control" accept="image/*"></input>

            </div>
            <div className="form-group">
                <label className="text-muted">Name</label>
                <input type="text" name="name" value={name} onChange={this.handleChange("name")} className="form-control"></input>

            </div>
            <div className="form-group">
                <label className="text-muted">Email</label>
                <input type="email" name="email" value={email} onChange={this.handleChange("email")} className="form-control"></input>

            </div>
            <div className="form-group">
                <label className="text-muted">About</label>
                <textarea type="text" name="about" value={about} onChange={this.handleChange("about")} className="form-control"></textarea>

            </div>
            <div className="form-group">
                <label className="text-muted">Password</label>
                <input type="password" name="password" value={password} onChange={this.handleChange("password")} className="form-control"></input>

            </div>
            <button onClick={this.clickSubmit} className="btn btn-raised btn-primary">
                Submit
    </button>


        </form>
    )


    componentDidMount() {
        this.userData=new FormData()
        const userId = this.props.match.params.userId
        this.init(userId)
    }
    
    isValid=()=>{
        const{name,email,password,fileSize}=this.state
        if(fileSize>100000){
            this.setState({error:"file  should be less than 100kb"})
            return false;
        }
        if(name.length===0){
            this.setState({error:"Name is required"})
            return false;
        }

        if(!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
            this.setState({error:"Enter valid email"})
            return false;
        }

        if(password.length>=1 && password.length<=5){
            this.setState({error:"must be 6 character long"})
            return false;
        }
        return true

    }

    render() {
        const { id, name, email, password, redirectToProfile, error ,loading,about} = this.state

        if (redirectToProfile) {
            return <Redirect to={`/user/${id}`} />
        }

        const photoUrl=id ? `${process.env.REACT_APP_API_URI}/user/photo/${id}?${new Date().getTime()}`:defaultImage
        return (
            <div className="container">
                <h2 className="mt-5 mb-5">Edit Profile</h2>
                <div className="alert alert-danger" style={{ display: error ? "" : "none" }}>
                    {error}
                </div>
              {/*  {loading ? (
                   <div className="jumbotron text-center">
                       <h2>Loading...</h2>
                       </div>
               ):(
                   ""
               )} */}
               <img style={{height:"200px",width:'auto'}} className="img-thumbnail" onError ={i =>(i.target.src=`${defaultImage}`)} src={photoUrl} />
                {this.signupForm(name, email, password,about)}
            </div>
        )
    }
}

export default editProfile