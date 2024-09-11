import React,{useState,useEffect} from 'react'
import {useParams,useLocation,useNavigate} from 'react-router-dom';
import ProductService from '../service/ProductService';

export default function ProductEdit() {
    const params=useParams();
    const location=useLocation();
    const navigate=useNavigate();
    const [formdetails,setformdetails]=useState({pid:"",pname:"",qty:"",price:""});
    useEffect(()=>{
        console.log(params.id);
        console.log("in productedit object initialization useeffect")
       console.log(location.state) 
       setformdetails({...location.state.edprod}); 
    },[])
    const handlechange=(event)=>{
        let {name,value}=event.target;
        setformdetails({...formdetails,[name]:value})

    }
    const updateproduct=()=>{
        ProductService.updateproduct(formdetails);
        setformdetails({pid:"",pname:"",qty:"",price:""});
        navigate("/table")

    }
    return (
        <div>
          <form>
            <div className="form-group">
              <label htmlFor="pid">Product Pid</label>
              <input type="text" className="form-control" id="pid" name="pid"
                value={formdetails.pid}
                onChange={handlechange}
                readOnly
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
      
      <button type="button" className="btn btn-primary" onClick={updateproduct}>Update Product</button>
    </form>
        </div>
      )
}
