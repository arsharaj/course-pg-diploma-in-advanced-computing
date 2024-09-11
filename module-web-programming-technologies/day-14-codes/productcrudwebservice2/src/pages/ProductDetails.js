import React,{useState,useEffect,Fragment} from 'react'
import {useParams,useLocation} from 'react-router-dom';
import ProductService from '../service/ProductService';
export default function ProductDetails() {
    const params=useParams();
    const location=useLocation()
    const [prod,setprod]=useState({pid:"",pname:"",qty:"",price:""});
    useEffect(()=>{
        console.log(location.state);
        let p=ProductService.getById(params.pid);
        console.log("in useeffect",p)
        setprod(p);

    },[])
    //this useEffect will get executed every time when the prams changes
    useEffect(()=>{
        console.log(location.state);
        let p=ProductService.getById(params.pid).then(()=>{
          console.log("in useeffect",p)
          setprod(p);
        }).catch((err)=>{
          console.log(err);
        });
        

    },[params.pid])
  return (
    <Fragment>
        <div className="card" style={{"width": "18rem;"}}>
         <div className="card-body">
           <h5 className="card-title">{prod.pname}</h5>
            <h6 className="card-subtitle mb-2 text-muted">{prod.qty}---{prod.price}</h6>
            <p className="card-text">Some quick example text to build on the card {prod.pid}.</p>
       
         </div>
       </div>
    </Fragment>
  )
}
