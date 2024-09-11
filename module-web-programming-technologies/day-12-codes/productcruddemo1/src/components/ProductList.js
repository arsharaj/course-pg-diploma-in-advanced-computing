import React, { Component } from 'react'
import ProductDetails from './ProductDetails';
import ProductService from '../service/ProductService';
import ProductFrom from './ProductFrom';
export default class ProductList extends Component {
    constructor(props){
        super(props);
        console.log("in productList constructor")
        this.state={
            prodarr:[],
            searcharr:[],
            flag:false
        }
    }
    //this method gets called only once in the lifetime of component, 
    //so better place to initialize the state, use API
    //useEffect(()=>{},[])  //empty array useEffect is equivalent to componentDidMount 
    componentDidMount(){
        console.log("in productList componentDidMount");
        //the data will retrieved from PRoductservice and initialize both arrays
        this.setState({...this.state,prodarr:ProductService.getallproducts(),searcharr:ProductService.getallproducts()})

    }
    changeflag=()=>{
        this.setState({...this.state,flag:true})
    }
  render() {
    console.log("in productList render",this.state.flag)
    return (
        
      <div className="container">
      <div className="row">
        <div className='col-md-12'>
        <h2>flag : {this.state.flag}</h2>
                <h1>Product List</h1>
                <button type="button" name="btn" id="btn" className="btn btn-info" onClick={this.changeflag}>Add new Product</button>
                {this.state.searcharr.map(prod=><ProductDetails key={prod.pid} product={prod}></ProductDetails>)}
        </div>
      </div>
      <div className='row'>
        {this.state.flag?<ProductFrom></ProductFrom>:""}

      </div>
        
      </div>
    )
  }
}
