import React from 'react'
import NameDetails from './NameDetails';
export default function NameList(props) {
  return (
    <div>
      {props.arr.map((ob,index)=><NameDetails key={index} fname={ob}></NameDetails>)}
    </div>
  )
}
