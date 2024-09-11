import React, { Component } from 'react'

export default class Demos extends Component {
    constructor(props){
        super(props);
        console.log("in constructor demos");
        this.state={
            x:5,
            searchtxt:"",
           // y:props.y
        }

    }
   static getDerivedStateFromProps(nextProps,prevState){
    //do the thisngs with nextProps.someprops!=prevState.s
        console.log("in getDerivedState from demos");
        return {
            x:10,
            
            y:34
        }    

   }
   componentDidMount(){
      console.log("in componentDidMount from demos");
   }
   shouldComponentUpdate(){
    console.log("in shouldComponentUpdate from demos");
    return true;
   }
   getSnapshotBeforeUpdate(prevprops,prevstate){
    console.log("in getsnapshotBeforeupdate");
    return 100;

   }
   componentDidUpdate(prevprops,prevstate,snapshot){
        prevprops.x!==this.props.x
      //always keep the code in some condition, otherwise it will go in infinite loop
      if(prevstate.searchtxt!==this.state.searchtxt){
          console.log("text not matching",prevstate.searchtxt,"   ",this.state.searchtxt);
          this.setState({...this.state,y:50});
      }
   }
   
   handlechange=(event)=>{
       this.setState({...this.state,searchtxt:event.target.value})
   }
   componentWillUnmount(){
    console.log("in componentWill unmount")
   }
  render() {
    return (
      <div>
      <input type="text" name="search" id="search"
      value={this.state.searchtxt}
      onChange={this.handlechange}></input>
      Demos  {this.state.x}</div>
    )
  }
}
