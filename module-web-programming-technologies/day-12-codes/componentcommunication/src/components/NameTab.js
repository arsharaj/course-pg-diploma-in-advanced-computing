import React from 'react'
import NameForm from './NameForm';
const NameTab=(props)=>{
    const insertdata=(nm)=>{
        console.log("in insertdata nametab",nm);
        //pass the name to parent
        props.insertname(nm)

    }
    const deldata=(nm)=>{
        props.deletename(nm);
    }
  return (
    <div>
    <table border='2'>
    <thead>
        <tr><th>Id</th><th>name</th></tr>
    </thead>
    <tbody>
    {/* add key property to identify eveery tr uniquely in React virtual DOM */}
        {props.nmarr.map((ob,index)=><tr key={index}>
        <td>{index+1}</td>
        <td>{ob}</td>
        </tr>)}
    </tbody>
    </table>
    <NameForm adddata={insertdata} deletedata={deldata}></NameForm>
    </div>
  )
}

export default  NameTab;