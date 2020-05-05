export const read=(userId,token)=>{
    return  fetch(`${process.env.REACT_APP_API_URI}/user/${userId}`,{
         method:"GET",
         headers:{
              
             "Content-Type":"application/json",
             Authorization:`Bearer ${token}`
         }
     })
     .then(response=>{
         return response.json()
     }).catch(err => console.log(err))
   }


   export const list=()=>{
    return  fetch(`${process.env.REACT_APP_API_URI}/users`,{
         method:"GET",
         headers:{
              
             "Content-Type":"application/json",
            
         }
     })
     .then(response=>{
         return response.json()
     }).catch(err => console.log(err))
   }



   export const remove=(userId,token)=>{
    return  fetch(`${process.env.REACT_APP_API_URI}/user/${userId}`,{
         method:"DELETE",
         headers:{
              
             "Content-Type":"application/json",
             Authorization:`Bearer ${token}`
         }
     })
     .then(response=>{
         return response.json()
     }).catch(err => console.log(err))
   }
   export const update=(userId,token,user)=>{
    return  fetch(`${process.env.REACT_APP_API_URI}/user/${userId}`,{
         method:"PUT",
         headers:{
              
            
             Authorization:`Bearer ${token}`
         },
         body:user
     })
     .then(response=>{
         return response.json()
     }).catch(err => console.log(err))
   }
