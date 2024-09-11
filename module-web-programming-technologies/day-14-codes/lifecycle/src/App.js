import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import MainNavBar from './components/MainNavBar';
import Header from './components/Header';
import Footer from './components/Footer';
import Discussion from './pages/Discussion';
import {Routes,Route} from 'react-router-dom';
import Demos from './pages/Demos';
function App() {
  return (
    <div className="App">
    <Header></Header>
    <MainNavBar></MainNavBar>
    <Routes>
      <Route path="/discussion" element={<Discussion></Discussion>}></Route>
      <Route path="/demo" element={<Demos></Demos>}></Route>
    </Routes>
    <Footer></Footer>
      
    </div>
  );
}

export default App;
