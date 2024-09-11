import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './components/Header';
import Footer from './components/Footer';
import flower from "./images/flowers.png";
import ProductList from './components/ProductList';
import ProductFrom from './components/ProductFrom';
function App() {
  return (
    <div className="App">
    <Header></Header>
    <div className="container">
     <div className="row">
     <div className="col-sm-12 col-md-3">
      <img  src={flower} className="img-thumbnail" width="200px" height="200px"></img>
     </div>
     <div className="col-sm-12 col-md-9">
        <ProductList> </ProductList>
     </div>
     
     </div>
     
    </div>
    <Footer></Footer>  
    </div>
  );
}

export default App;
