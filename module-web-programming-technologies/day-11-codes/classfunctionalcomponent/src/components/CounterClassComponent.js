import React,{Component} from 'react';
class CounterClassComponent extends React.Component{
    constructor(props){
        super(props);
        console.log("in constructor function")
        this.state={
            count:0,
            name:'Kishori'
        }
        //this.increament=this.increament.bind(this);
    }
    increament=()=>{
        //use setstate function to change the state, it is asynchronous function, it will create new state object, it will not overrite the old state object
        //to check the changed value of state use call back function
       this.setState({...this.state,count:this.state.count+1},()=>{
           console.log(this.state.count);
       })
      
    }
    decrement=()=>{
        this.setState({...this.state,count:this.state.count>0?this.state.count-1:0})
    }
    resetcnt=()=>{
        this.setState({...this.state,count:0});
    }
  render(){
    console.log("in render function")
    return(
        <div>
              {this.state.count>0?<h3>You clicked {this.state.count} times</h3>:""}
            <button type="button"  className="btn btn-success" name="btn" id="inc" onClick={this.increament}>Increament</button>&nbsp;&nbsp;&nbsp;

            <button type="button" name="btn" id="dec" className="btn btn-primary" onClick={this.decrement}>Decreament</button>&nbsp;&nbsp;&nbsp;
            <button type="button" name="btn" id="res" className="btn btn-info" onClick={this.resetcnt}>reset</button>
        </div>
    )
  }
}
export default CounterClassComponent;