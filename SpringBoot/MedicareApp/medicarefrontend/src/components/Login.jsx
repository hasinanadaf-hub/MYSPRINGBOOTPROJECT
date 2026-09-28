import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

function Login()
 {
    const navigate = useNavigate();
    const[user ,setUser] = useState({
        email:"",
        password:""
    });
    const handleChange = (e)=>{
       setUser({...user,[e.target.name]:e.target.value});
    }
    const login = () =>
        {
          axios.post("http://localhost:8080/medicare/users/login",user)
          .then((response)=>{
            localStorage.setItem("user",JSON.stringify(response.data));
            alert("Login Successful");
            navigate("/");
          }).catch(()=>{
            alert ("Invalid Email or Password");
          })
    }
  return (
    <div className="container">
      <div className="form-card">
        <h2> Login : </h2>
        <p> Welcome Back ! Login To Continue</p>
        <div className="form-group">
          
          <h1> Medicare Login</h1>
          <p>
           <input type= "email" name="email"
           placeholder="Enter Email"
           value={user.email} onChange={handleChange}/>
          </p>
          <p>
           <input type="password" name="password"
           placeholder='password' value={user.password}
           onChange={handleChange}
           />
               </p> 
               <p>
                <button onClick={login}>Login</button>
               </p>
          </div>   

       </div>
   
   </div>
  )
}

export default Login


