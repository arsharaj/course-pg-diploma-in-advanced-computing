import React,{useState,useEffect} from 'react'
import ProductService from '../service/ProductService';
import {Link,Outlet} from 'react-router-dom';
export default function ProductTable() {
    //create a array as state
    const [prodarr,setprodarr]=useState([]);
    const [searcharr,setsearcharr]=useState([]);
    const [searchtxt,setSearchTxt]=useState("");
    //this is equivalent to componentDidMount
    useEffect(()=>{
        console.log("in initialization useEffect")
        fetchdata();
       
    },[]);
    //this function will keep on updating value of searchtxt when user type something in the text box
    const handlechange=(event)=>{
        setSearchTxt(event.target.value);

    }
    const fetchdata=()=>{
       let newarr=ProductService.getAllProducts()
       setprodarr([...newarr])
       setsearcharr([...newarr])
    }
    const deleteproduct=(pid)=>{
         ProductService.deleteproduct(pid);
         fetchdata();
    }
    useEffect(()=>{
        console.log("prodarr",prodarr,searcharr);
       // setsearcharr([...prodarr])
    },[prodarr])
    //this useEffect is similar to componentDidUpdate
    useEffect(()=>{
        console.log("in searchtxt useEffect")
       if(searchtxt!==""){
         //find all products which has searchtext in the product pname
         let newarr=prodarr.filter(p=>p.pname.includes(searchtxt));
         //assign the filtered array to searcharr
         setsearcharr([...newarr]);
        
            
        }else{
            console.log("in else",prodarr);
            if(prodarr.length>0)
               setsearcharr([...prodarr])
            
        }
    
    },[searchtxt])
  return (
    <div>
    {/* use Link component if you want to change the link after clicking on the button */}
    <Link to="/form">
        <button type="button" name="btn" id="add" className="btn btn-info">Add new Product</button>
    </Link>&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" name="search" id="search"
    value={searchtxt}
    onChange={handlechange}
    ></input> 
    {/* add a drop down box and select the search should happen on which filed */}
        <table className="table table-striped">
  <thead>
    <tr>
      <th scope="col">Product Id</th>
      <th scope="col">Product name</th>
      <th scope="col">Quantity</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    {searcharr.map(prod=><tr key={prod.pid}>
    
    <th scope="row">{prod.pid}</th>
    <td>{prod.pname}</td>
    <td>{prod.qty}</td>
    <td>{prod.price}</td>
    <td>
    <Link to={`/table/${prod.pid}`} state={{edprod:prod,x:10,y:90}} >
      <button type="button" name="btn" id="view" className="btn btn-success">view</button>
      </Link>&nbsp;&nbsp;&nbsp;
      <Link to={`/edit/${prod.pid}`} state={{edprod:prod,x:10,y:90}}>
      <button type="button" name="btn" id="edit" className="btn btn-primary">Edit</button>
      </Link>&nbsp;&nbsp;&nbsp;
        <button type="button" name="btn" id="delete" className="btn btn-danger" onClick={()=>{deleteproduct(prod.pid)}}>Delete</button>&nbsp;&nbsp;&nbsp;
    </td>
  </tr>)}
  </tbody>
</table>
<div>
    <Outlet></Outlet>
</div>
    </div>
  )
}
