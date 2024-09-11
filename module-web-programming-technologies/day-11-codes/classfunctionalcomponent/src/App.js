import logo from './logo.svg';
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import Header from './components/Header';
import Footer from './components/Footer';
import CounterClassComponent from './components/CounterClassComponent';
import CounterfucntionalComponent from './components/CounterfunctionalComponent';
import DisplayNames from "./components/DisplayNames"
function App() {
  let namearr=["Revati","Atharva","Sohuum","Rajashree"]
  return (
    <div>
      <h1>Hello World!</h1>
      <Header></Header>
        
         <CounterClassComponent></CounterClassComponent>
         <hr></hr>
         <CounterfucntionalComponent></CounterfucntionalComponent>
         <DisplayNames nmarr={namearr}></DisplayNames>
      <Footer></Footer>
    </div>
  );
}

export default App;
