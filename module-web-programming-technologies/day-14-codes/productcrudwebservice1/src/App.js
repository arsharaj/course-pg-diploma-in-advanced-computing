import logo from './logo.svg';
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css"
import MainNavBar from './components/MainNavBar';
import Header from './components/Header';
import Footer from './components/Footer';
import ProductList from './pages/ProductList';
import ProductTable from './pages/ProductTable';
import ProductForm from './pages/ProductForm';
import ProductEdit from './pages/ProductEdit';
import {Routes,Route} from 'react-router-dom';
import ProductDetails from './pages/ProductDetails';
function App() {
  return (
    <div className="App">
       <Header></Header>
       <MainNavBar></MainNavBar>
       <Routes>
          <Route path="/table" element={<ProductTable></ProductTable>}>
              <Route path=':pid' element={<ProductDetails></ProductDetails>}></Route>
          </Route>
          <Route path="/list" element={<ProductList></ProductList>}></Route>
          <Route path="/form" element={<ProductForm></ProductForm>}></Route>
          <Route path="/edit/:id" element={<ProductEdit></ProductEdit>}></Route>
       </Routes>
       <Footer></Footer>
    </div>
  );
}

export default App;
