import React,{useState} from 'react'
import ProductService from '../service/ProductService';
import {useNavigate} from 'react-router-dom';

export default function ProductForm() {
  const navigate=useNavigate();
  const[formdetails,setformdetails]=useState({pid:"",pname:"",qty:"",price:""});
  const handlechange=(event)=>{
      let {name,value}=event.target;
      setformdetails({...formdetails,[name]:value});
  }
  const addproduct=()=>{
      if(formdetails.pid==="" || formdetails.pname==="" || formdetails.qty==="" || formdetails.price===""){
        alert("pls fill all the fields");
        return;
      }
      ProductService.insertProduct(formdetails).then((result)=>{
        setformdetails({pid:"",pname:"",qty:"",price:""});
        //use navigate to change url via function
        navigate("/table");
      }).catch((err)=>{
         console.log(err);
      });
      
  }
  return (
    <div>
      <form>
        <div className="form-group">
          <label htmlFor="pid">Product Pid</label>
          <input type="text" className="form-control" id="pid" name="pid"
            value={formdetails.pid}
            onChange={handlechange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="pname">Product name</label>
          <input type="text" className="form-control" id="pname" name="pname"
          value={formdetails.pname}
            onChange={handlechange}/>
        </div>
        <div className="form-group">
          <label htmlFor="qty">Quantity</label>
          <input type="number" className="form-control" id="qty" name="qty"
            value={formdetails.qty}
            onChange={handlechange}/>
         
        </div>
        <div className="form-group">
          <label htmlFor="price">Product Price</label>
          <input type="number" className="form-control" id="price" name="price"
          value={formdetails.price}
            onChange={handlechange}/>
        </div>
  
  <button type="button" className="btn btn-primary" onClick={addproduct}>Add Product</button>
</form>
    </div>
  )
}
