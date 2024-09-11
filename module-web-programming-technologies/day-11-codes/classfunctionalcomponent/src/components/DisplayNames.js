const DisplayNames=(props)=>{
    return(
        <div>
         <h1>Names </h1>
         <ul>
           {props.nmarr.map((ob,index)=><li key={index}>{ob}</li>)}
         </ul>
        </div>
    )
}
export default DisplayNames;