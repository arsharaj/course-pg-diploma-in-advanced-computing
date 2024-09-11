import { useState,useEffect } from "react";
const CounterfucntionalComponent=()=>{
    //let count=0;
    //useState function accepts initial value as a parameter, and return 2 values, the variable and reference to setter method
    const [count,setcnt]=useState(0);
    const increment=()=>{
        //count++;
        //console.log("count",count);
        setcnt(count+1);
        
    }
    const decrement=()=>{
        setcnt(count>0?count-1:0); 
    }
    const resetcnt=()=>{
        setcnt(0); 
    }
    //this hook replacecs componentDidUpdate Lifecycle method
    //this function will get called every time the value of count changes
    useEffect(()=>{
        console.log("count in useEffect",count);
    },[count])
    return(
        <div>
           <h1>in functional component</h1>
           {count>0?<h3>you clicked {count} times</h3>:""}
           <button type="button" name="btn" id="inc" className="btn btn-success" onClick={increment}>increament</button>
           <button type="button" name="btn" id="dec" className="btn btn-primary" onClick={decrement}>decreament</button>
           <button type="button" name="btn" id="res" className="btn btn-info" onClick={resetcnt}>rest</button>
        </div>

    )

}
export default CounterfucntionalComponent;