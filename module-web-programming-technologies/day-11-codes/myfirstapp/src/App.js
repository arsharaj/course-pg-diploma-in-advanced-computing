import logo from './logo.svg';
import './App.css';
import Header,{F1} from './components/Header';

function App() {
  var s={color:"red",backgroundColor:"yellow"};
  var test="this is title";
  let m=23456;
  return (
    <div>
      <h1>Hello world!! {test}</h1>
      <h2 style={s}>Welcome to react programming</h2>
      <Header name="Kishori" mobile={m} ></Header>
      <Header name="Rajan"></Header>
      <Header name="Revati"></Header>
      <F1></F1>
  </div>);
    
  
}

export default App;
