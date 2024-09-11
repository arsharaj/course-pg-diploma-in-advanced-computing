import React,{useState,useEffect} from 'react'
import ProductService from '../service/ProductService';
export default function ProductFrom(props) {
    const [formdetails,setformdetails]=useState({pid:"",pname:"",qty:"",price:""})
    const [formerrors,seterrors]=useState({});
    useEffect(()=>{
        console.log("in useEffect edit form")
        if(props.editprod.pid!==undefined)
            setformdetails({...props.editprod});   
    },[props.editprod])
    const validateForm=()=>{
        let errors={};
        if(props.editprod.pid===undefined && formdetails.pid.trim().length===0){
            errors.piderr="pid cannot be empty";
        }
        if(formdetails.qty<0){
            errors.qtyerr="quantity cannot be negative"
        }
        seterrors(errors)
        return errors; 

    }
    const addproduct=()=>{
        var errors=validateForm();
        if(Object.keys(errors).length>0){
            //we don't want to add object
            return;
        }else{
          //add the object in the array
          ProductService.insertProduct(formdetails);
          //clearing the form
          setformdetails({pid:"",pname:"",qty:"",price:""})
          //to hide the form
          props.chflag();
        }

    }
    const handlechange=(event)=>{
        //let name=event.target.name;
        //let value=event.target.value;
        //this is equivalent to previous 2 lines
        //it will retrieve name property of event.target assign it to name variable, also retrieve value property and assign to value variable
        let {name,value}=event.target;
        setformdetails({...formdetails,[name]:value})


    }
    const updateproduct=()=>{
        var errors=validateForm();
        if(Object.keys(errors).length>0){
            //we don't want to add object
            return;
        }else{
          //add the object in the array
          ProductService.updateProduct(formdetails);
          //clearing the form
          setformdetails({pid:"",pname:"",qty:"",price:""})
          //to hide the form
          props.chflag();
        }
    }
  return (
    <div>
    <form>
    <div className="form-group">
      <label htmlFor="pid">Product Id</label>
      <input type="text" className="form-control" id="pid" name="pid"
      value={formdetails.pid}
      onChange={handlechange} readOnly={props.editprod.pid!==undefined} />
      <p>{formerrors.piderr}</p>
      
    </div>
    <div className="form-group">
      <label htmlFor="pname">Product Name</label>
      <input type="text" className="form-control" id="pname" name="pname"
      value={formdetails.pname}
      onChange={handlechange}
      />
    </div>
    <div className="form-group">
      <label htmlFor="qty">Product Quantity</label>
      <input type="text" className="form-control" id="qty" name="qty"
        value={formdetails.qty}
      onChange={handlechange}
      />
      <p>{formerrors.piderr}</p>
    </div>
    <div className="form-group">
      <label htmlFor="price">Product Price</label>
      <input type="text" className="form-control" id="price" name="price"
        value={formdetails.price}
      onChange={handlechange}
      />
    </div>
    
    {props.editprod.pid===undefined?<button type="button" className="btn btn-primary" id="add" name="add" onClick={addproduct}>Add Product</button>:<button type="button" className="btn btn-primary" id="add" name="add" onClick={updateproduct}>Update Product</button>
    }
  </form></div>
  )
}
