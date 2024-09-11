import React, { Component } from 'react'

export default class Discussion extends Component {
    constructor(props){
       super(props);
       console.log("in constructor discussion"); 
       this.state={
        x:10,
        currentTime:String(new Date())
       }

    }
    componentDidMount(){
        console.log("in componentDidMount discussion");
        this.livetime=setInterval(()=>{
            console.log("in setinterval");
            this.setState({...this.state,currentTime:String(new Date()),x:this.state.x+1});
        },1000);
    }
    componentWillUnmount(){
        console.log("componentWillunmount disscussion");
        console.log("clearInterval called");
        clearInterval(this.livetime);
    }

  render() {
    console.log("in render function discussion")
    return (
      <div>
        X: {this.state.x}<br></br>
        CurrentTime : {this.state.currentTime}
      </div>
    )
  }
}
