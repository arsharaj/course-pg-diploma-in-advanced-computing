import React,{useState} from 'react'

export default function NameForm(props) {
    const [name,setname]=useState("");
    const [errmsg,setmsg]=useState("");
    //pass the name to parent for adding it in the array which is in app.js
    const addname=(event)=>{
        event.preventDefault(); //this will stop the rfresh of the page which is default action of submit button
        console.log("in addname in NameForm",name);
    // this will pass data to parent component  
    if(name.trim().length===0){
       // alert("name cannot be blank");
       //to display message beside the text box
        setmsg("name cannot be blank")
        return;
    }
    //to clear error message
    setmsg("")
    props.adddata(name);
    //to clear the form
    setname("");
    }

    const delname=()=>{
        if(name.trim().length===0){
            // alert("name cannot be blank");
             setmsg("name cannot be blank");
             return;
         }
         setmsg("");
        props.deletedata(name);
        setname("");
    }
    const updatename=()=>{
        const newname=prompt("enetr new name");
        console.log(name,newname);
        //add this property in NameTab, and complete the code for updating name
        //props.updatedata(name,newname);
    }
  return (
    <div>
    {name}
    <form>
  <div className="form-group" >
  {/* to make textbox modifiable use onChange event which will assign the data from textbox to name state */}
  {/* also add value property to assign the value from component to view */}
    <label htmlFor="name">Name</label>
    <input type="text" className="form-control" id="name" name="name"
    value={name}
    onChange={(event)=>{setname(event.target.value)}}
     />
     <p>{errmsg}</p>
    
  </div>
  <button type="button" className="btn btn-primary" onClick={addname}>ADD NAME</button>
  <button type="button" className="btn btn-primary" onClick={delname}>DELETE NAME</button>
  <button type="button" className="btn btn-primary" onClick={updatename}>Update NAME</button>
</form>
    </div>
  )
}
