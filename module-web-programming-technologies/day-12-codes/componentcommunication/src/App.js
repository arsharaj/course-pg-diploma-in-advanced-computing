import logo from './logo.svg';
import flower from './images/flowers.png'
import './App.css';
import Header from './components/Header';
import Footer from "./components/Footer";
import "bootstrap/dist/css/bootstrap.min.css"
import NameTab from './components/NameTab';
import NameList from './components/NameList';
import { useState } from 'react';
function App() {
  //let namearr=["Revati","Arati","Atharva","Ajay"];
  const [namearr,setarr]=useState(["Revati","Arati","Atharva","Ajay"])
  const addnewname=(nm)=>{
    console.log("in addnewname in App",nm);
    setarr([...namearr,nm]);
    console.log(namearr);

  }
  const removename=(nm)=>{
    let newarr=namearr.filter(ob=>ob!==nm);
    setarr(newarr);
  }
  return (
    <div>
      <h1>Name Lists</h1>
      <Header></Header>
      <div className="container">
         <div className="row">
            <div className='col-sm-12 col-md-3'>
               <img src={flower} width="200px" height="200px"></img>
            </div>
            <div className='col-sm-12 col-md-5'>
               <NameTab nmarr={namearr} insertname={addnewname} deletename={removename}></NameTab>
            </div>
            <div className='col-sm-12 col-md-4'>
               <NameList arr={namearr}></NameList>
            </div>
         </div>

      </div>
      
      
      
      <Footer></Footer>
    </div>
  );
}

export default App;
